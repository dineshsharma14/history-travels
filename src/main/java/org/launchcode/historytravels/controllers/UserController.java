package org.launchcode.historytravels.controllers;

import org.launchcode.historytravels.models.User;
import org.launchcode.historytravels.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index (Model model) {
        // Model class's model object is used to pass data to view.

        model.addAttribute("title","Hello User");
        return "user/index";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayRegistrationForm (Model model) {
        model.addAttribute("title","User Registration");
        //passing empty object to view, I got same result by using @ModelAttribute User user here.
        model.addAttribute("user",new User());
        return "user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistrationForm (Model model,
                                           @ModelAttribute @Valid User user,
                                           Errors errors) {

        if (errors.hasErrors() || !user.getPassword().equals(user.getVerify())){
            model.addAttribute("title",
                    "User Registration");

            if(!user.getPassword().equals(user.getVerify())){
                model.addAttribute("passwordError",
                        "Passwords don't match!");
            }
            return "user/register";
        }
        userDao.save(user);
        model.addAttribute("user", user.getUserName());
        return "user/index";

    }

    @RequestMapping(value = "trail", method = RequestMethod.GET)
    public String addToTrail (Model model){
        model.addAttribute("title","Add to trail");
        return "user/trail";
    }


}
