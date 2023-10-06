/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class Lop_Model {
    private String maLop;
    private String className;
    private String maKhoa;

    public Lop_Model(String maLop, String className, String maKhoa) {
        this.maLop = maLop;
        this.className = className;
        this.maKhoa = maKhoa;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getClassName() {
        return className;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
    
    
    
   
    
}
