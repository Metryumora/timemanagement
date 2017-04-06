package edu.chdtu.controller;

import edu.chdtu.model.entity.User;
import edu.chdtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Metr_yumora on 06.04.2017.
 */
@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ModelAndView register(ModelMap modelMap,
                                 @RequestParam String userName,
                                 @RequestParam String phone,
                                 @RequestParam String email,
                                 @RequestParam String password) {

        User newUser = new User(email, password, userName, phone);
        try {
            userService.add(newUser);
            System.out.println("User added successfully!");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to add user!");
        }

        return new ModelAndView("index");
    }

}
