package com.automata.testing.framework.post.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.automata.testing.framework.post.dto.PostDTO;
import com.automata.testing.framework.post.model.PostEntity;

/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

/**
 * Dependencies
 */

/**
 * The post handling service.
 * 
 * @author GELIBERT
 */
@Service
public interface IPostService {

    // -------------------------------------- Public methods

    /**
     * Create the post, and encrypt the content in the database.
     * 
     * @param post
     *             the dto representing the post.
     * @return 
     */
    public Integer createPost(PostDTO post);

    /**
     * Find a post by its id.
     * @param id the id
     * @return
     */
    Optional<PostEntity> getPost(Integer id);
    
    /**
     * Delete a post by its id.
     * @param id the id
     * @return
     */
    void deletePost(Integer id);
    
}
