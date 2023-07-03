package utilidad;

import java.util.ArrayList;
import java.util.List;

import algoritmo.Grafo;
import algoritmo.Nodo;
import entidad.Administrador;
import entidad.Cliente;

public class GuardarDatosEnArchivos {
        public static void main(String[] args) {

                ManejoDeArchivos.eliminarContenidoArchivo("archivos/Grafo.dat");
                ManejoDeArchivos.eliminarContenidoArchivo("archivos/Solicitudes.dat");
                ManejoDeArchivos.eliminarContenidoArchivo("archivos/Usuarios.dat");

                Nodo A1 = new Nodo("A1", 0, 455, 275); // 445
                Nodo A2 = new Nodo("A2", 1, 355, 110); // 545
                Nodo A3 = new Nodo("A3", 2, 660, 505); // 240
                Nodo A4 = new Nodo("A4", 3, 295, 180); // 605
                Nodo A5 = new Nodo("A5", 4, 645, 190); // 255
                Nodo A6 = new Nodo("A6", 5, 470, 45); // 430
                Nodo A7 = new Nodo("A7", 6, 800, 325); // 100
                Nodo A8 = new Nodo("A8", 7, 640, 345); // 260
                Nodo A9 = new Nodo("A9", 8, 465, 445); // 435
                Nodo A10 = new Nodo("A10", 9, 210, 505); // 690
                Nodo A11 = new Nodo("A11", 10, 120, 325); // 780
                Nodo A12 = new Nodo("A12", 11, 70, 170); // 830
                Nodo A13 = new Nodo("A13", 12, 220, 85); // 680
                Nodo A14 = new Nodo("A14", 13, 400, 530); // 500

                Grafo<Nodo> grafo = new Grafo<>();

                grafo.agregarNodo(A1);
                grafo.agregarNodo(A2);
                grafo.agregarNodo(A3);
                grafo.agregarNodo(A4);
                grafo.agregarNodo(A5);
                grafo.agregarNodo(A6);
                grafo.agregarNodo(A7);
                grafo.agregarNodo(A8);
                grafo.agregarNodo(A9);
                grafo.agregarNodo(A10);
                grafo.agregarNodo(A11);
                grafo.agregarNodo(A12);
                grafo.agregarNodo(A13);
                grafo.agregarNodo(A14);

                grafo.agregarArista(A1, A2);
                grafo.agregarArista(A1, A6);
                grafo.agregarArista(A1, A8);
                grafo.agregarArista(A1, A9);

                grafo.agregarArista(A2, A6);
                grafo.agregarArista(A2, A13);

                grafo.agregarArista(A3, A7);
                grafo.agregarArista(A3, A9);
                grafo.agregarArista(A3, A14);

                grafo.agregarArista(A4, A13);
                grafo.agregarArista(A4, A12);

                grafo.agregarArista(A5, A6);
                grafo.agregarArista(A5, A8);

                grafo.agregarArista(A7, A8);

                grafo.agregarArista(A8, A9);

                grafo.agregarArista(A10, A11);
                grafo.agregarArista(A10, A14);

                grafo.agregarArista(A11, A12);
                grafo.agregarArista(A11, A14);

                grafo.agregarArista(A12, A13);

                // Guardar el grafo en un archivo
                // ArchivoUtil.crearArchivoTxt("C:\\Users\\JoArDiTo\\eclipse-workspace\\ED.ProyectoDeCurso\\src\\Archivos\\Grafo.txt");
                ManejoDeArchivos.guardarGrafo(grafo, "archivos/Grafo.dat");

                ManejoDeArchivos.eliminarContenidoArchivo("archivos/Administradores.dat");
                ManejoDeArchivos.eliminarContenidoArchivo("archivos/Clientes.dat");

                // Crear Administradores
                List<Administrador> ad = new ArrayList<>();
                ad.add(new Administrador("admin", "1234"));
                ad.add(new Administrador("miguel.valle@unmsm.edu.pe", "miguel123"));
                ad.add(new Administrador("fabian.cabana@unmsm.edu.pe", "fabian123"));
                ad.add(new Administrador("armando.diaz@unmsm.edu.pe", "diaz123"));
                ad.add(new Administrador("fabricio.oporto@unmsm.edu.pe", "oporto123"));
                ad.add(new Administrador("jeremy.menejes@unmsm.edu.pe", "micerebro123"));
                ad.add(new Administrador("fernando.ruiz@unmsm.edu.pe", "ruiz123"));
                ad.add(new Administrador("gerardo.hernandez@unmsm.edu.pe", "hernandez123"));
                ad.add(new Administrador("josue.guembes@unmsm.edu.pe", "guembes123"));

                // Crear Clientes
                List<Cliente> cli = new ArrayList<>();
                // Cliente(String correo, String string, String nombreComp, String dni, int
                // telefono, Nodo n)
                cli.add(new Cliente("cli", "usu", "MM", "78901234", "987654321", A1, false));
                // cli.add(new Cliente("juan.garcia@hotmail.com", "usuario01", "Juan Garcia",
                // "78901234", "987654321", A1));
                cli.add(new Cliente("maria.rodriguez@hotmail.com", "usuario02", "Maria Rodriguez", "80765432",
                                "912345678", A2,
                                false));
                cli.add(new Cliente("carlos.gonzales@hotmail.com", "usuario03", "Carlos Gonzales", "83215479",
                                "936587412", A3,
                                false));
                cli.add(new Cliente("ana.lopez@hotmail.com", "usuario04", "Ana Lopez", "74893651", "956782341", A4,
                                false));
                cli.add(new Cliente("alejandro.martinez@hotmail.com", "usuario05", "Alejandro Martinez", "89426713",
                                "923874561", A5, false));
                cli.add(new Cliente("laura.lopez@hotmail.com", "usuario06", "Laura Perez", "79134628", "948561237", A6,
                                false));
                cli.add(new Cliente("pedro.sanchez@hotmail.com", "usuario07", "Pedro Sanchez", "82974156", "961237845",
                                A7,
                                false));
                cli.add(new Cliente("gabriela.romero@hotmail.com", "usuario08", "Gabriela Romero", "83749562",
                                "974512386", A8,
                                false));
                cli.add(new Cliente("manuel.fernandez@hotmail.com", "usuario09", "Manuel Fernandez", "79526483",
                                "932187456",
                                A9, false));
                cli.add(new Cliente("sofia.torres@hotmail.com", "usuario10", "Sofia Torres", "81275946", "965423178",
                                A10,
                                false));
                cli.add(new Cliente("luis.ramirez@hotmail.com", "usuario11", "Luis Ramirez", "83924657", "998765432",
                                A11,
                                false));
                cli.add(new Cliente("mark.zuckerberg@hotmail.com", "usuario12", "Mark Zuckerberg", "92785641",
                                "946783215", A12,
                                false));
                cli.add(new Cliente("peter.arevalo@hotmail.com", "usuario13", "Peter Arevalo", "92736814", "919283746",
                                A13,
                                false));
                cli.add(new Cliente("paolo.guerrero@hotmail.com", "usuario14", "Paolo Guerrero", "91675348",
                                "977654321", A14,
                                false));

                ManejoDeArchivos.guardarAdministradores(ad, "archivos/Administradores.dat");
                ManejoDeArchivos.guardarClientes(cli, "archivos/Clientes.dat");

        }
}
