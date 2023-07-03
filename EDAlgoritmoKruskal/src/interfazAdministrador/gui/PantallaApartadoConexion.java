package interfazAdministrador.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algoritmo.Grafo;
import algoritmo.Nodo;
import utilidad.CargaImagen;
import utilidad.DibujarGrafo;
import utilidad.Formato;
import utilidad.ManejoDeArchivos;

public class PantallaApartadoConexion {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Formato formato;

    private Grafo<Nodo> grafo = new Grafo<>();
    // -------BOTONES-----------------
    JButton btn_regresarMenuAdministrador = new JButton("Regresar");
    JLabel botonRegresar = new JLabel();
    // ------------FONDO---------------
    JLabel imagenFondo = new JLabel();

    JLabel cuadro = new JLabel();

    // -----------TEXTO----------------
    JLabel texto1 = new JLabel();
    JLabel texto2 = new JLabel();

    public PantallaApartadoConexion(JFrame ventana) {
        fondo = new JPanel();
        this.ventana = ventana;
        grafo = ManejoDeArchivos.recuperarGrafo("archivos/Grafo.dat");
        configVentana();

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
        fondo.setLayout(null);
        fondo.setBackground(Color.decode("#17222E"));
        ventana.getContentPane().repaint();
        ventana.getContentPane().revalidate();
        sbackground(); //
        mostrarCalle();
        btn_regresarMenuAdministrador();
        titulo1();
        titulo2();
        cargarCuadro();

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

    public void cargarCuadro() {
        cuadro.setOpaque(true);
        cuadro.setBounds(400, 100, 880, 600);
        cuadro.setBackground(Color.WHITE);
        CargaImagen.setImagen(cuadro, "ED_Calle.png");
        fondo.add(cuadro);
    }

    // ------FUNCION PARA QUE APARESCA EL EL GRAFO(CALLE)--------

    public void mostrarCalle() {
        JLabel conexion = new JLabel();
        conexion.setBounds(400, 100, 900, 600);
        DibujarGrafo grafico = new DibujarGrafo(grafo);
        grafico.setBounds(0, 0, conexion.getWidth(), conexion.getHeight());
        grafico.setGrafo(grafo);
        conexion.add(grafico);
        fondo.add(conexion);

    }

    // ------------------------TEXTOS------------------------------------
    public void titulo1() {
        texto1 = new JLabel();
        formato = new Formato();
        texto1.setBounds(480, 15, 1000, 35);
        formato.formato(texto1, 0, 60);
        texto1.setForeground(Color.WHITE);
        texto1.setText("Administrador");
        fondo.add(texto1);
    }

    public void titulo2() {
        texto2 = new JLabel();
        formato = new Formato();
        texto2.setBounds(550, 50, 800, 35);
        formato.formato(texto2, 0, 30);
        texto2.setForeground(Color.WHITE);
        texto2.setText("Consultar Calles");
        fondo.add(texto2);
    }
    
    public void sbackground() {
		try {
			ImageIcon imagen = new ImageIcon(getClass().getResource("imagen/Fondo_Predeterminado.png"));
			JLabel f = new JLabel();
			f.setBounds(0, 0, 1400, 800);
			f.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH)));
			fondo.add(f);
		} catch (Exception e) {
			System.out.println("Error al cargar la imagen: " + e.getMessage());
		}
	}

    // --------------------------------------------------------------------
    // ------------------------------BOTONES-------------------------------

    public void btn_regresarMenuAdministrador() {
        botonRegresar.setBounds(40, 605, 110, 110);
        CargaImagen.setImagen(botonRegresar, "Cerrar.png");
        botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                regresarAlMenuAdministrador();
            }
        });
        fondo.add(botonRegresar);
    }

    // ------------------------------------------------------
    // ------FUNCIONES PARA LOS BOTONES----------------------

    public void regresarAlMenuAdministrador() {
        ventana.remove(fondo);
        PantallaOpcionesAdministrador c = new PantallaOpcionesAdministrador(ventana);
    }

}
