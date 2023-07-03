package algoritmo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class kruskalTest {

	private Grafo<Nodo> grafo;

    @BeforeEach
    void setUp() {
        grafo = new Grafo<>();

        Nodo nodoA = new Nodo("A", 1, 1, 1);
        Nodo nodoB = new Nodo("B", 2, 2, 5);
        Nodo nodoC = new Nodo("C", 3, 6, 6);
        Nodo nodoD = new Nodo("D", 4, 4, 3);
        Nodo nodoE = new Nodo("E", 5, 7, 4);
        Nodo nodoF = new Nodo("F", 6, 6, 1);
        Nodo nodoG = new Nodo("G", 7, 8, 3);

        grafo.agregarNodo(nodoA);
        grafo.agregarNodo(nodoB);
        grafo.agregarNodo(nodoC);
        grafo.agregarNodo(nodoD);
        grafo.agregarNodo(nodoE);
        grafo.agregarNodo(nodoF);
        grafo.agregarNodo(nodoG);

        grafo.agregarArista(nodoA, nodoB);
        grafo.agregarArista(nodoA, nodoD);
        grafo.agregarArista(nodoA, nodoF);
        grafo.agregarArista(nodoB, nodoC);
        grafo.agregarArista(nodoB, nodoD);
        grafo.agregarArista(nodoB, nodoE);
        grafo.agregarArista(nodoC, nodoE);
        grafo.agregarArista(nodoD, nodoE);
        grafo.agregarArista(nodoD, nodoF);
        grafo.agregarArista(nodoE, nodoG);
        grafo.agregarArista(nodoF, nodoG);
    }

    @Test
    void testObtenerArbolExpansionMinima() {
        // Instanciar objeto Kruskal
        Kruskal<Nodo> kruskal = new Kruskal<>(grafo);

        // Obtener el árbol de expansión mínima
        Grafo<Nodo> obtenerAEM = kruskal.obtenerArbolExpansionMinima();

        // Comprobar que el árbol de expansión mínima contiene los nodos esperados
        assertEquals(7, obtenerAEM.getNodos().size());
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("A", 1, 1, 1)));
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("B", 2, 2, 5)));
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("C", 3, 6, 6)));
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("D", 4, 4, 3)));
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("E", 5, 7, 4)));
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("F", 6, 6, 1)));
        assertTrue(obtenerAEM.getNodos().contains(new Nodo("G", 7, 8, 3)));

        // Comprobar que el árbol de expansión mínima contiene las aristas esperadas
        assertEquals(6, obtenerAEM.getAristas().size());
        assertTrue(obtenerAEM.getAristas().contains(new Arista<>(new Nodo("E", 5, 7, 4), new Nodo("G", 7, 8, 3))));
        assertTrue(obtenerAEM.getAristas().contains(new Arista<>(new Nodo("C", 3, 6, 6), new Nodo("E", 5, 7, 4))));
        assertTrue(obtenerAEM.getAristas().contains(new Arista<>(new Nodo("B", 2, 2, 5), new Nodo("D", 4, 4, 3))));
        assertTrue(obtenerAEM.getAristas().contains(new Arista<>(new Nodo("D", 4, 4, 3), new Nodo("F", 6, 6, 1))));
        assertTrue(obtenerAEM.getAristas().contains(new Arista<>(new Nodo("F", 6, 6, 1), new Nodo("G", 7, 8, 3))));
        assertTrue(obtenerAEM.getAristas().contains(new Arista<>(new Nodo("A", 1, 1, 1), new Nodo("D", 4, 4, 3))));
           
    }

    @Test
    void testFormanCiclo() {
    	Grafo<Nodo> grafo = new Grafo<>();
        // Crear los nodos del grafo
        Nodo nodoA = new Nodo("A", 1, 1, 1);
        Nodo nodoB = new Nodo("B", 2, 2, 2);
        Nodo nodoC = new Nodo("C", 3, 3, 3);

        grafo.agregarNodo(nodoA);
        grafo.agregarNodo(nodoB);
        grafo.agregarNodo(nodoC);

        // Agregar aristas al grafo
        grafo.agregarArista(nodoA, nodoB);
        grafo.agregarArista(nodoB, nodoC);
        
    	Kruskal<Nodo> kruskal = new Kruskal<>(grafo);

    }


    @Test
    void testAgregarNodoAlGrafo() {
        // Crear nuevo nodo
        Nodo nodoE = new Nodo("E", 5, 1, 1);

        // Agregar nodo al grafo
        boolean resultado = grafo.agregarNodoAlGrafo(nodoE);

        // Comprobar que el nodo se agregó correctamente
        assertTrue(resultado);
        assertTrue(grafo.getNodos().contains(nodoE));
        assertTrue(grafo.getGrafo().containsKey(nodoE));
    }

    @Test
    void testAgregarArista() {
        // Crear nuevo nodo
        Nodo nodoH = new Nodo("H", 5, 1, 1);

        // Agregar nodo al grafo
        grafo.agregarNodo(nodoH);

        // Crear arista entre nodos existentes
        Arista<Nodo> arista = new Arista<>(nodoH, new Nodo("B", 2, 2, 5));

        // Agregar arista al grafo
        grafo.agregarArista(nodoH, new Nodo("B", 2, 2, 5));

        // Comprobar que la arista se agregó correctamente
        assertTrue(grafo.getAristas().contains(arista));
        assertTrue(grafo.getGrafo().get(nodoH).contains(arista));
        assertTrue(grafo.getGrafo().get(new Nodo("B", 2, 2, 5)).contains(arista));
    }

    @Test
    void testGetGrafo() {
        // Obtener el grafo
        Map<Nodo, List<Arista<Nodo>>> grafoMap = grafo.getGrafo();

        // Comprobar que el grafo es el esperado
        assertEquals(7, grafoMap.size());
        assertTrue(grafoMap.containsKey(new Nodo("A", 1, 1, 1)));
        assertTrue(grafoMap.containsKey(new Nodo("B", 2, 2, 5)));
        assertTrue(grafoMap.containsKey(new Nodo("C", 3, 6, 6)));
        assertTrue(grafoMap.containsKey(new Nodo("D", 4, 4, 3)));

    }


}

