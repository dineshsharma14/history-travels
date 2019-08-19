package org.launchcode.historytravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TravelController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "History Travels");
        return "history/index";

    }

    @RequestMapping(value="places")
    public String places (Model model) {

        model.addAttribute("title", "Cultural Places");
        return "history/places";
    }

    @RequestMapping(value = "place", method = RequestMethod.GET)
    public String placeDisplay (Model model){
        model.addAttribute("title","A place");
        return "history/place";
    }


}
