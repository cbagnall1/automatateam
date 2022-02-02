package com.automata.testing.framework.post.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automata.testing.framework.algorithm.service.IEncryptionService;
import com.automata.testing.framework.post.dto.PostDTO;
import com.automata.testing.framework.post.model.PostEntity;
import com.automata.testing.framework.post.repository.IPostRepository;

/**
 * Dependencies
 */

/**
 * Post service implementation.
 * 
 * @author GELIBERT
 */
public class PostServiceImpl implements IPostService {
	
	/**
     * Encryption service to use.
     */
	@Autowired
    private IEncryptionService encryptionService;

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * Loading the post repository in order to load datas.
     */
    @Autowired
    private IPostRepository postRepo;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    /**
     * {@inheritDoc}
     */
    public Integer createPost(PostDTO post) {
	PostEntity postDoc = PostEntity.builder().content(post.getContent()).userId(post.getUser().getUserId())
		.userFirstName(post.getUser().getFirstName()).userLastName(post.getUser().getLastName()).build();
	postDoc.setContent(encryptionService.encode(postDoc.getContent()));
	return postRepo.save(postDoc).getId();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PostEntity> getPost(Integer id) {
	return postRepo.findById(id);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePost(Integer id) {    
    	postRepo.deleteById(id);
    }

    // -------------------------------------- Setters and Getters

}
