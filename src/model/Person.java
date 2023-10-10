/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;


public abstract class Person {
    private String name;
    private boolean gender;
    private Date dateOfBirth;
    private String queQuan;

    public Person(String name, boolean gender, Date dateOfBirth, String queQuan) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.queQuan = queQuan;
    }

    public String getName() {
        return name;
    }
    public boolean isGender() {
        return gender;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    
    
}
