package com.msc.springmvc.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.*;

import java.util.logging.Logger;

/**
 * This code was written by Marcelo Caldas.
 * e-Mail: mscaldas@gmail.com
 */
@Controller
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class.getName());

    @RequestMapping("/helloWorld")
    public ModelAndView helloWorld() {
        String message = "Hello World, Spring 3.2!";
        return new ModelAndView("welcome", "message", message);
    }
}
