package com.ttt.form;

import com.ttt.DAO.ThongKeDAO;
import com.ttt.LibaryHelper.DateHelper;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.component.Form;
import com.ttt.transitions.TransitionsForm;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class DoanhThu_Form extends TransitionsForm {

    int row = -1;

    public DoanhThu_Form() {
        initComponents();
        fillTable();
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getDoanhThu();

        for (Object[] rows : list) {
            model.addRow(rows);
        }

    }

    void fillTableTheoNgay() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);

        if (checkDate()) {
            String date1 = txtNgay1.getText();
            String date2 = txtNgay2.getText();
            List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getDoanhThuTheoNgay(date1, date2);

            for (Object[] rows : list) {
                model.addRow(rows);
            }
        }
    }

    boolean checkDate() {
        String patternDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        String text1 = txtNgay1.getText();
        String text2 = txtNgay2.getText();
        if (!text1.matches(patternDate)) {
            DialogHelper.alert(this, "Ngày bắt đầu không đúng định dạng dd-MM-yyyy");
            return false;
        } else if (!text2.matches(patternDate)) {
            DialogHelper.alert(this, "Ngày kết thúc không đúng định dạng dd-MM-yyyy");
            return false;
        }

        return true;
    }

    void first() {
        this.row = 0;
        tblDoanhThu.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblDoanhThu.getRowCount() - 1) {
            this.row++;

        } else {
            first();

        }
        tblDoanhThu.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;

        } else {
            last();

        }
        tblDoanhThu.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblDoanhThu.getRowCount() - 1;

        tblDoanhThu.setRowSelectionInterval(this.row, this.row);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnFirst = new com.ttt.swing.Button();
        btnPrev = new com.ttt.swing.Button();
        btnNext = new com.ttt.swing.Button();
        btnLast = new com.ttt.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        panelBackground2 = new com.ttt.swing.PanelBackground();
        btnLamMoi = new com.ttt.swing.Button();
        btnXem = new com.ttt.swing.Button();
        txtNgay1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtNgay2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblMaST6 = new javax.swing.JLabel();
        lblMaST5 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("BÁO CÁO DOANH THU");
        add(jLabel1);
        jLabel1.setBounds(220, 60, 400, 50);

        btnFirst.setBackground(new java.awt.Color(102, 102, 102));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnFirst);
        btnFirst.setBounds(90, 360, 31, 26);

        btnPrev.setBackground(new java.awt.Color(102, 102, 102));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnPrev);
        btnPrev.setBounds(140, 360, 36, 26);

        btnNext.setBackground(new java.awt.Color(102, 102, 102));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(190, 360, 36, 26);

        btnLast.setBackground(new java.awt.Color(102, 102, 102));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnLast);
        btnLast.setBounds(250, 360, 31, 26);

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Loại xe", "Tên Loại xe", "Số lượng bán", "Doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoanhThu);

        add(jScrollPane1);
        jScrollPane1.setBounds(90, 390, 660, 215);

        panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground2.setLayout(null);

        btnLamMoi.setBackground(new java.awt.Color(102, 102, 102));
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        panelBackground2.add(btnLamMoi);
        btnLamMoi.setBounds(130, 130, 71, 26);

        btnXem.setBackground(new java.awt.Color(102, 102, 102));
        btnXem.setForeground(new java.awt.Color(255, 255, 255));
        btnXem.setText("XEM");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        panelBackground2.add(btnXem);
        btnXem.setBounds(320, 130, 57, 26);

        txtNgay1.setBackground(new java.awt.Color(0, 51, 51));
        txtNgay1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtNgay1.setForeground(new java.awt.Color(204, 204, 204));
        txtNgay1.setText("dd-MM-yyyy");
        txtNgay1.setBorder(null);
        txtNgay1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgay1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgay1FocusLost(evt);
            }
        });
        panelBackground2.add(txtNgay1);
        txtNgay1.setBounds(130, 20, 250, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator3);
        jSeparator3.setBounds(130, 50, 250, 10);

        txtNgay2.setBackground(new java.awt.Color(0, 51, 51));
        txtNgay2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtNgay2.setForeground(new java.awt.Color(204, 204, 204));
        txtNgay2.setText("dd-MM-yyyy");
        txtNgay2.setBorder(null);
        txtNgay2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgay2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgay2FocusLost(evt);
            }
        });
        panelBackground2.add(txtNgay2);
        txtNgay2.setBounds(130, 60, 250, 30);

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator2);
        jSeparator2.setBounds(130, 90, 250, 10);

        lblMaST6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST6.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST6.setText("Từ ngày");
        panelBackground2.add(lblMaST6);
        lblMaST6.setBounds(50, 30, 60, 18);

        lblMaST5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST5.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST5.setText("Đến ngày");
        panelBackground2.add(lblMaST5);
        lblMaST5.setBounds(50, 80, 60, 18);

        add(panelBackground2);
        panelBackground2.setBounds(330, 150, 420, 170);
    }// </editor-fold>//GEN-END:initComponents


    private void btnOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionActionPerformed
        if (tblDoanhThu.getRowCount() != 0) {
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

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        this.fillTableTheoNgay();
        //checkDate();
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        this.fillTable();
        txtNgay1.setText("");
        txtNgay2.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtNgay1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgay1FocusGained
        if (txtNgay1.getText().equalsIgnoreCase("dd-MM-yyyy")) {
            txtNgay1.setText("");
        }

        txtNgay1.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtNgay1FocusGained

    private void txtNgay1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgay1FocusLost
        if (txtNgay1.getText().equalsIgnoreCase("")) {
            txtNgay1.setText("dd-MM-yyyy");
        }
        txtNgay1.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtNgay1FocusLost

    private void txtNgay2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgay2FocusGained
        if (txtNgay2.getText().equalsIgnoreCase("dd-MM-yyyy")) {
            txtNgay2.setText("");
        }

        txtNgay2.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtNgay2FocusGained

    private void txtNgay2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgay2FocusLost
        if (txtNgay2.getText().equalsIgnoreCase("")) {
            txtNgay2.setText("dd-MM-yyyy");
        }
        txtNgay2.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtNgay2FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private com.ttt.swing.Button btnLamMoi;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPrev;
    private com.ttt.swing.Button btnXem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblMaST5;
    private javax.swing.JLabel lblMaST6;
    private com.ttt.swing.PanelBackground panelBackground2;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTextField txtNgay1;
    private javax.swing.JTextField txtNgay2;
    // End of variables declaration//GEN-END:variables
}
