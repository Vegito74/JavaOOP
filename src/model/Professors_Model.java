/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;


public class Professors_Model extends Person{
      private int id_Login;
      private String email;
      private String password;

  
      
    public Professors_Model(int id_Login, String password, 
            String name, String email, boolean gender, Date dateOfBirth, String queQuan) {
        super(name, gender, dateOfBirth, queQuan);
        this.id_Login = id_Login;
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId_Login() {
        return id_Login;
    }
    public void setId_Login(int id_Login) {
        this.id_Login = id_Login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
        
}
