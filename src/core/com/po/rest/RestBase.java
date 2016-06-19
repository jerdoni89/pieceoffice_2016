/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.rest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Lucky Bear
 */
public abstract class RestBase {
    protected ObjectMapper om = new ObjectMapper();
    protected Logger logger;
    
    public RestBase() {
        logger = Logger.getLogger(this.getClass());
    }
}
