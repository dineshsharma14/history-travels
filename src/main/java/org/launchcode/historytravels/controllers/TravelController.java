package org.launchcode.historytravels.controllers;

import org.launchcode.historytravels.models.Checkout;
import org.launchcode.historytravels.models.data.CheckoutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TravelController {

    @Autowired
    CheckoutDao checkoutDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "History Travels");
        return "index";
    }

    @RequestMapping(value = "about")
    public String about(Model model) {
        model.addAttribute("title", "About us");
        return "about";
    }

    @RequestMapping(value="/trails/history-trail")
    public String places (Model model) {
        model.addAttribute("title", "history trail");
        return "history/historyTrail";
    }

    @RequestMapping(value = "/trails/history-trail/brihadisvara-temple",
                method = RequestMethod.GET)
    public String placeDisplay (Model model){
        model.addAttribute("title","Brihadisvara Temple");
        return "history/brihadisvaraTemple";
    }

    @RequestMapping(value = "/trails/history-trail/rajaraja-chola-museum",
            method = RequestMethod.GET)
    public String place1Display (Model model){
        model.addAttribute("title","Rajaraja Chola Museum");
        return "history/rajarajaCholaMuseum";
    }

    @RequestMapping(value = "/trails/history-trail/srirangam-temple",
            method = RequestMethod.GET)
    public String place2Display (Model model){
        model.addAttribute("title","Srirangam Temple");
        return "history/srirangamTemple";
    }

    @RequestMapping(value = "/trails/history-trail/checkout",
            method = RequestMethod.GET)
    public String historyTrailCheckout (Model model){
        model.addAttribute("title","Checkout Page");
        model.addAttribute(new Checkout());
        return "history/checkoutHistoryTrail";
    }

    @PostMapping(value = "/checkout")
    public String processHistoryTrailCheckout(@ModelAttribute @Valid Checkout newCheckout,
                                              Errors errors, Model model){

        System.out.println("In the processCheckout");
        System.out.println(errors);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Error Checkout Page");
            return "history/checkoutHistoryTrail";
        }

        //checkoutDao.save(newCheckout);
        return "history/checkoutSuccess";
    }


}
