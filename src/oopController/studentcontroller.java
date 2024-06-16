/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopController;

import javax.swing.JOptionPane;
import oopDao.studentDao;
import oopModel.studentModel;
import oopView.studentView;

/**
 *
 * @author User
 */
public class studentcontroller {
    
    
    
    
    
    
    private final  studentView view;
    private  studentDao dao;

    public studentcontroller(studentView view) {
        this.view = view;
         this.dao = new studentDao(); 
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
    
     
      public void update(studentModel student) {
     
        try {
            dao.update(student);
            //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
        }
    }
    
    
}
