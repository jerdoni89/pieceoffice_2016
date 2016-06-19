/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

import biz.source_code.miniConnectionPoolManager.MiniConnectionPoolManager;
import com.microsoft.sqlserver.jdbc.SQLServerXADataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.postgresql.ds.PGConnectionPoolDataSource;

/**
 *
 * @author Lucky Bear
 */
public class PoolManager {

    /**
     * DBMS DataSource
     */
    private static PGConnectionPoolDataSource postgresDataSource;
    private static SQLServerXADataSource sqlServerDataSource;
    private static OracleConnectionPoolDataSource oracleDataSource;
    private static IStrategyConfigDb strategyDbConfig;
    private static MiniConnectionPoolManager mcpm;
    private static DbConfig dbConfig;

    /**
     * Constructor
     */
    public PoolManager() {

    }

    /**
     * Constructor with IStrategyConfigDb
     *
     * @param pStrategyDbConfig
     */
    public PoolManager(IStrategyConfigDb pStrategyDbConfig) {
        strategyDbConfig = pStrategyDbConfig;
        dbConfig = strategyDbConfig.loadConfig();
    }

    public MiniConnectionPoolManager getConnectionPoolManager(DBMSType dbms) {
        switch (dbms) {
            case MYSQL:
                break;
            case ORACLE:
                if (mcpm == null) {
                    try {
                        oracleDataSource = new OracleConnectionPoolDataSource();
                        strategyDbConfig.setOracleDataSource(oracleDataSource);
                        mcpm = new MiniConnectionPoolManager(oracleDataSource, dbConfig.getMaxConnection(), dbConfig.getTimout());
                    } catch (SQLException ex) {
                        Logger.getLogger(PoolManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case POSTGRES:
                if (mcpm == null) {
                    postgresDataSource = new PGConnectionPoolDataSource();
                    strategyDbConfig.setPostgresDataSource(postgresDataSource);
                    mcpm = new MiniConnectionPoolManager(postgresDataSource, dbConfig.getMaxConnection(), dbConfig.getTimout());
                }
                break;
            case SQL_SERVER:
                if (mcpm == null) {
                    sqlServerDataSource = new SQLServerXADataSource();
                    strategyDbConfig.setSqlServerDataSource(sqlServerDataSource);
                    mcpm = new MiniConnectionPoolManager(sqlServerDataSource, dbConfig.getMaxConnection(), dbConfig.getTimout());
                }
                break;
        }
        return mcpm;
    }
}
