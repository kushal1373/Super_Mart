package controller;

import model.BillingModel;
import DAO.BillingDAO;
import javax.swing.table.DefaultTableModel;

public class BillingController {
    private BillingDAO dao;
    
    public BillingController() {
        this.dao = new BillingDAO();
    }
    
    public boolean addBilling(BillingModel model) {
        return dao.add(model);
    }
    
    public boolean deleteBilling(BillingModel model) {
        return dao.delete(model);
    }
    
    public boolean updateBilling(BillingModel model) {
        return dao.update(model);
    }
    
    public DefaultTableModel viewBilling() {
        try {
            return dao.getBillingTableModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
