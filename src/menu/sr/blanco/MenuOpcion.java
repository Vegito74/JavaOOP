package menu.sr.blanco;

import com.raven.model.Model_Card;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import combobox.Combobox;
import controller.DiemSV_DAO;
import controller.KhoaHoc_DAO;
import controller.Khoa_DAO;
import controller.Lop_DAO;
import controller.Professors_DAO;
import controller.SinhVien_DAO;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.DiemSV_Model;
import model.KhoaHoc_Model;
import model.Khoa_Model;
import model.Lop_Model;
import model.Professors_Model;
import model.SinhVien_Model;
import modeloDesign.sr.blanco.AnimateBTT;
import textfield.TextField;

public class MenuOpcion extends javax.swing.JFrame {

    AnimateBTT ColorOP = new AnimateBTT();
    DefaultTableModel model_Tb;
    DefaultTableModel modelTb_Khoa;
    DefaultTableModel modelTb_Lop;
    DefaultTableModel modelTb_KhoaHoc;
    DefaultTableModel modelTb_Diem;
    DefaultTableModel modelTb_QuanTri;
    DefaultTableModel modelTb_SVFinal;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    int res = 0;

    public MenuOpcion() {
        initComponents();
        //DefaultComboBoxModel model_Cbb= (DefaultComboBoxModel) combobox1.getModel();

        pestanas.setEnabledAt(0, false);
        pestanas.setEnabledAt(1, false);
        pestanas.setEnabledAt(2, false);
        pestanas.setEnabledAt(3, false);
        pestanas.setEnabledAt(4, false);
        pestanas.setEnabledAt(5, false);

        setBackground(new Color(0, 0, 0, 0));
        ColorOP.AnimattIni();
        init_Lop();
        init();
        //showResult();
        init_Khoa();
        //Table Sinh vien

        init_KhoaHoc();
        init_Diem();
        init_QuanTri();
        initSVFinal();
        noticeBoard_Main.addNoticeBoard(new ModelNoticeBoard(new Color(110, 44, 212), "Phương Đông University", "Now", "   Trường đại học Phương Đông là một ngôi trường vô cùng đặc biệt, nằm trong lòng một thành phố tràn đầy lịch sử và văn hóa. Với một truyền thống giáo dục lâu đời và chất lượng, trường đã thu hút học sinh và sinh viên từ khắp nơi đến để khám phá sự đa dạng và sự phong phú trong kiến thức.\n" +
"\n" +
"Nơi đây không chỉ là một mái nhà để hình thành kiến thức, mà còn là nơi mà tinh thần sáng tạo và đam mê được thúc đẩy. Trường đại học Phương Đông luôn tạo điều kiện tốt nhất để học sinh và sinh viên phát triển toàn diện, kết hợp giữa học tập, nghiên cứu, và hoạt động ngoại khóa đa dạng.\n" +
"\n" +
"Cùng với sự hỗ trợ từ các giảng viên và nhân viên tận tâm, trường đại học Phương Đông tự hào là nơi nơi tạo ra những người học trí thức, có lý thuyết và thực hành, sẵn sàng đối mặt với thách thức của thế giới hiện đại."));

    }
//============================================================================================================

    private void init() {
        table_SV.fixTable(jScrollPane1);
        table_SV.fixTable(jScrollPane2);
        table_SV.fixTable(jScrollPane3);
        table_SV.fixTable(jScrollPane4);
        table_SV.fixTable(jScrollPane5);
        table_SV.fixTable(jScrollPane6);
        table_SV.fixTable(jScrollPane7);
        model_Tb = (DefaultTableModel) table_SV.getModel();

        showResult();
        this.DoMaLop(ccb_MaClassSV);

    }
//============================================================================================================

    private void init_Khoa() {
        modelTb_Khoa = (DefaultTableModel) table_khoa.getModel();
        showResult_Khoa();
    }
//============================================================================================================

    private void init_Lop() {
        modelTb_Lop = (DefaultTableModel) table_Class.getModel();
        showResult_Lop();
        this.DoMaKhoa(cbbClass_MaKhoa);
    }
    //============================================================================================================    

    private void init_KhoaHoc() {
        modelTb_KhoaHoc = (DefaultTableModel) table_KhoaHoc.getModel();
        showResult_KhoaHoc();
        this.DoMonHocDaiCuong(cbbKhoaHoc_mh1);
        this.DoMonHocTheChat(cbbKhoaHoc_mh2);
        this.DoMonHocChuyenNganh(cbbKhoaHoc_mh3);
        this.DoMonHocDoAnChuyenNganh(cbbKhoaHoc_mh4);
        noticeBoard_KhoaHoc.addNoticeBoard(new ModelNoticeBoard(new Color(110, 44, 212), "Môn học đại cương", "Now", "    Toán cao cấp, Vật lý đại cương, Hóa học cơ bản, Tiếng Anh cơ sở, Lịch sử đại cương, Đại số tuyến tính, Giải tích, Nhập môn Công nghệ thông tin, Văn học đại cương, Khoa học xã hội đại cương, Kỹ thuật lập trình, Quản lý dự án, Hình học đại cương, Chính trị học, Kinh tế học đại cương, Đại cương về trí tuệ nhân tạo, Tâm lý học đại cương, Sinh học đại cương, Đại cương về lập trình web, Cơ sở dữ liệu"));
        noticeBoard_KhoaHoc.addNoticeBoard(new ModelNoticeBoard(new Color(255, 0, 25), "Môn học thể chất", "Now", "    Bóng đá, Bơi lội, Yoga, Gimnastics, Tennis, Cầu lông, Hội họa, Âm nhạc, Múa, Võ thuật, Điền kinh, Bóng chuyền, Nhảy xa, Bóng rổ, Cắm trại, Leo núi, Câu cá, Đi xe đạp, Thể dục buổi sáng, Thể thao nước"));
        noticeBoard_KhoaHoc.addNoticeBoard(new ModelNoticeBoard(new Color(0, 255, 25), "Môn học thể chất", "Now", "    Lập trình Java, Machine Learning, Kỹ thuật phần mềm, Hệ thống thông tin, Trí tuệ nhân tạo, Mạng máy tính, An toàn thông tin, Quản trị dự án IT, Cơ sở dữ liệu, Phát triển ứng dụng di động, Nhập môn khoa học dữ liệu, Học máy, Kỹ thuật đồ họa, Hệ điều hành, Công nghệ web, Trình biên dịch, Quản lý cơ sở dữ liệu, An toàn mạng, Kỹ thuật phân tích dữ liệu, IoT"));
        noticeBoard_KhoaHoc.addNoticeBoard(new ModelNoticeBoard(new Color(192, 173, 0), "Môn học thể chất", "Now", "    Xây dựng ứng dụng di động, Phân tích dữ liệu thương mại điện tử, Hệ thống quản lý cơ sở dữ liệu, Phát triển website, Ứng dụng trí tuệ nhân tạo, Thiết kế mạng máy tính, Bảo mật hệ thống thông tin, Quản lý dự án phần mềm, Quản lý cơ sở dữ liệu, Phát triển ứng dụng web, Phân tích dữ liệu, Đồ án IoT, Ứng dụng trí tuệ nhân tạo, Hệ thống điều khiển, Quản lý mạng, Ứng dụng đồ họa, Hệ thống điều khiển"));

    }
//============================================================================================================

    private void init_Diem() {
        modelTb_Diem = (DefaultTableModel) table_DiemSV.getModel();
        showResult_DiemSV();
        this.DoMaSV(cbbDiemSV_MaSV);
        this.DoMaSV(cbbDiemSV_MaSV1);
        this.DoMaKhoaHoc(cbbDiemSV_MaKhoaHoc);
        for (int i = 1; i <= 4; i++) {
            cbbDiemSV_HocKy.addItem(i + "");
        }
    }
//============================================================================================================

    private void init_QuanTri() {
        modelTb_QuanTri = (DefaultTableModel) table_QuanTri.getModel();
        showResult_QuanTri();
        noticeBoard2.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Lưu ý:", "Now", "Để quản lý thông tin và mật khẩu của người dùng cần quyền truy cập Admin."));
        btQuanTri_add.setEnabled(false);
        btQuanTri_update.setEnabled(false);
        btQuanTri_delete.setEnabled(false);

        tfQuanTri_MaGiangVien.setEnabled(false);

    }
//============================================================================================================

