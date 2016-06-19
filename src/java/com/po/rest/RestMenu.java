/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.rest;

import com.po.service.MenuService;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lucky Bear
 */
@Path("Menu")
public class RestMenu extends RestBase {
    
    private final MenuService service = new MenuService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listAll")
    public String getListAllMenu() {
        String result = "";
        try {
            result = om.writeValueAsString(service.getListAllMenu());
            logger.debug(result);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{userId}")
    public String getListMenuByUser(@PathParam("userId") long userId) {
        String result = "";
        try {
            result = om.writeValueAsString(service.getListMenuByUser(userId));
            logger.debug(result);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return result;
    }
}
