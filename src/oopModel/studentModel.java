/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopModel;


public class studentModel {
    
    private int id;
    private String name;
    private String address;
    private String intake;
    private String age;
    private String birthday;
    private String gender;
    private String contact; 
    
    
  public studentModel()
  {
  }
   public studentModel(int id,String name,String address,String intake,String age,String birthday,String gender,String contact)
  {
      this.id = id; 
      this.name = name;
      this.address = address;
      this.intake = intake;
      this.age = age;
      this.birthday = birthday;
      this.gender = gender;
      this.contact = contact;
  }

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }
    
    

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIntake() {
        return intake;
    }

    public String getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }
    
  
    
    
}
