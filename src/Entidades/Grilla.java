package Entidades;

	import java.awt.Color;
import java.awt.Point;
import java.util.Collections;

	public class Grilla {
		// Atributos de clase
		protected static final Par origenGrilla = new Par(3, 0);
		
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
	    	int nuevoValorEnX,nuevoValorEnY;
	    	for (Par parBloqueActual : posicionesActuales) {
	    		nuevoValorEnX = valorX + parBloqueActual.getX();
	    		nuevoValorEnY = valorY + parBloqueActual.getY();
	    		if(nuevoValorEnX>9 || nuevoValorEnX<0 || nuevoValorEnY>=21 ||  grilla[nuevoValorEnY][nuevoValorEnX].getColor() != Color.BLACK){
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
		public void actualizarColorBloque(int x, int y, int indice) {
			grilla[x][y].setIndice(indice);
		}		
		
	    
	    public void reacomodarGrilla(int fila) {
	    	for (int j = fila - 1; j > 0; j--) {
				for (int i = 1; i < 11; i++) {
					grilla[i][j+1] = grilla[i][j];
				}
			}
	    }

		public void acoplarTetriminoAGrilla(Tetrimino t) {
			Par[] posicionesAOcupar = t.getPosicionesActuales();

	    	for(int i = 0; i < 4; i++) {
	    		grilla[posicionesAOcupar[i].getY() + t.getCentroPieza().getY()][posicionesAOcupar[i].getX() + t.getCentroPieza().getX()].setColor(t.getColor());
	    	}		
	    }
	}
	

