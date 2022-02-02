package com.automata.testing.framework.user.controller;
/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automata.testing.framework.user.dto.UserDTO;
import com.automata.testing.framework.user.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Dependencies
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * The user Service.
     */
    @Autowired
    private IUserService userService;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    /**
     * Rest API for the creation of the user.
     * 
     * @param user
     *             the user
     * @return the response entity
     */
    @PostMapping(path = "/user")
    public ResponseEntity<String> createUser(final UserDTO user) {
	log.debug("Receiving the user {}", user);
	userService.createUser(user);
	return ResponseEntity.ok().build();
    }
    
    /**
     * Rest API to delete a user based by id.
     * 
     * @param id
     *           the identifier
     * @return the response entity
     */
    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "identifier") Integer id) {
    	log.info("Trying to delete a with id {}", id);
    	userService.deleteUser(id);
		return ResponseEntity.ok().build();
    }
    

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
