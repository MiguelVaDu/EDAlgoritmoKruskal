package interfazCliente.gui;

import javax.swing.*;

import utilidad.CargaImagen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algoritmo.*;
import utilidad.*;

public class PantallaMostrarConexionCliente {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Formato formato;
    // -------BOTONES-----------------
    private Boton regresar;
    // ---TEXTO----------------
    JLabel label = new JLabel();
    JLabel titulo = new JLabel();
    JLabel imagenFondo = new JLabel();
    JLabel conexion = new JLabel();

    public PantallaMostrarConexionCliente(JFrame ventana) {
        fondo = new JPanel();
        this.ventana = ventana;
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
        titulo();
        btn_regresarAlMenuCliente();
        mostrarConexionesAlCliente();
        cuadro();
        sbackground();
        cargarFondo();
        ventana.add(fondo);
    }
    
    private void cargarFondo() {
    	imagenFondo = new JLabel();
    	imagenFondo.setBounds(0,0,WIDTH,HEIGHT);
    	CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
    	fondo.add(imagenFondo);
    }

    // ------FUNCION PARA QUE APARESCA EL ARBOL DE EXPANSIÓN MÍNIMA-----

    public void mostrarConexionesAlCliente() {
        Grafo<Nodo> grafo = new Grafo<>();
        conexion.setBounds(400, 100, 900, 600);
        grafo = ManejoDeArchivos.recuperarGrafo("archivos/Grafo.dat");
        Grafo<Nodo> aem = new Grafo<>();
        Kruskal<Nodo> algoritmo = new Kruskal<>(grafo);
        aem = algoritmo.obtenerArbolExpansionMinima();
        DibujarGrafo grafico = new DibujarGrafo(aem);
        grafico.setBounds(0, 0, conexion.getWidth(), conexion.getHeight());
        grafico.setGrafo(aem);
        conexion.add(grafico);
        fondo.add(conexion);
    }

    // ------------------------TEXTOS------------------------------------
    public void titulo() {
        titulo = new JLabel();
        formato = new Formato();
        titulo.setBounds(30, 0, 680, 60);
        formato.formato(titulo, 0, 28);
        titulo.setForeground(Color.WHITE);
        titulo.setText("Conexiones");
        fondo.add(titulo);
    }
    // ---------------BOTONES-------------------------

    public void btn_regresarAlMenuCliente() {
        regresar = new Boton();
        formato = new Formato();
        regresar.setBounds(10, 650, (int) (WIDTH * 5 / 17) - 100, (int) (HEIGHT * 7 / 72));
        formato.formato(regresar, 0, 24, 70, 2);
        regresar.setText("Regresar");
        regresar.addActionListener(e -> {
            regresarAlMenuCliente();
        });
        fondo.add(regresar);
    }

    // --------FUNCION PARA EL BOTON------------------

    public void regresarAlMenuCliente() {
        ventana.remove(fondo);
        PantallaOpcionesCliente c = new PantallaOpcionesCliente(ventana);
    }

    public void cuadro() {
        //label.setOpaque(true); // Establece la propiedad "opaque" en true para que se pueda ver el fondo blanco
        label.setBackground(Color.WHITE); // Establece el fondo del JLabel en blanco
        //label.setEnabled(false);
        //label.setBounds(350, 50, 1000, 700);
        label.setBounds(400, 100, 880, 600);
        CargaImagen.setImagen(label, "ED_Calle.png");
        fondo.add(label);
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
