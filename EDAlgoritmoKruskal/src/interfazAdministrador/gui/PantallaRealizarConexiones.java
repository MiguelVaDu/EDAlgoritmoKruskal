package interfazAdministrador.gui;
/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utilidad.ManejoDeArchivos;
import algoritmo.Grafo;
import algoritmo.Nodo;
import utilidad.DibujarGrafo;
import utilidad.CargaImagen;
import utilidad.Formato;

public class PantallaRealizarConexiones {
    private JFrame ventana;
    private JPanel fondo;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    private Grafo<Nodo> grafo = null;
    private Formato formato;
    private JLabel conexion = new JLabel();
    private Stack<Nodo> pila = new Stack<>();
    DibujarGrafo grafico;
    //-------BOTONES-----------------
    JLabel botonRegresar = new JLabel();
    //------------FONDO---------------
    JLabel imagenFondo = new JLabel();
    //------------LOGO----------------
    JLabel logo = new JLabel();
    
    public PantallaRealizarConexiones(JFrame ventana){
        fondo = new JPanel(); 
        formato = new Formato();
        this.ventana = ventana;
        grafo = ManejoDeArchivos.recuperarGrafo("archivos/Grafo.dat");
        configVentana();
    }

    public void configVentana(){

    	ventana.repaint();
		ventana.setSize(1400, 800);
		ventana.setTitle("KRUKAL-UNMSM");
		ventana.setLocationRelativeTo(null);
        configComponentes();
    }

    public void configComponentes(){
    	fondo.setLayout(null);
        fondo.setBackground(Color.WHITE);
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
		asignarBotonesParaQuitar();
		mostrarCalle();
		imagenFondo();
    	botonRegresar();
    	logo();
        cargarFondo();
        ventana.add(fondo);

    }
  //------------------------LOGO--------------------------------------
    public void logo() {
    	logo.setBounds(1220, 600, 110, 110);
    	CargaImagen.setImagen(logo, "Logo.png");
    	fondo.add(logo);
    }
    
  //------------------------FONDO-------------------------------------
    public void cargarFondo() {
    	imagenFondo = new JLabel();
    	imagenFondo.setBounds(0,0,WIDTH,HEIGHT);
    	CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
    	fondo.add(imagenFondo);
    }

    //-------------BOTONES-------------------------

    public void botonRegresar() {
    	botonRegresar.setBounds(40, 605, 110, 110);
    	CargaImagen.setImagen(botonRegresar, "Cerrar.png");
    	botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	regresarAlMenuAdministrador();
            }
        });
    	fondo.add(botonRegresar);
    }
    
    private void imagenFondo() {
    	CargaImagen.setImagen(conexion, "ED_Calle.png");
    	fondo.add(conexion);
    }
    
    private void mostrarCalle(){
    	conexion.setBounds(400,100,900,600);
        grafico = new DibujarGrafo(grafo);
        grafico.setBounds(400,100,conexion.getWidth(), conexion.getHeight());
		grafico.setGrafo(grafo);
		fondo.add(grafico);
        fondo.add(conexion);
    }
    
    //-----------INTERACTUAR CON LOS NODOS------------------
    private void asignarBotonesParaQuitar() {
    	for(Nodo nodos : grafo.getNodos()) {
    		JButton NodoConBoton = new JButton();
    		NodoConBoton.setBackground(Color.CYAN);
    		NodoConBoton.setPreferredSize(new Dimension(20,20));
    		NodoConBoton.setBounds(nodos.getCoordenada_X()-10, nodos.getCoordenada_Y()-10, 20,20);
    		NodoConBoton.addActionListener(e -> {
    			Nodo i;
    			i=tomarNodo(NodoConBoton);
    			pila.push(i);
    			if(pila.size()==2){
   					interactuarNodos(pila.pop(),pila.pop());
 				}
    		});
    		conexion.add(NodoConBoton);
    	}
    }
    
    private Nodo tomarNodo(JButton seleccionado) {
		for(Nodo n : grafo.getNodos()) {
			if(seleccionado.getX()==n.getCoordenada_X()-10 && seleccionado.getY()==n.getCoordenada_Y()-10) {
				System.out.println(n.getNombre());
				return n;
			}
		}
		return null;
	}
    
    private void interactuarNodos(Nodo n1, Nodo n2) {
    	if(grafo.sonAdyacentes(n1, n2)) {
    		System.out.println("SON ADYACENTES");
    		destruirArista(n1,n2);
    	}else if (!grafo.sonAdyacentes(n1, n2)){
    		System.out.println("NO SON ADYACENTES");
    		construirArista(n1,n2);
    	}
    }
    
    private void construirArista(Nodo n1, Nodo n2) {
    	fondo.remove(conexion);
    	JOptionPane.showMessageDialog(null, "¡Arista creada con exito!");
    	grafo.agregarArista(n1, n2);
    	mostrarCalle();
		imagenFondo();
		fondo.revalidate();
		fondo.repaint();
		ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
		ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
    }
    
    public void destruirArista(Nodo n1, Nodo n2) {
    	fondo.remove(conexion);
    	fondo.remove(grafico);
    	JOptionPane.showMessageDialog(null, "¡Arista eliminada con exito!");
    	grafo.eliminarArista(n1, n2);
    	mostrarCalle();
    	fondo.add(grafico);
		imagenFondo();
		fondo.revalidate();
		fondo.repaint();
		ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
		ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
    }

    //------------------------------------------------------
    //------FUNCIONES PARA LOS BOTONES----------------------

    public void regresarAlMenuAdministrador(){
        ventana.remove(fondo);
        PantallaOpcionesAdministrador c = new PantallaOpcionesAdministrador(ventana);
    }

}*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algoritmo.Grafo;
import algoritmo.Nodo;
import utilidad.CargaImagen;
import utilidad.DibujarGrafo;
import utilidad.ManejoDeArchivos;

