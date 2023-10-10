/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;


public class KhoaHoc_Model {
    private  String maKH;
    private String nameKH;
    private String mh1;
    private String mh2;
    private String mh3;
    private String mh4;

    public KhoaHoc_Model(String maKH, String nameKH,
            String mh1, String mh2, String mh3, String mh4) {
        this.maKH = maKH;
        this.nameKH = nameKH;
        this.mh1 = mh1;
        this.mh2 = mh2;
        this.mh3 = mh3;
        this.mh4 = mh4;
    }
    public KhoaHoc_Model() {
    }

    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getNameKH() {
        return nameKH;
    }
    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }
    public String getMh1() {
        return mh1;
    }
    public void setMh1(String mh1) {
        this.mh1 = mh1;
    }
    public String getMh2() {
        return mh2;
    }
    public void setMh2(String mh2) {
        this.mh2 = mh2;
    }
    public String getMh3() {
        return mh3;
    }
    public void setMh3(String mh3) {
        this.mh3 = mh3;
    }
    public String getMh4() {
        return mh4;
    }
    public void setMh4(String mh4) {
        this.mh4 = mh4;
    }  
    
}
