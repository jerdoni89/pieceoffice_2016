/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

import com.microsoft.sqlserver.jdbc.SQLServerXADataSource;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.postgresql.ds.PGConnectionPoolDataSource;

/**
 *
 * @author Lucky Bear
 */
public interface IStrategyConfigDb {
    
    public static final String CONFIG_FILE = "/config/DbConfig.properties";
    
    public DbConfig loadConfig();
    
    public void setOracleDataSource(OracleConnectionPoolDataSource oracleDatasource);
    
    public void setPostgresDataSource(PGConnectionPoolDataSource postgresDatasource);
    
    public void setSqlServerDataSource(SQLServerXADataSource sqlServerDatasource);
    
}
