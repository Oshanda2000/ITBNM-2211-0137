/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopController;

import javax.swing.JOptionPane;
import oopDao.lecturerDao;
import oopModel.lecturerModel;
import oopView.lecturerView;

/**
 *
 * @author User
 */
public class lecturercontroller {
    
    private final  lecturerView view;
    private  lecturerDao dao;

    public lecturercontroller(lecturerView view) {
        this.view = view;
         this.dao = new lecturerDao(); 
        initComponents();
    }
    

    private void initComponents() {
         //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
    
    
    
     public void delete(int id) {
        try {
            dao.delete(id);
            //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
        }
    }
    
     
      public void update(lecturerModel lecturer) {
 
        try {
            dao.update(lecturer);
            //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
        }
    }
    
}
