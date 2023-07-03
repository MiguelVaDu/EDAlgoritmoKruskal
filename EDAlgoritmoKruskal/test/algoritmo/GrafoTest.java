package algoritmo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class GrafoTest {

	@Test
    public void testAgregarNodo() {
        Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo = new Nodo("A",0,10,10);
        
        grafo.agregarNodo(nodo);
        
        assertEquals(1, grafo.getNodos().size());
        assertTrue(grafo.getNodos().contains(nodo));
        assertTrue(grafo.getGrafo().containsKey(nodo));
    }
	
	@Test
	public void testAgregarNodoVacio() {
		Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo_1 = null;
        assertFalse(grafo.agregarNodoAlGrafo(nodo_1));
        Nodo nodo_2 = null;
        assertFalse(grafo.agregarNodoAlGrafo(nodo_2));
	}
    
    @Test
    public void testAgregarArista() {
        Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo1 = new Nodo("A",0,15,5);
        Nodo nodo2 = new Nodo("B",1,5,12);
        
        grafo.agregarNodo(nodo1);
        grafo.agregarNodo(nodo2);
        grafo.agregarArista(nodo1, nodo2);
        
        assertEquals(1, grafo.getAristas().size());
        assertEquals(1, grafo.getGrafo().get(nodo1).size());
        assertEquals(1, grafo.getGrafo().get(nodo2).size());
        assertTrue(grafo.sonAdyacentes(nodo1, nodo2));
    }
    
    @Test
    public void testEliminarNodoYAdyacentes() {
        Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo1 = new Nodo("A",0,15,5);
        Nodo nodo2 = new Nodo("B",1,5,12);
        Nodo nodo3 = new Nodo("C",2,20,10);
        
        grafo.agregarNodo(nodo1);
        grafo.agregarNodo(nodo2);
        grafo.agregarNodo(nodo3);
        grafo.agregarArista(nodo1, nodo2);
        grafo.agregarArista(nodo2, nodo3);
        
        grafo.eliminarNodoYAdyacentes(nodo2);
        
        assertEquals(2, grafo.getNodos().size());
        assertEquals(0, grafo.getAristas().size());
        assertFalse(grafo.getNodos().contains(nodo2));
        assertFalse(grafo.getGrafo().containsKey(nodo2));
        assertFalse(grafo.sonAdyacentes(nodo1, nodo2));
        assertFalse(grafo.sonAdyacentes(nodo2, nodo3));
        assertFalse(grafo.sonAdyacentes(nodo2, nodo1));
    }
    
    @Test
    public void testEliminarArista() {
        Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo1 = new Nodo("A",0,15,5);
        Nodo nodo2 = new Nodo("B",1,5,12);
        
        grafo.agregarNodo(nodo1);
        grafo.agregarNodo(nodo2);
        grafo.agregarArista(nodo1, nodo2);
        
        assertEquals(1, grafo.getAristas().size());
        
        grafo.eliminarArista(nodo1, nodo2);
        
        assertEquals(0, grafo.getAristas().size());

    }
    
    @Test
    public void testAgregarNodoAlGrafo() {
        Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo = new Nodo("A",0,15,5);
        
        assertTrue(grafo.agregarNodoAlGrafo(nodo));
        
        assertEquals(1, grafo.getNodos().size());
        assertTrue(grafo.getNodos().contains(nodo));
        assertTrue(grafo.getGrafo().containsKey(nodo));
    }
    
    @Test
    public void verMatrizDeAdyecencia() {
    	Grafo<Nodo> grafo = new Grafo<>();
        Nodo nodo1 = new Nodo("Nodo 1",0,5,10);
        Nodo nodo2 = new Nodo("Nodo 2",1,10,5);
        Nodo nodo3 = new Nodo("Nodo 3",2,20,5);
        Nodo nodo4 = new Nodo("Nodo 4",3,30,8);

        grafo.agregarNodo(nodo1);
        grafo.agregarNodo(nodo2);
        grafo.agregarNodo(nodo3);
        grafo.agregarNodo(nodo4);

        grafo.agregarArista(nodo1, nodo2);
        grafo.agregarArista(nodo2, nodo3);
        grafo.agregarArista(nodo3, nodo4);
        grafo.agregarArista(nodo2, nodo4);
        grafo.agregarArista(nodo4, nodo1);
        
        String matriz="[0][1][0][1]\n[1][0][1][1]\n[0][1][0][1]\n[1][1][1][0]\n";
        
        
        int[][] generandoMatriz = grafo.hallarMatrizDeAdyecencia();
        assertEquals(matriz, grafo.adyStr(generandoMatriz));
        
    }

}
