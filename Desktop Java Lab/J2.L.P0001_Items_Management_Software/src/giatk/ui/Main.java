/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.ui;

import giatk.daos.ItemDAO;
import giatk.daos.SupplierDAO;
import giatk.dtos.Item;
import giatk.dtos.Supplier;
import giatk.utils.MyConnection;
import java.sql.Connection;
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
    DefaultTableModel supplierModel;
    DefaultTableModel itemModel;
    ArrayList<Supplier> supplierList;
    ArrayList<Item> itemList;
    int indexSupplier = -1;
    int indexItem = -1;
    Connection conn;
    boolean newSupplier = false;
    boolean newItem = false;

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        itemList = new ArrayList<>();
        supplierModel = (DefaultTableModel) tblSuppliers.getModel();
        itemModel = (DefaultTableModel) tblItems.getModel();
        supplierModel.setColumnIdentifiers(new Object[]{"Code", "Name", "Address"});
        itemModel.setColumnIdentifiers(new Object[]{"Code", "Name", "Supplier", "Unit", "Price", "Supply"});
        try {
            conn = MyConnection.getConnection();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        showSupplierTable();
        showItemTable();

    }

    public void getSupplierList() {
        supplierList = SupplierDAO.getSupplierList(conn);
    }

    public void showSupplierTable() {
        getSupplierList();
        //Remove old data
        int rowCount = supplierModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            supplierModel.removeRow(0);
        }
        //add new data
        for (Supplier s : supplierList) {
            supplierModel.addRow(new Object[]{
                s.getSupCode(), s.getSupName(), s.getSupAddress()
            });
        }
    }

    public void getItemList() {
        itemList = ItemDAO.getItemList(conn);
    }

    public void showItemTable() {
        getItemList();
        //Remove old data
        int rowCount = itemModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            itemModel.removeRow(0);
        }
        //add new data
        for (Item item : itemList) {
            String supName = "";
            for (Supplier supplier : supplierList) {
                if (item.getSupCode().equalsIgnoreCase(supplier.getSupCode())) {
                    supName = supplier.getSupName();
                    break;
                }
            }
            itemModel.addRow(new Object[]{
                item.getItemCode(), item.getItemName(), item.getSupCode() + "-" + supName, item.getUnit(), item.getPrice(), item.isSupplying()
            });
        }
        //add item into combo box Supplier
        cbbSupplier.removeAllItems();
        for (Supplier s : supplierList) {
            cbbSupplier.addItem(s.getSupCode() + "-" + s.getSupName());
        }
    }

    public void clearDetailSupplier() {
        txtSupplierCode.setText(null);
        txtSupplierName.setText(null);
        txtSupplierAddress.setText(null);
        chkSupplierColloborating.setSelected(false);
        txtSupplierCode.requestFocus();
    }

    public void clearDetailItem() {
        txtItemCode.setText(null);
        txtItemName.setText(null);
        txtUnit.setText(null);
        txtPrice.setText(null);
        chkSupplying.setSelected(false);
        cbbSupplier.setSelectedIndex(0);
        txtItemCode.requestFocus();
    }

    public boolean isValidInputSupplier() {
        if (txtSupplierCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input supplier's code!");
            txtSupplierCode.requestFocus();
            return false;
        }
        if (txtSupplierName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input supplier's name!");
            txtSupplierName.requestFocus();
            return false;
        }
        if (txtSupplierAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input supplier's address!");
            txtSupplierAddress.requestFocus();
            return false;
        }
        return true;
    }

    public boolean isValidInputItem() {
        if(txtItemCode.getText().length() > 5){
            JOptionPane.showMessageDialog(this, "Please input code length <= 5");
            return false;
        }
        if (txtItemCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input item's code!");
            txtItemCode.requestFocus();
            return false;
        }
        if (txtItemName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input item's name!");
            txtItemName.requestFocus();
            return false;
        }
        if (txtUnit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input item's unit!");
            txtUnit.requestFocus();
            return false;
        }
        if (txtUnit.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "Item's length smaller than 10!");
            txtUnit.requestFocus();
            return false;
        }
        if (txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input item's price!");
            txtPrice.requestFocus();
            return false;
        }
        try {
        if (Integer.parseInt(txtPrice.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Price must be large than 0");
            txtPrice.requestFocus();
            return false;
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Price must be number");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tab = new javax.swing.JTabbedPane();
        tabSuppliers = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuppliers = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSupplierCode = new javax.swing.JTextField();
        txtSupplierName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSupplierAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkSupplierColloborating = new javax.swing.JCheckBox();
        btnAddNewSupplier = new javax.swing.JButton();
        btnSaveSupplier = new javax.swing.JButton();
        btnDeleteSupplier = new javax.swing.JButton();
        tabItems = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        cbbSupplier = new javax.swing.JComboBox<>();
        txtUnit = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        chkSupplying = new javax.swing.JCheckBox();
        btnAddNewItem = new javax.swing.JButton();
        btnSaveItem = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Items Management Software");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuppliersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuppliers);

        jLabel1.setText("Code");

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Colloborating");

        btnAddNewSupplier.setText("Add New");
        btnAddNewSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewSupplierActionPerformed(evt);
            }
        });

        btnSaveSupplier.setText("Save");
        btnSaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSupplierActionPerformed(evt);
            }
        });

        btnDeleteSupplier.setText("Delete");
        btnDeleteSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddNewSupplier)
                        .addGap(51, 51, 51)
                        .addComponent(btnSaveSupplier)
                        .addGap(50, 50, 50)
                        .addComponent(btnDeleteSupplier))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSupplierAddress)
                            .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkSupplierColloborating)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(82, 82, 82)
                        .addComponent(txtSupplierCode, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSupplierCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSupplierColloborating)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNewSupplier)
                    .addComponent(btnSaveSupplier)
                    .addComponent(btnDeleteSupplier))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabSuppliersLayout = new javax.swing.GroupLayout(tabSuppliers);
        tabSuppliers.setLayout(tabSuppliersLayout);
        tabSuppliersLayout.setHorizontalGroup(
            tabSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        tabSuppliersLayout.setVerticalGroup(
            tabSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        Tab.addTab("Suppliers", tabSuppliers);

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblItems);

        jLabel5.setText("Item Code");

        jLabel6.setText("Item Name");

        jLabel7.setText("Supplier");

        jLabel8.setText("Unit");

        jLabel9.setText("Price");

        jLabel10.setText("Supplying");

        btnAddNewItem.setText("Add New");
        btnAddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewItemActionPerformed(evt);
            }
        });

        btnSaveItem.setText("Save");
        btnSaveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveItemActionPerformed(evt);
            }
        });

        btnDeleteItem.setText("Delete");
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddNewItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveItem)
                        .addGap(39, 39, 39)
                        .addComponent(btnDeleteItem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSupplying)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtItemCode)
                                .addComponent(txtItemName)
                                .addComponent(cbbSupplier, 0, 236, Short.MAX_VALUE)
                                .addComponent(txtUnit)
                                .addComponent(txtPrice)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(chkSupplying))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNewItem)
                    .addComponent(btnSaveItem)
                    .addComponent(btnDeleteItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabItemsLayout = new javax.swing.GroupLayout(tabItems);
        tabItems.setLayout(tabItemsLayout);
        tabItemsLayout.setHorizontalGroup(
            tabItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabItemsLayout.setVerticalGroup(
            tabItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tab.addTab("Items", tabItems);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewSupplierActionPerformed
        newSupplier = true;
        txtSupplierCode.setEditable(true);
        clearDetailSupplier();
    }//GEN-LAST:event_btnAddNewSupplierActionPerformed

    private void tblSuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuppliersMouseClicked
        indexSupplier = tblSuppliers.getSelectedRow();
        if (indexSupplier != -1) {
            Supplier s = supplierList.get(indexSupplier);
            txtSupplierCode.setText(s.getSupCode());
            txtSupplierName.setText(s.getSupName());
            txtSupplierAddress.setText(s.getSupAddress());
            chkSupplierColloborating.setSelected(s.isSupColloborating());
            txtSupplierCode.setEditable(false);
        }
    }//GEN-LAST:event_tblSuppliersMouseClicked

    private void btnSaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSupplierActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Do you want to save?", "Save?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            return;
        if (!isValidInputSupplier()) {
            return;
        }
        Supplier s = new Supplier(txtSupplierCode.getText(), txtSupplierName.getText(), txtSupplierAddress.getText(), chkSupplierColloborating.isSelected());

        if (newSupplier) {
            try {

                if (SupplierDAO.addNewSupplier(s, conn)) {
                    JOptionPane.showMessageDialog(this, "Saved!");
                    showSupplierTable();
                    showItemTable();
                    newSupplier = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            if (indexSupplier < 0) {
                return;
            }
            String supCode = supplierModel.getValueAt(indexSupplier, 0).toString();

            try {
                if (SupplierDAO.updateSupplier(supCode, s, conn)) {
                    JOptionPane.showMessageDialog(this, "Saved!");
                    showSupplierTable();
                    showItemTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }//GEN-LAST:event_btnSaveSupplierActionPerformed

    private void btnDeleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSupplierActionPerformed
        if (indexSupplier < 0) {
            return;
        }
        String supCode = tblSuppliers.getValueAt(indexSupplier, 0).toString();
        if (JOptionPane.showConfirmDialog(this, "Do you want to delete " + supplierList.get(indexSupplier).getSupName() + "?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                if (SupplierDAO.deleteSupplier(supCode, conn, false)) {
                    JOptionPane.showMessageDialog(this, "Successful!");
                    showSupplierTable();
                    showItemTable();
                    indexSupplier = -1;
                    clearDetailSupplier();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Delete the supplier only when this supplier has no items");
            }
        }
    }//GEN-LAST:event_btnDeleteSupplierActionPerformed

    private void btnAddNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewItemActionPerformed
        newItem = true;
        txtItemCode.setEditable(true);
        clearDetailItem();

    }//GEN-LAST:event_btnAddNewItemActionPerformed

    private void btnSaveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveItemActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Do you want to save?", "Save?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            return;
        Item item;
        if (!isValidInputItem()) {
            return;
        }
        try {
            item = new Item(txtItemCode.getText(), txtItemName.getText(),
                    supplierList.get(cbbSupplier.getSelectedIndex()).getSupCode(),
                    txtUnit.getText(), Integer.parseInt(txtPrice.getText()),
                    chkSupplying.isSelected());
        } catch (Exception e) {
            return;
        }

        if (newItem) {
            try {
                if (ItemDAO.addNewSItem(item, conn)) {
                    JOptionPane.showMessageDialog(this, "Saved!");
                    showSupplierTable();
                    showItemTable();
                    newItem = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if(indexItem < 0){
            JOptionPane.showMessageDialog(this, "If you want to add new item, please click Add New button!");
        } else{
            try {
                String itemCode = tblItems.getValueAt(indexItem, 0).toString();
                if (ItemDAO.updateItem(itemCode, item, conn)) {
                    JOptionPane.showMessageDialog(this, "Saved!");
                    showSupplierTable();
                    showItemTable();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveItemActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        if (indexItem < 0) {
            return;
        }
        String itemCode = tblItems.getValueAt(indexItem, 0).toString();
        if (JOptionPane.showConfirmDialog(this, "Do you want to delete " + itemList.get(indexItem).getItemName() + "?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                if (ItemDAO.deleteItem(itemCode, conn)) {
                    JOptionPane.showMessageDialog(this, "Successful!");
                    showSupplierTable();
                    showItemTable();
                    indexItem = -1;
                    clearDetailItem();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void tblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMouseClicked
        indexItem = tblItems.getSelectedRow();
        if (indexItem != -1) {
            txtItemCode.setEditable(false);
            Item item = itemList.get(indexItem);
            txtItemCode.setText(item.getItemCode());
            txtItemName.setText(item.getItemName());
            txtPrice.setText("" + item.getPrice());
            txtUnit.setText("" + item.getUnit());
            chkSupplying.setSelected(item.isSupplying());
            for (int i = 0; i < supplierList.size(); i++) {
                if (supplierList.get(i).getSupCode().equalsIgnoreCase(item.getSupCode())) {
                    cbbSupplier.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tblItemsMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton btnAddNewItem;
    private javax.swing.JButton btnAddNewSupplier;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnDeleteSupplier;
    private javax.swing.JButton btnSaveItem;
    private javax.swing.JButton btnSaveSupplier;
    private javax.swing.JComboBox<String> cbbSupplier;
    private javax.swing.JCheckBox chkSupplierColloborating;
    private javax.swing.JCheckBox chkSupplying;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel tabItems;
    private javax.swing.JPanel tabSuppliers;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblSuppliers;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSupplierAddress;
    private javax.swing.JTextField txtSupplierCode;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
