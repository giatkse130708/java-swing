/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.daos;

import giatk.dtos.Supplier;
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
public class SupplierDAO {

    public static boolean addNewSupplier(Supplier s, Connection conn) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("INSERT INTO tblSuppliers VALUES(?,?,?,?)");
        ps.setString(1, s.getSupCode());
        ps.setString(2, s.getSupName());
        ps.setString(3, s.getSupAddress());
        ps.setBoolean(4, s.isSupColloborating());
        return ps.executeUpdate() > 0;
    }

    public static boolean deleteSupplier(String supplierCode, Connection conn, boolean deleteItem) throws SQLException {
        PreparedStatement ps;
        if (deleteItem) {
            ps = conn.prepareStatement("DELETE FROM tblItems WHERE SupCode=?");
            ps.setString(1, supplierCode);
            ps.execute();
        }
        ps = conn.prepareStatement("DELETE FROM tblSuppliers WHERE SupCode=?");
        ps.setString(1, supplierCode);
        return ps.executeUpdate() > 0;
    }

    public static boolean updateSupplier(String supCode, Supplier s, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE tblSuppliers SET SupName=?, Address=?, colloborating=? WHERE SupCode=?");
        ps.setString(1, s.getSupName());
        ps.setString(2, s.getSupAddress());
        ps.setBoolean(3, s.isSupColloborating());
        ps.setString(4, supCode);
        return ps.executeUpdate() > 0;
    }

    public static ArrayList<Supplier> getSupplierList(Connection conn) {
        ArrayList<Supplier> supplierList = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT SupCode, SupName, Address, colloborating FROM tblSuppliers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                supplierList.add(new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return supplierList;
    }
}
