package org.launchcode.historytravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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


}
