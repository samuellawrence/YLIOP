package com.arvato.jesy.lifematters;

import java.util.Arrays;

import com.arvato.jesy.lifematters.entities.Role;
import com.arvato.jesy.lifematters.entities.User;
import com.arvato.jesy.lifematters.repositories.UserRepository;
import com.arvato.jesy.lifematters.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LifeMattersApplication {


	LifeMattersApplication(){
	}

	public static void main(String[] args) {
		SpringApplication.run(LifeMattersApplication.class, args);
	}

	
}
