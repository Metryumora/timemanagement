package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.User;
import edu.chdtu.timemanagement.service.SecurityService;
import edu.chdtu.timemanagement.service.SpecialistService;
import edu.chdtu.timemanagement.service.UserService;
import edu.chdtu.timemanagement.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by Metr_yumora on 06.04.2017.
 */
@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SpecialistService specialistService;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView home(ModelMap modelMap) {
        modelMap.addAttribute("currentUser", securityService.findLoggedInUser());
        List<Appointment> appointments = specialistService.get(1).getWeeklyAppointmentsSchema(new Date());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.add(userForm);
        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());
        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public ModelAndView authUser(ModelMap modelMap) {
        modelMap.addAttribute("currentUser", securityService.findLoggedInUser());
        return new ModelAndView("redirect:/", modelMap);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView showLogin(ModelMap modelMap, String error, String logout) {
        if (error != null) {
            modelMap.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            modelMap.addAttribute("message", "Logged out successfully.");
        }
        return new ModelAndView("login");
    }
}
