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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Kha Gia
 */
public class StockDAO {
    
    public static boolean insertStocks(Connection conn, ArrayList<Stock> list) throws SQLException, ParseException{
        conn.setAutoCommit(false);
        /*Mặc định khi tạo 1 Connection tạo ra sẽ có thuộc tính Auto-Commit bằng true.
        Có nghĩa là ứng với 1 câu lệnh SQL thiết lập cho object tại thời điểm đó thì
        Connection object sẽ tự động thực thi để tác động đến Database mà không cần
        phải gọi lệnh commit của Connection đó. Ở đây, khi dùng kỹ thuật Batch Update
        thì lập trình viên muốn khi nào yêu cầu, các lệnh đã gắn cho Connection object 
        mới được thực thi, vì thế Auto-Commit phải được thiết lập là false. */
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Stocks VALUES(?,?,?,?,?)");
        try {
            for (Stock stock : list) {
                ps.setInt(1, stock.getID());
                ps.setString(2, stock.getName());
                ps.setString(3, stock.getAddress());
                Date javaDate = new SimpleDateFormat("dd/MM/yyyy").parse(stock.getDateAvailable()); //convert String -> java.util.Date
                String sqlDate = new SimpleDateFormat("yyyy-MM-dd").format(javaDate); //convert java.util.Date -> String,which is Date's format in SQL
                ps.setString(4, sqlDate);
                ps.setString(5, stock.getNote());
                ps.execute();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            conn.rollback(); //Nếu có lỗi xảy ra thì quay lại điểm khởi đầu
            return false;
        }
        conn.commit();//Gọi lệnh commit của Connection để tác động trực tiếp lên DB, thực hiện các lệnh SQL đã gắn sẵn cho các đối tượng Statement.
        conn.setAutoCommit(true);
        return true;
    }
    
    public static boolean deleteTable(Connection conn) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE Stocks");
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
}
