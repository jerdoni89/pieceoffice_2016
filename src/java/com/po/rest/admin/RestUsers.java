/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.rest.admin;

import com.po.rest.RestBase;
import com.po.service.admin.UserService;
import java.io.IOException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Lucky Bear
 */
@Path("user")
public class RestUsers extends RestBase {
    
    private final UserService service = new UserService();
    
    @Context
    private UriInfo context;
    
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListUser() {
        try {
            return om.writeValueAsString(service.getListUsers());
        } catch (IOException ex) {
            logger.error(ex);
        }
        return null;
    }
    
}
