package org.chdtu.controller;

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

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView showAllBooks(ModelMap modelMap) {
        return new ModelAndView("index");
    }

}
