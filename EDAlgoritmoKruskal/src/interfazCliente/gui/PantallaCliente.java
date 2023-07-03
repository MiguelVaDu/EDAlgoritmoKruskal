package interfazCliente.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.Usuario;

import interfazInicio.gui.PantallaInicio;

import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;
import utilidad.ManejoDeArchivos;

public class PantallaCliente {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Formato formato;
    // ---------BOTONES----------------
    private Boton botonOpcionCliente;
    private Boton botonAgregarCliente;
    JLabel botonRegresar = new JLabel();
    JButton btn_ClienteOpciones = new JButton("Cliente opciones");
    JButton btn_AgregarCliente = new JButton("Agregar cliente");
    // -------CUADRO DE TEXTO----------
    JTextField txtCorreoElectro = new JTextField("example@hotmail.com");
    JTextField txtContrasenia = new JPasswordField("********");
    // ------------FONDO---------------
    JLabel imagenFondo = new JLabel();
    // ------------LOGO----------------
    JLabel logo = new JLabel();
    // -----------TEXTO----------------
    JLabel texto1 = new JLabel();
    JLabel texto2 = new JLabel();
    JLabel texto3 = new JLabel();
    JLabel texto4 = new JLabel();
    JLabel texto5 = new JLabel();

    public PantallaCliente(JFrame ventana) {
        fondo = new JPanel();
        this.ventana = ventana;
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

        botonOpcionCliente();
        botonAgregarCliente();
        botonRegresar();
        campo_Texto();
        titulo1();
        titulo2();
        tituloCorreo();
        tituloContrasenia();
        preguntaCliente();
        logo();
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
        logo.setBounds(1220, 600, 110, 110);
        CargaImagen.setImagen(logo, "Logo.png");
        fondo.add(logo);
    }

    // ------------------------TEXTOS------------------------------------
    public void titulo1() {
        texto1 = new JLabel();
        formato = new Formato();
        texto1.setBounds(220, 30, 1000, 35);
        formato.formato(texto1, 0, 50);
        texto1.setForeground(Color.WHITE);
        texto1.setText("BIENVENIDO CLIENTE E-KRUSKAL");
        fondo.add(texto1);
    }

    public void titulo2() {
        texto2 = new JLabel();
        formato = new Formato();
        texto2.setBounds(450, 110, 800, 35);
        formato.formato(texto2, 0, 48);
        texto2.setForeground(Color.WHITE);
        texto2.setText("INICIO DE SESIÓN");
        fondo.add(texto2);
    }

    public void tituloCorreo() {
        texto3 = new JLabel();
        formato = new Formato();
        texto3.setBounds(400, 200, 600, 35);
        formato.formato(texto3, 0, 40);
        texto3.setForeground(Color.WHITE);
        texto3.setText("Correo Electrónico:");
        fondo.add(texto3);
    }

    public void tituloContrasenia() {
        texto4 = new JLabel();
        formato = new Formato();
        texto4.setBounds(400, 300, 600, 35);
        formato.formato(texto4, 0, 40);
        texto4.setForeground(Color.WHITE);
        texto4.setText("Contraseña:");
        fondo.add(texto4);
    }

    public void preguntaCliente() {
        texto5 = new JLabel();
        formato = new Formato();
        texto5.setBounds(570, 500, 600, 35);// 464, 428, 468, 65
        formato.formato(texto5, 0, 22);
        texto5.setForeground(Color.WHITE);
        texto5.setText("¿Es tu primera vez?");
        fondo.add(texto5);
    }

