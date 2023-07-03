package interfazCliente.gui;
/*
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import algoritmo.Grafo;
import algoritmo.Nodo;
import entidad.Cliente;
import utilidad.DibujarGrafo;
import utilidad.ManejoDeArchivos;
import interfazInicio.gui.PantallaInicio;
import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;

public class PantallaNuevoCliente {
    private JFrame ventana;
    private JPanel fondo, fondoAUX;
    private Formato formato = new Formato();
	private Grafo<Nodo> grafo = new Grafo<>();
	private boolean casaSelecionada=false;
	private Nodo nuevoNodo;
	private int coordenadaX,coordenadaY;
	
	JTextField txtNombreComp,txtDni,txtCorreo,txtTelefono,txtContrasena,txtConfirmarContra;
    
    JLabel logo = new JLabel();
    
    //---------BOTONES---------------
    Boton btn_verVivienda = new Boton();
    Boton btn_aniadirServicio = new Boton();
    JLabel btn_Regresar = new JLabel();
    
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    //------------------------------
    public PantallaNuevoCliente(JFrame ventana){
        fondo = new JPanel(); 
        this.ventana = ventana;
        configVentana();
    }

    private void configVentana() {
        ventana.repaint();
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setTitle("KRUKAL-UNMSM");
		ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
        configComponentes();
	}

    private void configComponentes(){
        fondo.setLayout(null);
        fondo.setBackground(Color.BLACK);
        ventana.add(fondo);
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
		titulo();
		logo();
		textField_NombreComp();
		textField_Dni();
		textField_Correo();
		textField_Telefono();
		textField_Contrasena();
		textField_ConfirmarContra();
		btn_SeleccionarVivienda();
		btn_AgregarServicio();
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
		JLabel Text = new JLabel("REGISTRESE COMO NUEVO CLIENTE");
		Text.setHorizontalAlignment(JLabel.CENTER);
		Text.setBounds(70, (int)(HEIGHT*0.09), 1260, (int)(HEIGHT*0.1));
		formato.formato(Text, 0, (int)(WIDTH*0.04));
        fondo.add(Text);
    }
    
    public void logo() {
    	logo.setBounds(1150, 605, 110, 110);
    	CargaImagen.setImagen(logo, "Logo.png");
    	fondo.add(logo);
    }
    
    public void textField_NombreComp() {
    	txtNombreComp = new JTextField();
		txtNombreComp.setBounds((int)(WIDTH*0.35), (int)(HEIGHT*0.25), (int)(WIDTH*0.25), (int)(HEIGHT*0.03));
		formato.formato(txtNombreComp, 0, (int)(WIDTH*0.01));
		txtNombreComp.setEditable(true);
		txtNombreComp.setFocusable(true);
        fondo.add(txtNombreComp);
        
        Font font1 = txtNombreComp.getFont();
        Font newFont1 = font1.deriveFont(font1.getSize() + 5f);
        txtNombreComp.setFont(newFont1);
        
        JLabel txt = new JLabel("NOMBRE COMPLETO:");
		txt.setHorizontalAlignment(JLabel.RIGHT);
		txt.setBounds((int)(WIDTH*0.045), (int)(HEIGHT*0.25), (int)(WIDTH*0.3), (int)(HEIGHT*0.03));
		formato.formato(txt, 0, (int)(WIDTH*0.0175));
        fondo.add(txt);
	}
    
    public void textField_Dni() {
    	txtDni = new JTextField();
		txtDni.setBounds((int)(WIDTH*0.35), (int)(HEIGHT*0.32), (int)(WIDTH*0.25), (int)(HEIGHT*0.03));
		formato.formato(txtDni, 0, (int)(WIDTH*0.01));
		txtDni.setEditable(true);
		txtDni.setFocusable(true);
        fondo.add(txtDni);
        
        Font font2 = txtDni.getFont();
        Font newFont2 = font2.deriveFont(font2.getSize() + 5f);
        txtDni.setFont(newFont2);
        
        JLabel txt = new JLabel("DOCUMENTO DE IDENTIDAD:");
		txt.setHorizontalAlignment(JLabel.RIGHT);
		txt.setBounds((int)(WIDTH*0.045), (int)(HEIGHT*0.32), (int)(WIDTH*0.3), (int)(HEIGHT*0.03));
		formato.formato(txt, 0, (int)(WIDTH*0.0175));
        fondo.add(txt);
	}
    
    public void textField_Correo() {
    	txtCorreo = new JTextField();
		txtCorreo.setBounds((int)(WIDTH*0.35), (int)(HEIGHT*0.39), (int)(WIDTH*0.25), (int)(HEIGHT*0.03));
		formato.formato(txtCorreo, 0, (int)(WIDTH*0.01));
		txtCorreo.setEditable(true);
		txtCorreo.setFocusable(true);
        fondo.add(txtCorreo);
        
        Font font3 = txtCorreo.getFont();
        Font newFont3 = font3.deriveFont(font3.getSize() + 5f);
        txtCorreo.setFont(newFont3);
        
        JLabel txt = new JLabel("CORREO ELECTRÓNICO:");
		txt.setHorizontalAlignment(JLabel.RIGHT);
		txt.setBounds((int)(WIDTH*0.045), (int)(HEIGHT*0.39), (int)(WIDTH*0.3), (int)(HEIGHT*0.03));
		formato.formato(txt, 0, (int)(WIDTH*0.0175));
        fondo.add(txt);
	}
    
    public void textField_Telefono() {
    	txtTelefono = new JTextField();
		txtTelefono.setBounds((int)(WIDTH*0.35), (int)(HEIGHT*0.46), (int)(WIDTH*0.25), (int)(HEIGHT*0.03));
		formato.formato(txtTelefono, 0, (int)(WIDTH*0.01));
		txtTelefono.setEditable(true);
		txtTelefono.setFocusable(true);
        fondo.add(txtTelefono);
        
        Font font4 = txtTelefono.getFont();
        Font newFont1 = font4.deriveFont(font4.getSize() + 5f);
        txtTelefono.setFont(newFont1);
        
        JLabel txt = new JLabel("TELÉFONO:");
		txt.setHorizontalAlignment(JLabel.RIGHT);
		txt.setBounds((int)(WIDTH*0.045), (int)(HEIGHT*0.46), (int)(WIDTH*0.3), (int)(HEIGHT*0.03));
		formato.formato(txt, 0, (int)(WIDTH*0.0175));
        fondo.add(txt);
	}
    
    public void textField_Contrasena() {
    	txtContrasena = new JPasswordField();
		txtContrasena.setBounds((int)(WIDTH*0.35), (int)(HEIGHT*0.53), (int)(WIDTH*0.25), (int)(HEIGHT*0.03));
		formato.formato(txtContrasena, 0, (int)(WIDTH*0.01));
		txtContrasena.setEditable(true);
		txtContrasena.setFocusable(true);
        fondo.add(txtContrasena);
        
        Font font5 = txtContrasena.getFont();
        Font newFont5 = font5.deriveFont(font5.getSize() + 5f);
        txtContrasena.setFont(newFont5);
        
        JLabel txt = new JLabel("CONTRASEÑA:");
		txt.setHorizontalAlignment(JLabel.RIGHT);
		txt.setBounds((int)(WIDTH*0.045), (int)(HEIGHT*0.53), (int)(WIDTH*0.3), (int)(HEIGHT*0.03));
		formato.formato(txt, 0, (int)(WIDTH*0.0175));
        fondo.add(txt);
	}
    
    public void textField_ConfirmarContra() {
    	txtConfirmarContra = new JPasswordField();
		txtConfirmarContra.setBounds((int)(WIDTH*0.35), (int)(HEIGHT*0.6), (int)(WIDTH*0.25), (int)(HEIGHT*0.03));
		formato.formato(txtConfirmarContra, 0, (int)(WIDTH*0.01));
		txtConfirmarContra.setEditable(true);
		txtConfirmarContra.setFocusable(true);
        fondo.add(txtConfirmarContra);
        
        Font font6 = txtConfirmarContra.getFont();
        Font newFont6 = font6.deriveFont(font6.getSize() + 5f);
        txtConfirmarContra.setFont(newFont6);
        
        JLabel txt = new JLabel("CONFIRMAR CONTRASEÑA:");
		txt.setHorizontalAlignment(JLabel.RIGHT);
		txt.setBounds((int)(WIDTH*0.045), (int)(HEIGHT*0.6), (int)(WIDTH*0.3), (int)(HEIGHT*0.03));
		formato.formato(txt, 0, (int)(WIDTH*0.0175));
        fondo.add(txt);
	}

    //----------FUNCIONES PARA LOS BOTONES------------------------
    
    public void btn_Regreso() {
    	btn_Regresar.setBounds(150, 605, 110, 110);
    	CargaImagen.setImagen(btn_Regresar, "Cerrar.png");
    	btn_Regresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	mostrarPantallaDeInicio();
            }
        });
    	fondo.add(btn_Regresar);
    }
    
    public void btn_SeleccionarVivienda() {
		btn_verVivienda.setBounds((int)(WIDTH*9/14), (int)(HEIGHT*1/4), (int)(WIDTH*2/7), (int)(HEIGHT*1/8));
		formato.formato(btn_verVivienda, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		btn_verVivienda.setText("SELECCIONAR VIVIENDA");
		btn_verVivienda.addActionListener(e -> {
			mostrarMapaParaSeleccionarCasa();
	    });
		fondo.add(btn_verVivienda);
    }
    
    public void btn_AgregarServicio() {
		btn_aniadirServicio.setBounds((int)(WIDTH*9/14), (int)(HEIGHT*37/80), (int)(WIDTH*2/7), (int)(HEIGHT*1/8));
		formato.formato(btn_aniadirServicio, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		btn_aniadirServicio.setText("AGREGAR SERVICIO");
		btn_aniadirServicio.addActionListener(e -> {
			//funcion
	    });
		fondo.add(btn_aniadirServicio);
    }
    
    //------------------------------------------------------------
    public void mostrarMapaParaSeleccionarCasa() {
    	fondo.setVisible(false);
    	//--------------------------------------------
        JButton btn_SalirDelMapa = new JButton("MAPA");
        JLabel conexion = new JLabel();
    	//--------------------------------------------
    	fondoAUX.setLayout(null);
        fondoAUX.setBackground(Color.WHITE);
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
        mostrarCalleEnFondoAux(conexion, grafo);
        imagenFondo(conexion);
        ventana.add(fondoAUX);
        btn_SalirDelMapa(btn_SalirDelMapa);
        
        //--------------------------------------------
    }
    //------------------------------------------------------------
    //------------------------BOTONES-----------------------------
    
    public void btn_SalirDelMapa(JButton btn) {
    	btn.setBounds(90, 620, 70, 90); //1250 658 85 90
		btn.setOpaque(true);
		btn.addActionListener(e -> {
			salirDelMapa();
	    });
		fondoAUX.add(btn);
    }
    
    public void salirDelMapa() {
    	ventana.remove(fondoAUX);
    	fondo.setVisible(true);
    }
    
    public void mostrarCalleEnFondoAux(JLabel labelAux, Grafo<Nodo> grafo){
        labelAux.setBounds(400,100,900,600);
        DibujarGrafo grafico = new DibujarGrafo(grafo);
        grafico.setBounds(0,0,labelAux.getWidth(), labelAux.getHeight());
		grafico.setGrafo(grafo);
		labelAux.add(grafico);
		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Coordenada: ["+e.getX()+","+e.getY()+"]");
				coordenadaX=e.getX();
				coordenadaY=e.getY();
				JOptionPane.showMessageDialog(null,"Casa seleccionada");
				casaSelecionada=true;
				salirDelMapa();
			}
		};
		labelAux.addMouseListener(click);
        fondoAUX.add(labelAux);
    }
    
    public void crearNuevoClienteConSuNodo() {
    	nuevoNodo = new Nodo("A"+(grafo.getNodos().size()+1),grafo.getNodos().size(),coordenadaX, coordenadaY);
    	grafo.getNodos().add(nuevoNodo);
    	grafo.getGrafo().put(nuevoNodo, new ArrayList<>());
    	JOptionPane.showMessageDialog(null,"Datos del nodo:\n"+
    	                                   "Nombre: "+nuevoNodo.getNombre()+"\n"+
    	                                   "id: "+nuevoNodo.getId()+"\n"+
    	                                   "Coordenadas: ["+nuevoNodo.getCoordenada_X()+","+nuevoNodo.getCoordenada_Y()+"]");
    	JOptionPane.showMessageDialog(null,"Su servicio fue adquirido con exito");
    	ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
    	ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
    	List<Cliente> clientes = new ArrayList<>();
    	clientes = ManejoDeArchivos.recuperarClientes("archivos/Clientes.txt");
    	Cliente cli = new Cliente(txtCorreo.getText(),txtContrasena.getText(),txtNombreComp.getText(),
    			txtDni.getText(),txtTelefono.getText(),nuevoNodo,false);
    	clientes.add(cli);
    	ManejoDeArchivos.guardarClientes(clientes, "archivos/Clientes.dat");
    	mostrarPantallaDeInicio();
    	casaSelecionada=false;
    }
    
    
    private void imagenFondo(JLabel labelAux) {
    	CargaImagen.setImagen(labelAux, "ED_Calle.png");
    	fondoAUX.add(labelAux);
    }

    //------------------------------------------------------------

    //------------------------------------------------------------
    //------------------------BOTONES-----------------------------

    public void mostrarPantallaDeInicio(){
        ventana.remove(fondo);
        PantallaInicio c = new PantallaInicio(ventana);
    }

    //------------------------------------------------------------

}
*/

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import algoritmo.Grafo;
import algoritmo.Nodo;
import entidad.Cliente;
import interfazInicio.gui.PantallaInicio;
import utilidad.CargaImagen;
import utilidad.DibujarGrafo;
import utilidad.Formato;
import utilidad.ManejoDeArchivos;

