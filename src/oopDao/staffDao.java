/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oopDataBase.DBConnection;
import oopModel.staffModel;

/**
 *
 * @author User
 */
public class staffDao {
    
     public void addstaff(staffModel staff) {
        
        
         String sql;
        sql = "INSERT INTO staff (name,address,age,birthday,gender,contact) VALUES(?,?,?,?,?,?)";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,staff.getName());
            stmt.setString(2,staff.getAddress());
            stmt.setString(3,staff.getAge());
            stmt.setString(4,staff.getBirthday());
            stmt.setString(5,staff.getGender());
            stmt.setString(6,staff.getContact());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
      public void update(staffModel staff){
         String sql = "UPDATE staff SET name = ?, address = ?, age = ?, birthday = ?, gender = ?, contact = ? WHERE id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,staff.getName());
            stmt.setString(2,staff.getAddress());
            stmt.setString(3,staff.getAge());
            stmt.setString(4,staff.getBirthday());
            stmt.setString(5,staff.getGender());
            stmt.setString(6,staff.getContact());
            stmt.setInt(7,staff.getId());
            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(new JFrame(),"DATA Updated Successfully ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
     
     public void delete(int id) throws SQLException {
       
       System.out.println(id);
       
        String deleteQuery = "DELETE FROM staff WHERE id = '"+id+"'";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(deleteQuery);
          //  ResultSet rs = pst.executeQuery();
         
            pst.executeUpdate();
            
//            JOptionPane.showMessageDialog(new JFrame(),"DATA Deleted Successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
    }
        
     }
     
     
     
     
     
      public List<String[]> getAllstaff() {
    List<String[]> userData = new ArrayList<>();

    String getData = "SELECT * FROM staff";

    try{
        Connection connection = DBConnection.getConnection();
         PreparedStatement pst = connection.prepareStatement(getData);
         ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        String[] user = new String[7]; // Assuming username and password
        
                user[0] = String.valueOf(rs.getInt("id")); 
                user[1] = rs.getString("name");
                user[2] = rs.getString("address");
                user[3] = rs.getString("age");
                user[4] = rs.getString("birthday");
                user[5] = rs.getString("gender"); 
                user[6] = rs.getString("contact");
               
                
                
                userData.add(user);
       
      }
      } catch (SQLException e) {
      e.printStackTrace();
    }

    return userData;
    
  }
    
}
