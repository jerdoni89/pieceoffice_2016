/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao;

import com.po.dao.db.DbHelper;
import com.po.dao.db.DbHelperImpl;
import com.po.entity.BaseDTO;
import com.po.entity.BaseResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author luckyhero
 */
public class BaseDAOImpl implements BaseDAO {
    
    private final DbHelper helper = new DbHelperImpl();
    
    @Override
    public BaseDTO getBeanBySql(Connection conn, String sql, List params, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlQuery(conn, sql, params);
        return getBeanFromResultSet(rs, result);
    }

    @Override
    public BaseDTO getBeanBySql(Connection conn, String sql, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlQuery(conn, sql, null);
        return getBeanFromResultSet(rs, result);
    }

    @Override
    public BaseDTO getBeanBySqlFile(Connection conn, String sqlFileName, List params, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlFile(conn, sqlFileName, params);
        return getBeanFromResultSet(rs, result);
    }

    @Override
    public BaseDTO getBeanBySqlFile(Connection conn, String sqlFileName, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlFile(conn, sqlFileName, null);
        return getBeanFromResultSet(rs, result);
    }

    @Override
    public BaseDTO getBeanByProc(Connection conn, String procName, List params, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeCallabble(conn, procName, params);
        return getBeanFromResultSet(rs, result);
    }

    @Override
    public BaseDTO getBeanByProc(Connection conn, String procName, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeCallabble(conn, procName, null);
        return getBeanFromResultSet(rs, result);
    }

    @Override
    public List<? extends BaseDTO> getListBeanBySql(Connection conn, String sql, List params, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlQuery(conn, sql, params);
        return getListFromResultSet(rs, result);
    }

    @Override
    public List<? extends BaseDTO> getListBeanBySql(Connection conn, String sql, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlQuery(conn, sql, null);
        return getListFromResultSet(rs, result);
    }

    @Override
    public List<? extends BaseDTO> getListBeanBySqlFile(Connection conn, String sqlFileName, List params, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlFile(conn, sqlFileName, params);
        return getListFromResultSet(rs, result);
    }

    @Override
    public List<? extends BaseDTO> getListBeanBySqlFile(Connection conn, String sqlFileName, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeSqlFile(conn, sqlFileName, null);
        return getListFromResultSet(rs, result);
    }

    @Override
    public List<? extends BaseDTO> getListBeanByProc(Connection conn, String procName, List params, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeCallabble(conn, procName, params);
        return getListFromResultSet(rs, result);
    }

    @Override
    public List<? extends BaseDTO> getListBeanByProc(Connection conn, String procName, BaseResult result) throws SQLException {
        ResultSet rs = helper.executeCallabble(conn, procName, null);
        return getListFromResultSet(rs, result);
    }

    private BaseDTO getBeanFromResultSet(ResultSet rs, BaseResult result) throws SQLException {
        return result.getBeanFromResultSet(rs);
    }
    
    private List<? extends BaseDTO> getListFromResultSet(ResultSet rs, BaseResult result) throws SQLException {
        return result.getListFromResultSet(rs);
    }

}