import java.util.ArrayList;
import java.util.List;

public class PantallaNuevoCliente {
	private JFrame ventana;
    private JPanel fondo, fondoAUX;
    private JLabel tituloLabel, nombreLabel, dniLabel, telefonoLabel, correoLabel, contraseniaLabel, idLabel;
	private JTextField nombreField, dniField, telefonoField, correoField, contraseniaField, idField;
	private Formato formato;
	private boolean casaSelecionada=false;
    private final int WIDTH = 1400;
	private final int HEIGHT = 800;
    JLabel imagenFondo = new JLabel();
    JLabel botonRegresar = new JLabel();
	//-------------------------------
	private Grafo<Nodo> grafo = new Grafo<>();
	private Nodo nuevoNodo;
	private int coordenadaX,coordenadaY; 
    //---------BOTONES---------------
    JButton btn_Regresar = new JButton("Volver");
    JButton btn_SeleccionarCasa = new JButton("Selecionar casa");
    JButton btn_AdquirirServicio = new JButton("Adquirir servicio");
    //------------------------------
    //-------TEXTO------------------
    JTextField txtCorreoElectro = new JTextField("example@hotmail.com");
	JTextField txtContrasenia= new JPasswordField("********");
    public PantallaNuevoCliente(JFrame ventana){
        grafo = ManejoDeArchivos.recuperarGrafo("archivos/Grafo.dat");
    	fondo = new JPanel();
        fondoAUX = new JPanel();
        this.ventana = ventana;
        formato = new Formato();
        configVentana();

    }

