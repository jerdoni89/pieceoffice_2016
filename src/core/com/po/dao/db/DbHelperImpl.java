/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Types;

/**
 *
 * @author Lucky Bear
 */
public class DbHelperImpl implements DbHelper {

    @Override
    public ResultSet executeSqlQuery(Connection conn, String sql, List params) throws SQLException {
        ResultSet rs = getPrepareStatement(conn, sql, params).executeQuery();
        return rs;
    }

    @Override
    public ResultSet executeSqlQuery(Connection conn, String sql) throws SQLException {
        return executeSqlQuery(conn, sql, null);
    }

    @Override
    public ResultSet executeSqlFile(Connection conn, String sqlFileName, List params) throws SQLException, IOException {
        return getPrstmBySqlFile(conn, sqlFileName, params).executeQuery();
    }

    @Override
    public ResultSet executeSqlFile(Connection conn, String sqlFileName) throws SQLException, IOException  {
        return executeSqlFile(conn, sqlFileName, null);
    }

    @Override
    public ResultSet executeCallabble(Connection conn, String procName, List params) throws SQLException {
        return getCallableStatement(conn, procName, params).executeQuery();
    }

    @Override
    public ResultSet executeCallabble(Connection conn, String procName) throws SQLException {
        return executeCallabble(conn, procName, null);
    }
    
    @Override
    public int executeUpdateBySql(Connection conn, String sql, List params) throws SQLException {
        return getPrepareStatement(conn, sql, params).executeUpdate();
    }

    @Override
    public int executeUpdateBySql(Connection conn, String sql) throws SQLException {
        return getPrepareStatement(conn, sql, null).executeUpdate();
    }

    @Override
    public int executeUpdateByFile(Connection conn, String sqlFileName, List params) throws SQLException, IOException {
        return getPrstmBySqlFile(conn, sqlFileName, params).executeUpdate();
    }

    @Override
    public int executeUpdateByFile(Connection conn, String sqlFileName) throws SQLException, IOException  {
        return getPrstmBySqlFile(conn, sqlFileName, null).executeUpdate();
    }

    @Override
    public long insertBySqlReturnId(Connection conn, String sql, List params) throws Exception {
        return getPrepareStatement(conn, sql, params).executeUpdate();
    }

    @Override
    public long insertBySqlReturnId(Connection conn, String sql) throws Exception {
        return getPrepareStatement(conn, sql, null).executeUpdate();
    }

    @Override
    public long insertByFileReturnId(Connection conn, String sqlFileName, List params) throws SQLException, IOException {
        return getPrstmBySqlFile(conn, sqlFileName, params).executeUpdate();
    }

    @Override
    public long insertByFileReturnId(Connection conn, String sqlFileName) throws SQLException, IOException {
        return getPrstmBySqlFile(conn, sqlFileName, null).executeUpdate();
    }
    
    private PreparedStatement getPrepareStatement(Connection conn, String sql, List params) throws SQLException {
        PreparedStatement prstm = conn.prepareStatement(sql);
        int idx = 0;
        if (params != null && params.size() > 0) {
            for (Object param : params) {
                idx++;
                prstm.setObject(idx, param);
            }
        }
        return prstm;
    }

    private PreparedStatement getPrstmBySqlFile(Connection conn, String sqlFileName, List params) throws SQLException, IOException {
        String sql = getSqlFromFile(sqlFileName);
        return getPrepareStatement(conn, sql, params);
    }
    
    private CallableStatement getCallableStatement(Connection conn, String procName, List params) throws SQLException {
        String sqlCall = "{call " + procName + "}";
        CallableStatement callable = conn.prepareCall(sqlCall);
        int idx = 0;
        if (params != null && params.size() > 0) {
            for (Object param : params) {
                idx++;
                callable.setObject(idx, param);
            }
        }
        callable.registerOutParameter(++idx, Types.INTEGER);
        callable.registerOutParameter(++idx, Types.VARCHAR);
        callable.registerOutParameter(++idx, Types.REF_CURSOR);
        return callable;
    }

    private String getSqlFromFile(String sqlFileName) throws FileNotFoundException, IOException {
        if (sqlFileName != null && !sqlFileName.equals("")) {
            if (!sqlFileName.startsWith("/")) {
                sqlFileName = "/" + sqlFileName;
            }
            StringBuilder stringBuffer = new StringBuilder();
                String s;
                FileReader fileReader = new FileReader(this.getClass().getResource(sqlFileName).toString().substring(6));
                try (BufferedReader bufferReader = new BufferedReader(fileReader)) {
                    while ((s = bufferReader.readLine()) != null) {
                        stringBuffer.append(s);
                    }
                }
            return stringBuffer.toString();
        }
        return null;
    }

}
