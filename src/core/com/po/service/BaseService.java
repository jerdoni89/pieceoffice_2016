/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.service;

import biz.source_code.miniConnectionPoolManager.MiniConnectionPoolManager;
import com.po.dao.BaseDAO;
import com.po.dao.BaseDAOImpl;
import com.po.dao.db.PoolManager;
import com.po.dao.db.SPMConfigDbMode;
import com.po.resp.MsgResp;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Lucky Bear
 */
public abstract class BaseService {

    private static PoolManager poolManager;
    protected static MiniConnectionPoolManager pool;
    protected BaseDAO baseDAO = new BaseDAOImpl();
    protected final static String DATA = "data";
    protected final Logger logger = Logger.getLogger(this.getClass());
    protected String language = "vi";
    
    public BaseService() {
        if (poolManager == null) {
            poolManager = new PoolManager(new SPMConfigDbMode());
        }
        if (pool == null) {
            pool = poolManager.getConnectionPoolManager();
        }
    }
    
    protected void startTransaction(Connection conn) throws SQLException {
            conn.setAutoCommit(false);
    }

    protected void endTransaction(Connection conn) throws SQLException {
            conn.commit();
    }

    protected void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }
    
    protected void setMsgResp(MsgResp resp, int respCode, Object obj) {
        if (resp != null) {
            Map<String, Object> data = new HashMap<>();
            data.put(DATA, obj);
            resp.setRespCode(respCode);
            resp.setRespDesc(getRespDesc(respCode));
            resp.setRespContent(data);
        }
    }

    private String getRespDesc(int respCode) {
        InputStream is = null;
        String respDesc = "";
        try {
            is = getClass().getResourceAsStream("/config/RespMessages.properties");
            // load a properties file
            Properties prop = new Properties();
            prop.load(is);
            respDesc = prop.getProperty(language + "." + respCode);
        } catch (IOException ex) {
            logger.error(ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    logger.error(ex);
                }
            }
        }
        return respDesc;
    }

}
