package interfazCliente.gui;

import javax.swing.*;

import entidad.Cliente;
import entidad.Usuario;
import utilidad.CargaImagen;
import utilidad.Formato;
import utilidad.ManejoDeArchivos;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PantallaMostrarInformacionCliente {
	private JFrame ventana;
	private JPanel fondo;
	private JLabel tituloLabel, nombreLabel, dniLabel, telefonoLabel, correoLabel, contraseniaLabel, idLabel;
	private JTextField nombreField, dniField, telefonoField, correoField, contraseniaField, idField;
	private Formato formato;
	private final int WIDTH = 1400;
	private final int HEIGHT = 800;
	JLabel imagenFondo = new JLabel();
	JLabel botonRegresar = new JLabel();
	List<Usuario> usuario = new ArrayList<>();
	Usuario usu = new Usuario();
	Cliente cli = null;
	List<Cliente> clienteEncontrado = new ArrayList<>();
	// ---LOGO-----------------
    JLabel logo = new JLabel();
	// -------BOTONES-----------------
	JButton btn_regresarAlMenuCliente = new JButton("Regresar");

	public PantallaMostrarInformacionCliente(JFrame ventana) {
		fondo = new JPanel();
		this.ventana = ventana;
		formato = new Formato();
		usuario = ManejoDeArchivos.recuperarUsuario("archivos/Usuarios.dat");
		usu = usuario.get(0);
		clienteEncontrado = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
		configVentana();

	}

	public void initTitulo() {
		tituloLabel = new JLabel("INFORMACIÓN PERSONAL");
		tituloLabel.setBounds((int) (WIDTH * 0.24), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.60),
				(int) (HEIGHT * 0.055));
		formato.formato(tituloLabel, 1, (float) (HEIGHT * 0.060));
		fondo.add(tituloLabel);
		for (Cliente c : clienteEncontrado) {
			if (c.getCorreo().equals(usu.getCorreo()) && c.getContrasena().equals(usu.getContrasena())) {
				cli = c;
			}
		}
	}
	
	private void cargarFondo() {
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
        CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
        fondo.add(imagenFondo);
    }

	public void initNombre() {
		nombreLabel = new JLabel("NOMBRE");
		nombreLabel.setBounds((int) (WIDTH * 0.60), (int) (HEIGHT * 0.20), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(nombreLabel);

		nombreField = new JTextField();
		nombreField.setBounds((int) (nombreLabel.getX() + WIDTH * 0.025),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (nombreLabel.getHeight()));
		formato.formato(nombreField, 0, (float) (HEIGHT * 0.035));
		nombreField.setText(cli.getNombreComp());
		nombreField.setEditable(false);
		nombreField.setFocusable(false);
		fondo.add(nombreField);
	}

	public void initdni() {
		dniLabel = new JLabel("DOCUMENTO DE IDENTIDAD");
		dniLabel.setBounds((int) (WIDTH * 0.60), (int) (HEIGHT * 0.35), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(dniLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(dniLabel);

		dniField = new JTextField();
		dniField.setBounds((int) (dniLabel.getX() + WIDTH * 0.025),
				(int) (dniLabel.getY() + dniLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (dniLabel.getHeight()));
		formato.formato(dniField, 0, (float) (HEIGHT * 0.035));
		dniField.setText(cli.getDni());
		dniField.setEditable(false);
		dniField.setFocusable(false);
		fondo.add(dniField);
	}

	public void inittelefono() {
		telefonoLabel = new JLabel("TELEFONO");
		telefonoLabel.setBounds((int) (WIDTH * 0.60), (int) (HEIGHT * 0.50), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(telefonoLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(telefonoLabel);

		telefonoField = new JTextField();
		telefonoField.setBounds((int) (telefonoLabel.getX() + WIDTH * 0.025),
				(int) (telefonoLabel.getY() + telefonoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (telefonoLabel.getHeight()));
		formato.formato(telefonoField, 0, (float) (HEIGHT * 0.035));
		telefonoField.setText(cli.getTelefono());
		telefonoField.setEditable(false);
		telefonoField.setFocusable(false);
		fondo.add(telefonoField);
	}

	public void initCorreo() {
		correoLabel = new JLabel("CORREO ELECTRONICO");
		correoLabel.setBounds((int) (WIDTH * 0.18), (int) (HEIGHT * 0.50), (int) (WIDTH * 0.80),
				(int) (HEIGHT * 0.055));
		formato.formato(correoLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(correoLabel);

		correoField = new JTextField();
		correoField.setBounds((int) (correoLabel.getX() + WIDTH * 0.025),
				(int) (correoLabel.getY() + correoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (correoLabel.getHeight()));
		formato.formato(correoField, 0, (float) (HEIGHT * 0.030));
		correoField.setText(cli.getCorreo());
		correoField.setEditable(false);
		correoField.setFocusable(false);
		fondo.add(correoField);
	}

	public void initContrasenia() {
		contraseniaLabel = new JLabel("CONTRASEÑA");
		contraseniaLabel.setBounds((int) (WIDTH * 0.18), (int) (HEIGHT * 0.65), (int) (WIDTH * 0.80),
				(int) (HEIGHT * 0.055));
		formato.formato(contraseniaLabel, 1, (float) (HEIGHT * 0.030));
		fondo.add(contraseniaLabel);

		contraseniaField = new JTextField();
		contraseniaField.setBounds((int) (contraseniaLabel.getX() + WIDTH * 0.025),
				(int) (contraseniaLabel.getY() + contraseniaLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (contraseniaLabel.getHeight()));
		formato.formato(contraseniaField, 0, (float) (HEIGHT * 0.035));
		contraseniaField.setText(cli.getContrasena());
		contraseniaField.setEditable(false);
		contraseniaField.setFocusable(false);
		fondo.add(contraseniaField);
	}

	public void initId() {
		idLabel = new JLabel("ID");
		idLabel.setBounds((int) (WIDTH * 0.60), (int) (HEIGHT * 0.65), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(idLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(idLabel);

		idField = new JTextField();
		idField.setBounds((int) (idLabel.getX() + WIDTH * 0.025),
				(int) (idLabel.getY() + idLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (idLabel.getHeight()));
		formato.formato(idField, 0, (float) (HEIGHT * 0.035));
		idField.setText(Integer.toString(cli.getN().getId()));
		idField.setEditable(false);
		idField.setFocusable(false);
		fondo.add(idField);
	}

	public void configVentana() {
		ventana.repaint();
		ventana.setSize(1400, 800);
		ventana.setTitle("KRUKAL-UNMSM");
		ventana.setLocationRelativeTo(null);
		configComponentes();
	}

	public void configComponentes() {
		fondo.setLayout(null);
		fondo.setBackground(Color.ORANGE);
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
		initTitulo();
		initNombre();
		initdni();
		inittelefono();
		initCorreo();
		initContrasenia();
		initId();
		botonRegresar();
		logo();
		cargarFondo();
		ventana.add(fondo);
	}
	// ---------------LOGO-------------------------
	public void logo() {
        logo = new JLabel();
        logo.setBounds(350, 150, 250, 250);
        CargaImagen.setImagen(logo, "Logo.png");
        fondo.add(logo);
    }
	
	
	// ---------------BOTONES-------------------------

	
	public void botonRegresar() {
        botonRegresar.setBounds(40, 605, 110, 110);
        CargaImagen.setImagen(botonRegresar, "Cerrar.png");
        botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	regresarAlMenuCliente();
            }
        });
        fondo.add(botonRegresar);
    }

	// --------FUNCION PARA EL BOTON------------------

	public void regresarAlMenuCliente() {
		ventana.remove(fondo);
		PantallaOpcionesCliente c = new PantallaOpcionesCliente(ventana);
	}

}
