package controller;

import Database.jdbc_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import menu.sr.blanco.MenuOpcion;
import model.Lop_Model;

public class Lop_DAO implements BasicFunction_Interface<Lop_Model> {

    public static Lop_DAO getInstance() {
        return new Lop_DAO();
    }
    @Override
    public int add(Lop_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "INSERT INTO Lop (MaLop, TenLop, MaKhoa)\n"
                    + "VALUES (?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaLop());
            st.setString(2, t.getClassName());
            st.setString(3, t.getMaKhoa());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
             JOptionPane.showMessageDialog(null, "Đã có lớp này không thể thêm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        return kq;
    }
    @Override
    public int update(Lop_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "UPDATE Lop SET TenLop = ?, MaKhoa = ? WHERE MaLop = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getClassName());
            st.setString(2, t.getMaKhoa());
            st.setString(3, t.getMaLop());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kq;
    }
    @Override
    public int delete(Lop_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "DELETE FROM Lop WHERE MaLop = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getMaLop());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
           
                        JOptionPane.showMessageDialog( null, "Đang có học sinh theo học ở lớp này!", "Không thể xóa!", JOptionPane.ERROR_MESSAGE);
        }
        return kq;
    }
    @Override
    public ArrayList<Lop_Model> selectAll() {
        ArrayList<Lop_Model> kqArrayList = new ArrayList<>();
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT * FROM Lop";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String MaLop = rs.getString("MaLop");
                String TenLop = rs.getString("TenLop");
                String MaKhoa = rs.getString("MaKhoa");
                Lop_Model lop = new Lop_Model(MaLop, TenLop, MaKhoa);
                kqArrayList.add(lop);
            }
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kqArrayList;
    }    
}
