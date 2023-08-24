package com.ttt.form;

import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.NhanVienDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.NhanVien;
import com.ttt.LibaryHelper.ExcelExporter;
import com.ttt.component.Form;
import com.ttt.transitions.TransitionsForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public final class BaoCaoDoanhSo_Form extends TransitionsForm {

    int row = -1;

    public BaoCaoDoanhSo_Form() {
        initComponents();
        init();
    }

    void init() {
        this.fillcboNhanVienKD();
        this.fillTableDoanhSo();
        //this.fillcboLoaiXe();

    }

    void fillcboNhanVienKD() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNhanVienKD.getModel();
        model.removeAllElements();
        List<NhanVien> list = NhanVienDAO.getNewNhanVienDAO().selectAll_NhanVienKD();
        for (NhanVien cd : list) {
            model.addElement(cd);
        }
        this.fillcboLoaiXe();
    }

    void fillcboLoaiXe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChiTietPhieuNhap.getModel();
        model.removeAllElements();
        NhanVien nhanVien = (NhanVien) cboNhanVienKD.getSelectedItem();
        if (nhanVien != null) {
            List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectByNVKD(nhanVien.getMaNV());
            for (ChiTietPhieuNhap cd : list) {
                model.addElement(cd);
            }
            this.fillTableDoanhSo();
        }
    }

    void fillTableDoanhSo() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhSo.getModel();
        model.setRowCount(0);

        NhanVien nv = (NhanVien) cboNhanVienKD.getSelectedItem();
        ChiTietPhieuNhap ctpn = (ChiTietPhieuNhap) cboChiTietPhieuNhap.getSelectedItem();
        if (nv != null && ctpn != null) {
            List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSoLuongBan(nv.getMaNV(), ctpn.getMaLoaiXe());
            for (Object[] rows : list) {
                String temp = String.valueOf(rows[3]).trim();
                double soLuong = Integer.parseInt(temp);
                model.addRow(
                        new Object[]{
                            rows[0],
                            rows[1],
                            rows[2],
                            soLuong,
                            rows[4],
                            rows[5]
                        }
                );
            }
        }

    }

    void first() {
        this.row = 0;
        tblDoanhSo.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblDoanhSo.getRowCount() - 1) {
            this.row++;

        } else {
            first();

        }
        tblDoanhSo.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;

        } else {
            last();

        }
        tblDoanhSo.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblDoanhSo.getRowCount() - 1;
        tblDoanhSo.setRowSelectionInterval(this.row, this.row);

    }

//    void export_excel() {
//        Map<String,Object> data = new HashMap<>();
//         List<Object[]> arr = ThongKeDAO.getNewThongKeDAO().getXuatFileSoLuongBan();
//         for (Object[] rows : arr) {
//             //System.out.println(rows[0]);
//             data.put("ma_loai_xe", rows[0]);
//             data.put("dong_xe", rows[1]);
//             data.put("ten_loai_xe", rows[2]);
//             data.put("so_luong_xuat", rows[3]);
//             data.put("ten_khach_hang", rows[4]);
//             data.put("ten_nhanh_nien", rows[5]);
//         }
//         ExcelExporter.getNewExcelExporter().exportToExcel(data);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboNhanVienKD = new javax.swing.JComboBox<>();
        cboChiTietPhieuNhap = new javax.swing.JComboBox<>();
        btnFirst = new com.ttt.swing.Button();
        btnPrev = new com.ttt.swing.Button();
        btnNext = new com.ttt.swing.Button();
        btnLast = new com.ttt.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhSo = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("BÁO CÁO DOANH SỐ");

        cboNhanVienKD.setBackground(new java.awt.Color(0, 51, 51));
        cboNhanVienKD.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboNhanVienKD.setForeground(new java.awt.Color(255, 255, 255));
        cboNhanVienKD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNhanVienKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanVienKDActionPerformed(evt);
            }
        });

        cboChiTietPhieuNhap.setBackground(new java.awt.Color(0, 51, 51));
        cboChiTietPhieuNhap.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboChiTietPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        cboChiTietPhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboChiTietPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChiTietPhieuNhapActionPerformed(evt);
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

        tblDoanhSo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Loại xe", "Dòng xe", "Tên Loại xe", "Số lượng bán", "Tên KH", "Tên NV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoanhSo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboNhanVienKD, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboChiTietPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhanVienKD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChiTietPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNhanVienKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhanVienKDActionPerformed
        this.fillcboLoaiXe();
        this.fillTableDoanhSo();
    }//GEN-LAST:event_cboNhanVienKDActionPerformed

    private void cboChiTietPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChiTietPhieuNhapActionPerformed
        this.fillTableDoanhSo();
    }//GEN-LAST:event_cboChiTietPhieuNhapActionPerformed

    private void btnOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionActionPerformed
        if (tblDoanhSo.getRowCount() != 0) {
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
    private javax.swing.JComboBox<String> cboChiTietPhieuNhap;
    private javax.swing.JComboBox<String> cboNhanVienKD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoanhSo;
    // End of variables declaration//GEN-END:variables
}
