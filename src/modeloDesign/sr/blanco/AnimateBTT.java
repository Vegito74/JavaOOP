package modeloDesign.sr.blanco;

import Panel_gradiend.PanelGradient;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import menu.sr.blanco.MenuOpcion;
import static menu.sr.blanco.MenuOpcion.btt_inicio;
import static menu.sr.blanco.MenuOpcion.btt_prueba;
import static menu.sr.blanco.MenuOpcion.btt_pruebaOne;
import static menu.sr.blanco.MenuOpcion.btt_pruebaTwo;
import static menu.sr.blanco.MenuOpcion.btt_pruebaTwo1;
import static menu.sr.blanco.MenuOpcion.btt_pruebaTwo2;
import static menu.sr.blanco.MenuOpcion.lbl_ini;
import static menu.sr.blanco.MenuOpcion.lbl_prueba;
import static menu.sr.blanco.MenuOpcion.lbl_pruebaOne;
import static menu.sr.blanco.MenuOpcion.lbl_pruebaTwo;
import static menu.sr.blanco.MenuOpcion.lbl_pruebaTwo1;
import static menu.sr.blanco.MenuOpcion.lbl_pruebaTwo2;

public class AnimateBTT {

    private void mostrarColor(PanelGradient paneX, PanelGradient paneZ, JLabel lblx, String url) {
        paneX.setBackground(new Color(52, 100, 174));//Color a mostrar
        paneZ.setColorGradient(new Color(59, 207, 255));//Color a mostrar
        lblx.setForeground(Color.WHITE);//Color de texto a mostrar

        lblx.setIcon(new ImageIcon(getClass().getResource(url)));//Cambiar icono a blanco
    }

    private void establecColor(PanelGradient paneX, PanelGradient paneZ, JLabel lblx, String url) {
        paneX.setBackground(new Color(23, 27, 36));//Color por defecto
        paneZ.setColorGradient(new Color(23, 27, 36));//Color por defecto
        lblx.setForeground(new Color(166, 166, 166));//Color de texto por defecto

        lblx.setIcon(new ImageIcon(getClass().getResource(url)));//Cambiar icono a gris
    }

    public void AnimattIni() {
        mostrarColor(btt_inicio, btt_inicio, lbl_ini, "/iconos/home-altVr.png");
        establecColor(btt_prueba, btt_prueba, lbl_prueba, "/iconos/icons8_student_male_80px.png");
        establecColor(btt_pruebaOne, btt_pruebaOne, lbl_pruebaOne, "/iconos/icons8_class_50px_2.png");
        establecColor(btt_pruebaTwo, btt_pruebaTwo, lbl_pruebaTwo, "/iconos/icons8_book_64px.png");
        establecColor(btt_pruebaTwo1, btt_pruebaTwo1, lbl_pruebaTwo1, "/iconos/icons8_grades_80px.png");
        establecColor(btt_pruebaTwo2, btt_pruebaTwo2, lbl_pruebaTwo2, "/iconos/icons8_circled_user_64px.png");
    }

    public void AnimattPrueba() {
        mostrarColor(btt_prueba, btt_prueba, lbl_prueba, "/iconos/icons8_student_male_80px.png");
        establecColor(btt_inicio, btt_inicio, lbl_ini, "/iconos/home-altV.png");
        establecColor(btt_pruebaOne, btt_pruebaOne, lbl_pruebaOne, "/iconos/icons8_class_50px_2.png");
        establecColor(btt_pruebaTwo, btt_pruebaTwo, lbl_pruebaTwo, "/iconos/icons8_book_64px.png");
         establecColor(btt_pruebaTwo1, btt_pruebaTwo1, lbl_pruebaTwo1, "/iconos/icons8_grades_80px.png");
        establecColor(btt_pruebaTwo2, btt_pruebaTwo2, lbl_pruebaTwo2, "/iconos/icons8_circled_user_64px.png");
    }

    public void AnimattPruebaOne() {
        mostrarColor(btt_pruebaOne, btt_pruebaOne, lbl_pruebaOne, "/iconos/icons8_class_50px_2.png");
        establecColor(btt_inicio, btt_inicio, lbl_ini, "/iconos/home-altV.png");
        establecColor(btt_prueba, btt_prueba, lbl_prueba, "/iconos/icons8_student_male_80px.png");
        establecColor(btt_pruebaTwo, btt_pruebaTwo, lbl_pruebaTwo, "/iconos/icons8_book_64px.png");
         establecColor(btt_pruebaTwo1, btt_pruebaTwo1, lbl_pruebaTwo1, "/iconos/icons8_grades_80px.png");
        establecColor(btt_pruebaTwo2, btt_pruebaTwo2, lbl_pruebaTwo2, "/iconos/icons8_circled_user_64px.png");
    }

    public void AnimattPruebaTwo() {
        mostrarColor(btt_pruebaTwo, btt_pruebaTwo, lbl_pruebaTwo, "/iconos/icons8_book_64px.png");
        establecColor(btt_inicio, btt_inicio, lbl_ini, "/iconos/home-altV.png");
        establecColor(btt_prueba, btt_prueba, lbl_prueba, "/iconos/icons8_student_male_80px.png");
        establecColor(btt_pruebaOne, btt_pruebaOne, lbl_pruebaOne, "/iconos/icons8_class_50px_2.png");
         establecColor(btt_pruebaTwo1, btt_pruebaTwo1, lbl_pruebaTwo1, "/iconos/icons8_grades_80px.png");
        establecColor(btt_pruebaTwo2, btt_pruebaTwo2, lbl_pruebaTwo2, "/iconos/icons8_circled_user_64px.png");
    }
    
    public void AnimattPruebaTwo1() {
        establecColor(btt_pruebaTwo, btt_pruebaTwo, lbl_pruebaTwo, "/iconos/icons8_book_64px.png");
        establecColor(btt_inicio, btt_inicio, lbl_ini, "/iconos/home-altV.png");
        establecColor(btt_prueba, btt_prueba, lbl_prueba, "/iconos/icons8_student_male_80px.png");
        establecColor(btt_pruebaOne, btt_pruebaOne, lbl_pruebaOne, "/iconos/icons8_class_50px_2.png");
         mostrarColor(btt_pruebaTwo1, btt_pruebaTwo1, lbl_pruebaTwo1, "/iconos/icons8_grades_80px.png");
        establecColor(btt_pruebaTwo2, btt_pruebaTwo2, lbl_pruebaTwo2, "/iconos/icons8_circled_user_64px.png");
    }
    
    public void AnimattPruebaTwo2() {
        establecColor(btt_pruebaTwo, btt_pruebaTwo, lbl_pruebaTwo, "/iconos/icons8_book_64px.png");
        establecColor(btt_inicio, btt_inicio, lbl_ini, "/iconos/home-altV.png");
        establecColor(btt_prueba, btt_prueba, lbl_prueba, "/iconos/icons8_student_male_80px.png");
        establecColor(btt_pruebaOne, btt_pruebaOne, lbl_pruebaOne, "/iconos/icons8_class_50px_2.png");
         establecColor(btt_pruebaTwo1, btt_pruebaTwo1, lbl_pruebaTwo1, "/iconos/icons8_grades_80px.png");
        mostrarColor(btt_pruebaTwo2, btt_pruebaTwo2, lbl_pruebaTwo2, "/iconos/icons8_circled_user_64px.png");
    }
    
}
