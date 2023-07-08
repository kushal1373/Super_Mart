/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BillingModel;
import controller.BillingController;
import controller.productController;
import java.awt.event.KeyEvent;
import javax.swing.event.TableModelEvent;
import model.ProductModel;

/**
 *
 * @author suyog
 */
public class billingform extends javax.swing.JFrame {
    ProductModel model;
    BillingModel mod;
//    DefaultTableModel mode;
//    int rowcount;

    public billingform() {
        initComponents();
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        txtbillno = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtproductname = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        vireBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdiscount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtgrandtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        billingTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        printBtn = new javax.swing.JButton();
        txtproductid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(40, 62, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILLING  PAGE");

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBtn.setText("LOG OUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        txtbillno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbillnoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("BILL NO:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PRODUCT NAME:");

        txtproductname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtproductname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductnameActionPerformed(evt);
            }
        });

        txtquantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("QUANTITY:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CATEGORY:");

        txtcategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DAIRY", "BAKERY", "MEAT", "BEVRAGE", "FRUITS", "VEGETABLE", "SNACKS", "HOUSEHOLD" }));
        txtcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoryActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn.setText("SAVE");

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        vireBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vireBtn.setText("VIEW");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL:");

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DISCOUNT:");

        txtdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscountActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("GRAND TOTAL:");

        txtgrandtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtgrandtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgrandtotalActionPerformed(evt);
            }
        });

        billingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Category", "Price"
            }
        ));
        billingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billingTable);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        printBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBtn.setText("PRINT");

        txtproductid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtproductidKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUCT ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRICE:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(saveBtn)
                        .addGap(55, 55, 55)
                        .addComponent(printBtn))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtbillno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(173, 173, 173)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addComponent(jLabel11))
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(69, 69, 69)
                                            .addComponent(jLabel13)
                                            .addGap(33, 33, 33)
                                            .addComponent(txtgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(addBtn)
                                                .addComponent(jLabel14))
                                            .addGap(33, 33, 33)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtproductname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtproductid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel2))
                                    .addGap(107, 107, 107)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(deleteBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(vireBtn))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel15)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(6, 6, 6)))))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtbillno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(logoutBtn))))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn)
                            .addComponent(updateBtn)
                            .addComponent(deleteBtn)
                            .addComponent(vireBtn))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printBtn)
                    .addComponent(saveBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        BillingController c = new BillingController(this,"update");
//        updateDataInTable();
//        mode.fireTableDataChanged();
    }//GEN-LAST:event_updateBtnActionPerformed

//    private void updateDataInTable() {
////        int selectedRow = billingTable.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel)billingTable.getModel();
//        int Myindex= billingTable.getSelectedRow();
//        if (Myindex == -1) {
//            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

//        String productId = txtproductid.getText();
//        String productName = txtproductname.getText();
//        String quantity = txtquantity.getText();
//        String category = txtcategory.getSelectedItem().toString();
//        String price = txtprice.getText();
//
//        model.setValueAt(productId, selectedRow, 0);
//        model.setValueAt(productName, selectedRow, 1);
//        model.setValueAt(quantity, selectedRow, 2);
//        model.setValueAt(category, selectedRow, 3);
//        model.setValueAt(price, selectedRow, 4);

        
//        txtproductid.setText(model.getValueAt(Myindex,0).toString());
//        txtproductname.setText(model.getValueAt(Myindex,1).toString());
//        txtquantity.setText(model.getValueAt(Myindex,2).toString());
//        txtcategory.setSelectedItem(model.getValueAt(Myindex,3).toString());
////        txtprice.setText(model.getValueAt(Myindex,4).toString());
//        int price = Integer.parseInt(model.getValueAt(Myindex,4).toString());
//
//        // Clear the text fields after updating the data
//       
//    }
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        BillingController c = new BillingController(this,"add");
//        addDataToTable();  
//        mode.fireTableDataChanged();
    }//GEN-LAST:event_addBtnActionPerformed

//    private void addDataToTable() {
//     
//      mode = (DefaultTableModel) billingTable.getModel();
//
//        String productId = txtproductid.getText();
//        String productName = txtproductname.getText();
//        String quantity = txtquantity.getText();
//        String category = txtcategory.getSelectedItem().toString();
//        Double price = txtprice.getDouble();
//        mode.setRowCount(rowcount);
//        rowcount++;
//
//        Object[] rowData = {productId, productName, quantity, category, price};
//        mode.addRow(rowData);
//
//        // Clear the text fields after adding the data
//        
//    }
    
    private void txtproductnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductnameActionPerformed

    private void txtgrandtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgrandtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgrandtotalActionPerformed

    private void txtdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscountActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtbillnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbillnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbillnoActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
         setVisible(false);
        LoginView r = new LoginView();
        r.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void txtcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoryActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        BillingController c = new BillingController(this,"update");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void billingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billingTableMouseClicked
        // TODO add your handling code here:
//        DefaultTableModel model = (DefaultTableModel)billingTable.getModel();
//        int Myindex= billingTable.getSelectedRow();
//        txtproductid.setText(model.getValueAt(Myindex,0).toString());
//        txtproductname.setText(model.getValueAt(Myindex,1).toString());
//        txtquantity.setText(model.getValueAt(Myindex,2).toString());
//        txtcategory.setSelectedItem(model.getValueAt(Myindex,3).toString());
////        txtprice.setText(model.getValueAt(Myindex,4).toString());
//        int price = Integer.parseInt(model.getValueAt(Myindex,4).toString());
    }//GEN-LAST:event_billingTableMouseClicked

    private void txtproductidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductidKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter key pressed
            String productId = txtproductid.getText();
            // Call a method to load data based on the product ID
           productController pController = new productController();
          ProductModel product = pController.getProductById(Integer.parseInt(txtproductid.getText()));
         txtproductname.setText(product.getProductname());
         txtcategory.setSelectedItem(product.getCategory());
         txtprice.setText(Double.toString(product.getPrice()));

        }
    }//GEN-LAST:event_txtproductidKeyPressed

    public BillingModel getUser() {
        int productId = Integer.parseInt(txtproductid.getText());
        int Billno = Integer.parseInt(txtbillno.getText());
    String productName = txtproductname.getText();
    String Category = txtcategory.getSelectedItem().toString();
    int Quantity = Integer.parseInt(txtquantity.getText());
    double Price = Double.parseDouble(txtprice.getText());

   mod  = new BillingModel(Billno, productId, productName, Category, Quantity, Price);
    return mod;
    }

    public void setMessage(String msg) {
        JOptionPane.showMessageDialog(this, "msg");
    }
 public void addbillListener(ActionListener log) {
        addBtn.addActionListener(log);

    }
   public void adddeleteListener(ActionListener log) {
        deleteBtn.addActionListener(log);

   }
   public void addupdateListener(ActionListener log) {
         updateBtn.addActionListener(log);
   }
  
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
            java.util.logging.Logger.getLogger(billingform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billingform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billingform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billingform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billingform().setVisible(true);
            }
        });
    }
    public void setTableModel(DefaultTableModel Model) {
    // Set the table model to your view's table
  billingTable.setModel(Model);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable billingTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField txtbillno;
    private javax.swing.JComboBox<String> txtcategory;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtgrandtotal;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproductid;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txttotal;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton vireBtn;
    // End of variables declaration//GEN-END:variables
}
