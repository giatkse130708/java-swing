/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.ui;

import giatk.daos.StockDAO;
import giatk.dtos.Stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kha Gia
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    Connection conn;
    DefaultTableModel model;
    ArrayList<Stock> list;

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            conn = getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        init();
    }

    private void init() {
        model = (DefaultTableModel) tblStocks.getModel();
        model.setColumnIdentifiers(new Object[]{
            "StockID", "StockName", "StockAddress", "Date Available", "Note"
        });
        list = new ArrayList<>();
        list.add(new Stock(1, "Stock one", "No1 - Washington", "11/05/2010", ""));
        list.add(new Stock(2, "Stock two", "372 Cave town", "09/07/2010", ""));
        list.add(new Stock(3, "Stock three", "Nary angel - 890", "13/05/2010", "Store dangerous"));
        list.add(new Stock(4, "Stock four", "Twin towner - 01", "04/07/2015", ""));
        list.add(new Stock(5, "Stock five", "Victory anniversa", "08/12/2014", ""));
        for (Stock stock : list) {
            model.addRow(new Object[]{
                stock.getID(), stock.getName(), stock.getAddress(), stock.getDateAvailable(), stock.getNote()
            });
        }

    }

    private void updateTable() {
        list = new ArrayList<>();
        for (int i = 0; i < tblStocks.getRowCount(); i++) {
            list.add(new Stock(Integer.parseInt(model.getValueAt(i, 0).toString()),
                    model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString(),
                    model.getValueAt(i, 3).toString(), model.getValueAt(i, 4).toString()));
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=FU_DB", "sa", "123");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        btnInsertDB = new javax.swing.JButton();
        btnDeleteData = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Use transaction in JDBC");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblStocks);

        btnInsertDB.setText("Insert DB");
        btnInsertDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDBActionPerformed(evt);
            }
        });

        btnDeleteData.setText("Clear DB's data");
        btnDeleteData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDataActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 8)); // NOI18N
        jLabel1.setText("Can edit data directly on table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnInsertDB)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertDB)
                            .addComponent(btnDeleteData))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDBActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Insert database?", "Insert DB", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }
        updateTable();
        try {
            if (StockDAO.insertStocks(conn, list)) {
                JOptionPane.showMessageDialog(this, "Successful");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnInsertDBActionPerformed

    private void btnDeleteDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDataActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you want to delete database?", "Deleted?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }
        if (StockDAO.deleteTable(conn)) {
            JOptionPane.showMessageDialog(this, "Deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Not found!");
        }

    }//GEN-LAST:event_btnDeleteDataActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            conn.close();
        } catch (Exception e) {
            if (JOptionPane.showConfirmDialog(this, "Cannot close connection SQL: "
                    + e.getMessage() + "\nDo you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                this.setDefaultCloseOperation(Main.DO_NOTHING_ON_CLOSE);
            } else {
                this.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteData;
    private javax.swing.JButton btnInsertDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStocks;
    // End of variables declaration//GEN-END:variables
}
