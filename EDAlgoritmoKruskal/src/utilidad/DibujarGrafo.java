package utilidad;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JComponent;

import algoritmo.Grafo;
import algoritmo.Nodo;

public class DibujarGrafo extends JComponent{
	private Grafo<Nodo> grafito;
	private int[][] matrizAdyacencia;

	public DibujarGrafo(Grafo<Nodo> grafito) {
		super();
		this.grafito = grafito;
		this.matrizAdyacencia = grafito.hallarMatrizDeAdyecencia();
	}
	
	public void setGrafo(Grafo<Nodo> newGrafito) {
		this.grafito = newGrafito;
		this.matrizAdyacencia = grafito.hallarMatrizDeAdyecencia();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int numNodos = matrizAdyacencia.length;
		List<Nodo> nodos = grafito.getNodos();
		int[] coordenadasX=new int[nodos.size()];
		int[] coordenadasY=new int[nodos.size()];
		int inicial = 0;
		super.paintComponent(g);
    	for(Nodo a : nodos) {
    		g.fillOval(a.getCoordenada_X()-10,a.getCoordenada_Y()-10,20,20);
    		coordenadasX[inicial]=a.getCoordenada_X();
    		coordenadasY[inicial]=a.getCoordenada_Y();
    		inicial++;
    		
    	}
    	
    	for (int i = 0; i < numNodos; i++) {
    		for (int j = i+1; j < numNodos; j++){ 
    			if (matrizAdyacencia[i][j] == 1) {
    					g.drawLine(coordenadasX[i], coordenadasY[i], coordenadasX[j], coordenadasY[j]);
    			}
    		}
    	}
	}
	
}
