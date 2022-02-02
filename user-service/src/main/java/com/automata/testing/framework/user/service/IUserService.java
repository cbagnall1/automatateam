package com.automata.testing.framework.user.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import com.automata.testing.framework.user.dto.UserDTO;

/**
 * Dependencies
 */

/**
 * The interface for a user service.
 * 
 * @author GELIBERT
 */
public interface IUserService {

    // -------------------------------------- Public methods

    /**
     * Create a new user.
     * 
     * @param user
     *             the user to create.
     */
    void createUser(UserDTO user);    
    
    /**
     * Delete a user by its id.
     * @param id the id
     * @return
     */
    void deleteUser(Integer id);

}
