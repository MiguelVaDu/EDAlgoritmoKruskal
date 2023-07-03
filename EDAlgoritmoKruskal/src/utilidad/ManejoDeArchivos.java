package utilidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedWriter;

import java.util.*;
import algoritmo.*;
import entidad.*;

public class ManejoDeArchivos {

	 public static void crearArchivo(String rutaArchivo) {
	        try {
	            File archivo = new File(rutaArchivo);
	            if (archivo.createNewFile()) {
	                System.out.println("Archivo creado exitosamente.");
	            } else {
	                System.out.println("El archivo ya existe.");
	            }
	        } catch (IOException e) {
	            System.err.println("Error al crear el archivo: " + e.getMessage());
	        }
	}
    public static void guardarGrafo(Grafo<Nodo> grafo, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(grafo);
            System.out.println("Grafo guardado correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el grafo en el archivo: " + e.getMessage());
        }
    }

    public static Grafo<Nodo> recuperarGrafo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Grafo<Nodo> grafo = (Grafo<Nodo>) ois.readObject();
            System.out.println("Grafo recuperado correctamente desde el archivo: " + nombreArchivo);
            return grafo;
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("Se recupera el archivo vacio - " + e.getMessage());
            return new Grafo<>();
        }
    }

    public static void guardarAdministradores(List<Administrador> a, String nombreArchivo){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(a);
            System.out.println("Administrador guardado correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los admin en el archivo: " + e.getMessage());
        }
    }

    public static List<Administrador> recuperarAdministradores(String nombreArchivo){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<Administrador> adm = (List<Administrador>) ois.readObject();
            System.out.println("Administradores recuperado correctamente desde el archivo: " + nombreArchivo);
            return adm;
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("Se recupera el archivo vacio - " + e.getMessage());
            return new ArrayList<>();
        }
    }

     public static void guardarClientes(List<Cliente> a, String nombreArchivo){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(a);
            System.out.println("Cliente guardado correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes en el archivo: " + e.getMessage());
        }
    }

    public static List<Cliente> recuperarClientes(String nombreArchivo){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<Cliente> cli = (List<Cliente>) ois.readObject();
            System.out.println("Cliente recuperado correctamente desde el archivo: " + nombreArchivo);
            return cli;
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("Se recupera el archivo vacio - " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void guardarSolicitudes(List<Solicitud> c, String nombreArchivo){
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(c);
            System.out.println("Solicitudes guardado correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la solicitud en el archivo: " + e.getMessage());
        }
    }

    public static List<Solicitud> recuperarSolicitudes(String nombreArchivo){    	
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<Solicitud> sol = (List<Solicitud>) ois.readObject();
            System.out.println("Solicitudes recuperado correctamente desde el archivo: " + nombreArchivo);
            return sol;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Se recupera el archivo vacio - " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public static void eliminarContenidoArchivo(String nombreArchivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
            System.out.println("Contenido del archivo eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el contenido del archivo: " + e.getMessage());
        }
    }
    
    public static void guardarUsuario(List<Usuario> c, String nombreArchivo){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(c);
            System.out.println("Usuario guardado correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el grafo en el archivo: " + e.getMessage());
        }
    }
    
    public static List<Usuario> recuperarUsuario(String nombreArchivo){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
        	List<Usuario> usu = (List<Usuario>) ois.readObject();
            System.out.println("Usuario recuperado correctamente desde el archivo: " + nombreArchivo);
            return usu;
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("Se recupera el archivo vacio - " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
}
