package com.ttt.form;

import com.ttt.DAO.LoaiXeDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.DAO.ViTriDAO;
import com.ttt.Entity.LoaiXe;
import com.ttt.Entity.ViTri;
import com.ttt.transitions.TransitionsForm;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public final class TonKho_Form extends TransitionsForm {

    int row = -1;
    public String maVT;
    public String maLX;

    public TonKho_Form() {
        initComponents();
        init();
    }

    void init() {
        this.fillcboLoaiXe();
        this.fillcboViTri();
    }

    void fillcboLoaiXe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiXe.getModel();
        model.removeAllElements();
        List<LoaiXe> list = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
        for (LoaiXe cd : list) {
            model.addElement(cd);
        }
    }

    void fillcboViTri() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboViTri.getModel();
        model.removeAllElements();
        List<ViTri> list = ViTriDAO.getNewViTriDAO().selectAll();
        for (ViTri vt : list) {
            model.addElement(vt);

        }
    }

//    void fillTableTonKho() {
//        DefaultTableModel model = (DefaultTableModel) tblTonKho.getModel();
//        model.setRowCount(0);
//
//        try {
//            LoaiXe lx = (LoaiXe) cboLoaiXe.getSelectedItem();
//            ViTri vt = (ViTri) cboViTri.getSelectedItem();
//
//            List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSoLuongTonKho(lx.getMaLoaiXe(), vt.getMaViTri());
//            for (Object[] rows : list) {
//                String temp = String.valueOf(rows[3]).trim();
//                double soLuong = Integer.parseInt(temp);
//                model.addRow(
//                        new Object[]{
//                            rows[0],
//                            rows[1],
//                            rows[2],
//                            soLuong,
//                            rows[4]
//                        }
//                );
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    void fillTableTonKho() {
        // System.out.println(maLX);
        // System.out.println(maVT);
        DefaultTableModel model = (DefaultTableModel) tblTonKho.getModel();
        model.setRowCount(0);
        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSoLuongTonKho(maLX, maVT);
        if (list != null) {
            for (Object[] rows : list) {
                String temp = String.valueOf(rows[3]).trim();
                double soLuong = Integer.parseInt(temp);
                model.addRow(
                        new Object[]{
                            rows[0],
                            rows[1],
                            rows[2],
                            soLuong,
                            rows[4]
                        }
                );
            }
        }
    }

    void first() {
        this.row = 0;
        tblTonKho.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblTonKho.getRowCount() - 1) {
            this.row++;

        } else {
            first();

        }
        tblTonKho.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;

        } else {
            last();

        }
        tblTonKho.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblTonKho.getRowCount() - 1;

        tblTonKho.setRowSelectionInterval(this.row, this.row);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboLoaiXe = new javax.swing.JComboBox<>();
        btnFirst = new com.ttt.swing.Button();
        btnPrev = new com.ttt.swing.Button();
        btnNext = new com.ttt.swing.Button();
        btnLast = new com.ttt.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTonKho = new javax.swing.JTable();
        cboViTri = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("BÁO CÁO HÀNG TỒN KHO");

        cboLoaiXe.setBackground(new java.awt.Color(0, 51, 51));
        cboLoaiXe.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboLoaiXe.setForeground(new java.awt.Color(255, 255, 255));
        cboLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dòng xe" }));
        cboLoaiXe.setBorder(null);
        cboLoaiXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiXeActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        tblTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Loại xe", "Dòng xe", "Tên Loại xe", "Số lượng tồn", "Vị trí"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTonKho);

        cboViTri.setBackground(new java.awt.Color(0, 51, 51));
        cboViTri.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboViTri.setForeground(new java.awt.Color(255, 255, 255));
        cboViTri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vị Trí" }));
        cboViTri.setBorder(null);
        cboViTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboViTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiXeActionPerformed

        LoaiXe lx = (LoaiXe) cboLoaiXe.getSelectedItem();
        if (lx != null) {
            maLX = lx.getMaLoaiXe();
            this.fillTableTonKho();
        }

    }//GEN-LAST:event_cboLoaiXeActionPerformed

    private void cboViTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboViTriActionPerformed
        ViTri vt = (ViTri) cboViTri.getSelectedItem();
        if (vt != null) {
            maVT = vt.getMaViTri();
            this.fillTableTonKho();
        }


    }//GEN-LAST:event_cboViTriActionPerformed

    private void btnOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionActionPerformed
        if(tblTonKho.getRowCount()!=0){
            String Option = evt.getActionCommand();
        String first = btnFirst.getText();
        String prev = btnPrev.getText();
        String next = btnNext.getText();
        String last = btnLast.getText();
        if (Option.equals(first)) {
            first();
        } else if (Option.equals(prev)) {
            prev();
        } else if (Option.equals(next)) {
            next();
        } else if (Option.equals(last)) {
            last();
        }

        }
        
        

    }//GEN-LAST:event_btnOptionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPrev;
    private javax.swing.JComboBox<String> cboLoaiXe;
    private javax.swing.JComboBox<String> cboViTri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTonKho;
    // End of variables declaration//GEN-END:variables

}
