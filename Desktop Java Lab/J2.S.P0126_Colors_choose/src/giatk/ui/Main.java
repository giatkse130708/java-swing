/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.ui;

import java.awt.Color;

/**
 *
 * @author Kha Gia
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        rdRed.setSelected(true);
        init();
    }
    
    public void init() {
        String color;
        String message = " is selected!";
        if(rdRed.isSelected()){
            color = "Red";
            lbColor.setBackground(Color.red);
        }else if(rdBlue.isSelected()){
            color = "Blue";
            lbColor.setBackground(Color.blue);
        }else if(rdGreen.isSelected()){
            color = "Green";
            lbColor.setBackground(Color.green);
        }else{
            color = "Black";
            lbColor.setBackground(Color.black);
        }
        lbColor.setText(color + message);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgColor = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdRed = new javax.swing.JRadioButton();
        rdBlue = new javax.swing.JRadioButton();
        rdGreen = new javax.swing.JRadioButton();
        rdBlack = new javax.swing.JRadioButton();
        lbColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgColor.add(rdRed);
        rdRed.setText("Red");
        rdRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdRedActionPerformed(evt);
            }
        });

        bgColor.add(rdBlue);
        rdBlue.setText("Blue");
        rdBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBlueActionPerformed(evt);
            }
        });

        bgColor.add(rdGreen);
        rdGreen.setText("Green");
        rdGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGreenActionPerformed(evt);
            }
        });

        bgColor.add(rdBlack);
        rdBlack.setText("Black");
        rdBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBlackActionPerformed(evt);
            }
        });

        lbColor.setBackground(new java.awt.Color(255, 255, 255));
        lbColor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbColor.setForeground(new java.awt.Color(255, 255, 255));
        lbColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbColor.setText("jLabel1");
        lbColor.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdBlack)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rdBlue)
                        .addComponent(rdRed))
                    .addComponent(rdGreen))
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(lbColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdBlue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdGreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdBlack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbColor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRedActionPerformed
        init();
    }//GEN-LAST:event_rdRedActionPerformed

    private void rdBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBlueActionPerformed
        init();
    }//GEN-LAST:event_rdBlueActionPerformed

    private void rdGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGreenActionPerformed
        init();
    }//GEN-LAST:event_rdGreenActionPerformed

    private void rdBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBlackActionPerformed
        init();
    }//GEN-LAST:event_rdBlackActionPerformed

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
    private javax.swing.ButtonGroup bgColor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbColor;
    private javax.swing.JRadioButton rdBlack;
    private javax.swing.JRadioButton rdBlue;
    private javax.swing.JRadioButton rdGreen;
    private javax.swing.JRadioButton rdRed;
    // End of variables declaration//GEN-END:variables
}