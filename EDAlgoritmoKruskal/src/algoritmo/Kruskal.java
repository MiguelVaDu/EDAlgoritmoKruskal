package algoritmo;

import java.util.*;
import java.util.List;

public class Kruskal<T> {
    private Grafo<T> grafo;
    private List<Arista<T>> arbolExpansionMinimo;

    public Kruskal(Grafo<T> grafo) {
        this.grafo = grafo;
        this.arbolExpansionMinimo = new ArrayList<>();
    }

    public Grafo<T> obtenerArbolExpansionMinima() {
        Grafo<T> aem = new Grafo<>();

        // Ordenar las aristas en orden ascendente de peso
        List<Arista<T>> aristasOrdenadas = new ArrayList<>(grafo.getAristas());
        Collections.sort(aristasOrdenadas, (a1, a2) -> Double.compare(a1.getPeso(), a2.getPeso()));

        for (Nodo nodo : grafo.getNodos()) {
            aem.agregarNodoAlGrafo(new Nodo(nodo.getNombre(), nodo.getId(), nodo.getCoordenada_X(), nodo.getCoordenada_Y()));
        }

        for (Arista<T> arista : aristasOrdenadas) {
            Nodo origen = arista.getOrigen();
            Nodo destino = arista.getDestino();

            if (!hayCamino(aem, origen, destino)) {
                aem.agregarArista(origen, destino);
            }
        }

        return aem;
    }

    private boolean hayCamino(Grafo<T> grafo, Nodo origen, Nodo destino) {
        List<Nodo> visitados = new ArrayList<>();
        return dfs(grafo, origen, destino, visitados);
    }

    private boolean dfs(Grafo<T> grafo, Nodo actual, Nodo destino, List<Nodo> visitados) {
        visitados.add(actual);

        if (actual.equals(destino)) {
            return true;
        }

        for (Arista<T> arista : grafo.getGrafo().get(actual)) {
            Nodo adyacente = (arista.getOrigen().equals(actual)) ? arista.getDestino() : arista.getOrigen();

            if (!visitados.contains(adyacente)) {
                if (dfs(grafo, adyacente, destino, visitados)) {
                    return true;
                }
            }
        }

        return false;
    }
    
}
