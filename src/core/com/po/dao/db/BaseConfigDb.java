/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

import com.microsoft.sqlserver.jdbc.SQLServerXADataSource;
import static com.po.dao.db.IStrategyConfigDb.CONFIG_FILE;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.apache.log4j.Logger;
import org.postgresql.ds.PGConnectionPoolDataSource;

/**
 *
 * @author Lucky Bear
 */
public abstract class BaseConfigDb implements IStrategyConfigDb {

    protected DbConfig dbConfig = new DbConfig();
    protected Properties prop = new Properties();
    public static Logger logger;

    public BaseConfigDb() {
        logger = Logger.getLogger(this.getClass());
    }

    protected abstract void loadDbConfig();

    @Override
    public DbConfig loadConfig() {
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream(CONFIG_FILE);
            // load a properties file
            prop.load(is);
            dbConfig.setDbmsType(prop.getProperty("dbmsType").trim());
            dbConfig.setMaxConnection(Integer.parseInt(prop.getProperty("db.maxconnection").trim()));
            dbConfig.setTimout(Integer.parseInt(prop.getProperty("db.timeout").trim()));
            loadDbConfig();
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
        return dbConfig;
    }
    
    @Override
    public void setOracleDataSource(OracleConnectionPoolDataSource oracleDatasource) {
        oracleDatasource.setServerName(dbConfig.getHost());
        oracleDatasource.setDriverType("thin");
        oracleDatasource.setPortNumber(dbConfig.getPort());
        oracleDatasource.setUser(dbConfig.getUser());
        oracleDatasource.setPassword(dbConfig.getPass());
    }
    
    @Override
    public void setPostgresDataSource(PGConnectionPoolDataSource postgresDatasource) {
        postgresDatasource.setServerName(dbConfig.getHost());
        postgresDatasource.setDatabaseName(dbConfig.getDatabaseName());
        postgresDatasource.setUser(dbConfig.getUser());
        postgresDatasource.setPassword(dbConfig.getPass());
    }
    
    @Override
    public void setSqlServerDataSource(SQLServerXADataSource sqlServerDatasource) {
        sqlServerDatasource.setServerName(dbConfig.getHost());
        sqlServerDatasource.setDatabaseName(dbConfig.getDatabaseName());
        sqlServerDatasource.setUser(dbConfig.getUser());
        sqlServerDatasource.setPassword(dbConfig.getPass());
    }
}
