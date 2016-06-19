/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao;

import com.po.entity.BaseDTO;
import com.po.entity.BaseResult;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Lucky Bear
 */
public interface BaseDAO {
    
    public BaseDTO getBeanBySql(Connection conn, String sql, List params, BaseResult result) throws Exception;

    public BaseDTO getBeanBySql(Connection conn, String sql, BaseResult result) throws Exception;

    public BaseDTO getBeanBySqlFile(Connection conn, String sqlFileName, List params, BaseResult result) throws Exception;

    public BaseDTO getBeanBySqlFile(Connection conn, String sqlFileName, BaseResult result) throws Exception;

    public BaseDTO getBeanByProc(Connection conn, String procName, List params, BaseResult result) throws Exception;

    public BaseDTO getBeanByProc(Connection conn, String procName, BaseResult result) throws Exception;
    
    public List<? extends BaseDTO> getListBeanBySql(Connection conn, String sql, List params, BaseResult result) throws Exception;

    public List<? extends BaseDTO> getListBeanBySql(Connection conn, String sql, BaseResult result) throws Exception;

    public List<? extends BaseDTO> getListBeanBySqlFile(Connection conn, String sqlFileName, List params, BaseResult result) throws Exception;

    public List<? extends BaseDTO> getListBeanBySqlFile(Connection conn, String sqlFileName, BaseResult result) throws Exception;

    public List<? extends BaseDTO> getListBeanByProc(Connection conn, String procName, List params, BaseResult result) throws Exception;

    public List<? extends BaseDTO> getListBeanByProc(Connection conn, String procName, BaseResult result) throws Exception;
    
    public int updateBeanBySql(Connection conn, String sql, List params, BaseResult result) throws Exception;

    public int updateBeanBySql(Connection conn, String sql, BaseResult result) throws Exception;

    public int updateBeanByFile(Connection conn, String sqlFileName, List params, BaseResult result) throws Exception;

    public int updateBeanByFile(Connection conn, String sqlFileName, BaseResult result) throws Exception;
    
    public long insertBeanBySql(Connection conn, String sql, List params, BaseResult result) throws Exception;

    public long insertBeanBySql(Connection conn, String sql, BaseResult result) throws Exception;

    public long insertBeanByFile(Connection conn, String sqlFileName, List params, BaseResult result) throws Exception;

    public long insertBeanByFile(Connection conn, String sqlFileName, BaseResult result) throws Exception;
    
}