public class PantallaRealizarConexiones {
    private JFrame ventana;
    private JPanel fondo;
    private Grafo<Nodo> grafo = null;
    private JLabel conexion = new JLabel();
    //private JButton NodoConBoton;
    private Stack<Nodo> pila = new Stack<>();
    private JLabel imagenFondo = new JLabel();
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    DibujarGrafo grafico;
    //-------BOTONES-----------------
    JButton btn_regresarMenuAdministrador = new JButton("Regresar");
    
    public PantallaRealizarConexiones(JFrame ventana){
        fondo = new JPanel(); 
        this.ventana = ventana;
        grafo = ManejoDeArchivos.recuperarGrafo("archivos/Grafo.dat");
        configVentana();
        
    }

    public void configVentana(){
        ventana.repaint();
		ventana.setSize(1400, 800);
		ventana.setTitle("KRUKAL-UNMSM");
		ventana.setLocationRelativeTo(null);
        configComponentes();
    }

    public void configComponentes(){
        fondo.setLayout(null);
        fondo.setBackground(Color.decode("#17222E"));
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
		sbackground();
		asignarBotonesParaQuitar();
		mostrarCalle();
		imagenFondo();
        btn_regresarMenuAdministrador(btn_regresarMenuAdministrador);
        ventana.add(fondo);
    }
    
    public void mostrarCalle(){
        conexion.setBounds(400,100,900,600);
        grafico = new DibujarGrafo(grafo);
        grafico.setBounds(400,100,conexion.getWidth(), conexion.getHeight());
		grafico.setGrafo(grafo);
		fondo.add(grafico);
        fondo.add(conexion);
    }
    
    private void imagenFondo() {
    	CargaImagen.setImagen(conexion, "ED_Calle.png");
    	fondo.add(conexion);
    }
    
    public void cargarFondo() {
    	imagenFondo = new JLabel();
    	imagenFondo.setBounds(0,0,WIDTH,HEIGHT);
    	CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
    	fondo.add(imagenFondo);
    }
    
    public void asignarBotonesParaQuitar() {
    	for(Nodo nodos : grafo.getNodos()) {
    		JButton NodoConBoton = new JButton();
    		NodoConBoton.setBackground(Color.CYAN);
    		NodoConBoton.setPreferredSize(new Dimension(20,20));
    		NodoConBoton.setBounds(nodos.getCoordenada_X()-10, nodos.getCoordenada_Y()-10, 20,20);
    		NodoConBoton.addActionListener(e -> {
    			Nodo i;
    			i=tomarNodo(NodoConBoton);
    			pila.push(i);
    			if(pila.size()==2){
   					interactuarNodos(pila.pop(),pila.pop());
 				}
    		});
    		conexion.add(NodoConBoton);
    	}
    }
    
    public Nodo tomarNodo(JButton seleccionado) {
		for(Nodo n : grafo.getNodos()) {
			if(seleccionado.getX()==n.getCoordenada_X()-10 && seleccionado.getY()==n.getCoordenada_Y()-10) {
				System.out.println(n.getNombre());
				return n;
			}
		}
		return null;
	}
    
    public void interactuarNodos(Nodo n1, Nodo n2) {
    	if(grafo.sonAdyacentes(n1, n2)) {
    		System.out.println("SON ADYACENTES");
    		destruirArista(n1,n2);
    	}else if (!grafo.sonAdyacentes(n1, n2)){
    		System.out.println("NO SON ADYACENTES");
    		construirArista(n1,n2);
    	}
    }
    
    public void construirArista(Nodo n1, Nodo n2) {
    	fondo.remove(conexion);
    	fondo.remove(grafico);
    	JOptionPane.showMessageDialog(null, "¡Arista creada con exito!");
    	grafo.agregarArista(n1, n2);
    	mostrarCalle();
		imagenFondo();
		fondo.revalidate();
		fondo.repaint();
		ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
		ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
    }
    
    public void destruirArista(Nodo n1, Nodo n2) {
    	fondo.remove(conexion);
    	fondo.remove(grafico);
    	conexion.remove(grafico);
    	JOptionPane.showMessageDialog(null, "¡Arista eliminada con exito!");
    	grafo.eliminarArista(n1, n2);
    	mostrarCalle();
    	fondo.add(grafico);
		imagenFondo();
		fondo.revalidate();
		fondo.repaint();
		ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
		ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
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

    //-------------BOTONES-------------------------

    public void btn_regresarMenuAdministrador(JButton btn){
        btn.setBounds(90, 620, 70, 90);
		btn.setOpaque(true);
		btn.addActionListener(e -> {
			regresarAlMenuAdministrador();
	    });
		fondo.add(btn);
    }

    //------------------------------------------------------
    //------FUNCIONES PARA LOS BOTONES----------------------

    public void regresarAlMenuAdministrador(){
        ventana.remove(fondo);
        PantallaOpcionesAdministrador c = new PantallaOpcionesAdministrador(ventana);
    }

}
