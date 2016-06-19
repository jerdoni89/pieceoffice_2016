/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.dao.db;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucky Bear
 */
public class Test {

    public static void main(String[] args) {
        try {
            String path1 = new File(".").getCanonicalPath();
            String path2 = new File(".").getAbsolutePath();
            String path3 = new File(".").getPath();
            System.out.println(path1);
            System.out.println(path2);
            System.out.println(path3);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public String getCanonicalt() {
        return "";
    }

}
