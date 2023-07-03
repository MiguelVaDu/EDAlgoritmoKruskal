package interfazAdministrador.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import entidad.Solicitud;
import algoritmo.Grafo;
import algoritmo.Nodo;
import utilidad.Boton;
import utilidad.CargaImagen;
import utilidad.Formato;
import utilidad.ManejoDeArchivos;

public class PantallaRevisarSolicitudes {
    private JFrame ventana;
    private JPanel fondo;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private Formato formato;
    private int filaSeleccionada;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    List<Solicitud> solicitud = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    Grafo<Nodo> grafo = new Grafo<>();
    List<Cliente> borrado;
    // -------BOTONES-----------------
    private Boton btn_AceptarSolicitud;
    private Boton btn_RechazarSolicitud;
    JLabel botonRegresar = new JLabel();
    // ------------FONDO---------------
    JLabel imagenFondo = new JLabel();
    // ------------LOGO----------------
    JLabel logo = new JLabel();
    // ----ETIQUETAS------------------
    private JLabel tituloLabel, descripcionLabel;
    private JTextField informacionField;

    public PantallaRevisarSolicitudes(JFrame ventana) {
        fondo = new JPanel();
        this.ventana = ventana;
        this.formato = new Formato();
        grafo = ManejoDeArchivos.recuperarGrafo("archivos/Grafo.dat");
        clientes = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
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
        btn_regresarMenuAdministrador();
        btn_AceptarSolicitud();
        btn_RechazarSolicitud();
        generarListaDeSolicitudes();
        initLabelTitulo();
        initDescripcion();
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

    // -------------BOTONES-------------------------

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

    public void btn_AceptarSolicitud() {
        btn_AceptarSolicitud = new Boton();
        formato = new Formato();
        btn_AceptarSolicitud.setBounds(700, 615, 200, 80);
        formato.formato(btn_AceptarSolicitud, 0, 24, 70, 2);
        btn_AceptarSolicitud.setText("Aceptar");
        btn_AceptarSolicitud.addActionListener(e -> {
            aceptarSolicitud();
        });
        fondo.add(btn_AceptarSolicitud);
    }

    public void btn_RechazarSolicitud() {
        btn_RechazarSolicitud = new Boton();
        formato = new Formato();
        btn_RechazarSolicitud.setBounds(960, 615, 200, 80);
        formato.formato(btn_RechazarSolicitud, 0, 24, 70, 2);
        btn_RechazarSolicitud.setText("Rechazar");
        btn_RechazarSolicitud.addActionListener(e -> {
            rechazarSolicitud();
        });
        fondo.add(btn_RechazarSolicitud);
    }

    private void initLabelTitulo() {
        tituloLabel = new JLabel("LISTADO DE SOLICITUDES");
        tituloLabel.setBounds((int) (WIDTH * 0.30), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.45),
                (int) (HEIGHT * 0.055));
        formato.formato(tituloLabel, 1, (float) (HEIGHT * 0.045));
        fondo.add(tituloLabel);
    }

