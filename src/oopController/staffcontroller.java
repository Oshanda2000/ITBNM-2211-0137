/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopController;

import javax.swing.JOptionPane;
import oopDao.lecturerDao;
import oopDao.staffDao;
import oopModel.lecturerModel;
import oopModel.staffModel;
import oopView.lecturerView;
import oopView.staffView;

/**
 *
 * @author User
 */
public class staffcontroller {
    
    
    private final  staffView view;
    private  staffDao dao;

    public staffcontroller(staffView view) {
        this.view = view;
         this.dao = new staffDao(); 
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
    
     
      public void update(staffModel staff) {
     
        try {
            dao.update(staff);
            //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
        }
    }
}
