package algoritmo;

import java.io.Serializable;
import java.util.Objects;

public class Arista<T> implements Serializable{
    private Nodo origen;
    private Nodo destino;
    private double peso;

    public Arista(Nodo origen, Nodo destino) {
        this.origen = origen;
        this.destino = destino;
        this.peso = Math.sqrt((Math.pow(Math.abs(origen.getCoordenada_X() - destino.getCoordenada_X()),2)
				+(Math.pow(Math.abs(origen.getCoordenada_Y() - destino.getCoordenada_Y()),2))));

    }

    public Nodo getOrigen() {
        return origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Arista<?> arista = (Arista<?>) obj;
        return Objects.equals(origen, arista.origen) && Objects.equals(destino, arista.destino) && peso == arista.peso;
    }
    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, peso);
    }

	@Override
	public String toString() {
		return "Arista [origen=" + origen + ", destino=" + destino + ", peso=" + peso + "]";
	}

}
