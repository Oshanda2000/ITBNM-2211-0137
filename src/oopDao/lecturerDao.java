/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopDao;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oopDataBase.DBConnection;
import oopModel.lecturerModel;
import oopModel.studentModel;


public class lecturerDao {
    
     public void addlecturer(lecturerModel lecturer) {
        
        
         String sql;
        sql = "INSERT INTO lecturer (name,address,age,birthday,gender,contact) VALUES(?,?,?,?,?,?)";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,lecturer.getName());
            stmt.setString(2,lecturer.getAddress());
            stmt.setString(3,lecturer.getAge());
            stmt.setString(4,lecturer.getBirthday());
            stmt.setString(5,lecturer.getGender());
            stmt.setString(6,lecturer.getContact());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
      public void update(lecturerModel lecturer){
       
          String sql = "UPDATE lecturer SET name = ?, address = ?, age = ?, birthday = ?, gender = ?, contact = ? WHERE id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,lecturer.getName());
            stmt.setString(2,lecturer.getAddress());
            stmt.setString(3,lecturer.getAge());
            stmt.setString(4,lecturer.getBirthday());
            stmt.setString(5,lecturer.getGender());
            stmt.setString(6,lecturer.getContact());
            stmt.setInt(7,lecturer.getId());
            
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
     
     public void delete(int id) throws SQLException {
       
       System.out.println(id);
       
        String deleteQuery = "DELETE FROM lecturer WHERE id = '"+id+"'";
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
     
     
     
     
     
      public List<String[]> getAlllecturer() {
    List<String[]> userData = new ArrayList<>();

    String getData = "SELECT * FROM lecturer";

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
