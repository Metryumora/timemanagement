package edu.chdtu.controller;

import edu.chdtu.model.entity.User;
import edu.chdtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Controller
@EnableAutoConfiguration
public class Main {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView showAllBooks(ModelMap modelMap) {
        User newUser = new User("metryumora@gmail.com","password","Валентин Тулуб");
        userService.add(newUser);
        return new ModelAndView("index");
    }

}
