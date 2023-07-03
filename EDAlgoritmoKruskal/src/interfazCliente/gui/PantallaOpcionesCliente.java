package interfazCliente.gui;

import javax.swing.*;

import entidad.Cliente;
import entidad.Usuario;
import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;
import utilidad.ManejoDeArchivos;

import java.util.List;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaOpcionesCliente {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Formato formato;
    private List<Usuario> busqueda;
    private Usuario usu;
    private List<Cliente> clientes;
    private Cliente cli;
    private Boton botonVerConexiones;
    private Boton botonRealizarSolicitud;
    private Boton botonVerInformacion;
    JLabel botonRegresar = new JLabel();
    //-----DARLE BIENVENIDA----------
    JLabel texto1 = new JLabel();
    // ---------BOTONES---------------
    private JButton btn_realizarSolicitud = new JButton("Realizar solicitud");
    private JButton btn_verInformacion = new JButton("Ver su informacion");
    private JButton btn_verConexiones = new JButton("Ver conexiones");
    //private JButton btn_Cerrar = new JButton("Regresar");
    //----IMAGEN DEL FONDO-------------
    JLabel imagenFondo = new JLabel();

    public PantallaOpcionesCliente(JFrame ventana) {
        fondo = new JPanel();
        this.ventana = ventana;
        busqueda = ManejoDeArchivos.recuperarUsuario("archivos/Usuarios.dat");
        usu = busqueda.get(0);
        clientes = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
        for (Cliente c : clientes) {
            if (usu.getCorreo().equals(c.getCorreo())) {
                cli = c;
            }
        }
        configVentana();
    }

    private void configVentana() {
        ventana.repaint();
        ventana.setSize(1400, 800);
        ventana.setTitle("KRUSKAL-UNMSM");
        ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
        configComponentes();
    }

    private void configComponentes() {
        fondo.setLayout(null);
        fondo.setBackground(Color.YELLOW);
        ventana.getContentPane().repaint();
        ventana.getContentPane().revalidate();
        botonRegresar();
        //btn_CerrarUsuario(btn_Cerrar);
        botonRealizarSolicitud();
        //btn_RealizarSolicitudDeRetiro(btn_realizarSolicitud);
        //btn_ConsultarInformación(btn_verInformacion);
        botonVerInformacion();
        //btn_ConsultarConexiones(btn_verConexiones);
        botonConexionesDeCliente();
        titulo1();
        cargarFondo();
        ventana.add(fondo);
    }
    
    private void titulo1() {
        texto1 = new JLabel();
        formato = new Formato();
        texto1.setBounds(420, 30, 1000, 35);
        formato.formato(texto1, 0, 50);
        texto1.setForeground(Color.WHITE);
        texto1.setText("BIENVENIDO "+cli.getNombreComp());
        fondo.add(texto1);
    }
    
    private void cargarFondo() {
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
        CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
        fondo.add(imagenFondo);
    }

    // ----------FUNCIONES PARA LOS BOTONES------------------------
    /*
    public void btn_CerrarUsuario(JButton btn) {
        btn.setBounds(90, 620, 70, 90);
        btn.setOpaque(true);
        btn.addActionListener(e -> {
            mostrarPantallaDeCliente();
        });
        fondo.add(btn);
    }*/
    
    public void botonRegresar() {
        botonRegresar.setBounds(40, 605, 110, 110);
        CargaImagen.setImagen(botonRegresar, "Cerrar.png");
        botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	mostrarPantallaDeCliente();
            }
        });
        fondo.add(botonRegresar);
    }
/*
    public void btn_RealizarSolicitudDeRetiro(JButton btn) {

        btn.setBounds(137, 182, 502, 118);
        btn.setOpaque(true);
        if (cli.getUsoSolicitud()) {
            btn.setEnabled(false);
        }
        btn.addActionListener(e -> {
            System.out.println("Mostrar apartado para hacer solicitudes");
            mostrarSolicitudesRetiroCliente();
        });
        fondo.add(btn);
    }*/
    
    public void botonRealizarSolicitud() {
    	botonRealizarSolicitud = new Boton();
        formato = new Formato();
        botonRealizarSolicitud.setBounds(137, 182, 502, 118);
        /*
        if(cli.getUsoSolicitud()) {
        	botonRealizarSolicitud.setEnabled(false);
		}*/
        formato.formato(botonRealizarSolicitud, 0, 24, 70, 2);
        botonRealizarSolicitud.setText("Realizar solicitud de retiro");
        botonRealizarSolicitud.addActionListener(e -> {
        	mostrarSolicitudesRetiroCliente();
        });
        fondo.add(botonRealizarSolicitud);
    }
/*
    public void btn_ConsultarInformación(JButton btn) {
        btn.setBounds(728, 181, 502, 118);
        btn.setOpaque(true);
        btn.addActionListener(e -> {
            System.out.println("Mostrar su informacion");
            mostrarInformacionCliente();
        });
        fondo.add(btn);
    }*/
    
    public void botonVerInformacion() {
    	botonVerInformacion = new Boton();
        formato = new Formato();
        botonVerInformacion.setBounds(728, 181, 502, 118);
        formato.formato(botonVerInformacion, 0, 24, 70, 2);
        botonVerInformacion.setText("Ver informacion personal");
        botonVerInformacion.addActionListener(e -> {
        	mostrarInformacionCliente();
        });
        fondo.add(botonVerInformacion);
    }
/*
    public void btn_ConsultarConexiones(JButton btn) {
        btn.setBounds(447, 448, 502, 118);
        btn.setOpaque(false);
        btn.setVisible(true);
        btn.addActionListener(e -> {
            mostrarConexionesCliente();
        });
        fondo.add(btn);
    }*/
    
    public void botonConexionesDeCliente() {
    	botonVerConexiones = new Boton();
        formato = new Formato();
        botonVerConexiones.setBounds(447, 448, 502, 118);
        formato.formato(botonVerConexiones, 0, 24, 70, 2);
        botonVerConexiones.setText("Ver mis conexiones");
        botonVerConexiones.addActionListener(e -> {
        	mostrarConexionesCliente();
        });
        fondo.add(botonVerConexiones);
    }

    // -------------------------------------------------------------
    // ------------FUNCIONES PARA LOS BOTONES-----------------------

    public void mostrarPantallaDeCliente() {
        ventana.remove(fondo);
        PantallaCliente c = new PantallaCliente(ventana);
    }

    public void mostrarSolicitudesRetiroCliente() {
    	if(!cli.getUsoSolicitud()) {
    		ventana.remove(fondo);
        	PantallaMostrarSolicitudRetiroCliente c = new PantallaMostrarSolicitudRetiroCliente(ventana);
    	} else {
    		JOptionPane.showMessageDialog(null, "Solicitud ya realizada");
    	}
    }

    public void mostrarInformacionCliente() {
        ventana.remove(fondo);
        PantallaMostrarInformacionCliente c = new PantallaMostrarInformacionCliente(ventana);
    }

    public void mostrarConexionesCliente() {
        ventana.remove(fondo);
        PantallaMostrarConexionCliente c = new PantallaMostrarConexionCliente(ventana);
    }

    // ---------------------------------------------------------------
}