    private void initDescripcion() {
        descripcionLabel = new JLabel("SOLICITUD SELECCIONADA:");
        descripcionLabel.setBounds((int) (WIDTH * 0.15), (int) (HEIGHT * 0.65), (int) (WIDTH * 0.80),
                (int) (HEIGHT * 0.055));
        formato.formato(descripcionLabel, 1, (float) (HEIGHT * 0.045));
        fondo.add(descripcionLabel);

        informacionField = new JTextField();
        informacionField.setBounds((int) (descripcionLabel.getX() + WIDTH * 0.025),
                (int) (descripcionLabel.getY() + descripcionLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
                (int) (descripcionLabel.getHeight()));
        formato.formato(informacionField, 0, (float) (HEIGHT * 0.035));
        fondo.add(informacionField);

    }

    // ------------------------------------------------------
    // ------FUNCIONES PARA LOS BOTONES----------------------

    public void regresarAlMenuAdministrador() {
        ventana.remove(fondo);
        PantallaOpcionesAdministrador c = new PantallaOpcionesAdministrador(ventana);
    }

    public void generarListaDeSolicitudes() {
        solicitud = ManejoDeArchivos.recuperarSolicitudes("archivos/Solicitudes.dat");
        String[][] m = new String[solicitud.size()][4];
        for (Solicitud c : solicitud) {
            m[solicitud.indexOf(c)][0] = Integer.toString(c.getId());
            m[solicitud.indexOf(c)][1] = c.getClienteQueSolicita().getNombreComp();
            m[solicitud.indexOf(c)][2] = c.getClienteQueSolicita().getCorreo();
            m[solicitud.indexOf(c)][3] = c.getClienteQueSolicita().getTelefono();
        }

        String[] cabecera = { "ID de hogar", "NOMBRE", "CORREO", "Telefono" };

        tableModel = new DefaultTableModel(m, cabecera);
        JTable table = new JTable(tableModel);
        for (int i = 0; i < cabecera.length; i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        table.setDefaultEditor(Object.class, null);
        table.getTableHeader().setEnabled(false);
        table.getTableHeader().setBackground(Color.decode("#09599B"));
        table.setRowHeight(40);
        table.setBackground(Color.decode("#1B7ECF"));
        table.getColumnModel().getColumn(2).setPreferredWidth(280);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.setFont(table.getFont().deriveFont(24f));

        formato.formato(table, 1, (float) (HEIGHT * 0.023));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(85, 90, 1200, 400);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    informacionField.setText(solicitud.get(filaSeleccionada).getDescripcion());
                    mostrarDatos(filaSeleccionada, m);

                }
            }
        });
        fondo.add(scrollPane);
    }

    public void mostrarDatos(int id, String[][] m) {
        System.out.println("DATOS DEL CLIENTE DE INDICE " + id + ":");
        System.out.println("\tID del hogar: " + m[id][0]);
        System.out.println("\tNombre: " + m[id][1]);
        System.out.println("\tCorreo: " + m[id][2]);
        System.out.println("\tTelefono: " + m[id][3]);
    }

    public void aceptarSolicitud() {
    	if(informacionField.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "¡Seleccione una solicitud!");
    	} else {
    		borrado = new ArrayList<>();
            ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
    		System.out.println(grafo.getNodos().size());
            ManejoDeArchivos.eliminarContenidoArchivo("archivos/Clientes.dat");
            System.out.println(clientes.size());
            for(Cliente c : clientes) {
            	System.out.println(c.getNombreComp());
            	if(c.getDni().equals(solicitud.get(filaSeleccionada).getClienteQueSolicita().getDni())) {
            		System.out.println("Eliminando "+c.getNombreComp());
            		borrado.add(c);
            		System.out.println(c.getNombreComp()+" guardado para eliminar");
            	}
            }
            for(Cliente b : borrado) {
            	clientes.remove(b);
            }
            ManejoDeArchivos.guardarClientes(clientes, "archivos/Clientes.dat");
            grafo.eliminarNodoYAdyacentes(solicitud.get(filaSeleccionada).getClienteQueSolicita().getN());
    		System.out.println(grafo.getNodos().size());
            ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");
            ManejoDeArchivos.eliminarContenidoArchivo("archivos/Solicitudes.dat");
    		solicitud.remove(filaSeleccionada);
            ManejoDeArchivos.guardarSolicitudes(solicitud, "archivos/Solicitudes.dat");
            JOptionPane.showMessageDialog(null, "Solicitud aceptada");
            fondo.remove(scrollPane);
            generarListaDeSolicitudes();
    	}
    }

    public void rechazarSolicitud() {
    	if(informacionField.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "¡Seleccione una solicitud!");
    	} else {
    		borrado = new ArrayList<>();
            JOptionPane.showMessageDialog(null, "Solicitud rechazada");
            ManejoDeArchivos.eliminarContenidoArchivo("archivos/Clientes.dat");
            System.out.println(clientes.size());
            for(Cliente c : clientes) {
            	System.out.println(c.getNombreComp());
            	if(c.getDni().equals(solicitud.get(filaSeleccionada).getClienteQueSolicita().getDni())) {
            		System.out.println("Eliminando "+c.getNombreComp());
            		borrado.add(c);
            	}
            }
            for(Cliente b : borrado) {
            	b.setUsoSolicitud(false);
            }
            
            ManejoDeArchivos.guardarClientes(clientes, "archivos/Clientes.dat");
            solicitud.remove(filaSeleccionada);
            ManejoDeArchivos.eliminarContenidoArchivo("archivos/Solicitudes.dat");
            ManejoDeArchivos.guardarSolicitudes(solicitud, "archivos/Solicitudes.dat");
            fondo.remove(scrollPane);
            generarListaDeSolicitudes();
    	}
    }

}
