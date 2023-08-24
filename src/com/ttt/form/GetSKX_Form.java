/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.PhieuNhapDAO;
import com.ttt.DAO.PhieuXuatDAO;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.PhieuNhap;
import com.ttt.Entity.PhieuXuat;
import com.ttt.properties.SystemProperties;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author ASUS
 */
public class GetSKX_Form extends javax.swing.JFrame {

    public static GetSKX_Form Instance;
    // public static JComboBox cbbPN;
    public JButton button;
    public String soKhung;
    public String dienGiai;
    public String maNV;
    public String tenNV;

    public GetSKX_Form() {
        initComponents();
        Instance = this;
        button = btnOK;
        //   cbbPN=cboPhieuNhap;
        setBackground(new Color(0, 0, 0, 0));
        init();
    }
    //SystemProperties pro = new SystemProperties();

    private void init() {
        // headerLogin.initMoving(this);
        // headerLogin.initEvent(this, panelBackgroundLogin);
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        //tạo panel
        ThemeColorChange.getInstance().initBackground(panelBackgroundLogin);
        //set background
        ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
        // set darkMode
        if (!pro.isDarkMode()) {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackgroundLogin.setBackground(Color.WHITE);
        } else {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.DARK);
            panelBackgroundLogin.setBackground(new Color(80, 80, 80));
        }
        fillcboChiTietPhieuNhap();
    }

    void fillcboChiTietPhieuNhap() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChiTietPhieuNhap.getModel();
        model.removeAllElements();
        List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_chuaXuatKho();
        for (ChiTietPhieuNhap cd : list) {
            model.addElement(cd);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackgroundLogin = new com.ttt.swing.PanelBackground();
        btnOK = new com.ttt.swing.Button();
        btnCancel = new com.ttt.swing.Button();
        cboChiTietPhieuNhap = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnOK.setBackground(new java.awt.Color(102, 102, 102));
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(102, 102, 102));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("ĐÓNG");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cboChiTietPhieuNhap.setBackground(new java.awt.Color(102, 102, 102));
        cboChiTietPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        cboChiTietPhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số khung" }));
        cboChiTietPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChiTietPhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackgroundLoginLayout = new javax.swing.GroupLayout(panelBackgroundLogin);
        panelBackgroundLogin.setLayout(panelBackgroundLoginLayout);
        panelBackgroundLoginLayout.setHorizontalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboChiTietPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelBackgroundLoginLayout.setVerticalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cboChiTietPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        XuatKho_Form.txtsk.setText(soKhung);
                
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void cboChiTietPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChiTietPhieuNhapActionPerformed

        ChiTietPhieuNhap px = (ChiTietPhieuNhap) cboChiTietPhieuNhap.getSelectedItem();
        if (px != null) {
            soKhung = px.getSoKhung();
        }

    }//GEN-LAST:event_cboChiTietPhieuNhapActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GetPN_Form().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnCancel;
    private com.ttt.swing.Button btnOK;
    private javax.swing.JComboBox<String> cboChiTietPhieuNhap;
    private com.ttt.swing.PanelBackground panelBackgroundLogin;
    // End of variables declaration//GEN-END:variables
}
