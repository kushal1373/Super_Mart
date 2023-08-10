package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BillingModel;
import DAO.BillingDAO;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import view.billingform;

public class BillingController {
    private BillingModel model;
    private billingform view;
    public BillingDAO dao;
    private JTextField txtbillno;
    private JTextArea bill;
    private BillingModel billModel;

    public BillingController(billingform view, String button) {
        this.view = view;
        this.dao = new BillingDAO();
        this.txtbillno = view.getBillNoField();
        this.bill = view.getBillField();

        if (button.equals("add")){
            new billListener().actionPerformed();
        }
        else if (button.equals("delete")){
            new deleteListener().actionPerformed();
        }
        else if (button.equals("update")){
            new updateListener().actionPerformed();
        }
        else if (button.equals("save")){
            new calculateListener().actionPerformed();
        }
    }

    public void setDAO(BillingDAO dao) {
        this.dao = dao;
    }

    public void saveBill() {
         if (dao != null && billModel != null) {
            dao.saveBill(billModel);
        } else {
            throw new IllegalStateException("DAO or BillingModel not set. Cannot save bill.");
        }
    }

    class billListener {
        public void actionPerformed() {
            try {
                model = view.getUser();
                addBilling(model);
                addDataToTable(model); 
                updateTotal();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void addBilling(BillingModel model) {
            boolean success = dao.add(model);
            if (success) {
                System.out.println("Billing added successfully.");
                JOptionPane.showMessageDialog(null, "Billing added successfully.");
            } else {
                System.out.println("Failed to add Billing.");
                JOptionPane.showMessageDialog(null, "Failed to add Billing.");
            }
        }

        private void addDataToTable(BillingModel model) {
            DefaultTableModel tableModel = view.getTableModel();
            Object[] rowData = {
                model.getProductid(),
                model.getProductname(),
                model.getQuantity(),
                model.getCategory(),
                model.getPrice()
            };
            tableModel.insertRow(0, rowData);
        }
    }

    class deleteListener {
        public void actionPerformed() {
            try {
                model = view.getUser();
                deleteBilling(model);
                deleteDataFromTable(model); 
                updateTotal();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void deleteBilling(BillingModel model) {
            try {
                boolean success = dao.delete(model);
                if (success) {
                    System.out.println("Delete successful");
                    JOptionPane.showMessageDialog(null, "Delete successful");
                } else {
                    System.out.println("Failed to delete Billing.");
                    JOptionPane.showMessageDialog(null, "Failed to delete Billing.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void deleteDataFromTable(BillingModel model) {
            DefaultTableModel tableModel = view.getTableModel();
            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object productId = tableModel.getValueAt(i, 0);
                if (productId != null && productId.equals(model.getProductid())) {
                    tableModel.removeRow(i);
                    break;
                }
            }
        }
    }

    class updateListener {
        public void actionPerformed() {
            try {
                model = view.getUser();
                updateBilling(model);
                updateDataInTable(model); 
                updateTotal();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void updateBilling(BillingModel model) {
            boolean success = dao.update(model);
            if (success) {
                System.out.println("Billing updated successfully.");
                JOptionPane.showMessageDialog(null, "Billing updated successfully.");
            } else {
                System.out.println("Failed to update Billing.");
                JOptionPane.showMessageDialog(null, "Failed to update Billing.");
            }
        }

        private void updateDataInTable(BillingModel model) {
            DefaultTableModel tableModel = view.getTableModel();
            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object productId = tableModel.getValueAt(i, 0);
                if (productId != null && productId.equals(model.getProductid())) {
                    tableModel.setValueAt(model.getProductname(), i, 1);
                    tableModel.setValueAt(model.getQuantity(), i, 2);
                    tableModel.setValueAt(model.getCategory(), i, 3);
                    tableModel.setValueAt(model.getPrice(), i, 4);
                    break;
                }
            }
        }
    }

    private void updateTotal() {
        DefaultTableModel tableModel = view.getTableModel();
        int totalColumnIndex = 4; 
        double total = calculateTotal(tableModel);
        view.setText(total);
    }

    private double calculateTotal(DefaultTableModel tableModel) {
    double total = 0.0;
    int rowCount = tableModel.getRowCount();
    for (int i = 0; i < rowCount; i++) {
        int column = 0;
        Object value = tableModel.getValueAt(i, column);
        if (value != null) {
            double price = Double.parseDouble(tableModel.getValueAt(i, 4).toString());
            int quantity = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            total += price * quantity;
        }
    }
    return total;
}
    class calculateListener {
        
    public void actionPerformed() {
        try {
            model = view.getUser();
            calculateGrandTotal();

            bill.setText("*************supermart********" + "\n\n" +
                    "Address: New Bhaktapur\n" +
                    "Phone Number: 998454334" + "\n" +
                    "PAN No: 6789" + "\n\n" +
                    "Bill No: " + txtbillno.getText() + "\n\n" +
                    "------------------------------------------------------------------\n" +
                    "Product ID | Product Name | Quantity | Category | Price\n" +
                    "-------------------------------------------------------------------\n");
            
            DefaultTableModel tableModel = view.getTableModel();
            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object productId = tableModel.getValueAt(i, 0);
                Object productName = tableModel.getValueAt(i, 1);
                Object quantity = tableModel.getValueAt(i, 2);
                Object category = tableModel.getValueAt(i, 3);
                Object price = tableModel.getValueAt(i, 4);
               if (productId != null && productName != null && quantity != null && category != null && price != null) {
                String rowText = String.format("  %-11s    | %-13s  | %-9s  | %-9s | %-5s", productId, productName, quantity, category, price);
                bill.setText(bill.getText() + rowText + "\n");
            }
            }

            bill.setText(bill.getText() + "------------------------------------------\n");

            double total = calculateTotal(tableModel);
            double discount = Double.parseDouble(view.getDiscountField().getText());
            double grandTotal = total - discount;

            bill.setText(bill.getText() + "Total: " + total + "\n");
            bill.setText(bill.getText() + "Discount: " + discount + "\n");
            bill.setText(bill.getText() + "Grand Total: " + grandTotal + "\n");
            bill.setText(bill.getText() + "*******Thank you********");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }

   public void calculateGrandTotal() {
    double total = calculateTotal(view.getTableModel());
    double discount = Double.parseDouble(view.getDiscountField().getText());
    double grandTotal = total - discount;
    view.getGrandTotalField().setText(String.valueOf(grandTotal));
}
}

 