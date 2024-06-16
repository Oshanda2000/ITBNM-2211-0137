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
import oopModel.studentModel;
/**
 *
 * @author User
 */
public class studentDao {




    public void addstudent(studentModel student) {
        
        
         String sql;
        sql = "INSERT INTO student (name,address,intake,age,birthday,gender,contact) VALUES(?,?,?,?,?,?,?)";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,student.getName());
            stmt.setString(2,student.getAddress());
            stmt.setString(3,student.getIntake());
            stmt.setString(4,student.getAge());
            stmt.setString(5,student.getBirthday());
            stmt.setString(6,student.getGender());
            stmt.setString(7,student.getContact());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
      public void update(studentModel student){
        String sql = "UPDATE student SET name = ?, address = ?, intake = ?, age = ?, birthday = ?, gender = ?, contact = ? WHERE id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,student.getName());
            stmt.setString(2,student.getAddress());
            stmt.setString(3,student.getIntake());
            stmt.setString(4,student.getAge());
            stmt.setString(5,student.getBirthday());
            stmt.setString(6,student.getGender());
            stmt.setString(7,student.getContact());
            stmt.setInt(8,student.getId());
            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(new JFrame(),"DATA Updated Successfully ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
     
     public void delete(int id) throws SQLException {
       
       System.out.println(id);
       
        String deleteQuery = "DELETE FROM student WHERE id = '"+id+"'";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(deleteQuery);
       
         
            pst.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
    }
        
     }
     
     
     
     
     
      public List<String[]> getAllstudent() {
    List<String[]> userData = new ArrayList<>();

    String getData = "SELECT * FROM student";

    try{
        Connection connection = DBConnection.getConnection();
         PreparedStatement pst = connection.prepareStatement(getData);
         ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        String[] user = new String[8]; // Assuming username and password
        
                user[0] = String.valueOf(rs.getInt("id")); 
                user[1] = rs.getString("name");
                user[2] = rs.getString("address");
                user[3] = rs.getString("intake"); 
                user[4] = rs.getString("age");
                user[5] = rs.getString("birthday");
                user[6] = rs.getString("gender"); 
                user[7] = rs.getString("contact");
               
                
                
                userData.add(user);
       
      }
      } catch (SQLException e) {
      e.printStackTrace();
    }

    return userData;
    
  }
     
     
    
}

   
