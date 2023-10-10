/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.text.DecimalFormat;


public class DiemSV_Model {
    private String maSV;
    private String khoaHoc;
    private int hocKy;
    private float score_1;
    private float score_2;
    private float score_3;
    private float score_4;

    public DiemSV_Model(String maSV, String khoaHoc, int hocKy, 
            float score_1, float score_2, float score_3, float score_4) {
        this.maSV = maSV;
        this.khoaHoc = khoaHoc;
        this.hocKy = hocKy;
        this.score_1 = score_1;
        this.score_2 = score_2;
        this.score_3 = score_3;
        this.score_4 = score_4;
    }
    public String getMaSV() {
        return maSV;
    }
    public String getKhoaHoc() {
        return khoaHoc;
    }
    public int getHocKy() {
        return hocKy;
    }
    public float getScore_1() {
        return score_1;
    }
    public float getScore_2() {
        return score_2;
    }
    public float getScore_3() {
        return score_3;
    }
    public float getScore_4() {
        return score_4;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }
    public void setScore_1(float score_1) {
        this.score_1 = score_1;
    }
    public void setScore_2(float score_2) {
        this.score_2 = score_2;
    }
    public void setScore_3(float score_3) {
        this.score_3 = score_3;
    }
    public void setScore_4(float score_4) {
        this.score_4 = score_4;
    }
    
    public float mediumScore(){
       float average=(this.getScore_1()+this.getScore_2()+
               this.getScore_3()+this.getScore_4()) / 4;
        
        // Sử dụng DecimalFormat để làm tròn đến hai số sau dấu phẩy
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(average));
    }
    
}
