package menu.sr.blanco;

import com.raven.model.ModelCard;
import controller.Lop_DAO;
import controller.SinhVien_DAO;
import java.awt.Button;
import java.awt.Color;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Lop_Model;
import model.SinhVien_Model;
import modeloDesign.sr.blanco.AnimateBTT;
import textfield.TextField;


public class MenuOpcion extends javax.swing.JFrame {

    AnimateBTT ColorOP = new AnimateBTT();
    DefaultTableModel model_Tb;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    int i;

    public MenuOpcion() {
        initComponents();
        //DefaultComboBoxModel model_Cbb= (DefaultComboBoxModel) combobox1.getModel();

        pestanas.setEnabledAt(0, false);
        pestanas.setEnabledAt(1, false);
        pestanas.setEnabledAt(2, false);
        pestanas.setEnabledAt(3, false);
        pestanas.setEnabledAt(4, false);
        pestanas.setEnabledAt(5, false);

        cbb_GenderSV.addItem("Nam");
        cbb_GenderSV.addItem("Nữ");
        this.DoMaLop();
        setBackground(new Color(0, 0, 0, 0));
        ColorOP.AnimattIni();
        init();
        showResult();

        //Table Sinh vien
    }

    private void init() {
        table_SV.fixTable(jScrollPane1);
        table_SV.fixTable(jScrollPane2);
        table_SV.fixTable(jScrollPane3);
        table_SV.fixTable(jScrollPane4);
        table_SV.fixTable(jScrollPane5);
        table_SV.fixTable(jScrollPane6);
        table_SV.fixTable(jScrollPane7);
        model_Tb = (DefaultTableModel) table_SV.getModel();
        initCardData();

    }
    
    private void initCardData(){
         // Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Sinh Viên", 200, 44, null));
    }
//============================================================================================================
    //Hiển thị Sinh viên
// đổ thông tin cbb lop

