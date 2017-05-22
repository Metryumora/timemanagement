package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.User;
import edu.chdtu.timemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
public class UserController {

    @Autowired
    private UserService userService;

    //    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView home(ModelMap modelMap) {
        return new ModelAndView("index");
    }

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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to add user!");
        }

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView showLogin(ModelMap modelMap) {
        return new ModelAndView("login");
    }

    @Secured("ROLE_USER")
    @RequestMapping("/loginSuccess")
    public ResponseEntity<String> loginSuccess() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("url", "/");
        return new ResponseEntity<String>("Success", responseHeaders, HttpStatus.OK);
    }

}
