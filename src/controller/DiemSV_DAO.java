package controller;

import Database.jdbc_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DiemSV_Model;
import model.SinhVien_Model;

public class DiemSV_DAO implements BasicFunction_Interface<DiemSV_Model> {

    public static DiemSV_DAO getInstance() {
        return new DiemSV_DAO();
    }

    @Override
    public int add(DiemSV_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();

            String sql = "INSERT INTO Diem (MaSV, MaKH, HocKy,"+
                    " DiemMonHoc1, DiemMonHoc2, DiemMonHoc3, DiemMonHoc4)\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaSV());
            st.setString(2, t.getKhoaHoc());
            st.setInt(3, t.getHocKy());
            st.setFloat(4, t.getScore_1());
            st.setFloat(5, t.getScore_2());
            st.setFloat(6, t.getScore_3());
            st.setFloat(7, t.getScore_4());
            kq = st.executeUpdate();

            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }                                             
    @Override
    public int update(DiemSV_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "UPDATE Diem SET HocKy = ?, DiemMonHoc1 = ?,"+
            " DiemMonHoc2 = ?, DiemMonHoc3 = ?, DiemMonHoc4 = ? WHERE MaSV = ? AND MaKH = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, t.getHocKy());
            st.setFloat(2, t.getScore_1());
            st.setFloat(3, t.getScore_2());
            st.setFloat(4, t.getScore_3());
            st.setFloat(5, t.getScore_4());
            st.setString(6, t.getMaSV());
            st.setString(7, t.getKhoaHoc());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    @Override
    public int delete(DiemSV_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "DELETE FROM Diem WHERE MaSV = ? AND MaKH = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaSV());
            st.setString(2, t.getKhoaHoc());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    @Override
    public ArrayList<DiemSV_Model> selectAll() {
        ArrayList<DiemSV_Model> kqArrayList = new ArrayList<>();

        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT * FROM Diem";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String MaSV = rs.getString("MaSV");
                String MaKH = rs.getString("MaKH");
                int HocKy = rs.getInt("HocKy");
                float DiemMonHoc1 = rs.getFloat("DiemMonHoc1");
                float DiemMonHoc2 = rs.getFloat("DiemMonHoc2");
                float DiemMonHoc3 = rs.getFloat("DiemMonHoc3");
                float DiemMonHoc4 = rs.getFloat("DiemMonHoc4");
                DiemSV_Model diemSV = new DiemSV_Model(MaSV, MaKH, HocKy, DiemMonHoc1, DiemMonHoc2, DiemMonHoc3, DiemMonHoc4);
                kqArrayList.add(diemSV);
            }

            jdbc_Connect.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kqArrayList;
    }
    public boolean checkDataExists(String maSV, int hocKy) {
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT COUNT(*) FROM Diem WHERE MaSV = ? AND HocKy = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, maSV);
            st.setInt(2, hocKy);
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
    public boolean checkDataExistsKH(String maSV, String MaKhoaHoc) {
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT COUNT(*) FROM Diem WHERE MaSV = ? AND MaKH = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, maSV);
            st.setString(2, MaKhoaHoc);
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
    public void calculateAndUpdateGPADelete(String maSV, int hocKy) {
        try {
            Connection conn = jdbc_Connect.getConnection();
                float diemMonHoc1 = 0.0f;
                float diemMonHoc2 = 0.0f;
                float diemMonHoc3 = 0.0f;
                float diemMonHoc4 = 0.0f;
                float tongDiem = diemMonHoc1 + diemMonHoc2 + diemMonHoc3 + diemMonHoc4;
                float diemTrungBinh = tongDiem / 4;
                String updateColumn = "GPA_" + hocKy;
                String updateSql = "UPDATE SinhVien SET " + updateColumn + " = ? WHERE MaSV = ?";
                PreparedStatement updateSt = conn.prepareStatement(updateSql);
                updateSt.setFloat(1, diemTrungBinh);
                updateSt.setString(2, maSV);
                updateSt.executeUpdate();
                jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void calculateAndUpdateGPA(String maSV, int hocKy) {
        try {
            Connection conn = jdbc_Connect.getConnection();
            // Lấy thông tin điểm của sinh viên cho kì học cụ thể
            String sql = "SELECT DiemMonHoc1, DiemMonHoc2, DiemMonHoc3, "+
                    "DiemMonHoc4 FROM Diem WHERE MaSV = ? AND HocKy = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, maSV);
            st.setInt(2, hocKy);
            ResultSet rs = st.executeQuery();
            // Kiểm tra xem có dữ liệu trả về không
            if (rs.next()) {
                float diemMonHoc1 = rs.getFloat("DiemMonHoc1");
                float diemMonHoc2 = rs.getFloat("DiemMonHoc2");
                float diemMonHoc3 = rs.getFloat("DiemMonHoc3");
                float diemMonHoc4 = rs.getFloat("DiemMonHoc4");
                //           Tính tổng điểm và điểm trung bình
                float tongDiem = diemMonHoc1 + diemMonHoc2 + diemMonHoc3 + diemMonHoc4;
                float diemTrungBinh = tongDiem / 4;
                // Cập nhật điểm GPA tương ứng với kì học vào bảng SinhVien
                String updateColumn = "GPA_" + hocKy;
                String updateSql = "UPDATE SinhVien SET " + updateColumn + " = ? WHERE MaSV = ?";
                PreparedStatement updateSt = conn.prepareStatement(updateSql);
                updateSt.setFloat(1, diemTrungBinh);
                updateSt.setString(2, maSV);
                updateSt.executeUpdate();
                jdbc_Connect.closeConnection(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  
    
    public   ArrayList<DiemSV_Model> selectByID(String t) {
       ArrayList<DiemSV_Model> kqUser = new ArrayList<>();
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT *FROM Diem where MaSV=?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
               String MaSV = rs.getString("MaSV");
                String MaKH = rs.getString("MaKH");
                int HocKy = rs.getInt("HocKy");
                float DiemMonHoc1 = rs.getFloat("DiemMonHoc1");
                float DiemMonHoc2 = rs.getFloat("DiemMonHoc2");
                float DiemMonHoc3 = rs.getFloat("DiemMonHoc3");
                float DiemMonHoc4 = rs.getFloat("DiemMonHoc4");
                DiemSV_Model diemSV = new DiemSV_Model(MaSV, MaKH, HocKy, DiemMonHoc1, DiemMonHoc2, DiemMonHoc3, DiemMonHoc4);
                kqUser.add(diemSV);
            }

           jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kqUser;
    }
}
