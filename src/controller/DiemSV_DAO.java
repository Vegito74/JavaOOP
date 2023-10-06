package controller;
import Database.jdbc_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DiemSV_Model;

public class DiemSV_DAO implements BasicFunction_Interface<DiemSV_Model> {

    @Override
    public int add(DiemSV_Model t) {
        int kq = 0;

        try {
            Connection conn = jdbc_Connect.getConnection();

            String sql = "INSERT INTO Diem (MaSV, MaKH, HocKy, DiemMonHoc1, DiemMonHoc2, DiemMonHoc3, DiemMonHoc4)\n"
                    + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaSV());
            st.setString(2, t.getKhoaHoc());
            st.setString(3, t.getHocKy());
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

            String sql = "UPDATE Diem SET HocKy = ?, DiemMonHoc1 = ?, DiemMonHoc2 = ?, DiemMonHoc3 = ?, DiemMonHoc4 = ? WHERE MaSV = ? AND MaKH = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getHocKy());
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
                String HocKy = rs.getString("HocKy");
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
}
