/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class Khoa_Model {
    private String maKhoa;
    private String tenKhoa;
    private String diaChi;
    private int sdt;

    public Khoa_Model() {
    }

    public Khoa_Model(String maKhoa, String tenKhoa, String diaChi, int sdt) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    
    
    
}
