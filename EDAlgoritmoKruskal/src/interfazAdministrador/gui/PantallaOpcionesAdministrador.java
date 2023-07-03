package interfazAdministrador.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;

public class PantallaOpcionesAdministrador {
    private JFrame ventana;
    private JPanel fondo;
    private Formato formato = new Formato();
    
    JLabel logo = new JLabel();
    ImageIcon imagen;
    JLabel background;
    //-------BOTONES-----------------
	Boton btn_verCalle;
    Boton btn_verListaDeSolicitudes;
    Boton btn_verListaDeClientes;
    Boton btn_realizarConexiones;
    JLabel btn_CerrarUsuario = new JLabel();
    
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;

    public PantallaOpcionesAdministrador(JFrame ventana){
        fondo = new JPanel(); 
        this.ventana = ventana;
        configVentana();
    }

    public void configVentana(){
        ventana.repaint();
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setTitle("KRUKAL-UNMSM");
		ventana.setLocationRelativeTo(null);
        configComponentes();
    }

    public void configComponentes(){
        fondo.setLayout(null);
        //fondo.setBackground(Color.BLUE);
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
        ventana.add(fondo);
    	titulo();
    	logo();
        btn_ConsultarCalle();
        btn_ListaDeSolicitudes();
        btn_ListaDeClientes();
        btn_AgregarConexion();
    	btn_Regreso();
        fondo();
    }
    
    public void fondo() {
		JLabel background = new JLabel();
	    background.setBounds(0,0,WIDTH,HEIGHT);
		CargaImagen.setImagen(background, "Fondo_Predeterminado.png");
	    fondo.add(background);
	}
    
    public void titulo() {
		JLabel Text = new JLabel("ADMINISTRADOR");
		Text.setHorizontalAlignment(JLabel.CENTER);
		Text.setBounds((int)(WIDTH*0.05), (int)(HEIGHT*0.09), (int)(WIDTH*0.9), (int)(HEIGHT*0.1));
		formato.formato(Text, 0, (int)(WIDTH*0.0575));
        fondo.add(Text);
    }
    
    public void logo() {
    	logo.setBounds(1150, 605, 110, 110);
    	CargaImagen.setImagen(logo, "Logo.png");
    	fondo.add(logo);
    }

    //-------------BOTONES--------------------------
    
    public void btn_Regreso() {
		btn_CerrarUsuario.setBounds(150, 605, 110, 110);
    	CargaImagen.setImagen(btn_CerrarUsuario, "Cerrar.png");
    	btn_CerrarUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	mostrarAdministrador();
            }
        });
    	fondo.add(btn_CerrarUsuario);
    }
    
    public void btn_ConsultarCalle() {
    	btn_verCalle = new Boton();
		btn_verCalle.setBounds((int)(WIDTH*1/7), (int)(HEIGHT*37/160), (int)(WIDTH*19/56), (int)(HEIGHT*1/8));
		formato.formato(btn_verCalle, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		btn_verCalle.setText("VER CALLE");
		btn_verCalle.addActionListener(e -> {
			mostrarApartadoDeConexiones();
	    });
		fondo.add(btn_verCalle);
    }
    
    public void btn_ListaDeSolicitudes() {
    	btn_verListaDeSolicitudes = new Boton();
		btn_verListaDeSolicitudes.setBounds((int)(WIDTH*4/7), (int)(HEIGHT*37/160), (int)(WIDTH*19/56), (int)(HEIGHT*1/8));
		formato.formato(btn_verListaDeSolicitudes, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		btn_verListaDeSolicitudes.setText("VER SOLICITUDES");
		btn_verListaDeSolicitudes.addActionListener(e -> {
			mostrarPantallaDeTablaSolicitudes();
	    });
		fondo.add(btn_verListaDeSolicitudes);
    }
	
    public void btn_ListaDeClientes() {
    	btn_verListaDeClientes = new Boton();
		btn_verListaDeClientes.setBounds((int)(WIDTH*1/7), (int)(HEIGHT*37/80), (int)(WIDTH*19/56), (int)(HEIGHT*1/8));
		formato.formato(btn_verListaDeClientes, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		btn_verListaDeClientes.setText("VER CLIENTES");
		btn_verListaDeClientes.addActionListener(e -> {
			mostrarPantallaListaDeClientes();
	    });
		fondo.add(btn_verListaDeClientes);
    }
    
    public void btn_AgregarConexion() {
    	btn_realizarConexiones = new Boton();
		btn_realizarConexiones.setBounds((int)(WIDTH*4/7), (int)(HEIGHT*37/80), (int)(WIDTH*19/56), (int)(HEIGHT*1/8));
		formato.formato(btn_realizarConexiones, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		btn_realizarConexiones.setText("REALIZAR CONEXIONES");
		btn_realizarConexiones.addActionListener(e -> {
			mostrarPantallaRealizarConexiones();
	    });
		fondo.add(btn_realizarConexiones);
    }

    //--------FUNCIONES PARA LOS BOTONES------------

    public void mostrarAdministrador(){
        ventana.remove(fondo);
        PantallaAdministrador c = new PantallaAdministrador(ventana);
    }

    public void mostrarPantallaRealizarConexiones(){
        ventana.remove(fondo);
        PantallaRealizarConexiones c = new PantallaRealizarConexiones(ventana);
    }

    public void mostrarApartadoDeConexiones(){
        ventana.remove(fondo);
        PantallaApartadoConexion c = new PantallaApartadoConexion(ventana);
    }

    public void mostrarPantallaDeTablaSolicitudes(){
        ventana.remove(fondo);
        PantallaRevisarSolicitudes c = new PantallaRevisarSolicitudes(ventana);
    }

    public void mostrarPantallaListaDeClientes(){
        ventana.remove(fondo);
        PantallaMostrarListaDeClientes c = new PantallaMostrarListaDeClientes(ventana);
    }


}