    private void configVentana() {
        ventana.repaint();
		ventana.setSize(1400, 800);
		ventana.setTitle("KRUKAL-UNMSM");
		ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
        configComponentes();

	}

    private void configComponentes(){
        fondo.setLayout(null);
        fondo.setBackground(Color.BLACK);
        ventana.add(fondo);
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
		initTitulo();
		initNombre();
		initdni();
		inittelefono();
		initCorreo();
		initContrasenia();
		//initId();
		botonRegresar();
        btn_SeleccionarCasa(btn_SeleccionarCasa);
        btn_AdquirirServicio(btn_AdquirirServicio);
        cargarFondo();
    }
    
    private void cargarFondo() {
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
        CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
        fondo.add(imagenFondo);
    }
    
    public void initTitulo() {
    	tituloLabel = new JLabel("INGRESE SUS DATOS");
    	tituloLabel.setBounds((int) (WIDTH * 0.24), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.60),
				(int) (HEIGHT * 0.055));
		formato.formato(tituloLabel, 1, (float) (HEIGHT * 0.060));
		fondo.add(tituloLabel);

    }
    
    public void initNombre() {
    	nombreLabel = new JLabel("NOMBRE");
    	nombreLabel.setBounds((int) (WIDTH * 0.50), (int) (HEIGHT * 0.20), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(nombreLabel);
		
		nombreField = new JTextField();
		nombreField.setBounds((int) (nombreLabel.getX() + WIDTH * 0.025),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (nombreLabel.getHeight()));
		formato.formato(nombreField, 0, (float) (HEIGHT * 0.035));
		nombreField.setEditable(true);
		nombreField.setFocusable(true);
		fondo.add(nombreField);
    }
    
    public void initdni() {
    	dniLabel = new JLabel("DOCUMENTO DE IDENTIDAD");
    	dniLabel.setBounds((int) (WIDTH * 0.50), (int) (HEIGHT * 0.35), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(dniLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(dniLabel);
		
		dniField = new JTextField();
		dniField.setBounds((int) (dniLabel.getX() + WIDTH * 0.025),
				(int) (dniLabel.getY() + dniLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (dniLabel.getHeight()));
		formato.formato(dniField, 0, (float) (HEIGHT * 0.035));
		dniField.setEditable(true);
		dniField.setFocusable(true);
		fondo.add(dniField);
    }
    
    public void inittelefono() {
    	telefonoLabel = new JLabel("TELEFONO");
    	telefonoLabel.setBounds((int) (WIDTH * 0.50), (int) (HEIGHT * 0.50), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(telefonoLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(telefonoLabel);
		
		telefonoField = new JTextField();
		telefonoField.setBounds((int) (telefonoLabel.getX() + WIDTH * 0.025),
				(int) (telefonoLabel.getY() + telefonoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (telefonoLabel.getHeight()));
		formato.formato(telefonoField, 0, (float) (HEIGHT * 0.035));
		telefonoField.setEditable(true);
		telefonoField.setFocusable(true);
		fondo.add(telefonoField);
    }
    
    public void initCorreo() {
    	correoLabel = new JLabel("CORREO ELECTRONICO");
    	correoLabel.setBounds((int) (WIDTH * 0.14), (int) (HEIGHT * 0.20), (int) (WIDTH * 0.80),
				(int) (HEIGHT * 0.055));
		formato.formato(correoLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(correoLabel);
		
		correoField = new JTextField();
		correoField.setBounds((int) (correoLabel.getX() + WIDTH * 0.025),
				(int) (correoLabel.getY() + correoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (correoLabel.getHeight()));
		formato.formato(correoField, 0, (float) (HEIGHT * 0.030));
		correoField.setEditable(true);
		correoField.setFocusable(true);
		fondo.add(correoField);
    }
    
    public void initContrasenia() {
    	contraseniaLabel = new JLabel("CONTRASEÑA");
    	contraseniaLabel.setBounds((int) (WIDTH * 0.14), (int) (HEIGHT * 0.35), (int) (WIDTH * 0.80),
				(int) (HEIGHT * 0.055));
		formato.formato(contraseniaLabel, 1, (float) (HEIGHT * 0.030));
		fondo.add(contraseniaLabel);
		
		contraseniaField = new JTextField();
		contraseniaField.setBounds((int) (contraseniaLabel.getX() + WIDTH * 0.025),
				(int) (contraseniaLabel.getY() + contraseniaLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (contraseniaLabel.getHeight()));
		formato.formato(contraseniaField, 0, (float) (HEIGHT * 0.035));
		contraseniaField.setEditable(true);
		contraseniaField.setFocusable(true);
		fondo.add(contraseniaField);
    }
    
    public void initId() {
    	idLabel = new JLabel("ID");
    	idLabel.setBounds((int) (WIDTH * 0.50), (int) (HEIGHT * 0.65), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(idLabel, 1, (float) (HEIGHT * 0.035));
		fondo.add(idLabel);
		
		idField = new JTextField();
		idField.setBounds((int) (idLabel.getX() + WIDTH * 0.025),
				(int) (idLabel.getY() + idLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (idLabel.getHeight()));
		formato.formato(idField, 0, (float) (HEIGHT * 0.035));
		idField.setEditable(true);
		idField.setFocusable(true);
		fondo.add(idField);
    }

    //----------FUNCIONES PARA LOS BOTONES------------------------
    public void botonRegresar() {
    	botonRegresar.setBounds(90, 620, 110, 110);
    	CargaImagen.setImagen(botonRegresar, "Cerrar.png");
    	botonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	mostrarPantallaDeInicio();
            }
        });
    	fondo.add(botonRegresar);
    }
    
    public void btn_SeleccionarCasa(JButton btn) {
    	btn.setBounds((int) (WIDTH * 0.20), (int) (HEIGHT * 0.60), (int) (WIDTH * 0.20),
				(int) (HEIGHT * 0.055)); //1250 658 85 90
		btn.setOpaque(true);
		btn.addActionListener(e -> {
			mostrarMapaParaSeleccionarCasa();
	    });
		fondo.add(btn);
    }
    
    public void btn_AdquirirServicio(JButton btn) {
    	btn.setBounds((int) (WIDTH * 0.20), (int) (HEIGHT * 0.75), (int) (WIDTH * 0.20),
				(int) (HEIGHT * 0.055));; //1250 658 85 90
		btn.setOpaque(true);
		btn.addActionListener(e -> {
			obtenerServicio();
	    });
		fondo.add(btn);
    }
    
    //----------FUNCION DEL BOTON--------------
    public void mostrarPantallaDeInicio(){
        ventana.remove(fondo);
        PantallaInicio c = new PantallaInicio(ventana);
    }
    
    public boolean verificarTextFieldLlenos() {
    	if(nombreField.getText().isEmpty() || dniField.getText().isEmpty() || telefonoField.getText().isEmpty() ||
    	   correoField.getText().isEmpty() || contraseniaField.getText().isEmpty() || idField.getText().isEmpty()) {
    		return false;
    	}
    	
    	return true;
    }
    
    public void obtenerServicio() {
    	if(!casaSelecionada && !verificarTextFieldLlenos()) {
    		JOptionPane.showMessageDialog(null, "¡Complete los datos solicitados!");
    	}else if(!verificarTextFieldLlenos()){
    		JOptionPane.showMessageDialog(null, "¡Dato(s) incompleto(s)!");
    	}else if(!casaSelecionada) {
    		JOptionPane.showMessageDialog(null, "¡Casa no seleccionada!");
    	}else {
    		crearNuevoClienteConSuNodo();
    	}
    }
    
    //-------------CUANDO LE DE AL BOTON DE VER CASAS-------------
    public void mostrarMapaParaSeleccionarCasa() {
    	fondo.setVisible(false);
    	//--------------------------------------------
        JButton btn_SalirDelMapa = new JButton("MAPA");
        JLabel conexion = new JLabel();
        JLabel textoSeleccionar= new JLabel("Seleccione");
        JLabel textoSuHogar = new JLabel("su hogar");
        JLabel textoEnElMapa = new JLabel("en el mapa");
    	//--------------------------------------------
    	fondoAUX.setLayout(null);
        fondoAUX.setBackground(Color.decode("#17222E"));
        ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
		textoSeleccionar.setBounds((int) (WIDTH * 0.07), (int) (HEIGHT * 0.20), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		textoSuHogar.setBounds((int) (WIDTH * 0.07), (int) (HEIGHT * 0.25), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		textoEnElMapa.setBounds((int) (WIDTH * 0.07), (int) (HEIGHT * 0.30), (int) (WIDTH * 0.40),
				(int) (HEIGHT * 0.055));
		formato.formato(textoSeleccionar, 1, (float) (HEIGHT * 0.050));
		formato.formato(textoSuHogar, 1, (float) (HEIGHT * 0.050));
		formato.formato(textoEnElMapa, 1, (float) (HEIGHT * 0.050));
		fondoAUX.add(textoSeleccionar);
		fondoAUX.add(textoSuHogar);
		fondoAUX.add(textoEnElMapa);
        mostrarCalleEnFondoAux(conexion, grafo);
        imagenFondo(conexion);
        ventana.add(fondoAUX);
        btn_SalirDelMapa(btn_SalirDelMapa);
        
        //--------------------------------------------
    }
    //------------------------------------------------------------
    //------------------------BOTONES-----------------------------
    
    public void btn_SalirDelMapa(JButton btn) {
    	btn.setBounds(90, 620, 70, 90); //1250 658 85 90
		btn.setOpaque(true);
		btn.addActionListener(e -> {
			salirDelMapa();
	    });
		fondoAUX.add(btn);
    }
    
    public void salirDelMapa() {
    	ventana.remove(fondoAUX);
    	fondo.setVisible(true);
    }
    
    public void mostrarCalleEnFondoAux(JLabel labelAux, Grafo<Nodo> grafo){
        labelAux.setBounds(400,100,900,600);
        labelAux.setForeground(null);
        DibujarGrafo grafico = new DibujarGrafo(grafo);
        grafico.setBounds(0,0,labelAux.getWidth(), labelAux.getHeight());
		grafico.setGrafo(grafo);
		labelAux.add(grafico);
		MouseAdapter click = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Coordenada: ["+e.getX()+","+e.getY()+"]");
				coordenadaX=e.getX();
				coordenadaY=e.getY();
				JOptionPane.showMessageDialog(null,"Casa seleccionada");
				casaSelecionada=true;
				salirDelMapa();
			}
		};
		labelAux.addMouseListener(click);
        fondoAUX.add(labelAux);
    }
    
    public void crearNuevoClienteConSuNodo() {
    	nuevoNodo = new Nodo("A"+(grafo.getNodos().size()+1),grafo.getNodos().size(),coordenadaX, coordenadaY);
    	grafo.getNodos().add(nuevoNodo);
    	grafo.getGrafo().put(nuevoNodo, new ArrayList<>());
    	JOptionPane.showMessageDialog(null,"Datos del nodo:\n"+
    	                                   "Nombre: "+nuevoNodo.getNombre()+"\n"+
    	                                   "id: "+nuevoNodo.getId()+"\n"+
    	                                   "Coordenadas: ["+nuevoNodo.getCoordenada_X()+","+nuevoNodo.getCoordenada_Y()+"]");
    	JOptionPane.showMessageDialog(null,"Su servicio fue adquirido con exito");
    	ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
    	ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
    	List<Cliente> clientes = new ArrayList<>();
    	clientes = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
    	Cliente cli = new Cliente(correoField.getText(),contraseniaField.getText(),nombreField.getText(),
    			                  dniField.getText(),telefonoField.getText(),nuevoNodo,false);
    	clientes.add(cli);
    	ManejoDeArchivos.guardarClientes(clientes, "archivos/Clientes.dat");
    	mostrarPantallaDeInicio();
    	casaSelecionada=false;
    }
    
    
    private void imagenFondo(JLabel labelAux) {
    	CargaImagen.setImagen(labelAux, "ED_Calle.png");
    	fondoAUX.add(labelAux);
    }

    //------------------------------------------------------------

}

