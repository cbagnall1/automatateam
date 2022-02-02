package com.automata.testing.framework.user.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */





/**
 * Dependencies
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automata.testing.framework.algorithm.service.IEncryptionService;
import com.automata.testing.framework.user.dto.UserDTO;
import com.automata.testing.framework.user.model.UserEntity;
import com.automata.testing.framework.user.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;


/**
 * The Implementation of the service.
 * 
 * @author GELIBERT
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {	
	/**
     * Encryption service to use.
     */
	@Autowired
    private IEncryptionService encryptionService;

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    @Autowired
    private IUserRepository repository;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    @Override
    public void createUser(UserDTO user) {
	log.info("Saving data for user {}", user);
	// We create the user in database.
	UserEntity savingUser = UserEntity.builder().firstName(user.getFirstName())
												.lastName(user.getLastName())
												.emailAddress(user.getEmailAddress())
												.password(encryptionService.encode(user.getPassword())).build();
	log.debug("Saving the user {}", user);
	repository.save(savingUser);
    }
    
    /**
     * {@inheritDoc}
     */  
    @Override
    public void deleteUser(Integer id) {  
    	log.info("Deleting user with id {}", id);	 
    	repository.deleteById(id); 
    }

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
