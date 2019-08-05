package com.reactivestax.web.controller;

import com.reactivestax.business.model.LoginModelObject;
import com.reactivestax.business.model.RegisterModelObject;
import com.reactivestax.business.services.UserService;
import com.reactivestax.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    public UserService userService;

    @Autowired
    private RegisterRepository repository;

    @RequestMapping({"/"})
    public ModelAndView baseRequestMapping()
    {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    @RequestMapping({"/login"})
    public ModelAndView loginRequestMapping()
    {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginModelObject",new LoginModelObject());
        return modelAndView;
    }

    @RequestMapping({"/loginProcess"})
    public ModelAndView loginProcessRequestMapping(@Valid final LoginModelObject loginModelObject, BindingResult bindingResult)
    {
        /**field level validation**/
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }
        //ModelAndView modelAndView = new ModelAndView();
        ModelAndView mav = null;

        RegisterModelObject user = userService.validateUser(loginModelObject);




        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("firstName", user.getFirstName());
        } else {
            mav = new ModelAndView("login");
            System.out.println("going to login.jsp");
            mav.addObject("message", "Username or Password is wrong!!");
        }

        return mav;
    }

    @RequestMapping({"/register"})
    public ModelAndView registerRequestMapping()
    {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerModelObject",new RegisterModelObject());
        return modelAndView;
    }

    @RequestMapping({"/registerProcess"})
    public ModelAndView registerProcessRequestMapping(@Valid final RegisterModelObject registerModelObject, BindingResult bindingResult)
    {
        /**field level validation**/
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("register");
            return modelAndView;
        }
        userService.register(registerModelObject);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return new ModelAndView("welcome", "firstname", registerModelObject.getFirstName());

        // modelAndView.addObject("message","You are succesfully Registered");
        // return modelAndView;



    }
}
