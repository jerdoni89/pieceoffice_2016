/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

/**
 *
 * @author Lucky Bear
 */
public class SPMConfigDbMode extends BaseConfigDb {

    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    @Override
    protected void loadDbConfig() {
        dbConfig.setHost(prop.getProperty("spm.host"));
        dbConfig.setUser(prop.getProperty("spm.user"));
        dbConfig.setPass(prop.getProperty("spm.pass"));
        dbConfig.setDatabaseName(prop.getProperty("spm.dbName"));
    }

}
