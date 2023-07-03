package interfazAdministrador.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import utilidad.ManejoDeArchivos;
import utilidad.CargaImagen;
import utilidad.Formato;

public class PantallaMostrarListaDeClientes {
    private JFrame ventana;
    private JPanel fondo;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private Formato formato;
    private final int WIDTH = 1400;
    private final int HEIGHT = 800;
    // -------BOTONES-----------------
    JButton btn_regresarMenuAdministrador = new JButton("Regresar");
    // ----ETIQUETAS------------------
    private JLabel tituloLabel, descripcionLabel;
    private JTextField informacionField;
    JLabel imagenFondo = new JLabel();

    public PantallaMostrarListaDeClientes(JFrame ventana) {
        fondo = new JPanel();
        this.ventana = ventana;
        this.formato = new Formato();
        configVentana();
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
        fondo.setBackground(Color.WHITE);
        ventana.getContentPane().repaint();
        ventana.getContentPane().revalidate();
        btn_regresarMenuAdministrador(btn_regresarMenuAdministrador);
        generarListaDeClientes();
        initLabelTitulo();
        initDescripcion();
        cargarFondo();
        ventana.add(fondo);
    }
    
    private void cargarFondo() {
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
        CargaImagen.setImagen(imagenFondo, "Fondo_Predeterminado.png");
        fondo.add(imagenFondo);
    }

    private void initLabelTitulo() {
        tituloLabel = new JLabel("LISTADO DE CLIENTES");
        tituloLabel.setBounds((int) (WIDTH * 0.30), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.45),
                (int) (HEIGHT * 0.055));
        formato.formato(tituloLabel, 1, (float) (HEIGHT * 0.045));
        fondo.add(tituloLabel);
    }

    private void initDescripcion() {
        descripcionLabel = new JLabel("DESCRIPCIÓN DE CLIENTE SELECCIONADO:");
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

    // -------------BOTONES-------------------------

    public void btn_regresarMenuAdministrador(JButton btn) {
        btn.setBounds(90, 620, 70, 90);
        btn.setOpaque(true);
        btn.addActionListener(e -> {
            regresarAlMenuAdministrador();
        });
        fondo.add(btn);
    }

    // ------------------------------------------------------
    // ------FUNCIONES PARA LOS BOTONES----------------------

    public void regresarAlMenuAdministrador() {
        ventana.remove(fondo);
        PantallaOpcionesAdministrador c = new PantallaOpcionesAdministrador(ventana);
    }

    public void generarListaDeClientes() {
        List<Cliente> cli = new ArrayList<>();
        cli = ManejoDeArchivos.recuperarClientes("archivos/Clientes.dat");
        String[][] m = new String[cli.size()][5];
        for (Cliente c : cli) {
            m[cli.indexOf(c)][0] = c.getCorreo();
            m[cli.indexOf(c)][1] = c.getNombreComp();
            m[cli.indexOf(c)][2] = c.getDni();
            m[cli.indexOf(c)][3] = c.getTelefono();
            m[cli.indexOf(c)][4] = c.getN().getNombre();
        }

        String[] cabecera = { "CORREO", "NOMBRE", "DNI", "TELÉFONO", "ID de hogar" };

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
        table.getColumnModel().getColumn(0).setPreferredWidth(280);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.setFont(table.getFont().deriveFont(24f));

        formato.formato(table, 1, (float) (HEIGHT * 0.023));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(85, 90, 1200, 400);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    informacionField.setText(m[filaSeleccionada][1]);
                    mostrarDatos(filaSeleccionada, m);
                }
            }
        });
        fondo.add(scrollPane);
    }

    public void mostrarDatos(int id, String[][] m) {
        System.out.println("DATOS DEL CLIENTE DE INDICE " + id + ":");
        System.out.println("\tCorreo: " + m[id][0]);
        System.out.println("\tNombre: " + m[id][1]);
        System.out.println("\tDNI: " + m[id][2]);
        System.out.println("\tTelefono: " + m[id][3]);
        System.out.println("\tDireccion: " + m[id][4]);
        // mostrarDatos(id, m);
    }

}
