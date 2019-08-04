package com.reactivestax.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/sample")
    public ModelAndView sampleRequestMapping()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sample");
        modelAndView.addObject("messageFromController",
                "real message from controller");

        logger.debug("hit logger************************************");

        System.out.println("hello");
        return modelAndView;
    }
}
