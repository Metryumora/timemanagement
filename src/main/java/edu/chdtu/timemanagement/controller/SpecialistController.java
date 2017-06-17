package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.service.SecurityService;
import edu.chdtu.timemanagement.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Metr_yumora on 17.06.2017.
 */

@Controller
@EnableAutoConfiguration
public class SpecialistController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SpecialistService specialistService;

    private ModelAndView getModelAndViewForCurrentUser(String pageName, ModelMap modelMap) {
        modelMap.addAttribute("currentUser", securityService.findLoggedInUser());
        return new ModelAndView(pageName, modelMap);
    }

    @RequestMapping(value = "/timetable", method = {RequestMethod.GET})
    public ModelAndView showSpecialistAppointments(ModelMap modelMap) {
        Specialist specialist = specialistService.getByUser(securityService.findLoggedInUser());
        modelMap.addAttribute("specialist", specialist);
        return getModelAndViewForCurrentUser("timetable", modelMap);
    }

}
