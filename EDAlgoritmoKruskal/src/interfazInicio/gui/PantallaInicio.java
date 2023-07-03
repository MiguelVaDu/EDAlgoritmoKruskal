package interfazInicio.gui;



import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;
import interfazCliente.gui.*;
import interfazAdministrador.gui.*;

public class PantallaInicio {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Formato formato;
    //---BOTONES--------------
    private Boton botonPantallaCliente;
    private Boton botonPantallaAdministrador;
    private Boton botonSobreNosotros;
    private Boton botonAgregarCliente;
    JLabel botonRegresar = new JLabel();
    //---FONDO----------------
    JLabel imagenFondo = new JLabel();
    //---LOGO-----------------
    JLabel logo = new JLabel();
    //---TEXTO----------------
    JLabel texto1 = new JLabel();
    JLabel texto2 = new JLabel();
    JLabel texto3 = new JLabel();
    JLabel texto4 = new JLabel();

    public PantallaInicio(){
        ventana  = new JFrame();
        fondo  = new JPanel();
        configVentana();
        ImageIcon i = new ImageIcon("imagen/Logo.png");
        ventana.setIconImage(i.getImage());
        ventana.getContentPane().revalidate();
        ventana.getContentPane().repaint();
    }

    public PantallaInicio(JFrame ventana){
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

    private void configComponentes(){
    	botonRegresar();
    	botonCliente();
    	botonAdministrador();
    	botonSobreNosotros();
    	botonAgregarCliente();
    	logo();
    	titulo();
    	textoLogo1();
    	textoLogo2();
    	preguntaCliente();
        cargarFondo();        
        ventana.add(fondo);
    }
    //------------------------FONDO-------------------------------------
    private void cargarFondo() {
    	imagenFondo = new JLabel();
    	imagenFondo.setBounds(0,0,WIDTH,HEIGHT);
    	CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
    	fondo.add(imagenFondo);
    }
    //------------------------LOGO--------------------------------------
    public void logo() {
    	logo.setBounds(860, 150, 350, 350);
    	CargaImagen.setImagen(logo, "Logo.png");
    	fondo.add(logo);
    }
    //------------------------TEXTOS------------------------------------
    public void titulo() {
    	texto1 = new JLabel();
    	formato = new Formato();
    	texto1.setBounds(90, 120, 680, 80);
    	formato.formato(texto1, 0, 28);
    	texto1.setForeground(Color.WHITE);
    	texto1.setText("Selecciona una de las opciones");
    	fondo.add(texto1);
    }
    public void textoLogo1() {
    	texto2 = new JLabel();
    	formato = new Formato();
    	texto2.setBounds(732, 70, 680, 70);
    	formato.formato(texto2, 0, 44);
    	texto2.setForeground(Color.WHITE);
    	texto2.setText("SERVICIO DE INTERNET");
    	fondo.add(texto2);
    }
    public void textoLogo2() {
    	texto3 = new JLabel();
    	formato = new Formato();
    	texto3.setBounds(870, 500, 680, 80);
    	formato.formato(texto3, 0, 42);
    	texto3.setForeground(Color.WHITE);
    	texto3.setText("E - KRUSKAL");
    	fondo.add(texto3);
    }
    public void preguntaCliente() {
    	texto4 = new JLabel();
    	formato = new Formato();
    	texto4.setBounds(220, 450, 680, 80);
    	formato.formato(texto4, 0, 22);
    	texto4.setForeground(Color.WHITE);
    	texto4.setText("¿Es tu primera vez?");
    	fondo.add(texto4);
    }
    
    //------------------------BOTONES-----------------------------------
    
    public void botonCliente() {
    	botonPantallaCliente = new Boton();
		formato = new Formato();
		botonPantallaCliente.setBounds(110, 210, 468, 80);
		formato.formato(botonPantallaCliente, 0, 24, 70, 2);
		botonPantallaCliente.setText("Ingresar como Cliente");
		botonPantallaCliente.addActionListener(e ->{
			mostrarPantallaDeCliente();
		});
		fondo.add(botonPantallaCliente);
    }
    public void botonAdministrador() {
    	botonPantallaAdministrador = new Boton();
		formato = new Formato();
		botonPantallaAdministrador.setBounds(110, 354, 468, 80);
		formato.formato(botonPantallaAdministrador, 0, 24, 70, 2);
		botonPantallaAdministrador.setText("Ingresar como Administrador");
		botonPantallaAdministrador.addActionListener(e ->{
			mostrarPantallaDeAdministrador();
		});
		fondo.add(botonPantallaAdministrador);
    }
    public void botonRegresar() {
    	botonRegresar.setBounds(285, 605, 110, 110);
    	CargaImagen.setImagen(botonRegresar, "Cerrar.png");
    	botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	System.exit(0);
                System.out.println("Saliste del programa");
            }
        });
    	fondo.add(botonRegresar);
    }
    
    public void botonSobreNosotros() {
    	botonSobreNosotros = new Boton();
		formato = new Formato();
		botonSobreNosotros.setBounds(885, 596, 280, 60);
		formato.formato(botonSobreNosotros, 0, 24, 70, 2);
		botonSobreNosotros.setText("Sobre Nosotros");
		botonSobreNosotros.addActionListener(e ->{
			mostrarPantallaSobreNosotros();
		});
		fondo.add(botonSobreNosotros);
    }
    public void botonAgregarCliente() {
    	botonAgregarCliente = new Boton();
		formato = new Formato();
		botonAgregarCliente.setBounds(110, 509, 468, 65);
		formato.formato(botonAgregarCliente, 0, 24, 70, 2);
		botonAgregarCliente.setText("Registrarse como Cliente");
		botonAgregarCliente.addActionListener(e ->{
			mostrarPantallaNuevoCliente();
		});
		fondo.add(botonAgregarCliente);
    }
	
    //-----------------------------------------------------------------------

    //-----------------FUNCIONES PARA LOS BOTONES----------------------------

    public void mostrarPantallaDeCliente(){
        ventana.remove(fondo);
        PantallaCliente c = new PantallaCliente(ventana);
    }

    public void mostrarPantallaDeAdministrador(){
        ventana.remove(fondo);
        PantallaAdministrador c = new PantallaAdministrador(ventana);
    }

    public void mostrarPantallaNuevoCliente(){
        ventana.remove(fondo);
        PantallaNuevoCliente c = new PantallaNuevoCliente(ventana);
    }

    public void mostrarPantallaSobreNosotros(){
        ventana.remove(fondo);
        PantallaSobreNosotros c = new PantallaSobreNosotros(ventana);
    }

    //-----------------------------------------------------------------------

    public static void main(String[] args) {
        PantallaInicio pI = new PantallaInicio(); 
    }
}

