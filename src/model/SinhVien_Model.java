/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;


public class SinhVien_Model extends Person{
    private String maSV;
    private String maClass;
    private float gpa_1;
    private float gpa_2;
    private float gpa_3;
    private float gpa_4;

    public void SinhVien_Model() {
        
    };
   
    public SinhVien_Model(String maSV, String name, boolean gender, Date dateOfBirth, String queQuan, float gpa_1, float gpa_2, float gpa_3, float gpa_4, String maClass) {
        super(name, gender, dateOfBirth, queQuan);
        this.maSV = maSV;
        this.maClass = maClass;
        this.gpa_1 = gpa_1;
        this.gpa_2 = gpa_2;
        this.gpa_3 = gpa_3;
        this.gpa_4 = gpa_4;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaClass() {
        return maClass;
    }

    public float getGpa_1() {
        return gpa_1;
    }

    public float getGpa_2() {
        return gpa_2;
    }

    public float getGpa_3() {
        return gpa_3;
    }

    public float getGpa_4() {
        return gpa_4;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaClass(String maClass) {
        this.maClass = maClass;
    }

    public void setGpa_1(float gpa_1) {
        this.gpa_1 = gpa_1;
    }

    public void setGpa_2(float gpa_2) {
        this.gpa_2 = gpa_2;
    }

    public void setGpa_3(float gpa_3) {
        this.gpa_3 = gpa_3;
    }

    public void setGpa_4(float gpa_4) {
        this.gpa_4 = gpa_4;
    }
    
    
    
    
    
}
