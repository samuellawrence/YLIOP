package com.arvato.jesy.lifematters.controller;

import java.util.Arrays;

import com.arvato.jesy.lifematters.entities.Role;
import com.arvato.jesy.lifematters.entities.User;
import com.arvato.jesy.lifematters.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "/", description = "Home Profile", produces = "application/json")
public class HomeController {


	@Autowired
	private UserService userService;
  
    @GetMapping(value = "/")
    public String index() {
        return "Hello world";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "Admin user registered";
    }

    @GetMapping(value = "/private")
    public String privateArea() {
        return "Private area";
    }
}