/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.daos;

import giatk.dtos.Stock;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kha Gia
 */
public class StockDAO {
    
    public static boolean insertStock(Connection conn, Stock stock) throws SQLException, ParseException{
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Stocks VALUES(?,?,?,?,?)");
        ps.setInt(1, stock.getID());
        ps.setString(2, stock.getName());
        ps.setString(3, stock.getAddress());
        Date javaDate = new SimpleDateFormat("dd/MM/yyyy").parse(stock.getDateAvailable()); //convert String -> java.util.Date
        String sqlDate = new SimpleDateFormat("yyyy-MM-dd").format(javaDate); //convert java.util.Date -> String,which is Date's format in SQL
        ps.setString(4, sqlDate);
        ps.setString(5, stock.getNote());
        return ps.executeUpdate() > 0;
    }
}
