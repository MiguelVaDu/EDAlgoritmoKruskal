package algoritmo;

import java.io.Serializable;
import java.util.Objects;

public class Nodo implements Serializable{
    private String nombre;
    private int id;
    private int coordenada_X;
    private int coordenada_Y;

    public Nodo(String nombre, int id, int coordenada_X, int coordenada_Y) {
        this.nombre = nombre;
        this.id = id;
        this.coordenada_X = coordenada_X;
        this.coordenada_Y = coordenada_Y;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getId() {
    	return id;
    }
    
    public int getCoordenada_X() {
    	return coordenada_X;
    }
    
    public int getCoordenada_Y() {
    	return coordenada_Y;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setCoordenada_X(int coordenada_X) {
    	this.coordenada_X = coordenada_X;
    }
    
    public void setCoordenada_Y(int coordenada_Y) {
    	this.coordenada_Y = coordenada_Y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nodo nodo = (Nodo) obj;
        return id == nodo.id && Objects.equals(nombre, nodo.nombre)
                && coordenada_X == nodo.coordenada_X && coordenada_Y == nodo.coordenada_Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, coordenada_X, coordenada_Y);
    }

	@Override
	public String toString() {
		return "Nodo [nombre=" + nombre + ", id=" + id + ", coordenada_X=" + coordenada_X + ", coordenada_Y="
				+ coordenada_Y + "]";
	}
}

