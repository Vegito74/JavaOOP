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
import javax.swing.JOptionPane;
import model.KhoaHoc_Model;

public class KhoaHoc_DAO implements BasicFunction_Interface<KhoaHoc_Model>{
public static KhoaHoc_DAO getInstance() {
        return new KhoaHoc_DAO();
    }
     @Override
    public int add(KhoaHoc_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "INSERT INTO KhoaHoc (MaKH, TenKH, MonHoc1, MonHoc2, MonHoc3, MonHoc4)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaKH());
            st.setString(2, t.getNameKH());
            st.setString(3, t.getMh1());
            st.setString(4, t.getMh2());
            st.setString(5, t.getMh3());
            st.setString(6, t.getMh4());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kq; }
    @Override
    public int update(KhoaHoc_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "UPDATE KhoaHoc SET TenKH = ?, MonHoc1 = ?,"+
                    " MonHoc2 = ?, MonHoc3 = ?, MonHoc4 = ? WHERE MaKH = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getNameKH());
            st.setString(2, t.getMh1());
            st.setString(3, t.getMh2());
            st.setString(4, t.getMh3());
            st.setString(5, t.getMh4());
            st.setString(6, t.getMaKH());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kq;}
    @Override
    public int delete(KhoaHoc_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "DELETE FROM KhoaHoc WHERE MaKH = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaKH());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
                      JOptionPane.showMessageDialog( null, "Khóa học đang được sử dụng!", "Không thể xóa!", JOptionPane.ERROR_MESSAGE);

        }
        return kq;
    }
    @Override
    public ArrayList<KhoaHoc_Model> selectAll() {
        ArrayList<KhoaHoc_Model> kqArrayList = new ArrayList<>();
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT * FROM KhoaHoc";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String TenKH = rs.getString("TenKH");
                String MonHoc1 = rs.getString("MonHoc1");
                String MonHoc2 = rs.getString("MonHoc2");
                String MonHoc3 = rs.getString("MonHoc3");
                String MonHoc4 = rs.getString("MonHoc4");
                KhoaHoc_Model kh = new KhoaHoc_Model(maKH, TenKH, MonHoc1, MonHoc2, MonHoc3, MonHoc4);
                kqArrayList.add(kh);
            }
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kqArrayList;
    }
      public boolean checkDataExists_KhoaHoc(String MaKhoaHoc, String TenKhoHoc) {
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT COUNT(*) FROM KhoaHoc WHERE MaKH = ? AND TenKH = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,MaKhoaHoc );
            st.setString(2, TenKhoHoc);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
        return false;
    }


}
