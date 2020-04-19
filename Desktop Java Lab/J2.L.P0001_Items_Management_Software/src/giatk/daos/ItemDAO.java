/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.daos;

import giatk.dtos.Item;
import giatk.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kha Gia
 */
public class ItemDAO {
    
    public static boolean addNewSItem(Item i, Connection conn) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("INSERT INTO tblItems VALUES(?,?,?,?,?,?)");
        ps.setString(1, i.getItemCode());
        ps.setString(2, i.getItemName());
        ps.setString(3, i.getSupCode());
        ps.setString(4, i.getUnit());
        ps.setInt(5, i.getPrice());
        ps.setBoolean(6, i.isSupplying());
        return ps.executeUpdate() > 0;
    }
    
    public static boolean deleteItem(String itemCode, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM tblItems WHERE itemCode=?");
        ps.setString(1, itemCode);
        return ps.executeUpdate() > 0;
    }
    
    public static boolean updateItem(String itemCode, Item item, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE tblItems SET itemName=?, supCode=?, unit=?, price=?, supplying=? WHERE itemCode=?");
        ps.setString(1, item.getItemName());
        ps.setString(2, item.getSupCode());
        ps.setString(3, item.getUnit());
        ps.setInt(4, item.getPrice());
        ps.setBoolean(5, item.isSupplying());
        ps.setString(6, itemCode);
        return ps.executeUpdate() > 0;
    }
    
    public static ArrayList<Item> getItemList(Connection conn) {
        ArrayList<Item> itemList = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT itemCode, itemName, supCode, unit, price, supplying FROM tblItems");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                itemList.add(new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return itemList;
    }
}