    public void DoMaLop() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) ccb_MaClassSV.getModel();
        cbbModel.removeAllElements();
        ArrayList<Lop_Model> lopList = new Lop_DAO().selectAll(); // Lấy danh sách MaLop từ cơ sở dữ liệu

        // Thêm MaLop từ danh sách vào JComboBox
        for (Lop_Model lop : lopList) {
            cbbModel.addElement(lop.getMaLop());
        }
    }

    public void showResult() {

        while (model_Tb.getRowCount() > 0) {
            model_Tb.removeRow(0);
        }
        try {
            ArrayList<SinhVien_Model> listSV = SinhVien_DAO.getInstance().selectAll();
            int i=1;
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
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }
        Object[] objectData = {1,sv.getMaSV(), sv.getName(), gioitinh,
            date, sv.getQueQuan(), sv.getGpa_1(), sv.getGpa_2(), sv.getGpa_3(), sv.getGpa_4(), sv.getMaClass()};
        return objectData;
    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
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
        pestanas = new tabbed.MaterialTabbed();
        pageHome = new javax.swing.JPanel();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        card1 = new com.raven.component.Card();
        roundPanel17 = new javaswingdev.swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        roundPanel18 = new javaswingdev.swing.RoundPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();
        pageSV = new javax.swing.JPanel();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_SV = new javaswingdev.swing.table.Table();
        roundPanel2 = new javaswingdev.swing.RoundPanel();
        tf_maSV = new textfield.TextField();
        jButton1 = new javax.swing.JButton();
        tf_dk1 = new textfield.TextField();
        tf_NameSV = new textfield.TextField();
        cbb_GenderSV = new combobox.Combobox();
        tf_dk3 = new textfield.TextField();
        tf_dk2 = new textfield.TextField();
        tf_dk4 = new textfield.TextField();
        tf_QqSV = new textfield.TextField();
        ccb_MaClassSV = new combobox.Combobox();
        tf_dob1 = new textfield.TextField();
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
        roundPanel5 = new javaswingdev.swing.RoundPanel();
        roundPanel7 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_khoa = new javaswingdev.swing.table.Table();
        jbt_addKhoa = new javax.swing.JButton();
        jbt_deleteKhoa = new javax.swing.JButton();
        tfKhoa_MaKhoa = new textfield.TextField();
        tfKhoa_TenKhoa = new textfield.TextField();
        tfKhoa_SDT = new textfield.TextField();
        tfKhoa_DiaChi = new textfield.TextField();
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
        roundPanel9 = new javaswingdev.swing.RoundPanel();
        roundPanel10 = new javaswingdev.swing.RoundPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_KhoaHoc = new javaswingdev.swing.table.Table();
        pageDiemSV = new javax.swing.JPanel();
        roundPanel11 = new javaswingdev.swing.RoundPanel();
        cbbDiemSV_MaSV = new combobox.Combobox();
        cbbDiemSV_MaKhoaHoc = new combobox.Combobox();
        cbbDiemSV_HocKy = new combobox.Combobox();
        tfDiemSV_diem2 = new textfield.TextField();
        tfDiemSV_diem3 = new textfield.TextField();
        tfDiemSV_diem4 = new textfield.TextField();
        tfDiemSV_diem1 = new textfield.TextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        roundPanel12 = new javaswingdev.swing.RoundPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_DiemSV = new javaswingdev.swing.table.Table();
        roundPanel13 = new javaswingdev.swing.RoundPanel();
        pageQuanTri = new javax.swing.JPanel();
        roundPanel14 = new javaswingdev.swing.RoundPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_QuanTri = new javaswingdev.swing.table.Table();
        roundPanel15 = new javaswingdev.swing.RoundPanel();
        textField7 = new textfield.TextField();
        textField8 = new textfield.TextField();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        roundPanel16 = new javaswingdev.swing.RoundPanel();
        textField1 = new textfield.TextField();
        textField2 = new textfield.TextField();
        textField3 = new textfield.TextField();
        textField4 = new textfield.TextField();
        textField5 = new textfield.TextField();
        textField6 = new textfield.TextField();
        btQuanTri_update = new javax.swing.JButton();
        btQuanTri_delete = new javax.swing.JButton();
        btQuanTri_add = new javax.swing.JButton();

        dateChooser1.setForeground(new java.awt.Color(0, 153, 204));
        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(tf_dob1);

        dateChooser2.setForeground(new java.awt.Color(0, 153, 204));
        dateChooser2.setDateFormat("dd/MM/yyyy");
        dateChooser2.setTextRefernce(tf_dob1);

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
        Titulo.setText("EAUT University");
        Titulo.setToolTipText("");
        Menu.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 70));

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
        lbl_prueba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users-altV.png"))); // NOI18N
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

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 167, 550));

        pestanas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pestanas.setMinimumSize(new java.awt.Dimension(1180, 550));
        pestanas.setPreferredSize(new java.awt.Dimension(1180, 550));

        pageHome.setBackground(new java.awt.Color(102, 102, 102));

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setColorGradient(new java.awt.Color(72, 111, 252));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setColorGradient(new java.awt.Color(208, 255, 90));

        card1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 102), null, new java.awt.Color(153, 0, 153), new java.awt.Color(204, 153, 255)));
        card1.setColorGradient(new java.awt.Color(211, 28, 215));

        roundPanel17.setRound(10);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Note");

        javax.swing.GroupLayout roundPanel17Layout = new javax.swing.GroupLayout(roundPanel17);
        roundPanel17.setLayout(roundPanel17Layout);
        roundPanel17Layout.setHorizontalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        roundPanel17Layout.setVerticalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel18.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel18.setRound(10);

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(table1);

        jLabel2.setText("Sinh viên xét tốt nghiệp");

        javax.swing.GroupLayout roundPanel18Layout = new javax.swing.GroupLayout(roundPanel18);
        roundPanel18.setLayout(roundPanel18Layout);
        roundPanel18Layout.setHorizontalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addGroup(roundPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel18Layout.setVerticalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout pageHomeLayout = new javax.swing.GroupLayout(pageHome);
        pageHome.setLayout(pageHomeLayout);
        pageHomeLayout.setHorizontalGroup(
            pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageHomeLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageHomeLayout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        pageHomeLayout.setVerticalGroup(
            pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pageHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 381, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
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
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            table_SV.getColumnModel().getColumn(10).setPreferredWidth(40);
        }

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
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

        tf_dk1.setBackground(new java.awt.Color(255, 255, 255));
        tf_dk1.setLabelText("Điểm Kì 1");

        tf_NameSV.setBackground(new java.awt.Color(255, 255, 255));
        tf_NameSV.setLabelText("Tên Sinh VIên");

        cbb_GenderSV.setLabeText("Gender");
        cbb_GenderSV.setLightWeightPopupEnabled(false);

        tf_dk3.setBackground(new java.awt.Color(255, 255, 255));
        tf_dk3.setLabelText("Điểm kì 3");

        tf_dk2.setBackground(new java.awt.Color(255, 255, 255));
        tf_dk2.setLabelText("Điểm kì 2");

        tf_dk4.setBackground(new java.awt.Color(255, 255, 255));
        tf_dk4.setLabelText("Điểm kì 4");
        tf_dk4.setOpaque(true);
        tf_dk4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dk4ActionPerformed(evt);
            }
        });

        tf_QqSV.setBackground(new java.awt.Color(255, 255, 255));
        tf_QqSV.setLabelText("Quê Quán");

        ccb_MaClassSV.setLabeText("Mã Lớp");

        tf_dob1.setBackground(new java.awt.Color(255, 255, 255));
        tf_dob1.setLabelText("Date Of Birth");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_dob1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ccb_MaClassSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_NameSV, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addComponent(tf_QqSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(cbb_GenderSV, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(tf_dk3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_dk4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(tf_dk1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(tf_dk2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_NameSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_QqSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccb_MaClassSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_dob1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(cbb_GenderSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_dk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dk4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        cbb_GenderSV.getAccessibleContext().setAccessibleName("");

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
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_addSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_updateSV, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(bt_deleteSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(bt_addSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_updateSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_deleteSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout pageSVLayout = new javax.swing.GroupLayout(pageSV);
        pageSV.setLayout(pageSVLayout);
        pageSVLayout.setHorizontalGroup(
            pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageSVLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pageSVLayout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        pageSVLayout.setVerticalGroup(
            pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbt_deleteClass.setText("Xóa Lớp Học");

        jbt_addClass.setText("Thêm Lớp Học");

        tfClass_TenLop.setBackground(new java.awt.Color(240, 240, 240));
        tfClass_TenLop.setLabelText("Tên Lớp");

        cbbClass_MaKhoa.setBackground(new java.awt.Color(240, 240, 240));
        cbbClass_MaKhoa.setLabeText("Lớp Thuộc Khoa");

        tfClass_MaLop1.setBackground(new java.awt.Color(240, 240, 240));
        tfClass_MaLop1.setLabelText("Mã Lớp");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jbt_addClass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfClass_TenLop, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(tfClass_MaLop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(74, 74, 74)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbt_deleteClass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbClass_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_deleteClass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_addClass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(tfClass_MaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfClass_TenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(cbbClass_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbt_addKhoa.setText("Thêm Khoa Mới");

        jbt_deleteKhoa.setText("Xóa Khoa");
        jbt_deleteKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_deleteKhoaActionPerformed(evt);
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

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel5Layout.createSequentialGroup()
                                .addComponent(tfKhoa_TenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(roundPanel5Layout.createSequentialGroup()
                                .addComponent(tfKhoa_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jbt_addKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfKhoa_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoa_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jbt_deleteKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_addKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_deleteKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKhoa_MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoa_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKhoa_TenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoa_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
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
                .addContainerGap(41, Short.MAX_VALUE))
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

        pageKhoaHoc.setBackground(new java.awt.Color(153, 153, 255));

        roundPanel8.setRound(10);

        tfKhoaHoc_TenKhoaHoc.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoaHoc_TenKhoaHoc.setLabelText("Tên Khóa Học");
        tfKhoaHoc_TenKhoaHoc.setPreferredSize(new java.awt.Dimension(64, 42));

        tfKhoaHoc_MaKhoaHoc.setBackground(new java.awt.Color(240, 240, 240));
        tfKhoaHoc_MaKhoaHoc.setLabelText("Mã Khóa Học");
        tfKhoaHoc_MaKhoaHoc.setPreferredSize(new java.awt.Dimension(64, 42));

        btKhoaHoc_add.setText("Thêm Khóa Học");

        btKhoaHoc_delete.setText("Xóa Khóa Học");

        btKhoaHoc_update.setText("Cập Nhật Khóa Học");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btKhoaHoc_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btKhoaHoc_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btKhoaHoc_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btKhoaHoc_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoaHoc_TenKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKhoaHoc_MaKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbbKhoaHoc_mh2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbKhoaHoc_mh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btKhoaHoc_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbKhoaHoc_mh3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKhoaHoc_mh4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKhoaHoc_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        roundPanel9.setRound(10);

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
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
        jScrollPane4.setViewportView(table_KhoaHoc);
        if (table_KhoaHoc.getColumnModel().getColumnCount() > 0) {
            table_KhoaHoc.getColumnModel().getColumn(0).setPreferredWidth(40);
        }

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pageKhoaHocLayout = new javax.swing.GroupLayout(pageKhoaHoc);
        pageKhoaHoc.setLayout(pageKhoaHocLayout);
        pageKhoaHocLayout.setHorizontalGroup(
            pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageKhoaHocLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pageKhoaHocLayout.setVerticalGroup(
            pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageKhoaHocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageKhoaHocLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pestanas.addTab("", pageKhoaHoc);

        pageDiemSV.setBackground(new java.awt.Color(0, 102, 153));

        roundPanel11.setRound(10);

        cbbDiemSV_MaSV.setLabeText("Mã Sinh Viên");

        cbbDiemSV_MaKhoaHoc.setLabeText("Mã Khóa Học");

        cbbDiemSV_HocKy.setLabeText("Học Kỳ");

        tfDiemSV_diem2.setLabelText("Điểm 2");

        tfDiemSV_diem3.setLabelText("Điểm 3");

        tfDiemSV_diem4.setLabelText("Điểm 4");

        tfDiemSV_diem1.setLabelText("Diểm 1");

        jButton2.setText("Nhập Điểm");

        jButton3.setText("Xóa Điểm");

        jButton4.setText("Sửa Điểm");

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
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
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
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        roundPanel12.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel12.setRound(10);

        table_DiemSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Mã Khóa Học", "Học Kỳ", "Điểm 1", "Điểm 2", "Điểm 3", "Điểm 4", "Medium Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table_DiemSV);
        if (table_DiemSV.getColumnModel().getColumnCount() > 0) {
            table_DiemSV.getColumnModel().getColumn(2).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(4).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(5).setPreferredWidth(50);
            table_DiemSV.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel13.setRound(10);

        javax.swing.GroupLayout roundPanel13Layout = new javax.swing.GroupLayout(roundPanel13);
        roundPanel13.setLayout(roundPanel13Layout);
        roundPanel13Layout.setHorizontalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        roundPanel13Layout.setVerticalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pageDiemSVLayout = new javax.swing.GroupLayout(pageDiemSV);
        pageDiemSV.setLayout(pageDiemSVLayout);
        pageDiemSVLayout.setHorizontalGroup(
            pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageDiemSVLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pageDiemSVLayout.setVerticalGroup(
            pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageDiemSVLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pageDiemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageDiemSVLayout.createSequentialGroup()
                        .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pestanas.addTab("", pageDiemSV);

        pageQuanTri.setBackground(new java.awt.Color(255, 204, 255));

        roundPanel14.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel14.setRound(10);

        table_QuanTri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Giảng Viên", "Email", "Giới Tính", "Ngày Sinh", "Quê Quán", "Password"
            }
        ));
        jScrollPane6.setViewportView(table_QuanTri);

        javax.swing.GroupLayout roundPanel14Layout = new javax.swing.GroupLayout(roundPanel14);
        roundPanel14.setLayout(roundPanel14Layout);
        roundPanel14Layout.setHorizontalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        roundPanel14Layout.setVerticalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        roundPanel15.setRound(10);

        textField7.setBackground(new java.awt.Color(240, 240, 240));

        textField8.setBackground(new java.awt.Color(240, 240, 240));

        jButton5.setText("Login with Admin");

        jLabel1.setText("Để có thể sử dụng chức năng này người dùng cần phải nhập tài khoản và mật khẩu của Admin hệ thống");

        javax.swing.GroupLayout roundPanel15Layout = new javax.swing.GroupLayout(roundPanel15);
        roundPanel15.setLayout(roundPanel15Layout);
        roundPanel15Layout.setHorizontalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel15Layout.createSequentialGroup()
                        .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        roundPanel15Layout.setVerticalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel16.setRound(10);

        textField1.setBackground(new java.awt.Color(240, 240, 240));

        textField2.setBackground(new java.awt.Color(240, 240, 240));

        textField3.setBackground(new java.awt.Color(240, 240, 240));

        textField4.setBackground(new java.awt.Color(240, 240, 240));

        textField5.setBackground(new java.awt.Color(240, 240, 240));

        textField6.setBackground(new java.awt.Color(240, 240, 240));

        btQuanTri_update.setText("Sửa Thông Tin");

        btQuanTri_delete.setText("Xóa Tài Khoản");

        btQuanTri_add.setText("Thêm Tài Khoản");

        javax.swing.GroupLayout roundPanel16Layout = new javax.swing.GroupLayout(roundPanel16);
        roundPanel16.setLayout(roundPanel16Layout);
        roundPanel16Layout.setHorizontalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btQuanTri_add, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btQuanTri_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btQuanTri_update, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        roundPanel16Layout.setVerticalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btQuanTri_add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btQuanTri_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btQuanTri_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pageQuanTriLayout = new javax.swing.GroupLayout(pageQuanTri);
        pageQuanTri.setLayout(pageQuanTriLayout);
        pageQuanTriLayout.setHorizontalGroup(
            pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageQuanTriLayout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pageQuanTriLayout.setVerticalGroup(
            pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageQuanTriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pageQuanTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageQuanTriLayout.createSequentialGroup()
                        .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
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

    private void tf_dk4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dk4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_dk4ActionPerformed

    private void bt_addSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addSVActionPerformed
        boolean gender = true;
        String flag = cbb_GenderSV.getLabeText();
        if (flag == "Nữ") {
            gender = false;
        }

        String MaSV = tf_maSV.getText();
        String TenSV = tf_NameSV.getText();
        boolean GioiTinh = gender;
        String NgaySinh = tf_dob1.getText();
        String QueQuan = tf_QqSV.getText();
        String GPA_1 = tf_dk1.getText();
        String GPA_2 = tf_dk2.getText();
        String GPA_3 = tf_dk3.getText();
        String GPA_4 = tf_dk4.getText();
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

       SinhVien_Model sv = new SinhVien_Model(MaSV, TenSV, gender, d, QueQuan, this.checkDiem(tf_dk1), this.checkDiem(tf_dk2), this.checkDiem(tf_dk3), this.checkDiem(tf_dk3), MaLop);
        SinhVien_DAO ins = new SinhVien_DAO();
        ins.getInstance().add(sv);
        showResult();
        ResetForm();
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_addSVActionPerformed

    public void ResetForm() {
        tf_maSV.setText("");
        tf_NameSV.setText("");
        tf_dob1.setText("");
        tf_QqSV.setText("");
        tf_dk1.setText("");
        tf_dk2.setText("");
        tf_dk3.setText("");
        tf_dk4.setText("");
    }
    private void table_SVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SVMouseReleased
        // TODO add your handling code here:
        tf_maSV.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 1).toString());
        tf_NameSV.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 2).toString());
        cbb_GenderSV.setSelectedItem(table_SV.getValueAt(table_SV.getSelectedRow(), 3).toString());
        tf_dob1.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 4).toString());
        tf_QqSV.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 5).toString());
        tf_dk1.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 6).toString());
        tf_dk2.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 7).toString());
        tf_dk3.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 8).toString());
        tf_dk4.setText(table_SV.getValueAt(table_SV.getSelectedRow(), 9).toString());
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
        showResult();
        ResetForm();
    }//GEN-LAST:event_bt_deleteSVActionPerformed

    private void bt_updateSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateSVActionPerformed
        // TODO add your handling code here:
        boolean gender = true;
        String flag = cbb_GenderSV.getLabeText();
        if (flag == "Nữ") {
            gender = false;
        }
        String MaSV = tf_maSV.getText();
        String TenSV = tf_NameSV.getText();
        boolean GioiTinh = gender;
        String NgaySinh = tf_dob1.getText();
        String QueQuan = tf_QqSV.getText();
        String GPA_1 = tf_dk1.getText();
        String GPA_2 = tf_dk2.getText();
        String GPA_3 = tf_dk3.getText();
        String GPA_4 = tf_dk4.getText();
        String MaLop = "";
        int MaLopIndex = ccb_MaClassSV.getSelectedIndex();
        if (MaLopIndex != -1) {
            Object selectedValue = ccb_MaClassSV.getItemAt(MaLopIndex); // Lấy giá trị tại chỉ số đã chọn
            MaLop = selectedValue.toString(); // Chuyển đổi giá trị thành chuỗi (nếu cần)
            // Sử dụng giá trị đã chọn ở đây
        } else {
           // ComboBotable_Classx trống
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
        SinhVien_Model sv = new SinhVien_Model(MaSV, MaSV, gender, d, QueQuan, this.checkDiem(tf_dk1), this.checkDiem(tf_dk2), this.checkDiem(tf_dk3), this.checkDiem(tf_dk4), MaLop);
        SinhVien_DAO ins = new SinhVien_DAO();
        ins.getInstance().delete(sv);
        showResult();
        ResetForm();

        
    }//GEN-LAST:event_bt_updateSVActionPerformed

    private void jbt_deleteKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_deleteKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_deleteKhoaActionPerformed

    private void btt_inicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_inicioMousePressed
        // TODO add your handling code here:
        pestanas.setSelectedIndex(0);
        ColorOP.AnimattIni();
    }//GEN-LAST:event_btt_inicioMousePressed

    private void lbl_iniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iniMousePressed
        // TODO add your handling code here:
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
                new MenuOpcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panel_redondo.PanelRound Menu;
    private javax.swing.JSeparator Separator;
    public javax.swing.JLabel Titulo;
    private javax.swing.JButton btKhoaHoc_add;
    private javax.swing.JButton btKhoaHoc_delete;
    private javax.swing.JButton btKhoaHoc_update;
    private javax.swing.JButton btQuanTri_add;
    private javax.swing.JButton btQuanTri_delete;
    private javax.swing.JButton btQuanTri_update;
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
    private com.raven.component.Card card4;
    private combobox.Combobox cbbClass_MaKhoa;
    private combobox.Combobox cbbDiemSV_HocKy;
    private combobox.Combobox cbbDiemSV_MaKhoaHoc;
    private combobox.Combobox cbbDiemSV_MaSV;
    private combobox.Combobox cbbKhoaHoc_mh1;
    private combobox.Combobox cbbKhoaHoc_mh2;
    private combobox.Combobox cbbKhoaHoc_mh3;
    private combobox.Combobox cbbKhoaHoc_mh4;
    private combobox.Combobox cbb_GenderSV;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jbt_addClass;
    private javax.swing.JButton jbt_addKhoa;
    private javax.swing.JButton jbt_deleteClass;
    private javax.swing.JButton jbt_deleteKhoa;
    public static javax.swing.JLabel lbl_Salir;
    public static javax.swing.JLabel lbl_ini;
    public static javax.swing.JLabel lbl_prueba;
    public static javax.swing.JLabel lbl_pruebaOne;
    public static javax.swing.JLabel lbl_pruebaTwo;
    public static javax.swing.JLabel lbl_pruebaTwo1;
    public static javax.swing.JLabel lbl_pruebaTwo2;
    private javax.swing.JPanel pageDiemSV;
    private javax.swing.JPanel pageHome;
    private javax.swing.JPanel pageKhoaHoc;
    private javax.swing.JPanel pageLopKhoa;
    private javax.swing.JPanel pageQuanTri;
    private javax.swing.JPanel pageSV;
    private tabbed.MaterialTabbed pestanas;
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
    private javaswingdev.swing.table.Table table1;
    private javaswingdev.swing.table.Table table_Class;
    private javaswingdev.swing.table.Table table_DiemSV;
    private javaswingdev.swing.table.Table table_KhoaHoc;
    private javaswingdev.swing.table.Table table_QuanTri;
    private javaswingdev.swing.table.Table table_SV;
    private javaswingdev.swing.table.Table table_khoa;
    private textfield.TextField textField1;
    private textfield.TextField textField2;
    private textfield.TextField textField3;
    private textfield.TextField textField4;
    private textfield.TextField textField5;
    private textfield.TextField textField6;
    private textfield.TextField textField7;
    private textfield.TextField textField8;
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
    private textfield.TextField tf_NameSV;
    private textfield.TextField tf_QqSV;
    private textfield.TextField tf_dk1;
    private textfield.TextField tf_dk2;
    private textfield.TextField tf_dk3;
    private textfield.TextField tf_dk4;
    private textfield.TextField tf_dob1;
    private textfield.TextField tf_maSV;
    private javaswingdev.swing.titlebar.TitleBar titleBar1;
    // End of variables declaration//GEN-END:variables
}
