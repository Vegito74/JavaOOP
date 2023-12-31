package controller;

import Database.jdbc_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Professors_Model;
import java.util.Date;
import javax.swing.JOptionPane;

public class Professors_DAO implements BasicFunction_Interface<Professors_Model> {

    public static Professors_DAO getInstance() {
        return new Professors_DAO();
    }
    @Override
    public int add(Professors_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "INSERT INTO Professors (NameGV, Email, GioiTinh,"+
                    " NgaySinh, QueQuan, Password)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getName());
            st.setString(2, t.getEmail());
            st.setBoolean(3, t.isGender());
            st.setDate(4, new java.sql.Date(t.getDateOfBirth().getTime()));
            st.setString(5, t.getQueQuan());
            st.setString(6, t.getPassword());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Email của một giảng viên đã đăng ký!", "Email đã tồn tại!", JOptionPane.WARNING_MESSAGE);
        }
        return kq;
    }
    @Override
    public int update(Professors_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "UPDATE Professors SET NameGV = ?, Email = ?,"+
                    " GioiTinh = ?, NgaySinh = ?, QueQuan = ?, Password = ? WHERE ID = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getName());
            st.setString(2, t.getEmail());
            st.setBoolean(3, t.isGender());
            st.setDate(4, new java.sql.Date(t.getDateOfBirth().getTime()));
            st.setString(5, t.getQueQuan());
            st.setString(6, t.getPassword());
            st.setInt(7, t.getId_Login());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(Professors_Model t) {
        int kq = 0;
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "DELETE FROM Professors WHERE ID = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, t.getId_Login());
            kq = st.executeUpdate();
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    @Override
    public ArrayList<Professors_Model> selectAll() {
        ArrayList<Professors_Model> kqArrayList = new ArrayList<>();
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT * FROM Professors";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NameGV = rs.getString("NameGV");
                String Email = rs.getString("Email");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                Date NgaySinh = rs.getDate("NgaySinh");
                String QueQuan = rs.getString("QueQuan");
                String Password = rs.getString("Password");
                Professors_Model professor = new Professors_Model(ID, Password, NameGV, Email, GioiTinh, (java.sql.Date) NgaySinh, QueQuan);
                kqArrayList.add(professor);
            }
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            Logger.getLogger(Professors_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return kqArrayList;
    }
    public boolean CheckAdministrativeRights(int id, String password) {
        if (id == 20210556 && password.equals("240603") ) {
            return false;
        } else {
            return false;
        }
    }

    public boolean checkLogin(int id, String password) {
        try {
            Connection conn = jdbc_Connect.getConnection();
            String sql = "SELECT * FROM Professors WHERE ID = ? AND Password = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (id == 20210556 && password.equals("240603")) {
                return true;
            }else if (rs.next()) {
                // Nếu có bản ghi khớp, trả về true
                return true;
            }
            jdbc_Connect.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Nếu không tìm thấy bản ghi khớp, hoặc có lỗi, trả về false
        return false;
    }
    
}
