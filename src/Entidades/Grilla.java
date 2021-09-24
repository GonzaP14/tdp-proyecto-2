package Entidades;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

    public class Grilla {
    	
        // Atributos de Clase.
        
    	protected static final Par origenGrilla = new Par(3, 0);
        
		// Atributos de instancia.
        
    	private Bloque grilla[][];
        protected final ImageIcon negro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/CuadradoNegro.png")));

        // Constructor.
  
        public Grilla() {
            grilla = new Bloque[22][10];
            for (int filas = 0; filas < 22; filas ++) {
                for (int columnas = 0; columnas < 10; columnas++) {                    
                    grilla[filas][columnas] = new Bloque(negro);       
                }
            }
        }

        public ImageIcon getNegro() {
			return negro;
		}
        
        public boolean buscarColisiones(int valorX, int valorY, Par[] posicionesActuales) {
	    	int nuevoValorEnX, nuevoValorEnY;
	    	for (Par parBloqueActual : posicionesActuales) {
	    		nuevoValorEnX = parBloqueActual.getX() + valorX;
	    		nuevoValorEnY = parBloqueActual.getY() + valorY;
				if (nuevoValorEnX > 9 || nuevoValorEnX < 0 || nuevoValorEnY > 21 || grilla[nuevoValorEnY][nuevoValorEnX].getColor() != negro) {
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
            grilla[x][y] = b;
        }
        public void actualizarColorBloque(int x, int y, ImageIcon color) {
            grilla[x][y].setColor(color);
        }        
        
        public void eliminarLinea(int fila) {	     	
        	Bloque auxiliar;
        	
        	for (int col = 0; col <  10; col ++) {
        		grilla [fila][col] = new Bloque (negro);
        	}
         	
        	for (int i = fila - 1; i >= 0; i --) {
                for (int j = 0; j < 10; j ++) {
                	auxiliar = grilla [i + 1][j];
                	grilla[i + 1][j] = grilla [i][j];
                	grilla [i][j] = auxiliar;
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