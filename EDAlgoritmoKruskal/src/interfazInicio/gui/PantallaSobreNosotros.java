package interfazInicio.gui;

import javax.swing.*;

import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaSobreNosotros {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Formato formato;

    // ---------BOTONES---------------
    // JButton btn_Regresar = new JButton("Volver");
    JLabel botonRegresar = new JLabel();
    // ---LOGO-----------------
    JLabel logo = new JLabel();
    // ---IMAGEN-----------------
    JLabel imagensobrenosotros = new JLabel();
    // ------------FONDO---------------
    JLabel imagenFondo = new JLabel();
    // ---TEXTO----------------
    JLabel texto0 = new JLabel();
    JLabel texto1 = new JLabel();
    JLabel texto2 = new JLabel();
    JLabel texto3 = new JLabel();
    JLabel texto4 = new JLabel();
    JLabel texto5 = new JLabel();
    JLabel texto6 = new JLabel();
    JLabel texto7 = new JLabel();
    JLabel texto8 = new JLabel();
    JLabel texto9 = new JLabel();
    JLabel texto10 = new JLabel();
    JLabel texto11 = new JLabel();
    JLabel texto12 = new JLabel();
    // ------------------------------

    public PantallaSobreNosotros() {
        ventana = new JFrame();
        fondo = new JPanel();
        configVentana();
        ventana.getContentPane().revalidate();
        ventana.getContentPane().repaint();
    }

    public PantallaSobreNosotros(JFrame ventana) {
        this.ventana = ventana;
        fondo = new JPanel();
        configVentana();
        ventana.getContentPane().revalidate();
        ventana.getContentPane().repaint();
    }

    private void configVentana() {
        ventana.setSize(WIDTH, HEIGHT);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("KRUSKAL - UNMSM");
        fondo.setLayout(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.getContentPane().add(fondo);
        configComponentes();

    }

    private void configComponentes() {
        // btn_Volver(btn_Regresar);
        fondo.setLayout(null);
        fondo.setBackground(Color.RED);
        ventana.getContentPane().repaint();
        ventana.getContentPane().revalidate(); // https://codesignal.com/developers/
        titulo();
        texto1();
        texto2();
        texto3();
        texto4();
        texto5();
        texto6();
        texto7();
        texto8();
        texto9();
        texto10();
        texto11();
        texto12();
        logo();
        logoUNMSM();
        botonRegresar();
        cargarFondo();
        ventana.add(fondo);

    }

    // ------------------------FONDO-------------------------------------
    private void cargarFondo() {
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
        CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
        fondo.add(imagenFondo);
    }

    // ------------------------LOGO--------------------------------------
    public void logo() {
        logo = new JLabel();
        logo.setBounds(1150, 600, 100, 100);
        CargaImagen.setImagen(logo, "Logo.png");
        fondo.add(logo);
    }
    public void logoUNMSM() {
    	imagensobrenosotros = new JLabel();
    	imagensobrenosotros.setBounds(900, 150, 350, 400);
        CargaImagen.setImagen(imagensobrenosotros, "LogoUNMSM.png");
        fondo.add(imagensobrenosotros);
    }

    // ------------------------TEXTOS------------------------------------
    public void titulo() {
        texto0 = new JLabel();
        formato = new Formato();
        texto0.setBounds(450, 80, 680, 80);
        formato.formato(texto0, 0, 50);
        texto0.setForeground(Color.WHITE);
        texto0.setText("SOBRE NOSOTROS");
        fondo.add(texto0);
    }

    public void texto1() {
        texto1 = new JLabel();
        formato = new Formato();
        texto1.setBounds(90, -200, 800, 800);
        formato.formato(texto1, 0, 20);
        texto1.setForeground(Color.WHITE);
        texto1.setText("EN NUESTRA EMPRESA, RECONOCEMOS QUE LA");
        fondo.add(texto1);
    }

    public void texto2() {
        texto2 = new JLabel();
        formato = new Formato();
        texto2.setBounds(90, -170, 800, 800);
        formato.formato(texto2, 0, 20);
        texto2.setForeground(Color.WHITE);
        texto2.setText("FLEXIBILIDAD Y LA LIBERTAD SON ELEMENTOS CLAVE EN");
        fondo.add(texto2);
    }

    public void texto3() {
        texto3 = new JLabel();
        formato = new Formato();
        texto3.setBounds(90, -140, 800, 800);
        formato.formato(texto3, 0, 20);
        texto3.setForeground(Color.WHITE);
        texto3.setText("EL MUNDO CONECTADO DE HOY EN DÍA. POR LO TANTO,");
        fondo.add(texto3);
    }

    public void texto4() {
        texto4 = new JLabel();
        formato = new Formato();
        texto4.setBounds(90, -110, 800, 800);
        formato.formato(texto4, 0, 20);
        texto4.setForeground(Color.WHITE);
        texto4.setText("HEMOS DESARROLLADO UNA INFRAESTRUCTURA DE RED");
        fondo.add(texto4);
    }

    public void texto5() {
        texto5 = new JLabel();
        formato = new Formato();
        texto5.setBounds(90, -80, 800, 800);
        formato.formato(texto5, 0, 20);
        texto5.setForeground(Color.WHITE);
        texto5.setText("UNICA Y AVANZADA QUE UTILIZA TECNOLOGIAS");
        fondo.add(texto5);
    }

    public void texto6() {
        texto6 = new JLabel();
        formato = new Formato();
        texto6.setBounds(90, -50, 800, 800);
        formato.formato(texto6, 0, 20);
        texto6.setForeground(Color.WHITE);
        texto6.setText("INALAMBRICAS DE ULTIMA GENERACION PARA OFRECER");
        fondo.add(texto6);
    }

    public void texto7() {
        texto7 = new JLabel();
        formato = new Formato();
        texto7.setBounds(90, -20, 800, 800);
        formato.formato(texto7, 0, 20);
        texto7.setForeground(Color.WHITE);
        texto7.setText("VELOCIDADES DE CONEXION ULTRARRAPIDAS Y UNA");
        fondo.add(texto7);
    }

    public void texto8() {
        texto8 = new JLabel();
        formato = new Formato();
        texto8.setBounds(90, 10, 800, 800);
        formato.formato(texto8, 0, 20);
        texto8.setForeground(Color.WHITE);
        texto8.setText("EXPERIENCIA EN LINEA SIN INTERRUPCIONES.");
        fondo.add(texto8);
    }

    public void texto9() {
        texto9 = new JLabel();
        formato = new Formato();
        texto9.setBounds(90, 70, 800, 800);
        formato.formato(texto9, 0, 20);
        texto9.setForeground(Color.WHITE);
        texto9.setText("POR LO CUAL OFRECEMOS SERVICIOS DE INTERNET ");
        fondo.add(texto9);
    }

    public void texto10() {
        texto10 = new JLabel();
        formato = new Formato();
        texto10.setBounds(90, 100, 800, 800);
        formato.formato(texto10, 0, 20);
        texto10.setForeground(Color.WHITE);
        texto10.setText("INALAMBRICO SIN CABLES COMPLICADOS NI COSTOSAS ");
        fondo.add(texto10);
    }

    public void texto11() {
        texto11 = new JLabel();
        formato = new Formato();
        texto11.setBounds(90, 130, 800, 800);
        formato.formato(texto11, 0, 20);
        texto11.setForeground(Color.WHITE);
        texto11.setText("INSTALACIONES, ADAPTANDONOS A TU NECESIDAD");
        fondo.add(texto11);
    }

    public void texto12() {
        texto12 = new JLabel();
        formato = new Formato();
        texto12.setBounds(900, 250, 800, 800);
        formato.formato(texto12, 0, 35);
        texto12.setForeground(Color.WHITE);
        texto12.setText("E-KRUSKAL");
        fondo.add(texto12);
    }
    // ----------FUNCIONES PARA LOS BOTONES------------------------

    public void botonRegresar() {
        botonRegresar.setBounds(347, 625, 90, 90);
        CargaImagen.setImagen(botonRegresar, "Cerrar.png");
        botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                mostrarPantallaDeInicio();
            }
        });
        fondo.add(botonRegresar);
    }

    // ------------FUNCIONES PARA LOS BOTONES----------------------

    public void mostrarPantallaDeInicio() {
        ventana.remove(fondo);
        PantallaInicio c = new PantallaInicio(ventana);
    }

}
