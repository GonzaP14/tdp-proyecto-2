package Entidades;

	import java.awt.Color;
import java.awt.Point;
import java.util.Collections;

	public class Grilla {
		// Atributos de clase
		protected static final Par origenGrilla = new Par(5, 0);
		
	    //Atributos de instancia
		private Bloque grilla[][];

		// Constructor
	    public Grilla() {
	    	grilla = new Bloque[22][10];
	        for(int filas = 0; filas<21; filas++) {
	        	for(int columnas = 0; columnas < 10; columnas++) {	        		
	        		grilla[filas][columnas] = new Bloque();	   
	        	}
	        }
	    }

	    //Buscar Colisiones
	    public boolean buscarColisiones(int valorX, int valorY, Par[] posicionesActuales) {
	    	for (Par parBloqueActual : posicionesActuales) {
				if (grilla[parBloqueActual.getX() + valorX][parBloqueActual.getY() + valorY].getColor() != Color.BLACK) {
					return true;
				}
			}
			return false;
	    }
	    
	    public Bloque getBloque(int x,int y) {
			return grilla[x][y];
		}
	    
	    public Par getOrigenGrilla() {
	    	return origenGrilla;
	    }
	    
		public void setBloque(int x, int y, Bloque b) {
			grilla[x][y]=b;
		}
		public void actualizarColorBloque(int x,int y,int indice) {
			grilla[x][y].setIndice(indice);
		}		
		
		//OcuparCelda
	    public void  ocuparCelda(Tetrimino t) {
	    	Par[] posicionesAOcupar = t.getPosicionesActuales();
	    	
	    	for(int i = 0; i < 4; i++) {
	    		grilla[posicionesAOcupar[i].getX() + t.getCentroPieza().getX()][posicionesAOcupar[i].getY() + t.getCentroPieza().getY()].getColor() = t.getColor();
	    	}
	    }
	}
	

