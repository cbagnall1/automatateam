package com.automata.testing.framework.algorithm.service;

import lombok.extern.slf4j.Slf4j;

/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

/**
 * Dependencies
 */

/**
 * Basic Decryption Management Service Impl
 * 
 * @author GELIBERT
 */
@Slf4j
public class DecrypteRotation13ServiceImpl implements IDecryptionService {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes    
    /**
     * Storing the last character we handled.
     */
    private String CHAR_RESULT = null;

    // -------------------------------------- private attributes

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    @Override
    public String decode(String input) {
    	System.out.println("Input is " + input);
		for (int i = 0 ; i <= input.toUpperCase().length() ; i++ ) {
		    if (i == 0) {
		    	continue;
		    }
		    char c = input.charAt(i - 1);
		    char res = c;
		    if (Character.isAlphabetic(c)) {
		    	res =  (char) ((c - 13)) ;
		    }
		    log.info("Result is {}", res);
		    if (CHAR_RESULT == null) {
		    	CHAR_RESULT = "";
		    }
		    CHAR_RESULT = CHAR_RESULT + res;
		}
		String res = CHAR_RESULT;
		CHAR_RESULT = null;
		return res;
    }

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
