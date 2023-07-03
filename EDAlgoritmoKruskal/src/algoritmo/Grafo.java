package algoritmo;

import java.io.Serializable;
import java.util.*;

public class Grafo<T> implements Serializable  {
    private List<Nodo> nodos;					// Lista de nodos en el grafo
    private List<Arista<T>> aristas;		        // Lista de aristas en el grafo
    private Map<Nodo, List<Arista<T>>> grafo;	// Mapa que representa el grafo con nodos y sus aristas

    public Grafo() {
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
        grafo = new HashMap<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
        grafo.put(nodo, new ArrayList<>());
    }

    public boolean agregarNodoAlGrafo(Nodo nodo) { //Para el test
        if (nodo == null)
            return false;
        nodos.add(nodo);
        grafo.put(nodo, new ArrayList<>());
        return true;
    }

    public void agregarArista(Nodo origen, Nodo destino) {
    	if(origen!=destino) {
            Arista<T> arista = new Arista<>(origen, destino);
            aristas.add(arista);
            grafo.get(origen).add(arista);
            grafo.get(destino).add(arista);
    	}
    }

    public int[][] hallarMatrizDeAdyecencia(){
        int[][] MatrizDeAdyecencia = new int[nodos.size()][nodos.size()];
        for (Arista<T> arista : aristas) {
            int x = nodos.indexOf(arista.getOrigen());
            int y = nodos.indexOf(arista.getDestino());
            if (arista.getPeso() > 0) {
                MatrizDeAdyecencia[x][y] = 1;
                MatrizDeAdyecencia[y][x] = 1;
            }
        }
        return MatrizDeAdyecencia;
    }
    

    public Map<Nodo, List<Arista<T>>> getGrafo(){
        return grafo;
    }

    public List<Arista<T>> getAristas(){
        return aristas;
    }

    public List<Nodo> getNodos(){
        return nodos;
    }
    
    public void eliminarNodoYAdyacentes(Nodo nodo) {
    	Nodo nodoAux=null;
    	
    	for(Nodo recorridoDeNodos : nodos) {
    		if(recorridoDeNodos.getNombre().equals(nodo.getNombre())) {
    			System.out.println("si esta");
    			nodoAux = recorridoDeNodos;
    		}
    	}
;
        List<Arista<T>> borrar = new ArrayList<>(); 
        
        for(Arista<T> b : aristas) {
        	if(b.getOrigen().getNombre().equals(nodo.getNombre()) || b.getDestino().getNombre().equals(nodo.getNombre())) {
        		System.out.println(b.getOrigen().getNombre());
        		System.out.println(b.getDestino().getNombre());
        		borrar.add(b);
        	}
        }
        
        for(Arista<T> m: borrar) {
            aristas.remove(m);
        }
        
        nodos.remove(nodoAux);
        grafo.remove(nodoAux);
    }  
    
    public void eliminarArista(Nodo inicio, Nodo llegada) {
    	List<Arista<T>> listita = new ArrayList<>();
    	for(Arista<T> a : aristas) {
    		if((a.getOrigen().equals(inicio) && a.getDestino().equals(llegada)) || (a.getOrigen().equals(llegada) && a.getDestino().equals(inicio))) {
    			listita.add(a);
    		}
    		
    	}
		for(Arista<T> b: listita) {
			aristas.remove(b);
		}
    }
    
    public boolean sonAdyacentes(Nodo nodo1, Nodo nodo2) {
    	System.out.println(nodo1.getNombre());
    	System.out.println(nodo2.getNombre());
    	System.out.println(aristas);
        for (Arista<T> arista : aristas) {
            if (arista.getOrigen().getNombre().equals(nodo1.getNombre()) && arista.getDestino().getNombre().equals(nodo2.getNombre())) {
                return true;
            }
            if (arista.getOrigen().getNombre().equals(nodo2.getNombre()) && arista.getDestino().getNombre().equals(nodo1.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public String adyStr(int[][] adyacencia) {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < adyacencia.length; i++) {
            for (int j = 0; j < adyacencia.length; j++) {
                cad.append("[").append(adyacencia[i][j]).append("]");
            }
            cad.append("\n");
        }
        return cad.toString();
        }

}