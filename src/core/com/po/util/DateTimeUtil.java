/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.util;

import java.util.Date;

/**
 *
 * @author Lucky Bear
 */
public class DateTimeUtil {
    
    public static Date toUtilDate(java.sql.Date sqlDate) {
        Date utilDate = new Date(sqlDate.getTime());
        return utilDate;
    }
    
    public static Date toSqlDate(Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
    
}
