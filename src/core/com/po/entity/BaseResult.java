/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucky Bear
 */
public abstract  class BaseResult {

    public abstract BaseDTO getBeanFromResultSet(ResultSet rs) throws SQLException;
    
    public abstract List<? extends BaseDTO> getListFromResultSet(ResultSet rs) throws SQLException;
    
}
