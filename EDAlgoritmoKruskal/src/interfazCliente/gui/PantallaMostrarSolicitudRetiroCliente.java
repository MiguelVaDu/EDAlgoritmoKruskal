package interfazCliente.gui;

import javax.swing.*;

import utilidad.ManejoDeArchivos;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import utilidad.*;
import entidad.*;
import java.util.ArrayList;
import java.util.List;

public class PantallaMostrarSolicitudRetiroCliente {
	private JFrame ventana;
	private JPanel fondo;
	private JLabel solicitudLabel;
	private JTextField solicitudField;
	private Formato formato;
	private final int WIDTH = 1400;
	private final int HEIGHT = 800;
	List<Usuario> usuario = new ArrayList<>();
	Usuario usu = new Usuario();
	List<Cliente> clienteEncontrado = new ArrayList<>();
	List<Solicitud> solicitud = new ArrayList<>();
	JLabel imagenFondo = new JLabel();
	Solicitud nuevo = new Solicitud();
	// -------BOTONES-----------------
	private Boton btn_regresar;
	private Boton btn_enviar;

	public PantallaMostrarSolicitudRetiroCliente(JFrame ventana) {
		fondo = new JPanel();
		this.ventana = ventana;
		this.formato = new Formato();
		usuario = ManejoDeArchivos.recuperarUsuario("archivos/Usuarios.dat");
		clienteEncontrado = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
		solicitud = ManejoDeArchivos.recuperarSolicitudes("archivos/Solicitudes.dat");
		configVentana();
		ventana.getContentPane().revalidate();
		ventana.getContentPane().repaint();
	}

	public void configVentana() {
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

	public void configComponentes() {
		btn_solicitarSalida();
		btn_regresarAlMenuCliente();
		agregarAreaDeTexto();
		sbackground();
		cargarFondo();
		ventana.add(fondo);
	}
	
	private void cargarFondo() {
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
        CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
        fondo.add(imagenFondo);
    }

	// ------------AREA DE TEXTO-----------------------
	public void agregarAreaDeTexto() {
		solicitudLabel = new JLabel("REALIZA SU SOLICITUD DE RETIRO");
		solicitudLabel.setBounds(100, (int) (HEIGHT * 0.05), 880,
				200);
		formato.formato(solicitudLabel, 1, (float) (HEIGHT * 0.045));
		fondo.add(solicitudLabel);

		solicitudField = new JTextField("Redacte su consulta");
		solicitudField.setBounds((int) (solicitudLabel.getX() + WIDTH * 0.025),
				(int) (solicitudLabel.getY() + solicitudLabel.getHeight() + HEIGHT * 0.025), 1000,
				40);
		formato.formato(solicitudField, 0, 20);
		solicitudField.setEditable(true);
		solicitudField.setFocusable(true);
		fondo.add(solicitudField);
	}

	// ---------------BOTONES-------------------------

	public void btn_regresarAlMenuCliente() {
		btn_regresar = new Boton();
		formato = new Formato();
		btn_regresar.setBounds(80, 400, (int) (WIDTH * 5 / 17), (int) (HEIGHT * 7 / 72));
		formato.formato(btn_regresar, 0, 24, 70, 2);
		btn_regresar.setText("Regresar");
		btn_regresar.addActionListener(e -> {
			regresarAlMenuCliente();
		});
		fondo.add(btn_regresar);
	}

	public void btn_solicitarSalida() {
		btn_enviar = new Boton();
		formato = new Formato();
		btn_enviar.setBounds(800, 400, (int) (WIDTH * 5 / 17), (int) (HEIGHT * 7 / 72));
		formato.formato(btn_enviar, 0, 24, 70, 2);
		btn_enviar.setText("Enviar");
		btn_enviar.addActionListener(e -> {
			guardarSolicitud();
		});
		fondo.add(btn_enviar);
	}

	// --------FUNCION PARA EL BOTON------------------

	public void regresarAlMenuCliente() {
		ventana.remove(fondo);
		PantallaOpcionesCliente c = new PantallaOpcionesCliente(ventana);
	}

	public void guardarSolicitud() {
		if (solicitudField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Incompleto - ¡Completar solicitud!");
		} else {
			usu = usuario.get(0);
			for (Cliente c : clienteEncontrado) {
				if (usu.getCorreo().equals(c.getCorreo()) && usu.getContrasena().equals(c.getContrasena())) {
					nuevo.setClienteQueSolicita(c);
					nuevo.setId(c.getN().getId());
					c.setUsoSolicitud(true);
				}
			}
			nuevo.setDescripcion(solicitudField.getText());
			solicitud.add(nuevo);
			ManejoDeArchivos.eliminarContenidoArchivo("archivos/Clientes.dat");
    		ManejoDeArchivos.guardarClientes(clienteEncontrado, "archivos/Clientes.dat");
			ManejoDeArchivos.eliminarContenidoArchivo("archivos/Solicitudes.dat");
			ManejoDeArchivos.guardarSolicitudes(solicitud, "archivos/Solicitudes.dat");
			JOptionPane.showMessageDialog(null, "¡Solicitud enviado con exito!");
			regresarAlMenuCliente();
		}
	}

	public void sbackground() {
		try {
			ImageIcon imagen = new ImageIcon(getClass().getResource("/imagen/Fondo_Predeterminado.png"));
			JLabel f = new JLabel();
			f.setBounds(0, 0, 1400, 800);
			f.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH)));
			fondo.add(f);
		} catch (Exception e) {
			System.out.println("Error al cargar la imagen: " + e.getMessage());
		}
	}

}