    private void initSVFinal() {
       setCard();
        
        modelTb_SVFinal = (DefaultTableModel) table_SVFinal.getModel();
        
    showResult_SVFinal();
    }
//============================================================================================================
//===============================================================================================================
public void setCard(){
     ArrayList<SinhVien_Model> listSV = SinhVien_DAO.getInstance().selectAll();
        ArrayList<SinhVien_Model> listSVFinal = SinhVien_DAO.getInstance().selectAll_SVFinal();
        ArrayList<Professors_Model> Gv = Professors_DAO.getInstance().selectAll();
        String gvsl= ""+Gv.size();
        String slSV = ""+listSV.size();
        String slSVFinal = ""+listSVFinal.size();
        int slSV1 = listSV.size();
        int slSVFinal1 =listSVFinal.size();
        float ptSV = (((float)slSV1-slSVFinal1)/((float)slSV1))*100;
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Sinh Viên", slSV, "Đang theo học "+((int)ptSV)+"%"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Sinh Viên Được Xét Tốt Nghiệp", slSVFinal, "Tốt Nghiệp "+(100-((int)ptSV))+"%"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Giảng Viên", gvsl, "Quản trị 100%"));
}
    //Hiển thị Sinh viên
// đổ thông tin cbb lop
    public void DoMaLop(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<Lop_Model> lopList = new Lop_DAO().selectAll(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (Lop_Model lop : lopList) {
            cbbModel.addElement(lop.getMaLop());
        }
    }
//===============================================================================================================

    public void DoMaKhoa(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<Khoa_Model> lopList = new Khoa_DAO().selectAll(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (Khoa_Model lop : lopList) {
            cbbModel.addElement(lop.getMaKhoa());
        }
    }
//===============================================================================================================

    public void DoMaSV(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<SinhVien_Model> lopList = new SinhVien_DAO().selectAll(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (SinhVien_Model lop : lopList) {
            cbbModel.addElement(lop.getMaSV());
        }
    }

    //===============================================================================================================
    public void DoMaKhoaHoc(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<KhoaHoc_Model> lopList = new KhoaHoc_DAO().selectAll(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (KhoaHoc_Model lop : lopList) {
            cbbModel.addElement(lop.getMaKH());
        }
    }

    //===============================================================================================================
    //===============================================================================================================
    public void DoMonHocDaiCuong(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<String> lopList = new danhSachMonHoc().selectAllDC(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (String lop : lopList) {
            cbbModel.addElement(lop);
        }
    }

    public void DoMonHocChuyenNganh(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<String> lopList = new danhSachMonHoc().selectAllCN(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (String lop : lopList) {
            cbbModel.addElement(lop);
        }
    }

    public void DoMonHocTheChat(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<String> lopList = new danhSachMonHoc().selectAllTC(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (String lop : lopList) {
            cbbModel.addElement(lop);
        }
    }

    public void DoMonHocDoAnChuyenNganh(Combobox t) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) t.getModel();
        cbbModel.removeAllElements();
        ArrayList<String> lopList = new danhSachMonHoc().selectAllDACN(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (String lop : lopList) {
            cbbModel.addElement(lop);
        }
    }

//===============================================================================================================
//===============================================================================================================
    public void showResult_SVFinal() {

        while (modelTb_SVFinal.getRowCount() > 0) {
            modelTb_SVFinal.removeRow(0);
        }
        try {
            ArrayList<SinhVien_Model> listSV = SinhVien_DAO.getInstance().selectAll_SVFinal();
            int i = 1;
            for (SinhVien_Model sinhVien_Model : listSV) {

                Object[] rowData = toObjectDataFinal(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_SVFinal.addRow(rowData);
                i++;
            }
            table_SVFinal.setModel(modelTb_SVFinal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectDataFinal(SinhVien_Model sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String date = dateFormat.format(sv.getDateOfBirth());

        boolean flag = sv.isGender();
        String gioitinh = "Nữ";
        if (flag) {
            gioitinh = "Nam";
        }
        Object[] objectData = {1, sv.getMaSV(), sv.getName(), sv.diemXepHang(), sv.xepHangSinhVien()};
        return objectData;
    }

    //===============================================================================================================
//===============================================================================================================
    public void showResult() {

        while (model_Tb.getRowCount() > 0) {
            model_Tb.removeRow(0);
        }
        try {
            ArrayList<SinhVien_Model> listSV = SinhVien_DAO.getInstance().selectAll();
            int i = 1;
            for (SinhVien_Model sinhVien_Model : listSV) {

                Object[] rowData = toObjectData(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                model_Tb.addRow(rowData);
                i++;
            }
            table_SV.setModel(model_Tb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectData(SinhVien_Model sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String date = dateFormat.format(sv.getDateOfBirth());

        boolean flag = sv.isGender();
        String gioitinh = "Nữ";
        if (flag) {
            gioitinh = "Nam";
        }
        Object[] objectData = {1, sv.getMaSV(), sv.getName(), gioitinh,
            date, sv.getQueQuan(), sv.getGpa_1(), sv.getGpa_2(), sv.getGpa_3(), sv.getGpa_4(), sv.getMaClass()};
        return objectData;
    }
//===============================================================================================================

//===============================================================================================================
    public float checkDiem(TextField t) {
        float res = 0.0f;
        String text = t.getText();
        try {

            // Kiểm tra xem chuỗi có chứa ký tự không phải số và không phải dấu thập phân hay không
            if (!text.matches("^[0-9]*\\.?[0-9]*$")) {
                throw new NumberFormatException("Chứa ký tự không hợp lệ");
            }

            // Kiểm tra xem chuỗi có chứa dấu thập phân hay không
            if (text.contains(".")) {
                res = Float.parseFloat(text);
            } else {
                res = Integer.parseInt(text);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm không hợp lệ", "Vui lòng nhập lại", JOptionPane.ERROR_MESSAGE);

        }
        return res;
    }
//===============================================================================================================

////===============================================================================================================
    ///Thao tác page Khoa và Lớp
    public void showResult_Khoa() {

        while (modelTb_Khoa.getRowCount() > 0) {
            modelTb_Khoa.removeRow(0);
        }
        try {
            ArrayList<Khoa_Model> listSV = Khoa_DAO.getInstance().selectAll();
            int i = 1;
            for (Khoa_Model sinhVien_Model : listSV) {

                Object[] rowData = toObjectData1(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_Khoa.addRow(rowData);
                i++;
            }
            table_khoa.setModel(modelTb_Khoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectData1(Khoa_Model sv) {
        Object[] objectData = {1, sv.getMaKhoa(), sv.getTenKhoa(), sv.getDiaChi(), sv.getSdt()};
        return objectData;
    }

    ////Hien thi Lop===========================
    public void showResult_Lop() {

        while (modelTb_Lop.getRowCount() > 0) {
            modelTb_Lop.removeRow(0);
        }
        try {
            ArrayList<Lop_Model> listLop = Lop_DAO.getInstance().selectAll();
            int i = 1;
            for (Lop_Model sinhVien_Model : listLop) {

                Object[] rowData = toObjectData2(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_Lop.addRow(rowData);
                i++;
            }
            table_Class.setModel(modelTb_Lop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectData2(Lop_Model sv) {
        Object[] objectData = {1, sv.getMaLop(), sv.getClassName(), sv.getMaKhoa(),};
        return objectData;
    }
////===============================================================================================================
//===============================================================================================================

    public void showResult_KhoaHoc() {

        while (modelTb_KhoaHoc.getRowCount() > 0) {
            modelTb_KhoaHoc.removeRow(0);
        }
        try {
            ArrayList<KhoaHoc_Model> listLop = KhoaHoc_DAO.getInstance().selectAll();
            int i = 1;
            for (KhoaHoc_Model sinhVien_Model : listLop) {

                Object[] rowData = toObjectData3(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_KhoaHoc.addRow(rowData);
                i++;
            }
            table_KhoaHoc.setModel(modelTb_KhoaHoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectData3(KhoaHoc_Model sv) {
        Object[] objectData = {1, sv.getMaKH(), sv.getNameKH(), sv.getMh1(), sv.getMh2(), sv.getMh3(), sv.getMh4()};
        return objectData;
    }
//===============================================================================================================
//===============================================================================================================

    public void showResult_DiemSV() {

        while (modelTb_Diem.getRowCount() > 0) {
            modelTb_Diem.removeRow(0);
        }
        try {
            ArrayList<DiemSV_Model> listLop = DiemSV_DAO.getInstance().selectAll();
            int i = 1;
            for (DiemSV_Model sinhVien_Model : listLop) {

                Object[] rowData = toObjectData4(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_Diem.addRow(rowData);
                i++;
            }
            table_DiemSV.setModel(modelTb_Diem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectData4(DiemSV_Model sv) {
        Object[] objectData = {1, sv.getMaSV(), sv.getKhoaHoc(), sv.getHocKy(), sv.getScore_1(), sv.getScore_2(), sv.getScore_3(), sv.getScore_4(), sv.mediumScore()};
        return objectData;
    }
//===============================================================================================================
//===============================================================================================================

    public void showResult_QuanTri() {

        while (modelTb_QuanTri.getRowCount() > 0) {
            modelTb_QuanTri.removeRow(0);
        }
        try {
            ArrayList<Professors_Model> listLop = Professors_DAO.getInstance().selectAll();
            int i = 1;
            for (Professors_Model sinhVien_Model : listLop) {

                Object[] rowData = toObjectData5(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_QuanTri.addRow(rowData);
                i++;
            }
            table_QuanTri.setModel(modelTb_QuanTri);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Đặt custom TableCellRenderer cho cột mật khẩu (ví dụ cột thứ 7)
    }

    public void showResult_QuanTri2() {

        while (modelTb_QuanTri.getRowCount() > 0) {
            modelTb_QuanTri.removeRow(0);
        }
        try {
            ArrayList<Professors_Model> listLop = Professors_DAO.getInstance().selectAll();
            int i = 1;
            for (Professors_Model sinhVien_Model : listLop) {

                Object[] rowData = toObjectData6(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_QuanTri.addRow(rowData);
                i++;
            }
            table_QuanTri.setModel(modelTb_QuanTri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectData6(Professors_Model sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String date = dateFormat.format(sv.getDateOfBirth());
        boolean flag = sv.isGender();
        String gioitinh = "Nữ";
        if (flag) {
            gioitinh = "Nam";
        }
        Object[] objectData = {1, sv.getId_Login(), sv.getName(), sv.getEmail(), gioitinh, date, sv.getQueQuan(), sv.getPassword()};
        return objectData;
    }
    // Đặt custom TableCellRenderer cho cột mật khẩu (ví dụ cột thứ 7)

    private static Object[] toObjectData5(Professors_Model sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String date = dateFormat.format(sv.getDateOfBirth());
        String hidePassword = "*******";
        boolean flag = sv.isGender();
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }
        Object[] objectData = {1, sv.getId_Login(), sv.getName(), sv.getEmail(), gioitinh, date, sv.getQueQuan(), hidePassword};
        return objectData;
    }

    public class PasswordRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String password = (String) value;

            // Kiểm tra nếu giá trị là mật khẩu, thay thế nó bằng dấu sao '*'
            if (password != null) {
                StringBuilder hiddenPassword = new StringBuilder();
                for (int i = 0; i < password.length() / 2; i++) {
                    hiddenPassword.append('*');
                }
                label.setText(hiddenPassword.toString());
            }

            return label;
        }
    }

//===============================================================================================================
//===============================================================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        btGroupGender_QuanTri = new javax.swing.ButtonGroup();
        Menu = new Panel_redondo.PanelRound();
        Titulo = new javax.swing.JLabel();
        btt_inicio = new Panel_gradiend.PanelGradient();
        lbl_ini = new javax.swing.JLabel();
        btt_prueba = new Panel_gradiend.PanelGradient();
        lbl_prueba = new javax.swing.JLabel();
        btt_pruebaOne = new Panel_gradiend.PanelGradient();
        lbl_pruebaOne = new javax.swing.JLabel();
        btt_pruebaTwo = new Panel_gradiend.PanelGradient();
        lbl_pruebaTwo = new javax.swing.JLabel();
        Separator = new javax.swing.JSeparator();
        btt_pruebaTwo1 = new Panel_gradiend.PanelGradient();
        lbl_pruebaTwo1 = new javax.swing.JLabel();
        btt_pruebaTwo2 = new Panel_gradiend.PanelGradient();
        lbl_pruebaTwo2 = new javax.swing.JLabel();
        btt_salir = new Panel_gradiend.PanelGradient();
        lbl_Salir = new javax.swing.JLabel();
        titleBar1 = new javaswingdev.swing.titlebar.TitleBar();
        Titulo1 = new javax.swing.JLabel();
        pestanas = new tabbed.MaterialTabbed();
        pageHome = new javax.swing.JPanel();
        roundPanel18 = new javaswingdev.swing.RoundPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_SVFinal = new javaswingdev.swing.table.Table();
        lbl_Quantri2 = new javax.swing.JLabel();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        roundPanel17 = new javaswingdev.swing.RoundPanel();
        noticeBoard_Main = new com.raven.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pageSV = new javax.swing.JPanel();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_SV = new javaswingdev.swing.table.Table();
        lbl_Quantri3 = new javax.swing.JLabel();
        roundPanel2 = new javaswingdev.swing.RoundPanel();
        tf_maSV = new textfield.TextField();
        jButton1 = new javax.swing.JButton();
        tf_NameSV = new textfield.TextField();
        tf_QqSV = new textfield.TextField();
        ccb_MaClassSV = new combobox.Combobox();
        tf_dob1 = new textfield.TextField();
        rdSV_NamNu = new radio_button.RadioButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        btSV_search = new javax.swing.JButton();
        tfSinhVien_searchName = new javax.swing.JTextField();
        btSV_reset = new javax.swing.JButton();
        roundPanel3 = new javaswingdev.swing.RoundPanel();
        bt_addSV = new javax.swing.JButton();
        bt_updateSV = new javax.swing.JButton();
        bt_deleteSV = new javax.swing.JButton();
        pageLopKhoa = new javax.swing.JPanel();
        roundPanel4 = new javaswingdev.swing.RoundPanel();
        roundPanel6 = new javaswingdev.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Class = new javaswingdev.swing.table.Table();
        jbt_deleteClass = new javax.swing.JButton();
        jbt_addClass = new javax.swing.JButton();
        tfClass_TenLop = new textfield.TextField();
        cbbClass_MaKhoa = new combobox.Combobox();
        tfClass_MaLop1 = new textfield.TextField();
        jbt_updateClass = new javax.swing.JButton();
        lbl_Quantri5 = new javax.swing.JLabel();
        roundPanel5 = new javaswingdev.swing.RoundPanel();
        roundPanel7 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_khoa = new javaswingdev.swing.table.Table();
        jbt_addKhoa = new javax.swing.JButton();
        jbt_UpdateKhoa = new javax.swing.JButton();
        tfKhoa_MaKhoa = new textfield.TextField();
        tfKhoa_TenKhoa = new textfield.TextField();
        tfKhoa_SDT = new textfield.TextField();
        tfKhoa_DiaChi = new textfield.TextField();
        jbt_deleteKhoa = new javax.swing.JButton();
        lbl_Quantri6 = new javax.swing.JLabel();
        pageKhoaHoc = new javax.swing.JPanel();
        roundPanel8 = new javaswingdev.swing.RoundPanel();
        tfKhoaHoc_TenKhoaHoc = new textfield.TextField();
        tfKhoaHoc_MaKhoaHoc = new textfield.TextField();
        btKhoaHoc_add = new javax.swing.JButton();
        btKhoaHoc_delete = new javax.swing.JButton();
        btKhoaHoc_update = new javax.swing.JButton();
        cbbKhoaHoc_mh1 = new combobox.Combobox();
        cbbKhoaHoc_mh4 = new combobox.Combobox();
        cbbKhoaHoc_mh2 = new combobox.Combobox();
        cbbKhoaHoc_mh3 = new combobox.Combobox();
        jButton3 = new javax.swing.JButton();
        roundPanel9 = new javaswingdev.swing.RoundPanel();
        noticeBoard_KhoaHoc = new com.raven.swing.noticeboard.NoticeBoard();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        roundPanel10 = new javaswingdev.swing.RoundPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_KhoaHoc = new javaswingdev.swing.table.Table();
        lbl_Quantri4 = new javax.swing.JLabel();
        pageDiemSV = new javax.swing.JPanel();
        roundPanel11 = new javaswingdev.swing.RoundPanel();
        cbbDiemSV_MaSV = new combobox.Combobox();
        cbbDiemSV_MaKhoaHoc = new combobox.Combobox();
        cbbDiemSV_HocKy = new combobox.Combobox();
        tfDiemSV_diem2 = new textfield.TextField();
        tfDiemSV_diem3 = new textfield.TextField();
        tfDiemSV_diem4 = new textfield.TextField();
        tfDiemSV_diem1 = new textfield.TextField();
        btDiemSV_add = new javax.swing.JButton();
        btDiemSv_delete = new javax.swing.JButton();
        btDiemSV_update = new javax.swing.JButton();
        btDiemSV_Reset = new javax.swing.JButton();
        roundPanel12 = new javaswingdev.swing.RoundPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_DiemSV = new javaswingdev.swing.table.Table();
        lbl_Quantri1 = new javax.swing.JLabel();
        roundPanel13 = new javaswingdev.swing.RoundPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbbDiemSV_MaSV1 = new combobox.Combobox();
        pageQuanTri = new javax.swing.JPanel();
        roundPanel14 = new javaswingdev.swing.RoundPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_QuanTri = new javaswingdev.swing.table.Table();
        lbl_Quantri = new javax.swing.JLabel();
        roundPanel15 = new javaswingdev.swing.RoundPanel();
        tfQuanTri_User = new textfield.TextField();
        jButton5 = new javax.swing.JButton();
        noticeBoard2 = new com.raven.swing.noticeboard.NoticeBoard();
        tfQuanTri_Login = new textfield.PasswordField();
        roundPanel16 = new javaswingdev.swing.RoundPanel();
        tfQuanTri_MaGiangVien = new textfield.TextField();
        tfQuanTri_Password = new textfield.TextField();
        tfQuanTri_Email = new textfield.TextField();
        tfQuanTri_TenGiangVien = new textfield.TextField();
        btQuanTri_update = new javax.swing.JButton();
        btQuanTri_delete = new javax.swing.JButton();
        btQuanTri_add = new javax.swing.JButton();
        tfQuanTri_date1 = new textfield.TextField();
        tfQuanTri_QueQuan = new textfield.TextField();
        tfQuanTri_Reset = new javax.swing.JButton();
        rdQuanTri_NamNu = new radio_button.RadioButtonCustom();
        jLabel1 = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(0, 153, 204));
        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(tf_dob1);

        dateChooser2.setForeground(new java.awt.Color(0, 153, 204));
        dateChooser2.setDateFormat("dd/MM/yyyy");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1180, 550));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(23, 27, 36));
        Menu.setMinimumSize(new java.awt.Dimension(157, 550));
        Menu.setPreferredSize(new java.awt.Dimension(157, 550));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Poppins", 3, 17)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("University");
        Titulo.setToolTipText("");
        Menu.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 40));

        btt_inicio.setBackground(new java.awt.Color(23, 27, 36));
        btt_inicio.setToolTipText("");
        btt_inicio.setColorGradient(new java.awt.Color(23, 27, 36));
        btt_inicio.setRadius(10);
        btt_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_inicioMousePressed(evt);
            }
        });
        btt_inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ini.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_ini.setForeground(new java.awt.Color(166, 166, 166));
        lbl_ini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home-altV.png"))); // NOI18N
        lbl_ini.setText("   Trang Chủ");
        lbl_ini.setAutoscrolls(true);
        lbl_ini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_iniMousePressed(evt);
            }
        });
        btt_inicio.add(lbl_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 129, 32));

        Menu.add(btt_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 120, 149, 32));

        btt_prueba.setBackground(new java.awt.Color(23, 27, 36));
        btt_prueba.setToolTipText("");
        btt_prueba.setColorGradient(new java.awt.Color(23, 27, 36));
        btt_prueba.setRadius(10);
        btt_prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaMousePressed(evt);
            }
        });
        btt_prueba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_prueba.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_prueba.setForeground(new java.awt.Color(166, 166, 166));
        lbl_prueba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_student_male_80px.png"))); // NOI18N
        lbl_prueba.setText("   Sinh Viên");
        lbl_prueba.setToolTipText("");
        lbl_prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_pruebaMouseReleased(evt);
            }
        });
        btt_prueba.add(lbl_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 129, 32));
        lbl_prueba.getAccessibleContext().setAccessibleName("Sinh Viên");

        Menu.add(btt_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 155, 149, 32));

        btt_pruebaOne.setBackground(new java.awt.Color(23, 27, 36));
        btt_pruebaOne.setToolTipText("");
        btt_pruebaOne.setColorGradient(new java.awt.Color(23, 27, 36));
        btt_pruebaOne.setRadius(10);
        btt_pruebaOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaOneMousePressed(evt);
            }
        });
        btt_pruebaOne.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_pruebaOne.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_pruebaOne.setForeground(new java.awt.Color(166, 166, 166));
        lbl_pruebaOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users-altV.png"))); // NOI18N
        lbl_pruebaOne.setText("   Lớp Học");
        lbl_pruebaOne.setToolTipText("");
        lbl_pruebaOne.setAutoscrolls(true);
        lbl_pruebaOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_pruebaOneMousePressed(evt);
            }
        });
        btt_pruebaOne.add(lbl_pruebaOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 129, 32));

        Menu.add(btt_pruebaOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 190, 149, 32));

        btt_pruebaTwo.setBackground(new java.awt.Color(23, 27, 36));
        btt_pruebaTwo.setToolTipText("");
        btt_pruebaTwo.setColorGradient(new java.awt.Color(23, 27, 36));
        btt_pruebaTwo.setRadius(10);
        btt_pruebaTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaTwoMousePressed(evt);
            }
        });
        btt_pruebaTwo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_pruebaTwo.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_pruebaTwo.setForeground(new java.awt.Color(166, 166, 166));
        lbl_pruebaTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users-altV.png"))); // NOI18N
        lbl_pruebaTwo.setText("   Khóa Học");
        lbl_pruebaTwo.setToolTipText("");
        lbl_pruebaTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_pruebaTwoMousePressed(evt);
            }
        });
        btt_pruebaTwo.add(lbl_pruebaTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 129, 32));

        Menu.add(btt_pruebaTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 225, 149, 32));

        Separator.setBackground(new java.awt.Color(51, 51, 51));
        Separator.setForeground(new java.awt.Color(71, 71, 71));
        Menu.add(Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 330, 130, -1));

        btt_pruebaTwo1.setBackground(new java.awt.Color(23, 27, 36));
        btt_pruebaTwo1.setToolTipText("");
        btt_pruebaTwo1.setColorGradient(new java.awt.Color(23, 27, 36));
        btt_pruebaTwo1.setRadius(10);
        btt_pruebaTwo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaTwo1MousePressed(evt);
            }
        });
        btt_pruebaTwo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_pruebaTwo1.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_pruebaTwo1.setForeground(new java.awt.Color(166, 166, 166));
        lbl_pruebaTwo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users-altV.png"))); // NOI18N
        lbl_pruebaTwo1.setText("   Điểm Học Kì");
        lbl_pruebaTwo1.setToolTipText("");
        lbl_pruebaTwo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_pruebaTwo1MousePressed(evt);
            }
        });
        btt_pruebaTwo1.add(lbl_pruebaTwo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 129, 32));

        Menu.add(btt_pruebaTwo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 260, 149, 32));

        btt_pruebaTwo2.setBackground(new java.awt.Color(23, 27, 36));
        btt_pruebaTwo2.setToolTipText("");
        btt_pruebaTwo2.setColorGradient(new java.awt.Color(23, 27, 36));
        btt_pruebaTwo2.setRadius(10);
        btt_pruebaTwo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaTwo2MousePressed(evt);
            }
        });
        btt_pruebaTwo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_pruebaTwo2.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_pruebaTwo2.setForeground(new java.awt.Color(166, 166, 166));
        lbl_pruebaTwo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users-altV.png"))); // NOI18N
        lbl_pruebaTwo2.setText("   Quản Trị");
        lbl_pruebaTwo2.setToolTipText("");
        lbl_pruebaTwo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_pruebaTwo2MousePressed(evt);
            }
        });
        btt_pruebaTwo2.add(lbl_pruebaTwo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 129, 32));

        Menu.add(btt_pruebaTwo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 295, 149, 32));

        btt_salir.setBackground(new java.awt.Color(59, 57, 71));
        btt_salir.setColorGradient(new java.awt.Color(59, 57, 71));
        btt_salir.setRadius(10);
        btt_salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Salir.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lbl_Salir.setForeground(new java.awt.Color(166, 166, 166));
        lbl_Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Salir.setText("Sign Out");
        lbl_Salir.setToolTipText("");
        lbl_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_Salir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_SalirMouseMoved(evt);
            }
        });
        lbl_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_SalirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_SalirMousePressed(evt);
            }
        });
        btt_salir.add(lbl_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 149, 32));

        Menu.add(btt_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 500, 149, 32));

        titleBar1.setOpaque(true);
        Menu.add(titleBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        Titulo1.setFont(new java.awt.Font("Poppins", 3, 17)); // NOI18N
        Titulo1.setForeground(new java.awt.Color(255, 255, 255));
        Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo1.setText("PHƯƠNG ĐÔNG ");
        Titulo1.setToolTipText("");
        Menu.add(Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 40));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 550));

        pestanas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pestanas.setMinimumSize(new java.awt.Dimension(1180, 550));
        pestanas.setPreferredSize(new java.awt.Dimension(1180, 550));

        pageHome.setBackground(new java.awt.Color(102, 102, 102));
        pageHome.setPreferredSize(new java.awt.Dimension(1148, 550));

        roundPanel18.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel18.setRound(10);

        table_SVFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sinh Viên", "Tên Sinh Viên", "Điểm Xét ", "Đánh Giá Xếp Loại"
            }
        ));
        jScrollPane7.setViewportView(table_SVFinal);

        lbl_Quantri2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri2.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri2.setText("Sinh Viên Được Xét Tốt Nghiệp");

        javax.swing.GroupLayout roundPanel18Layout = new javax.swing.GroupLayout(roundPanel18);
        roundPanel18.setLayout(roundPanel18Layout);
        roundPanel18Layout.setHorizontalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel18Layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(lbl_Quantri2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        roundPanel18Layout.setVerticalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Quantri2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        card1.setColor1(new java.awt.Color(255, 51, 51));
        card1.setColor2(new java.awt.Color(255, 204, 204));

        card2.setColor1(new java.awt.Color(204, 204, 0));
        card2.setColor2(new java.awt.Color(153, 204, 0));

        card3.setColor1(new java.awt.Color(0, 153, 51));
        card3.setColor2(new java.awt.Color(153, 255, 102));

        roundPanel17.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel17.setRound(10);

        noticeBoard_Main.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Giới Thiệu");

        javax.swing.GroupLayout roundPanel17Layout = new javax.swing.GroupLayout(roundPanel17);
        roundPanel17.setLayout(roundPanel17Layout);
        roundPanel17Layout.setHorizontalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel17Layout.createSequentialGroup()
                        .addGroup(roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noticeBoard_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel17Layout.setVerticalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noticeBoard_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout pageHomeLayout = new javax.swing.GroupLayout(pageHome);
        pageHome.setLayout(pageHomeLayout);
        pageHomeLayout.setHorizontalGroup(
            pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageHomeLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageHomeLayout.createSequentialGroup()
                        .addComponent(roundPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pageHomeLayout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pageHomeLayout.setVerticalGroup(
            pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(card2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pageHomeLayout.createSequentialGroup()
                        .addComponent(roundPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pestanas.addTab("", pageHome);

        pageSV.setBackground(new java.awt.Color(240, 240, 240));
        pageSV.setPreferredSize(new java.awt.Dimension(1148, 550));
        pageSV.setRequestFocusEnabled(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table_SV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MSV", "Tên Sinh Viên", "Giới Tính", "Ngày Sinh", "Quê Quán", "Điểm Kì I", "Điểm Kì II", "Điểm Kì II", "Điểm Kì VI", "Mã Lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_SV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_SVMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_SV);
        if (table_SV.getColumnModel().getColumnCount() > 0) {
            table_SV.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_SV.getColumnModel().getColumn(1).setPreferredWidth(40);
            table_SV.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_SV.getColumnModel().getColumn(6).setPreferredWidth(45);
            table_SV.getColumnModel().getColumn(7).setPreferredWidth(45);
            table_SV.getColumnModel().getColumn(8).setPreferredWidth(45);
            table_SV.getColumnModel().getColumn(9).setPreferredWidth(45);
            table_SV.getColumnModel().getColumn(10).setPreferredWidth(40);
        }

        lbl_Quantri3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri3.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri3.setText("Quản Lý Sinh Viên");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Quantri3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addComponent(lbl_Quantri3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setToolTipText("");
        roundPanel2.setRound(10);

        tf_maSV.setBackground(new java.awt.Color(255, 255, 255));
        tf_maSV.setForeground(new java.awt.Color(102, 102, 102));
        tf_maSV.setLabelText("Mã Sinh Viên");
        tf_maSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_maSVActionPerformed(evt);
            }
        });

        jButton1.setText(".....");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tf_NameSV.setBackground(new java.awt.Color(255, 255, 255));
        tf_NameSV.setLabelText("Tên Sinh VIên");

        tf_QqSV.setBackground(new java.awt.Color(255, 255, 255));
        tf_QqSV.setLabelText("Quê Quán");

        ccb_MaClassSV.setLabeText("Mã Lớp");

        tf_dob1.setBackground(new java.awt.Color(255, 255, 255));
        tf_dob1.setLabelText("Date Of Birth");

        rdSV_NamNu.setText("Nam/Nữ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Giới Tính:");

        btSV_search.setText("Tìm Sinh Viên");
        btSV_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSV_searchActionPerformed(evt);
            }
        });

        btSV_reset.setText("Reset");
        btSV_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSV_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(ccb_MaClassSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tfSinhVien_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_NameSV, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(tf_QqSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdSV_NamNu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tf_dob1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(btSV_search, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290)
                        .addComponent(btSV_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_NameSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rdSV_NamNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_QqSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccb_MaClassSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dob1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSV_search)
                            .addComponent(tfSinhVien_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(btSV_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel3.setRound(10);

        bt_addSV.setFont(new java.awt.Font("Aachen", 1, 18)); // NOI18N
        bt_addSV.setText("Thêm");
        bt_addSV.setToolTipText("");
        bt_addSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addSVActionPerformed(evt);
            }
        });

        bt_updateSV.setFont(new java.awt.Font("Aachen", 1, 18)); // NOI18N
        bt_updateSV.setText("Update");
        bt_updateSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateSVActionPerformed(evt);
            }
        });

        bt_deleteSV.setFont(new java.awt.Font("Aachen", 1, 18)); // NOI18N
        bt_deleteSV.setText("Xóa");
        bt_deleteSV.setToolTipText("");
        bt_deleteSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_addSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_updateSV, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(bt_deleteSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(bt_addSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_updateSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(bt_deleteSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout pageSVLayout = new javax.swing.GroupLayout(pageSV);
        pageSV.setLayout(pageSVLayout);
        pageSVLayout.setHorizontalGroup(
            pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageSVLayout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pageSVLayout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pageSVLayout.setVerticalGroup(
            pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pestanas.addTab("", pageSV);

        pageLopKhoa.setBackground(new java.awt.Color(204, 204, 204));

        roundPanel4.setBackground(new java.awt.Color(240, 240, 240));
        roundPanel4.setRound(8);

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel6.setRound(10);

        table_Class.setBackground(new java.awt.Color(255, 255, 255));
        table_Class.setForeground(new java.awt.Color(102, 102, 102));
        table_Class.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Lớp", "Tên Lớp", "Mã Khoa"
            }
        ));
        table_Class.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_ClassMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(table_Class);
        if (table_Class.getColumnModel().getColumnCount() > 0) {
            table_Class.getColumnModel().getColumn(0).setPreferredWidth(40);
        }

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbt_deleteClass.setText("Xóa Lớp Học");
        jbt_deleteClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_deleteClassActionPerformed(evt);
            }
        });

        jbt_addClass.setText("Thêm Lớp Học");
        jbt_addClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_addClassActionPerformed(evt);
            }
        });

        tfClass_TenLop.setBackground(new java.awt.Color(240, 240, 240));
        tfClass_TenLop.setLabelText("Tên Lớp");

        cbbClass_MaKhoa.setBackground(new java.awt.Color(240, 240, 240));
        cbbClass_MaKhoa.setLabeText("Lớp Thuộc Khoa");

        tfClass_MaLop1.setBackground(new java.awt.Color(240, 240, 240));
        tfClass_MaLop1.setLabelText("Mã Lớp");

        jbt_updateClass.setText("Update Lớp");
        jbt_updateClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_updateClassActionPerformed(evt);
            }
        });

        lbl_Quantri5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri5.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri5.setText("Quản Lý Lớp Học");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Quantri5, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfClass_TenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfClass_MaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addComponent(cbbClass_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jbt_addClass, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jbt_updateClass, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_deleteClass, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Quantri5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbt_addClass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_updateClass, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbt_deleteClass, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(tfClass_MaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfClass_TenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(cbbClass_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );

        roundPanel5.setRound(8);

        roundPanel7.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel7.setRound(10);

        table_khoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khoa", "Tên Khoa", "Địa Chỉ", "Số Điện Thoại"
            }
        ));
        table_khoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_khoaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table_khoa);
        if (table_khoa.getColumnModel().getColumnCount() > 0) {
            table_khoa.getColumnModel().getColumn(0).setPreferredWidth(40);
        }

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbt_addKhoa.setText("Thêm Khoa Mới");
        jbt_addKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_addKhoaActionPerformed(evt);
            }
        });

        jbt_UpdateKhoa.setText("Update Khoa");
        jbt_UpdateKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_UpdateKhoaActionPerformed(evt);
            }
        });

        tfKhoa_MaKhoa.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoa_MaKhoa.setLabelText("Mã Khoa");
        tfKhoa_MaKhoa.setMaximumSize(new java.awt.Dimension(150, 2147483647));

        tfKhoa_TenKhoa.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoa_TenKhoa.setLabelText("Tên Khoa");
        tfKhoa_TenKhoa.setMaximumSize(new java.awt.Dimension(150, 2147483647));

        tfKhoa_SDT.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoa_SDT.setLabelText("Số Điện Thoại");
        tfKhoa_SDT.setMaximumSize(new java.awt.Dimension(150, 2147483647));

        tfKhoa_DiaChi.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoa_DiaChi.setLabelText("Địa Chỉ");
        tfKhoa_DiaChi.setMaximumSize(new java.awt.Dimension(150, 2147483647));

        jbt_deleteKhoa.setText("Xóa Khoa");
        jbt_deleteKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_deleteKhoaActionPerformed(evt);
            }
        });

        lbl_Quantri6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri6.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri6.setText("Quản Lý Khoa");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(tfKhoa_TenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(tfKhoa_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfKhoa_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoa_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbt_addKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbt_deleteKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbt_UpdateKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lbl_Quantri6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lbl_Quantri6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_deleteKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_addKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_UpdateKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKhoa_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoa_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKhoa_TenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoa_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout pageLopKhoaLayout = new javax.swing.GroupLayout(pageLopKhoa);
        pageLopKhoa.setLayout(pageLopKhoaLayout);
        pageLopKhoaLayout.setHorizontalGroup(
            pageLopKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageLopKhoaLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pageLopKhoaLayout.setVerticalGroup(
            pageLopKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageLopKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageLopKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pestanas.addTab("", pageLopKhoa);

        pageKhoaHoc.setBackground(new java.awt.Color(102, 102, 102));

        roundPanel8.setRound(10);

        tfKhoaHoc_TenKhoaHoc.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoaHoc_TenKhoaHoc.setLabelText("Tên Khóa Học");
        tfKhoaHoc_TenKhoaHoc.setPreferredSize(new java.awt.Dimension(64, 42));

        tfKhoaHoc_MaKhoaHoc.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoaHoc_MaKhoaHoc.setLabelText("Mã Khóa Học");
        tfKhoaHoc_MaKhoaHoc.setPreferredSize(new java.awt.Dimension(64, 42));

        btKhoaHoc_add.setText("Thêm Khóa Học");
        btKhoaHoc_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhoaHoc_addActionPerformed(evt);
            }
        });

        btKhoaHoc_delete.setText("Xóa Khóa Học");
        btKhoaHoc_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhoaHoc_deleteActionPerformed(evt);
            }
        });

        btKhoaHoc_update.setText("Cập Nhật Khóa Học");
        btKhoaHoc_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhoaHoc_updateActionPerformed(evt);
            }
        });

        cbbKhoaHoc_mh1.setBackground(new java.awt.Color(240, 240, 240));
        cbbKhoaHoc_mh1.setLabeText("Môn Học 1");
        cbbKhoaHoc_mh1.setLineColor(new java.awt.Color(51, 51, 255));

        cbbKhoaHoc_mh4.setBackground(new java.awt.Color(240, 240, 240));
        cbbKhoaHoc_mh4.setLabeText("Môn Học 4");
        cbbKhoaHoc_mh4.setLineColor(new java.awt.Color(51, 51, 255));

        cbbKhoaHoc_mh2.setBackground(new java.awt.Color(240, 240, 240));
        cbbKhoaHoc_mh2.setLabeText("Môn Học 2");
        cbbKhoaHoc_mh2.setLineColor(new java.awt.Color(51, 51, 255));

        cbbKhoaHoc_mh3.setBackground(new java.awt.Color(240, 240, 240));
        cbbKhoaHoc_mh3.setLabeText("Môn Học 3");
        cbbKhoaHoc_mh3.setLineColor(new java.awt.Color(51, 51, 255));

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfKhoaHoc_MaKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKhoaHoc_mh1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(cbbKhoaHoc_mh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbKhoaHoc_mh4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKhoaHoc_mh2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoaHoc_TenKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                        .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btKhoaHoc_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btKhoaHoc_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btKhoaHoc_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(45, 45, 45))))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfKhoaHoc_TenKhoaHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfKhoaHoc_MaKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btKhoaHoc_add, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btKhoaHoc_update, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btKhoaHoc_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhoaHoc_mh1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhoaHoc_mh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhoaHoc_mh3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhoaHoc_mh4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        roundPanel9.setRound(10);

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Môn Học Đào Tạo");

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noticeBoard_KhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(noticeBoard_KhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel10.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel10.setForeground(new java.awt.Color(255, 255, 255));
        roundPanel10.setRound(12);

        table_KhoaHoc.setBackground(new java.awt.Color(255, 255, 255));
        table_KhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        table_KhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khóa Học", "Tên Khóa Học", "Môn Học 1", "Môn Học 2", "Môn Học 3", "Môn Học 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_KhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_KhoaHocMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(table_KhoaHoc);
        if (table_KhoaHoc.getColumnModel().getColumnCount() > 0) {
            table_KhoaHoc.getColumnModel().getColumn(0).setPreferredWidth(40);
        }

        lbl_Quantri4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri4.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri4.setText("Quản Lý Khóa Học");

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Quantri4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Quantri4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pageKhoaHocLayout = new javax.swing.GroupLayout(pageKhoaHoc);
        pageKhoaHoc.setLayout(pageKhoaHocLayout);
        pageKhoaHocLayout.setHorizontalGroup(
            pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageKhoaHocLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pageKhoaHocLayout.setVerticalGroup(
            pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageKhoaHocLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pageKhoaHocLayout.createSequentialGroup()
                        .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pestanas.addTab("", pageKhoaHoc);

        pageDiemSV.setBackground(new java.awt.Color(0, 102, 153));

        roundPanel11.setRound(10);

        cbbDiemSV_MaSV.setBackground(new java.awt.Color(240, 240, 240));
        cbbDiemSV_MaSV.setForeground(new java.awt.Color(102, 102, 102));
        cbbDiemSV_MaSV.setLabeText("Mã Sinh Viên");

        cbbDiemSV_MaKhoaHoc.setBackground(new java.awt.Color(240, 240, 240));
        cbbDiemSV_MaKhoaHoc.setLabeText("Mã Khóa Học");

        cbbDiemSV_HocKy.setBackground(new java.awt.Color(240, 240, 240));
        cbbDiemSV_HocKy.setLabeText("Học Kỳ");

        tfDiemSV_diem2.setBackground(new java.awt.Color(240, 240, 240));
        tfDiemSV_diem2.setLabelText("Điểm 2");

        tfDiemSV_diem3.setBackground(new java.awt.Color(240, 240, 240));
        tfDiemSV_diem3.setLabelText("Điểm 3");

        tfDiemSV_diem4.setBackground(new java.awt.Color(240, 240, 240));
        tfDiemSV_diem4.setLabelText("Điểm 4");

        tfDiemSV_diem1.setBackground(new java.awt.Color(240, 240, 240));
        tfDiemSV_diem1.setLabelText("Diểm 1");

        btDiemSV_add.setText("Nhập Điểm");
        btDiemSV_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDiemSV_addActionPerformed(evt);
            }
        });

        btDiemSv_delete.setText("Xóa Điểm");
        btDiemSv_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDiemSv_deleteActionPerformed(evt);
            }
        });

        btDiemSV_update.setText("Sửa Điểm");
        btDiemSV_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDiemSV_updateActionPerformed(evt);
            }
        });

        btDiemSV_Reset.setText("Reset");
        btDiemSV_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDiemSV_ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel11Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbDiemSV_HocKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbDiemSV_MaKhoaHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbDiemSV_MaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDiemSV_diem1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(tfDiemSV_diem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDiemSV_diem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDiemSV_diem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(roundPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDiemSv_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDiemSV_add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btDiemSV_update, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btDiemSV_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbDiemSV_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDiemSV_MaKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDiemSV_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDiemSV_diem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDiemSV_diem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDiemSV_diem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDiemSV_diem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDiemSV_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDiemSV_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDiemSv_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btDiemSV_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        roundPanel12.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel12.setRound(10);

        table_DiemSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sinh Viên", "Mã Khóa Học", "Học Kỳ", "Điểm 1", "Điểm 2", "Điểm 3", "Điểm 4", "Medium Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_DiemSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_DiemSVMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(table_DiemSV);
        if (table_DiemSV.getColumnModel().getColumnCount() > 0) {
            table_DiemSV.getColumnModel().getColumn(0).setPreferredWidth(35);
            table_DiemSV.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(4).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(5).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(6).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        lbl_Quantri1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri1.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri1.setText("Quản Lý Điểm Học Kỳ Sinh");

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(lbl_Quantri1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel12Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbl_Quantri1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel13.setRound(10);

        jButton2.setText("Hiển thị tất cả điểm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Hiển thị điểm theo mã đã chọn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbbDiemSV_MaSV1.setBackground(new java.awt.Color(240, 240, 240));
        cbbDiemSV_MaSV1.setForeground(new java.awt.Color(102, 102, 102));
        cbbDiemSV_MaSV1.setLabeText("Mã Sinh Viên");

        javax.swing.GroupLayout roundPanel13Layout = new javax.swing.GroupLayout(roundPanel13);
        roundPanel13.setLayout(roundPanel13Layout);
        roundPanel13Layout.setHorizontalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDiemSV_MaSV1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel13Layout.setVerticalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel13Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbDiemSV_MaSV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout pageDiemSVLayout = new javax.swing.GroupLayout(pageDiemSV);
        pageDiemSV.setLayout(pageDiemSVLayout);
        pageDiemSVLayout.setHorizontalGroup(
            pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageDiemSVLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pageDiemSVLayout.setVerticalGroup(
            pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageDiemSVLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageDiemSVLayout.createSequentialGroup()
                        .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pestanas.addTab("", pageDiemSV);

        pageQuanTri.setBackground(new java.awt.Color(102, 102, 102));

        roundPanel14.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel14.setRound(10);

        table_QuanTri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Giảng Viên", "Tên Giảng Viên", "Email", "Giới Tính", "Ngày Sinh", "Quê Quán", "Password"
            }
        ));
        table_QuanTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_QuanTriMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(table_QuanTri);
        if (table_QuanTri.getColumnModel().getColumnCount() > 0) {
            table_QuanTri.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_QuanTri.getColumnModel().getColumn(3).setPreferredWidth(110);
            table_QuanTri.getColumnModel().getColumn(4).setPreferredWidth(35);
        }

        lbl_Quantri.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Quantri.setForeground(new java.awt.Color(51, 51, 51));
        lbl_Quantri.setText("Giảng Viên & Quản Trị");

        javax.swing.GroupLayout roundPanel14Layout = new javax.swing.GroupLayout(roundPanel14);
        roundPanel14.setLayout(roundPanel14Layout);
        roundPanel14Layout.setHorizontalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel14Layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(lbl_Quantri, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        roundPanel14Layout.setVerticalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Quantri, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel15.setRound(10);

        tfQuanTri_User.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_User.setLabelText("User");

        jButton5.setText("Login with Admin");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        noticeBoard2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfQuanTri_Login.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_Login.setLabelText("Password");

        javax.swing.GroupLayout roundPanel15Layout = new javax.swing.GroupLayout(roundPanel15);
        roundPanel15.setLayout(roundPanel15Layout);
        roundPanel15Layout.setHorizontalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noticeBoard2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfQuanTri_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfQuanTri_Login, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel15Layout.setVerticalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(tfQuanTri_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfQuanTri_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noticeBoard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel16.setRound(10);

        tfQuanTri_MaGiangVien.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_MaGiangVien.setLabelText("Mã Giảng Viên");

        tfQuanTri_Password.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_Password.setLabelText("Password");

        tfQuanTri_Email.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_Email.setLabelText("Email");

        tfQuanTri_TenGiangVien.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_TenGiangVien.setLabelText("Tên Giảng Viên");

        btQuanTri_update.setText("Sửa Thông Tin");
        btQuanTri_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuanTri_updateActionPerformed(evt);
            }
        });

        btQuanTri_delete.setText("Xóa Tài Khoản");
        btQuanTri_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuanTri_deleteActionPerformed(evt);
            }
        });

        btQuanTri_add.setText("Thêm Tài Khoản");
        btQuanTri_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuanTri_addActionPerformed(evt);
            }
        });

        tfQuanTri_date1.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_date1.setLabelText("Date of Birth");

        tfQuanTri_QueQuan.setBackground(new java.awt.Color(240, 240, 240));
        tfQuanTri_QueQuan.setLabelText("Quê Quán");

        tfQuanTri_Reset.setText("Reset");
        tfQuanTri_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuanTri_ResetActionPerformed(evt);
            }
        });

        rdQuanTri_NamNu.setText("Nam/Nữ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Giới Tính:");

        javax.swing.GroupLayout roundPanel16Layout = new javax.swing.GroupLayout(roundPanel16);
        roundPanel16.setLayout(roundPanel16Layout);
        roundPanel16Layout.setHorizontalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel16Layout.createSequentialGroup()
                        .addComponent(btQuanTri_add, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btQuanTri_update, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btQuanTri_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfQuanTri_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel16Layout.createSequentialGroup()
                        .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfQuanTri_TenGiangVien, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(tfQuanTri_Password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfQuanTri_MaGiangVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfQuanTri_Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roundPanel16Layout.createSequentialGroup()
                                .addComponent(tfQuanTri_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(rdQuanTri_NamNu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addComponent(tfQuanTri_QueQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        roundPanel16Layout.setVerticalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btQuanTri_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btQuanTri_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btQuanTri_add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuanTri_Reset))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfQuanTri_MaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuanTri_date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel16Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(rdQuanTri_NamNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuanTri_TenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuanTri_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuanTri_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuanTri_QueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pageQuanTriLayout = new javax.swing.GroupLayout(pageQuanTri);
        pageQuanTri.setLayout(pageQuanTriLayout);
        pageQuanTriLayout.setHorizontalGroup(
            pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageQuanTriLayout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pageQuanTriLayout.createSequentialGroup()
                        .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pageQuanTriLayout.setVerticalGroup(
            pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageQuanTriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pestanas.addTab("", pageQuanTri);

        getContentPane().add(pestanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void lbl_pruebaOneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaOneMousePressed
        pestanas.setSelectedIndex(2);
        ColorOP.AnimattPruebaOne();
    }//GEN-LAST:event_lbl_pruebaOneMousePressed

    private void btt_pruebaOneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaOneMousePressed
        pestanas.setSelectedIndex(2);
        ColorOP.AnimattPruebaOne();
    }//GEN-LAST:event_btt_pruebaOneMousePressed

    private void lbl_pruebaTwoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaTwoMousePressed
        pestanas.setSelectedIndex(3);
        ColorOP.AnimattPruebaTwo();
    }//GEN-LAST:event_lbl_pruebaTwoMousePressed

    private void btt_pruebaTwoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaTwoMousePressed
        pestanas.setSelectedIndex(3);
        ColorOP.AnimattPruebaTwo();
    }//GEN-LAST:event_btt_pruebaTwoMousePressed

    private void lbl_SalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SalirMousePressed
        this.dispose();
        Login login =new Login();
        login.setVisible(true);
    }//GEN-LAST:event_lbl_SalirMousePressed

    private void lbl_SalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SalirMouseMoved
        lbl_Salir.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbl_SalirMouseMoved

    private void lbl_SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SalirMouseExited
        lbl_Salir.setForeground(new Color(166, 166, 166));
    }//GEN-LAST:event_lbl_SalirMouseExited

    private void lbl_pruebaTwo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaTwo1MousePressed
        // TODO add your handling code here:
        pestanas.setSelectedIndex(4);
        ColorOP.AnimattPruebaTwo1();
    }//GEN-LAST:event_lbl_pruebaTwo1MousePressed

    private void btt_pruebaTwo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaTwo1MousePressed
        // TODO add your handling code here:
        pestanas.setSelectedIndex(4);
        ColorOP.AnimattPruebaTwo1();
    }//GEN-LAST:event_btt_pruebaTwo1MousePressed

    private void lbl_pruebaTwo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaTwo2MousePressed
        // TODO add your handling code here:
        pestanas.setSelectedIndex(5);
        ColorOP.AnimattPruebaTwo2();
    }//GEN-LAST:event_lbl_pruebaTwo2MousePressed

    private void btt_pruebaTwo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaTwo2MousePressed
        // TODO add your handling code here:
        pestanas.setSelectedIndex(5);
        ColorOP.AnimattPruebaTwo2();
    }//GEN-LAST:event_btt_pruebaTwo2MousePressed

    private void tf_maSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_maSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_maSVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dateChooser1.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean CheckWhitespace(String t) {
        // Kiểm tra xem chuỗi text có chứa khoảng trắng hay không
        boolean containsWhitespace = t.contains(" ");

        if (containsWhitespace) {
            JOptionPane.showMessageDialog(this, "Dữ liệu mã không được có khoảng trắng!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            tf_maSV.setText("");
        } else if (t.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã khoa!", "Lỗi!", JOptionPane.ERROR_MESSAGE);

        }
        return containsWhitespace;
    }
    private void bt_addSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addSVActionPerformed

        String MaSV = tf_maSV.getText().trim();
        String TenSV = tf_NameSV.getText().trim().replaceAll("\\s+", " ");

        if (MaSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Mã Sinh Viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (TenSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Tên Sinh Viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean GioiTinh = rdSV_NamNu.isSelected();
        String NgaySinh = tf_dob1.getText();
        String QueQuan = tf_QqSV.getText().trim().replaceAll("\\s+", " ");

        String MaLop = "";
        int MaLopIndex = ccb_MaClassSV.getSelectedIndex();
        if (MaLopIndex != -1) {
            Object selectedValue = ccb_MaClassSV.getItemAt(MaLopIndex); // Lấy giá trị tại chỉ số đã chọn
            MaLop = selectedValue.toString(); // Chuyển đổi giá trị thành chuỗi (nếu cần)
            // Sử dụng giá trị đã chọn ở đây
        } else {
            // ComboBox trống
        }
        java.sql.Date d = null;
        if (NgaySinh == null || NgaySinh.equals("") || !NgaySinh.matches(regexDDMMYYYY)) {

            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.showMessageDialog(null, "Lỗi ngày sinh");
            tf_dob1.setText("");
            tf_dob1.requestFocus();
            return;
        } else {
            try {
                java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(NgaySinh);
                d = new java.sql.Date(utilDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(MenuOpcion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        SinhVien_Model sv = new SinhVien_Model(MaSV, TenSV, GioiTinh, d, QueQuan, 0.0f, 0.0f, 0.0f, 0.0f, MaLop);
        SinhVien_DAO ins = new SinhVien_DAO();
        ins.getInstance().add(sv);

        showResult();
        ResetForm();

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_addSVActionPerformed

    public void ResetForm() {
        tf_maSV.setEnabled(true);
        tf_maSV.setText("");
        tf_NameSV.setText("");
        tf_dob1.setText("");
        tf_QqSV.setText("");
    }
    private void table_SVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SVMouseReleased
        // TODO add your handling code here:
        tf_maSV.setEnabled(false);
        tf_maSV.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 1).toString());
        tf_NameSV.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 2).toString());
        tf_dob1.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 4).toString());
        tf_QqSV.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 5).toString());
        ccb_MaClassSV.setSelectedItem(table_SV.getValueAt(table_SV.getSelectedRow(), 10).toString());
    }//GEN-LAST:event_table_SVMouseReleased

    private void bt_deleteSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteSVActionPerformed
        // Lấy mã sinh viên cần xóa từ giao diện người dùng (ví dụ: mã sinh viên trong một trường nhập liệu)
        String maSinhVien = tf_maSV.getText();
        java.sql.Date d = null;

        // Gọi phương thức xóa thông tin và chuyển mã sinh viên hoặc đối tượng sinh viên cần xóa
        if (maSinhVien != null && !maSinhVien.isEmpty()) {
            java.util.Date utilDate;
            try {
                utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(tf_dob1.getText());

            } catch (ParseException ex) {
                Logger.getLogger(MenuOpcion.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Gọi phương thức xóa thông tin với mã sinh viên hoặc đối tượng sinh viên
            SinhVien_Model sv = new SinhVien_Model(maSinhVien, "", rootPaneCheckingEnabled, d, maSinhVien, TOP_ALIGNMENT, TOP_ALIGNMENT, TOP_ALIGNMENT, TOP_ALIGNMENT, maSinhVien);
            int deleted = 0;
            deleted = SinhVien_DAO.getInstance().delete(sv);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_SVFinal();
        showResult();
        showResult_DiemSV();
        ResetForm();
    }//GEN-LAST:event_bt_deleteSVActionPerformed

    private void bt_updateSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateSVActionPerformed
        // TODO add your handling code here:
        tf_maSV.setEnabled(true);
        String MaSV = tf_maSV.getText().trim().replaceAll("\\s+", " ");
        String TenSV = tf_NameSV.getText().trim().replaceAll("\\s+", " ");
        if (MaSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Mã Sinh Viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (TenSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Tên Sinh Viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean GioiTinh = rdSV_NamNu.isSelected();
        String NgaySinh = tf_dob1.getText();
        String QueQuan = tf_QqSV.getText().trim().replaceAll("\\s+", " ");
        String MaLop = "";
        int MaLopIndex = ccb_MaClassSV.getSelectedIndex();
        if (MaLopIndex != -1) {
            Object selectedValue = ccb_MaClassSV.getItemAt(MaLopIndex); // Lấy giá trị tại chỉ số đã chọn
            MaLop = selectedValue.toString(); // Chuyển đổi giá trị thành chuỗi (nếu cần)
            // Sử dụng giá trị đã chọn ở đây
        } else {
            // ComboBox trống
        }
        java.sql.Date d = null;
        if (NgaySinh == null || NgaySinh.equals("") || !NgaySinh.matches(regexDDMMYYYY)) {

            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.showMessageDialog(null, "Lỗi ngày sinh");
            tf_dob1.setText("");
            tf_dob1.requestFocus();
            return;
        } else {
            try {
                java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(NgaySinh);
                d = new java.sql.Date(utilDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(MenuOpcion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        SinhVien_Model sv = new SinhVien_Model(MaSV, TenSV, GioiTinh, d, QueQuan, 0.0f, 0.0f, 0.0f, 0.0f, MaLop);
        SinhVien_DAO ins = new SinhVien_DAO();
        ins.getInstance().update(sv);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult();
        ResetForm();


    }//GEN-LAST:event_bt_updateSVActionPerformed

    private void btt_inicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_inicioMousePressed
        // TODO add your handling code here:
       setCard();
        pestanas.setSelectedIndex(0);
        ColorOP.AnimattIni();
        
    }//GEN-LAST:event_btt_inicioMousePressed

    private void lbl_iniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iniMousePressed
        // TODO add your handling code here:
        setCard();
        pestanas.setSelectedIndex(0);
        ColorOP.AnimattIni();
        
    }//GEN-LAST:event_lbl_iniMousePressed

    private void btt_pruebaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaMousePressed
        // TODO add your handling code here:
        pestanas.setSelectedIndex(1);
        ColorOP.AnimattPrueba();
    }//GEN-LAST:event_btt_pruebaMousePressed

    private void lbl_pruebaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaMouseReleased
        // TODO add your handling code here:
        pestanas.setSelectedIndex(1);
        ColorOP.AnimattPrueba();
    }//GEN-LAST:event_lbl_pruebaMouseReleased
    public void ResetForm_QuanTri() {

        tfQuanTri_MaGiangVien.setText("");
        tfQuanTri_TenGiangVien.setText("");
        tfQuanTri_Email.setText("");
        tfQuanTri_QueQuan.setText("");
        tfQuanTri_date1.setText("");
        tfQuanTri_Password.setText("");

    }

    private void table_khoaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_khoaMouseReleased
        // TODO add your handling code here:
        tfKhoa_MaKhoa.setEnabled(false);
        tfKhoa_MaKhoa.setText(table_khoa.getValueAt(table_khoa.getSelectedRow(), 1).toString());
        tfKhoa_TenKhoa.setText(table_khoa.getValueAt(table_khoa.getSelectedRow(), 2).toString());
        tfKhoa_DiaChi.setText(table_khoa.getValueAt(table_khoa.getSelectedRow(), 3).toString());
        tfKhoa_SDT.setText(table_khoa.getValueAt(table_khoa.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_table_khoaMouseReleased

    private void table_ClassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ClassMouseReleased
        // TODO add your handling code here:
        tfClass_MaLop1.setEnabled(false);
        tfClass_MaLop1.setText(table_Class.getValueAt(table_Class.getSelectedRow(), 1).toString());
        tfClass_TenLop.setText(table_Class.getValueAt(table_Class.getSelectedRow(), 2).toString());
        cbbClass_MaKhoa.setSelectedItem(table_Class.getValueAt(table_Class.getSelectedRow(), 3).toString());


    }//GEN-LAST:event_table_ClassMouseReleased

    private void table_KhoaHocMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KhoaHocMouseReleased
        // TODO add your handling code here:
        tfKhoaHoc_MaKhoaHoc.setEnabled(false);
        tfKhoaHoc_MaKhoaHoc.setText(table_KhoaHoc.getValueAt(table_KhoaHoc.getSelectedRow(), 1).toString());
        tfKhoaHoc_TenKhoaHoc.setText(table_KhoaHoc.getValueAt(table_KhoaHoc.getSelectedRow(), 2).toString());
        cbbKhoaHoc_mh1.setSelectedItem(table_KhoaHoc.getValueAt(table_KhoaHoc.getSelectedRow(), 3).toString());
        cbbKhoaHoc_mh2.setSelectedItem(table_KhoaHoc.getValueAt(table_KhoaHoc.getSelectedRow(), 4).toString());
        cbbKhoaHoc_mh3.setSelectedItem(table_KhoaHoc.getValueAt(table_KhoaHoc.getSelectedRow(), 5).toString());
        cbbKhoaHoc_mh4.setSelectedItem(table_KhoaHoc.getValueAt(table_KhoaHoc.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_table_KhoaHocMouseReleased

    private void table_DiemSVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DiemSVMouseReleased
        // TODO add your handling code here:
        cbbDiemSV_MaSV.setEnabled(false);
        cbbDiemSV_MaKhoaHoc.setEnabled(false);
        cbbDiemSV_MaSV.setSelectedItem(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 1).toString());
        cbbDiemSV_MaKhoaHoc.setSelectedItem(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 2).toString());
        cbbDiemSV_HocKy.setSelectedItem(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 3).toString());
        tfDiemSV_diem1.setText(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 4).toString());
        tfDiemSV_diem2.setText(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 5).toString());
        tfDiemSV_diem3.setText(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 6).toString());
        tfDiemSV_diem4.setText(table_DiemSV.getValueAt(table_DiemSV.getSelectedRow(), 7).toString());

    }//GEN-LAST:event_table_DiemSVMouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String a = tfQuanTri_User.getText();
        String b = new String(tfQuanTri_Login.getPassword());
        b.trim();
        System.out.println("Chuoi vua nhap vao" + b);
        if (a.equals("20210556") && b.equals("240603")) {
            showResult_QuanTri2();
            btQuanTri_add.setEnabled(true);
            btQuanTri_update.setEnabled(true);
            btQuanTri_delete.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Login with admin right!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    public void ShowAlltf() {
        this.DoMonHocDaiCuong(cbbKhoaHoc_mh1);
        this.DoMonHocTheChat(cbbKhoaHoc_mh2);
        this.DoMonHocChuyenNganh(cbbKhoaHoc_mh3);
        this.DoMonHocDoAnChuyenNganh(cbbKhoaHoc_mh4);
        this.DoMaKhoa(cbbClass_MaKhoa);
        this.DoMaSV(cbbDiemSV_MaSV);
        this.DoMaSV(cbbDiemSV_MaSV1);
        this.DoMaKhoaHoc(cbbDiemSV_MaKhoaHoc);

        tf_maSV.setEnabled(true);
        tfKhoa_MaKhoa.setEnabled(true);
        tfClass_MaLop1.setEnabled(true);
        tfKhoaHoc_MaKhoaHoc.setEnabled(true);
        cbbDiemSV_MaSV.setEnabled(true);
        cbbDiemSV_MaKhoaHoc.setEnabled(true);
    }
///=============================================================================================
///=============================================================================================

    private void table_QuanTriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QuanTriMouseReleased
        // TODO add your handling code here:
        tfQuanTri_MaGiangVien.setEnabled(false);
        tfQuanTri_MaGiangVien.setText(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 1).toString());
        tfQuanTri_TenGiangVien.setText(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 2).toString());
        tfQuanTri_Email.setText(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 3).toString());
        // cbbQuanTri_gender.setSelectedItem(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 4).toString());
        tfQuanTri_date1.setText(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 5).toString());
        tfQuanTri_QueQuan.setText(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 6).toString());
        tfQuanTri_Password.setText(table_QuanTri.getValueAt(table_QuanTri.getSelectedRow(), 7).toString());

    }//GEN-LAST:event_table_QuanTriMouseReleased

    private void tfQuanTri_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuanTri_ResetActionPerformed
        // TODO add your handling code here:
        ShowAlltf();
        ResetForm_QuanTri();
    }//GEN-LAST:event_tfQuanTri_ResetActionPerformed

    private void btQuanTri_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuanTri_addActionPerformed

        String TenGV = tfQuanTri_TenGiangVien.getText().trim();
        String Email = tfQuanTri_Email.getText();
        if (CheckWhitespace(Email)) {
            return;
        }

        boolean GioiTinh = rdQuanTri_NamNu.isSelected();
        String NgaySinh = tfQuanTri_date1.getText();
        String QueQuan = tfQuanTri_QueQuan.getText().trim().replaceAll("\\s+", " ");
        String Password = tfQuanTri_Password.getText().trim().replaceAll("\\s+", " ");
        if (TenGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (CheckWhitespace(Password)) {
            return;
        }

        java.sql.Date d = null;
        if (NgaySinh == null || NgaySinh.equals("") || !NgaySinh.matches(regexDDMMYYYY)) {

            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.showMessageDialog(null, "Lỗi ngày sinh");
            tfQuanTri_date1.setText("");
            tfQuanTri_date1.requestFocus();
            return;
        } else {
            try {
                java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(NgaySinh);
                d = new java.sql.Date(utilDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(MenuOpcion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        int MaGV = 0;
        try {
            MaGV = Integer.parseInt(tfQuanTri_MaGiangVien.getText());
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Id phải là số nguyên!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
        }

        Professors_Model gv = new Professors_Model(MaGV, Password, TenGV, Email, GioiTinh, d, QueQuan);
        Professors_DAO ins = new Professors_DAO();
        ins.getInstance().add(gv);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_QuanTri2();
        ResetForm_QuanTri();

    }//GEN-LAST:event_btQuanTri_addActionPerformed

    private void btQuanTri_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuanTri_deleteActionPerformed
        // TODO add your handling code here:
        String maGV = tfQuanTri_MaGiangVien.getText();
        // Gọi phương thức xóa thông tin và chuyển mã sinh viên hoặc đối tượng sinh viên cần xóa
        if (maGV != null && !maGV.isEmpty()) {
            // Gọi phương thức xóa thông tin với mã sinh viên hoặc đối tượng sinh viên
            Professors_Model gv = new Professors_Model(Integer.parseInt(maGV), "", "", "", rootPaneCheckingEnabled, Date.valueOf(LocalDate.MAX), "");
            int deleted = 0;
            deleted = Professors_DAO.getInstance().delete(gv);

        } else {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_QuanTri2();
        ResetForm_QuanTri();
    }//GEN-LAST:event_btQuanTri_deleteActionPerformed

    private void btQuanTri_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuanTri_updateActionPerformed
        // TODO add your handling code here:
        String TenGV = tfQuanTri_TenGiangVien.getText().trim();
        String Email = tfQuanTri_Email.getText();
        if (CheckWhitespace(Email)) {
            return;
        }
        boolean GioiTinh = rdQuanTri_NamNu.isSelected();
        String NgaySinh = tfQuanTri_date1.getText();
        String QueQuan = tfQuanTri_QueQuan.getText().trim().replaceAll("\\s+", " ");;
        String Password = tfQuanTri_Password.getText().trim().replaceAll("\\s+", " ");
        if (TenGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (CheckWhitespace(Password)) {
            return;
        }

        java.sql.Date d = null;
        if (NgaySinh == null || NgaySinh.equals("") || !NgaySinh.matches(regexDDMMYYYY)) {

            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.showMessageDialog(null, "Lỗi ngày sinh");
            tfQuanTri_date1.setText("");
            tfQuanTri_date1.requestFocus();
            return;
        } else {
            try {
                java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(NgaySinh);
                d = new java.sql.Date(utilDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(MenuOpcion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        int MaGV = 0;
        try {
            MaGV = Integer.parseInt(tfQuanTri_MaGiangVien.getText());
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Id phải là số nguyên!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
        }

        Professors_Model gv = new Professors_Model(MaGV, Password, TenGV, Email, GioiTinh, d, QueQuan);
        Professors_DAO ins = new Professors_DAO();
        ins.getInstance().update(gv);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_QuanTri2();
        ResetForm_QuanTri();
    }//GEN-LAST:event_btQuanTri_updateActionPerformed
//=================================================================================================
//=================================================================================================

    private void jbt_deleteKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_deleteKhoaActionPerformed
        // TODO add your handling code here:
        String maKhoa = tfKhoa_MaKhoa.getText();
        if (maKhoa != null && !maKhoa.isEmpty()) {
            // Gọi phương thức xóa thông tin với mã sinh viên hoặc đối tượng sinh viên
            Khoa_Model khoa = new Khoa_Model(maKhoa, "", "", WIDTH);
            int deleted = 0;
            deleted = Khoa_DAO.getInstance().delete(khoa);

        } else {
            JOptionPane.showMessageDialog(this, "Mã Khoa không hợp lệ !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_Khoa();
        ResetForm_Khoa();
    }//GEN-LAST:event_jbt_deleteKhoaActionPerformed

    private void jbt_addKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_addKhoaActionPerformed
        // TODO add your handling code here:
        String maKhoa = tfKhoa_MaKhoa.getText().trim();

        String tenKhoa = tfKhoa_TenKhoa.getText().trim().replaceAll("\\s+", " ");
        String diaChi = tfKhoa_DiaChi.getText().trim().replaceAll("\\s+", " ");
        if (maKhoa.isEmpty() || tenKhoa.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int sdt = 0;
        if (CheckWhitespace(maKhoa)) {
            tfKhoa_SDT.setText("");
            return;
        } else if (tfKhoa_SDT.getText().trim().length() != 10) {
            tfKhoa_SDT.setText("");
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);

            return;

        }
        try {
            sdt = Integer.parseInt(tfKhoa_SDT.getText());

        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ !", "Lỗi", JOptionPane.ERROR_MESSAGE);

        }

        Khoa_Model khoa = new Khoa_Model(maKhoa, tenKhoa, diaChi, sdt);
        Khoa_DAO ins = new Khoa_DAO();
        ins.getInstance().add(khoa);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_Khoa();
        ResetForm_Khoa();

    }//GEN-LAST:event_jbt_addKhoaActionPerformed

    private void jbt_UpdateKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_UpdateKhoaActionPerformed
        // TODO add your handling code here:
        String maKhoa = tfKhoa_MaKhoa.getText().trim();
        String tenKhoa = tfKhoa_TenKhoa.getText();
        String diaChi = tfKhoa_DiaChi.getText().trim().replaceAll("\\s+", " ");
        String sdt = tfKhoa_SDT.getText().trim();
        if (maKhoa.isEmpty() || tenKhoa.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sdt.length() != 10) {
            tfKhoa_SDT.setText("");
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;

        }
        System.out.println(sdt);
        Khoa_Model khoa = new Khoa_Model(maKhoa, tenKhoa, diaChi, Integer.parseInt(sdt));
        Khoa_DAO ins = new Khoa_DAO();
        ins.getInstance().update(khoa);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_Khoa();
        ResetForm_Khoa();
    }//GEN-LAST:event_jbt_UpdateKhoaActionPerformed
    public void ResetForm_Khoa() {
        tfKhoa_MaKhoa.setEnabled(true);
        tfKhoa_MaKhoa.setText("");
        tfKhoa_DiaChi.setText("");
        tfKhoa_SDT.setText("");
        tfKhoa_TenKhoa.setText("");
    }
//=================================================================================================
//=================================================================================================
    private void jbt_addClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_addClassActionPerformed
        // TODO add your handling code here:
        String maLop = tfClass_MaLop1.getText().trim().replaceAll("\\s+", " ");

        if (maLop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã Lớp!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            tf_maSV.setText("");
            return;
        }
        String tenLop = tfClass_TenLop.getText().trim().replaceAll("\\s+", " ");
        String maKhoa = (String) cbbClass_MaKhoa.getSelectedItem();
        if (tenLop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Lop_Model lop = new Lop_Model(maLop, tenLop, maKhoa);
        Lop_DAO ins = new Lop_DAO();
        ins.getInstance().add(lop);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_Lop();
        ResetForm_Lop();
    }//GEN-LAST:event_jbt_addClassActionPerformed

    private void jbt_updateClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_updateClassActionPerformed
        // TODO add your handling code here:
        String maLop = tfClass_MaLop1.getText();
        String tenLop = tfClass_TenLop.getText().trim().replaceAll("\\s+", " ");
        String maKhoa = (String) cbbClass_MaKhoa.getSelectedItem();

        if (tenLop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Lop_Model lop = new Lop_Model(maLop, tenLop, maKhoa);
        Lop_DAO ins = new Lop_DAO();
        ins.getInstance().update(lop);
        showResult_Lop();
        ResetForm_Lop();
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbt_updateClassActionPerformed

    private void jbt_deleteClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_deleteClassActionPerformed
        // TODO add your handling code here:
        String maLop = tfClass_MaLop1.getText();
        if (maLop != null && !maLop.isEmpty()) {
            // Gọi phương thức xóa thông tin với mã sinh viên hoặc đối tượng sinh viên
            Lop_Model lop = new Lop_Model(maLop, maLop, maLop);
            int deleted = 0;
            deleted = Lop_DAO.getInstance().delete(lop);

        } else {
            JOptionPane.showMessageDialog(this, "Mã Lớp không hợp lệ !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_Lop();
        ResetForm_Lop();
    }//GEN-LAST:event_jbt_deleteClassActionPerformed
    public void ResetForm_Lop() {
        tfClass_TenLop.setEnabled(true);
        tfClass_TenLop.setText("");
        tfClass_MaLop1.setText("");

    }

///=============================================================================================
///=============================================================================================
    private void btKhoaHoc_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhoaHoc_addActionPerformed
        // TODO add your handling code here:
        String maKhoaHoc = tfKhoaHoc_MaKhoaHoc.getText().trim();

        if (CheckWhitespace(maKhoaHoc)) {
            tfKhoaHoc_MaKhoaHoc.setText("");
            return;
        }
        if (maKhoaHoc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã môn học!", "Lỗi", JOptionPane.ERROR_MESSAGE);

            return;
        }
        String TenKhoaHoc = tfKhoaHoc_TenKhoaHoc.getText().trim().replaceAll("\\s+", " ");
        String mh1 = (String) cbbKhoaHoc_mh1.getSelectedItem();
        String mh2 = (String) cbbKhoaHoc_mh2.getSelectedItem();
        String mh3 = (String) cbbKhoaHoc_mh3.getSelectedItem();
        String mh4 = (String) cbbKhoaHoc_mh4.getSelectedItem();
        if (mh1.isEmpty() || mh2.isEmpty() || mh3.isEmpty() || mh4.isEmpty() || TenKhoaHoc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean exists = KhoaHoc_DAO.getInstance().checkDataExists_KhoaHoc(maKhoaHoc, TenKhoaHoc);
        if (exists) {
            tfKhoaHoc_TenKhoaHoc.setText("");
            JOptionPane.showMessageDialog(this, "Đã có " + TenKhoaHoc + " rồi !", "Không thể nhập thêm!", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            KhoaHoc_Model lop = new KhoaHoc_Model(maKhoaHoc, TenKhoaHoc, mh1, mh2, mh3, mh4);
            KhoaHoc_DAO ins = new KhoaHoc_DAO();
            ins.getInstance().add(lop);
            JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            showResult_KhoaHoc();
            ResetForm_KhoaHoc();
        }

    }//GEN-LAST:event_btKhoaHoc_addActionPerformed

    private void btKhoaHoc_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhoaHoc_updateActionPerformed
        // TODO add your handling code here:
        String maKhoaHoc = tfKhoaHoc_MaKhoaHoc.getText();
        String TenKhoaHoc = tfKhoaHoc_TenKhoaHoc.getText();
        String mh1 = (String) cbbKhoaHoc_mh1.getSelectedItem();
        String mh2 = (String) cbbKhoaHoc_mh2.getSelectedItem();
        String mh3 = (String) cbbKhoaHoc_mh3.getSelectedItem();
        String mh4 = (String) cbbKhoaHoc_mh4.getSelectedItem();
        if (mh1.isEmpty() || mh2.isEmpty() || mh3.isEmpty() || mh4.isEmpty() || TenKhoaHoc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        KhoaHoc_Model lop = new KhoaHoc_Model(maKhoaHoc, TenKhoaHoc, mh1, mh2, mh3, mh4);
        KhoaHoc_DAO ins = new KhoaHoc_DAO();
        ins.getInstance().update(lop);
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_KhoaHoc();
        ResetForm_KhoaHoc();
    }//GEN-LAST:event_btKhoaHoc_updateActionPerformed

    private void btKhoaHoc_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhoaHoc_deleteActionPerformed
        // TODO add your handling code here:
        String maKhoaHoc = tfKhoaHoc_MaKhoaHoc.getText();
        if (maKhoaHoc != null && !maKhoaHoc.isEmpty()) {
            // Gọi phương thức xóa thông tin với mã sinh viên hoặc đối tượng sinh viên
            KhoaHoc_Model lop = new KhoaHoc_Model(maKhoaHoc, maKhoaHoc, maKhoaHoc, maKhoaHoc, maKhoaHoc, maKhoaHoc);
            int deleted = 0;
            deleted = KhoaHoc_DAO.getInstance().delete(lop);

        } else {
            JOptionPane.showMessageDialog(this, "Mã khóa học không hợp lệ !", "Không thể xóa!", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        showResult_KhoaHoc();
        ResetForm_KhoaHoc();
    }//GEN-LAST:event_btKhoaHoc_deleteActionPerformed
    public void ResetForm_KhoaHoc() {
        tfKhoaHoc_MaKhoaHoc.setEnabled(true);
        tfKhoaHoc_MaKhoaHoc.setText("");
        tfKhoaHoc_TenKhoaHoc.setText("");
        cbbKhoaHoc_mh1.setSelectedItem("");
        cbbKhoaHoc_mh2.setSelectedItem("");
        cbbKhoaHoc_mh3.setSelectedItem("");
        cbbKhoaHoc_mh4.setSelectedItem("");
    }

    ///=============================================================================================
///=============================================================================================
    private void btDiemSV_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDiemSV_addActionPerformed
        // TODO add your handling code here:

        String maSV = "" + cbbDiemSV_MaSV.getSelectedItem();
        String maKhoaHoc = "" + cbbDiemSV_MaKhoaHoc.getSelectedItem();
        String hk = "" + cbbDiemSV_HocKy.getSelectedItem();
        int hocKy = Integer.parseInt(hk);

// Kiểm tra xem đã có dữ liệu với MaSV và HocKy tương ứng hay chưa
        boolean exists = DiemSV_DAO.getInstance().checkDataExists(maSV, hocKy);
        boolean exists1 = DiemSV_DAO.getInstance().checkDataExistsKH(maSV, maKhoaHoc);
        if (exists1) {
            JOptionPane.showMessageDialog(this, "Sinh viên đã học " + maKhoaHoc + " này rồi !", "Không thể nhập thêm!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (exists) {
            // Hiển thị thông báo hoặc thực hiện xử lý khi dữ liệu đã tồn tại
            JOptionPane.showMessageDialog(this, "Sinh viên đã có điểm học kỳ " + hocKy + " !", "Không thể nhập thêm!", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            // Thêm dữ liệu mới vào bảng Diem
            if (tfDiemSV_diem1.getText().isEmpty() || tfDiemSV_diem2.getText().isEmpty() || tfDiemSV_diem3.getText().isEmpty() || tfDiemSV_diem4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập đủ điểm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float diemMonHoc1 = checkDiem(tfDiemSV_diem1);
            float diemMonHoc2 = checkDiem(tfDiemSV_diem2);
            float diemMonHoc3 = checkDiem(tfDiemSV_diem3);
            float diemMonHoc4 = checkDiem(tfDiemSV_diem4);
            if (diemMonHoc1 > 10.0f || diemMonHoc1 < 0.0f) {
                tfDiemSV_diem1.setText("");
                JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else if (diemMonHoc2 > 10 || diemMonHoc2 < 0) {
                tfDiemSV_diem2.setText("");
                JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else if (diemMonHoc3 > 10 || diemMonHoc3 < 0) {
                JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                tfDiemSV_diem3.setText("");
                return;
            } else if (diemMonHoc4 > 10 || diemMonHoc4 < 0) {
                JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                tfDiemSV_diem4.setText("");
                return;
            }
            DiemSV_Model diemSV = new DiemSV_Model(maSV, maKhoaHoc, hocKy, diemMonHoc1, diemMonHoc2, diemMonHoc3, diemMonHoc4);
            DiemSV_DAO ins = new DiemSV_DAO();
            ins.getInstance().add(diemSV);

            // Hiển thị thông báo hoặc thực hiện xử lý khi thêm dữ liệu thành công
            JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DiemSV_DAO.getInstance().calculateAndUpdateGPA(maSV, hocKy);

            // Cập nhật giao diện hoặc làm bất kỳ thao tác nào khác sau khi thêm dữ liệu
            showResult_SVFinal();
            showResult_DiemSV();
            showResult();
            ResetForm_DiemSV();
//        DiemSV_Model diemSV = new DiemSV_Model(maSV, maKhoaHoc, hocKi, this.checkDiem(tfDiemSV_diem1), this.checkDiem(tfDiemSV_diem2), this.checkDiem(tfDiemSV_diem3), checkDiem(tfDiemSV_diem4));
//        DiemSV_DAO ins = new DiemSV_DAO();
//        ins.getInstance().add(diemSV);
//        showResult_DiemSV();
//        ResetForm_DiemSV();
        }
    }//GEN-LAST:event_btDiemSV_addActionPerformed

    private void btDiemSV_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDiemSV_updateActionPerformed
        // TODO add your handling code here:
        String maSV = "" + cbbDiemSV_MaSV.getSelectedItem();
        String maKhoaHoc = "" + cbbDiemSV_MaKhoaHoc.getSelectedItem();
        String hk = "" + cbbDiemSV_HocKy.getSelectedItem();
        int hocKy = Integer.parseInt(hk);

// Kiểm tra xem đã có dữ liệu với MaSV và HocKy tương ứng hay chưa
        boolean exists = DiemSV_DAO.getInstance().checkDataExists(maSV, hocKy);
        if (tfDiemSV_diem1.getText().isEmpty() || tfDiemSV_diem2.getText().isEmpty() || tfDiemSV_diem3.getText().isEmpty() || tfDiemSV_diem4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ điểm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Thêm dữ liệu mới vào bảng Diem
        float diemMonHoc1 = checkDiem(tfDiemSV_diem1);
        float diemMonHoc2 = checkDiem(tfDiemSV_diem2);
        float diemMonHoc3 = checkDiem(tfDiemSV_diem3);
        float diemMonHoc4 = checkDiem(tfDiemSV_diem4);
        if (tfDiemSV_diem1.getText().isEmpty() || tfDiemSV_diem2.getText().isEmpty() || tfDiemSV_diem3.getText().isEmpty() || tfDiemSV_diem4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ điểm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (diemMonHoc1 > 10.0f || diemMonHoc1 < 0.0f) {
            tfDiemSV_diem1.setText("");
            JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (diemMonHoc2 > 10 || diemMonHoc2 < 0) {
            tfDiemSV_diem2.setText("");
            JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (diemMonHoc3 > 10 || diemMonHoc3 < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            tfDiemSV_diem3.setText("");
            return;
        } else if (diemMonHoc4 > 10 || diemMonHoc4 < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải lớn hơn 0 và nhỏ hơn 10 !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            tfDiemSV_diem4.setText("");
            return;
        }

        DiemSV_Model diemSV = new DiemSV_Model(maSV, maKhoaHoc, hocKy, diemMonHoc1, diemMonHoc2, diemMonHoc3, diemMonHoc4);
        DiemSV_DAO ins = new DiemSV_DAO();
        ins.getInstance().update(diemSV);

        // Hiển thị thông báo hoặc thực hiện xử lý khi thêm dữ liệu thành công
        JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        DiemSV_DAO.getInstance().calculateAndUpdateGPA(maSV, hocKy);

        // Cập nhật giao diện hoặc làm bất kỳ thao tác nào khác sau khi thêm dữ liệu
        showResult_SVFinal();
        showResult_DiemSV();
        showResult();
        ResetForm_DiemSV();


    }//GEN-LAST:event_btDiemSV_updateActionPerformed

    private void btDiemSv_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDiemSv_deleteActionPerformed
        // TODO add your handling code here:
        String maSV = "" + cbbDiemSV_MaSV.getSelectedItem();
        String maKH = "" + cbbDiemSV_MaKhoaHoc.getSelectedItem();
        String hk = "" + cbbDiemSV_HocKy.getSelectedItem();
        int hocKy = Integer.parseInt(hk);
        if (maSV != null && !maSV.isEmpty()) {
            // Gọi phương thức xóa thông tin với mã sinh viên hoặc đối tượng sinh viên
            float diemMonHoc1 = 0.1f;
            float diemMonHoc2 = 0.1f;
            float diemMonHoc3 = 0.1f;
            float diemMonHoc4 = 0.1f;
            DiemSV_Model lop = new DiemSV_Model(maSV, maKH, WIDTH, (float) diemMonHoc1, (float) diemMonHoc2, (float) diemMonHoc3, (float) diemMonHoc4);
            int deleted = 0;
            JOptionPane.showMessageDialog(this, "Done!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DiemSV_DAO.getInstance().calculateAndUpdateGPADelete(maSV, hocKy);
            deleted = DiemSV_DAO.getInstance().delete(lop);

        } else {
            JOptionPane.showMessageDialog(this, "Mã không hợp lệ!", "Không thể xóa!", JOptionPane.ERROR_MESSAGE);
        }
        showResult_SVFinal();
        showResult_DiemSV();
        showResult();
        ResetForm_DiemSV();
    }//GEN-LAST:event_btDiemSv_deleteActionPerformed

    private void btSV_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSV_searchActionPerformed
        // TODO add your handling code here:
        String tenSV = tfSinhVien_searchName.getText();

        // Kiểm tra xem có giá trị trong tfSinhVien_searchName hay không
        if (!tenSV.isEmpty()) {
            // Tạo đối tượng SinhVien_Model và gọi phương thức selectByName
            showResultSearch(tenSV);
        } else {
            // Xử lý trường hợp tfSinhVien_searchName trống
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sinh viên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btSV_searchActionPerformed

    private void btDiemSV_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDiemSV_ResetActionPerformed
        // TODO add your handling code here:
        ShowAlltf();
        ResetForm_DiemSV();
    }//GEN-LAST:event_btDiemSV_ResetActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String t = "" + cbbDiemSV_MaSV1.getSelectedItem();

        while (modelTb_Diem.getRowCount() > 0) {
            modelTb_Diem.removeRow(0);
        }
        try {
            ArrayList<DiemSV_Model> listLop = DiemSV_DAO.getInstance().selectByID(t);
            int i = 1;
            for (DiemSV_Model sinhVien_Model : listLop) {

                Object[] rowData = toObjectData4(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                modelTb_Diem.addRow(rowData);
                i++;
            }
            table_DiemSV.setModel(modelTb_Diem);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showResult_DiemSV();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btSV_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSV_resetActionPerformed
        // TODO add your handling code here:
        ShowAlltf();
        ResetForm();
    }//GEN-LAST:event_btSV_resetActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ShowAlltf();
        ResetForm_KhoaHoc();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void showResultSearch(String t) {

        while (model_Tb.getRowCount() > 0) {
            model_Tb.removeRow(0);
        }
        try {
            ArrayList<SinhVien_Model> listSV = SinhVien_DAO.getInstance().selectByName(t);
            int i = 1;
            for (SinhVien_Model sinhVien_Model : listSV) {

                Object[] rowData = toObjectDataS(sinhVien_Model);
                rowData[0] = i;
                //model_Tb.addRow(toObjectData(sinhVien_Model));  
                model_Tb.addRow(rowData);
                i++;
            }
            table_SV.setModel(model_Tb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] toObjectDataS(SinhVien_Model sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String date = dateFormat.format(sv.getDateOfBirth());

        boolean flag = sv.isGender();
        String gioitinh = "Nữ";
        if (flag) {
            gioitinh = "Nam";
        }
        Object[] objectData = {1, sv.getMaSV(), sv.getName(), gioitinh,
            date, sv.getQueQuan(), sv.getGpa_1(), sv.getGpa_2(), sv.getGpa_3(), sv.getGpa_4(), sv.getMaClass()};
        return objectData;
    }

    public void ResetForm_DiemSV() {
        cbbDiemSV_MaKhoaHoc.setEnabled(true);
        cbbDiemSV_MaSV.setEnabled(true);
        cbbDiemSV_MaSV.setSelectedItem("");
        cbbDiemSV_MaKhoaHoc.setSelectedItem("");
        cbbDiemSV_HocKy.setSelectedItem("");
        tfDiemSV_diem1.setText("");
        tfDiemSV_diem2.setText("");
        tfDiemSV_diem3.setText("");
        tfDiemSV_diem4.setText("");

    }
    ///=============================================================================================
///=============================================================================================   

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               //new MenuOpcion().setVisible(true);
               Login login = new Login();
               login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panel_redondo.PanelRound Menu;
    private javax.swing.JSeparator Separator;
    public javax.swing.JLabel Titulo;
    public javax.swing.JLabel Titulo1;
    private javax.swing.JButton btDiemSV_Reset;
    private javax.swing.JButton btDiemSV_add;
    private javax.swing.JButton btDiemSV_update;
    private javax.swing.JButton btDiemSv_delete;
    private javax.swing.ButtonGroup btGroupGender_QuanTri;
    private javax.swing.JButton btKhoaHoc_add;
    private javax.swing.JButton btKhoaHoc_delete;
    private javax.swing.JButton btKhoaHoc_update;
    private javax.swing.JButton btQuanTri_add;
    private javax.swing.JButton btQuanTri_delete;
    private javax.swing.JButton btQuanTri_update;
    private javax.swing.JButton btSV_reset;
    private javax.swing.JButton btSV_search;
    public javax.swing.JButton bt_addSV;
    private javax.swing.JButton bt_deleteSV;
    private javax.swing.JButton bt_updateSV;
    public static Panel_gradiend.PanelGradient btt_inicio;
    public static Panel_gradiend.PanelGradient btt_prueba;
    public static Panel_gradiend.PanelGradient btt_pruebaOne;
    public static Panel_gradiend.PanelGradient btt_pruebaTwo;
    public static Panel_gradiend.PanelGradient btt_pruebaTwo1;
    public static Panel_gradiend.PanelGradient btt_pruebaTwo2;
    private Panel_gradiend.PanelGradient btt_salir;
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private combobox.Combobox cbbClass_MaKhoa;
    private combobox.Combobox cbbDiemSV_HocKy;
    private combobox.Combobox cbbDiemSV_MaKhoaHoc;
    private combobox.Combobox cbbDiemSV_MaSV;
    private combobox.Combobox cbbDiemSV_MaSV1;
    private combobox.Combobox cbbKhoaHoc_mh1;
    private combobox.Combobox cbbKhoaHoc_mh2;
    private combobox.Combobox cbbKhoaHoc_mh3;
    private combobox.Combobox cbbKhoaHoc_mh4;
    private combobox.Combobox ccb_MaClassSV;
    public com.raven.datechooser.DateChooser dateChooser1;
    public com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jbt_UpdateKhoa;
    private javax.swing.JButton jbt_addClass;
    private javax.swing.JButton jbt_addKhoa;
    private javax.swing.JButton jbt_deleteClass;
    private javax.swing.JButton jbt_deleteKhoa;
    private javax.swing.JButton jbt_updateClass;
    private javax.swing.JLabel lbl_Quantri;
    private javax.swing.JLabel lbl_Quantri1;
    private javax.swing.JLabel lbl_Quantri2;
    private javax.swing.JLabel lbl_Quantri3;
    private javax.swing.JLabel lbl_Quantri4;
    private javax.swing.JLabel lbl_Quantri5;
    private javax.swing.JLabel lbl_Quantri6;
    public static javax.swing.JLabel lbl_Salir;
    public static javax.swing.JLabel lbl_ini;
    public static javax.swing.JLabel lbl_prueba;
    public static javax.swing.JLabel lbl_pruebaOne;
    public static javax.swing.JLabel lbl_pruebaTwo;
    public static javax.swing.JLabel lbl_pruebaTwo1;
    public static javax.swing.JLabel lbl_pruebaTwo2;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard2;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard_KhoaHoc;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard_Main;
    private javax.swing.JPanel pageDiemSV;
    private javax.swing.JPanel pageHome;
    private javax.swing.JPanel pageKhoaHoc;
    private javax.swing.JPanel pageLopKhoa;
    private javax.swing.JPanel pageQuanTri;
    private javax.swing.JPanel pageSV;
    private tabbed.MaterialTabbed pestanas;
    private radio_button.RadioButtonCustom rdQuanTri_NamNu;
    private radio_button.RadioButtonCustom rdSV_NamNu;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.RoundPanel roundPanel10;
    private javaswingdev.swing.RoundPanel roundPanel11;
    private javaswingdev.swing.RoundPanel roundPanel12;
    private javaswingdev.swing.RoundPanel roundPanel13;
    private javaswingdev.swing.RoundPanel roundPanel14;
    private javaswingdev.swing.RoundPanel roundPanel15;
    private javaswingdev.swing.RoundPanel roundPanel16;
    private javaswingdev.swing.RoundPanel roundPanel17;
    private javaswingdev.swing.RoundPanel roundPanel18;
    private javaswingdev.swing.RoundPanel roundPanel2;
    private javaswingdev.swing.RoundPanel roundPanel3;
    private javaswingdev.swing.RoundPanel roundPanel4;
    private javaswingdev.swing.RoundPanel roundPanel5;
    private javaswingdev.swing.RoundPanel roundPanel6;
    private javaswingdev.swing.RoundPanel roundPanel7;
    private javaswingdev.swing.RoundPanel roundPanel8;
    private javaswingdev.swing.RoundPanel roundPanel9;
    private javaswingdev.swing.table.Table table_Class;
    private javaswingdev.swing.table.Table table_DiemSV;
    private javaswingdev.swing.table.Table table_KhoaHoc;
    private javaswingdev.swing.table.Table table_QuanTri;
    private javaswingdev.swing.table.Table table_SV;
    private javaswingdev.swing.table.Table table_SVFinal;
    private javaswingdev.swing.table.Table table_khoa;
    private textfield.TextField tfClass_MaLop1;
    private textfield.TextField tfClass_TenLop;
    private textfield.TextField tfDiemSV_diem1;
    private textfield.TextField tfDiemSV_diem2;
    private textfield.TextField tfDiemSV_diem3;
    private textfield.TextField tfDiemSV_diem4;
    private textfield.TextField tfKhoaHoc_MaKhoaHoc;
    private textfield.TextField tfKhoaHoc_TenKhoaHoc;
    private textfield.TextField tfKhoa_DiaChi;
    private textfield.TextField tfKhoa_MaKhoa;
    private textfield.TextField tfKhoa_SDT;
    private textfield.TextField tfKhoa_TenKhoa;
    private textfield.TextField tfQuanTri_Email;
    private textfield.PasswordField tfQuanTri_Login;
    private textfield.TextField tfQuanTri_MaGiangVien;
    private textfield.TextField tfQuanTri_Password;
    private textfield.TextField tfQuanTri_QueQuan;
    private javax.swing.JButton tfQuanTri_Reset;
    private textfield.TextField tfQuanTri_TenGiangVien;
    private textfield.TextField tfQuanTri_User;
    private textfield.TextField tfQuanTri_date1;
    private javax.swing.JTextField tfSinhVien_searchName;
    private textfield.TextField tf_NameSV;
    private textfield.TextField tf_QqSV;
    private textfield.TextField tf_dob1;
    private textfield.TextField tf_maSV;
    private javaswingdev.swing.titlebar.TitleBar titleBar1;
    // End of variables declaration//GEN-END:variables
}
