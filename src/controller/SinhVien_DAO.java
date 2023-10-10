/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Database.jdbc_Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Khoa_Model;
import model.SinhVien_Model;
public class SinhVien_DAO implements BasicFunction_Interface<SinhVien_Model> {

    public static SinhVien_DAO getInstance() {
        return new SinhVien_DAO();
    }

    @Override
    public int add(SinhVien_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();

            String sql = "INSERT INTO SinhVien (MaSV, TenSV, GioiTinh, "+
                    "NgaySinh, QueQuan, GPA_1, GPA_2, GPA_3, GPA_4, MaLop)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaSV());
            st.setString(2, t.getName());
            st.setBoolean(3, t.isGender());
            st.setDate(4, new java.sql.Date(t.getDateOfBirth().getTime()));
            st.setString(5, t.getQueQuan());
            st.setFloat(6, t.getGpa_1());
            st.setFloat(7, t.getGpa_2());
            st.setFloat(8, t.getGpa_3());
            st.setFloat(9, t.getGpa_4());
            st.setString(10, t.getMaClass());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Sinh viên đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            
        }
        JOptionPane.showMessageDialog(null, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        return kq;
    }
    @Override
    public int update(SinhVien_Model sv) {
int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
             String sql = "UPDATE SinhVien SET TenSV = ?, GioiTinh = ?, NgaySinh = ?, QueQuan = ?, MaLop = ? WHERE MaSV = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, sv.getName());
            st.setBoolean(2, sv.isGender());
            st.setDate(3, new java.sql.Date(sv.getDateOfBirth().getTime())); // Chuyển đổi Date thành java.sql.Date
            st.setString(4, sv.getQueQuan());
            st.setString(5, sv.getMaClass());
            st.setString(6, sv.getMaSV());

            kq = st.executeUpdate();

            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kq;    }
    @Override
    public int delete(SinhVien_Model t) {
          int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = " DELETE FROM Diem WHERE MaSV= ?; DELETE "
                    +"FROM SinhVien WHERE MaSV = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaSV());
            st.setString(2, t.getMaSV());

            kq = st.executeUpdate();

            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    @Override
    public ArrayList<SinhVien_Model> selectAll() {
        ArrayList<SinhVien_Model> kqArrayList = new ArrayList<>();

        try {
            Connection conn = jdbc_Connect.getConnection();

            String sql = "SELECT *FROM SinhVien";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String MaSV = rs.getString("MaSV");
                String TenSV = rs.getString("TenSV");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                Date NgaySinh = rs.getDate("NgaySinh");
                String QueQuan = rs.getString("QueQuan");
                float GPA_1 = rs.getFloat("GPA_1");
                float GPA_2 = rs.getFloat("GPA_2");
                float GPA_3 = rs.getFloat("GPA_3");
                float GPA_4 = rs.getFloat("GPA_4");
                String MaLop = rs.getString("MaLop");
                SinhVien_Model k1 = new SinhVien_Model(MaSV, TenSV, GioiTinh, NgaySinh, QueQuan, GPA_1, GPA_2, GPA_3, GPA_4, MaLop);
                kqArrayList.add(k1);
            }
            jdbc_Connect.closeConnection(conn);

        } catch (Exception e) {
            Logger.getLogger(SinhVien_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return kqArrayList;
    }
 public ArrayList<SinhVien_Model> selectByName(String t) {
        ArrayList<SinhVien_Model> kqUser = new ArrayList<>();
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT *FROM SinhVien where TenSV LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%"+t+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               String MaSV = rs.getString("MaSV");
                String TenSV = rs.getString("TenSV");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                Date NgaySinh = rs.getDate("NgaySinh");
                String QueQuan = rs.getString("QueQuan");
                float GPA_1 = rs.getFloat("GPA_1");
                float GPA_2 = rs.getFloat("GPA_2");
                float GPA_3 = rs.getFloat("GPA_3");
                float GPA_4 = rs.getFloat("GPA_4");
                String MaLop = rs.getString("MaLop");
                SinhVien_Model k1 = new SinhVien_Model(MaSV, TenSV, GioiTinh, NgaySinh, QueQuan, GPA_1, GPA_2, GPA_3, GPA_4, MaLop);
                kqUser.add(k1);             
            }

            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kqUser;
    }
 public ArrayList<SinhVien_Model> selectAll_SVFinal() {
    ArrayList<SinhVien_Model> kqArrayList = new ArrayList<>();
    try {
        Connection conn = jdbc_Connect.getConnection();
        String sql = "SELECT * FROM SinhVien WHERE GPA_1 <> 0.0 AND GPA_2 <> 0.0 AND GPA_3 <> 0.0 AND GPA_4 <> 0.0";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            String MaSV = rs.getString("MaSV");
            String TenSV = rs.getString("TenSV");
            boolean GioiTinh = rs.getBoolean("GioiTinh");
            Date NgaySinh = rs.getDate("NgaySinh");
            String QueQuan = rs.getString("QueQuan");
            float GPA_1 = rs.getFloat("GPA_1");
            float GPA_2 = rs.getFloat("GPA_2");
            float GPA_3 = rs.getFloat("GPA_3");
            float GPA_4 = rs.getFloat("GPA_4");
            String MaLop = rs.getString("MaLop");
            SinhVien_Model k1 = new SinhVien_Model(MaSV, TenSV, GioiTinh, NgaySinh, QueQuan, GPA_1, GPA_2, GPA_3, GPA_4, MaLop);
            kqArrayList.add(k1);
        }
        jdbc_Connect.closeConnection(conn);
    } catch (Exception e) {
        Logger.getLogger(SinhVien_DAO.class.getName()).log(Level.SEVERE, null, e);

    }
    return kqArrayList;
}
//    public static void main(String[] args) {
//        ArrayList<SinhVien_Model> listSV = SinhVien_DAO.getInstance().selectAll();
//        for (SinhVien_Model sinhVien_Model : listSV) {
//            System.out.println(sinhVien_Model);
//        }
//        String Ng2aySinh = "22/03/2023";
//        java.sql.Date d = null;
//        java.util.Date utilDate;
//        try {
//            utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(Ng2aySinh);
//            d = new java.sql.Date(utilDate.getTime());
//        } catch (ParseException ex) {
//            Logger.getLogger(SinhVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                
//        SinhVien_Model sv= new SinhVien_Model("4323", "343", true, d, "rwer", 0, 0, 0, 0, "L001");
//        SinhVien_DAO.getInstance().add(sv);
//       
//        
//
//    }

}
