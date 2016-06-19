
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucky Bear
 */
public interface DbHelper {
    
    public ResultSet executeSqlQuery(Connection conn, String sql, List params) throws Exception;

    public ResultSet executeSqlQuery(Connection conn, String sql) throws Exception;

    public ResultSet executeSqlFile(Connection conn, String sqlFileName, List params) throws Exception;

    public ResultSet executeSqlFile(Connection conn, String sqlFileName) throws Exception;

    public ResultSet executeCallabble(Connection conn, String procName, List params) throws Exception;

    public ResultSet executeCallabble(Connection conn, String procName) throws Exception;

}
