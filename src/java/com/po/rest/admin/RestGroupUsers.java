/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.rest.admin;

import com.po.rest.RestBase;
import com.po.service.admin.GroupUserService;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Lucky Bear
 */
@Path("GroupUsers")
public class RestGroupUsers extends RestBase {
    private final GroupUserService service = new GroupUserService();
    
    @Context
    private UriInfo context;
    
    public RestGroupUsers() {
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("List")
    public String getListGroupUsers() {
        String result = "";
        try {
            result = om.writeValueAsString(service.getListGroupUsers());
            logger.debug(result);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return result;
    }
}
