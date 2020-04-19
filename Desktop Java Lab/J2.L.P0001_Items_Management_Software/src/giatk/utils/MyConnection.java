/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Kha Gia
 */
public class MyConnection {
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=J2LP0001","sa","123");
    }
}