    // ----------FUNCIONES PARA EL TEXTO------------------------
    public void campo_Texto() {
        // Campo del nombre
        txtCorreoElectro.setBounds(400, 241, 600, 35);
        txtCorreoElectro.setBorder(null);
        txtCorreoElectro.setHorizontalAlignment(SwingConstants.CENTER);
        txtCorreoElectro.setText("example@hotmail.com");
        txtCorreoElectro.setForeground(Color.decode("#073F82"));
        fondo.add(txtCorreoElectro);

        txtCorreoElectro.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtCorreoElectro.getText().equals("example@hotmail.com")) {
                    txtCorreoElectro.setText("");
                    txtCorreoElectro.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtCorreoElectro.getText().isEmpty()) {
                    txtCorreoElectro.setText("example@hotmail.com");
                    txtCorreoElectro.setForeground(Color.decode("#073F82"));
                }
            }
        });

        Font font = txtCorreoElectro.getFont();
        Font newFont = font.deriveFont(font.getSize() + 10f); // Aumentar en 10 puntos
        txtCorreoElectro.setFont(newFont);

        // Campo contraseña
        txtContrasenia.setBounds(400, 341, 600, 35);
        txtContrasenia.setBorder(null);
        txtContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        txtContrasenia.setText("********");
        txtContrasenia.setForeground(Color.decode("#073F82"));
        fondo.add(txtContrasenia);

        txtContrasenia.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtContrasenia.getText().equals("********")) {
                    txtContrasenia.setText("");
                    txtContrasenia.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtContrasenia.getText().isEmpty()) {
                    txtContrasenia.setText("********");
                    txtContrasenia.setForeground(Color.decode("#073F82"));
                }
            }
        });

        Font font2 = txtContrasenia.getFont();
        Font newFont2 = font2.deriveFont(font2.getSize() + 10f); // Aumentar en 5 puntos
        txtContrasenia.setFont(newFont2);
    }

    public void verificarClientes() {
        List<Cliente> u = new ArrayList<>();
        List<Usuario> m = new ArrayList<>();
        u = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
        for (Cliente us : u) {
            if (txtCorreoElectro.getText().equals(us.getCorreo())
                    && txtContrasenia.getText().equals(us.getContrasena())) {
                Usuario usuEncontrado = new Usuario(txtCorreoElectro.getText(), txtContrasenia.getText());
                m.add(usuEncontrado);
                System.out.println(us.getNombreComp());
                ManejoDeArchivos.eliminarContenidoArchivo("archivos/Usuarios.dat");
                ManejoDeArchivos.guardarUsuario(m, "archivos/Usuarios.dat");
                mostrarOpcionesCliente();
            }
        }
        txtCorreoElectro.setText("example@hotmail.com");
        txtCorreoElectro.setForeground(Color.decode("#073F82"));
        txtContrasenia.setText("********");
        txtContrasenia.setForeground(Color.decode("#073F82"));
    }

    // -------------------------------------------------------------
    // ---------------BOTONES---------------------------------------

    public void botonRegresar() {
        botonRegresar.setBounds(40, 605, 110, 110);
        CargaImagen.setImagen(botonRegresar, "Cerrar.png");
        botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                mostrarPantallaInicio();
            }
        });
        fondo.add(botonRegresar);
    }

    public void botonOpcionCliente() {
        botonOpcionCliente = new Boton();
        formato = new Formato();
        botonOpcionCliente.setBounds(464, 415, 468, 65);
        formato.formato(botonOpcionCliente, 0, 24, 70, 2);
        botonOpcionCliente.setText("Ingresar");
        botonOpcionCliente.addActionListener(e -> {
            verificarClientes();
        });
        fondo.add(botonOpcionCliente);
    }

    public void botonAgregarCliente() {
        botonAgregarCliente = new Boton();
        formato = new Formato();
        botonAgregarCliente.setBounds(464, 535, 468, 65);
        formato.formato(botonAgregarCliente, 0, 24, 70, 2);
        botonAgregarCliente.setText("Registrarse como Cliente");
        botonAgregarCliente.addActionListener(e -> {
            mostrarPantallaNuevoCliente();
        });
        fondo.add(botonAgregarCliente);
    }

    // -------------------------------------------------------------
    // ----------FUNCIONES PARA LOS BOTONES-------------------------

    public void mostrarPantallaInicio() {
        ventana.remove(fondo);
        PantallaInicio c = new PantallaInicio(ventana);
        System.out.println("Volviendo a la pantalla incial");
    }

    public void mostrarOpcionesCliente() {
        ventana.remove(fondo);
        PantallaOpcionesCliente c = new PantallaOpcionesCliente(ventana);
    }

    public void mostrarPantallaNuevoCliente() {
        ventana.remove(fondo);
        PantallaNuevoCliente c = new PantallaNuevoCliente(ventana);
    }

    // ----------------------------------------------------------------
}
