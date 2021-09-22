package PartesGraficas;

import java.awt.Color;
import Entidades.Bloque;
import Entidades.Par;
import Entidades.Tetrimino;

/**
 * Class GrillaGrafica - Modela la GrillaGrafica asociada al juego.
 * @author Grupo N°
 */
public class GrillaGrafica {

	private Bloque grilla[][];

	public GrillaGrafica() {
		grilla = new Bloque[22][10];
		        
		for (int filas = 0; filas < 22; filas ++) {
			for (int columnas = 0; columnas < 10; columnas ++) {	   
				grilla[filas][columnas]= new Bloque ();	   
			}
	    }
		
	}

	public Bloque getBloque(int x,int y) {
		return grilla[x][y];
	}
		
	public void setBloque(int x, int y, Bloque b) {
		grilla[x][y]=b;
	}
		
	public void actualizarColorBloque(int x,int y,int indice) {
		grilla[x][y].setIndice(indice);
	}
	
	public void acoplarTetriminoAGrillaGrafica(Par[] posicionesActuales) {
		for (int i = 0; i < 4; i ++) {
			// Discutir implementación.
			// Pienso que con actualizar alcanza.
		}
	}

	public void actualizar (Par [] posiciones, Color color) {
		for (int i = 0; i < 4; i ++) {
			grilla [posiciones [i].getX()][posiciones [i].getY()].setColor(color); 
		}
	}

	public void mostrarNuevoTetrimino(Tetrimino tetriminoActual) {
		Color colorTetrimino = tetriminoActual.getColor();
		Par centro = tetriminoActual.getCentroPieza();
		Par [] posiciones = tetriminoActual.getPosicionesActuales();
		
		for (int i = 0; i < 4; i ++) {
			grilla [posiciones[i].getX() + centro.getX()][posiciones[i].getY() + centro.getX()].setColor(colorTetrimino);
		}
	}

	public void reacomodarGrillaGrafica(int fila) {
		for (int i = fila - 1; i > 0; i --) {
			for (int j = 1; j < 11; j ++) {
				grilla [i][j + 1] = grilla [i][j];
			}
		}
	}		
		
}	
