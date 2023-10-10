/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Database.jdbc_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Khoa_Model;
public class Khoa_DAO implements BasicFunction_Interface<Khoa_Model> {
    public static Khoa_DAO getInstance() {
        return new Khoa_DAO();
    }
    @Override
    public int add(Khoa_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "INSERT INTO Khoa (MaKhoa, TenKhoa, DiaChi, DienThoai)\n"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaKhoa());
            st.setString(2, t.getTenKhoa());
            st.setString(3, t.getDiaChi());
            st.setInt(4, t.getSdt());
            kq = st.executeUpdate();          
            jdbc_Connect.closeConnection(conn);
        }catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Mã Khoa không được bỏ trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException sQLException) {
             JOptionPane.showMessageDialog(null, "Khoa đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        return kq;
    }
    @Override
    public int update(Khoa_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "UPDATE Khoa\n"
                    + "SET TenKhoa = ?\n"
                    + ",DiaChi =?\n"
                    + ",DienThoai = ?\n"
                    + "WHERE MaKhoa = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getTenKhoa());
            st.setString(2, t.getDiaChi());
            st.setInt(3, t.getSdt());
            st.setString(4, t.getMaKhoa());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kq;}
    @Override
    public int delete(Khoa_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();      
            String sql = "DELETE FROM Khoa WHERE MaKhoa =?";
         PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaKhoa());
     
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (Exception e) {    
          JOptionPane.showMessageDialog( null, "Khoa đang có lớp theo học không thể xóa!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
        }
        return kq;
    }
    @Override
    public ArrayList<Khoa_Model> selectAll() {
        ArrayList<Khoa_Model> kqArrayList  = new ArrayList<>();
        try {
             Connection conn = jdbc_Connect.getConnection();        
             String sql= "SELECT *FROM KHOA";
             PreparedStatement st= conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery();   
             while (rs.next()) {
                 String maKhoa = rs.getString("MaKhoa");
                 String tenKhoa = rs.getString("TenKhoa");
                 String diaChi = rs.getString("DiaChi");
                 int sdt = rs.getInt("DienThoai");
                 Khoa_Model k1= new Khoa_Model(maKhoa, tenKhoa, diaChi, sdt);
                 kqArrayList.add(k1);
            }
          jdbc_Connect.closeConnection(conn);
     } catch (Exception e) {
                        Logger.getLogger(Khoa_DAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return kqArrayList;
    }
}
