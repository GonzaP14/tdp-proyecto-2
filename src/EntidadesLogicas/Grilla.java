package EntidadesLogicas;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import Tetrimino.Tetrimino;
 
public class Grilla {
    	
	// Atributos de Clase.
        
    protected static final Par origenGrilla = new Par(3, 0);
        
	// Atributos de instancia.
        
    private Bloque grilla[][];
    protected final ImageIcon negro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/CuadradoNegro.png")));

    // Constructor.
  
    /**
     * Crea una nueva Grilla.
     */
    public Grilla() {
    	grilla = new Bloque[22][10];
          
    	for (int filas = 0; filas < 22; filas ++) {
    		for (int columnas = 0; columnas < 10; columnas++) {                    
    			grilla[filas][columnas] = new Bloque(negro);       
            }
    	}
    }
    
    /**
     * Retorna el Color negro.
     * @return ImagenIcon asociada al color negro.
     */
    public ImageIcon getNegro() {
    	return negro;
	}
        
    /**
     * Busca las colisiones de un conjunto de Pares en la Grilla.
     * @param valorX Coordenada x del centro del Tetrimino.
     * @param valorY Coordenada y del centro del Tetrimino.
     * @param posicionesActuales Posiciones actuales del Tetrimino.
     * @return true si se encontró colisiones y false en caso contrario.
     */
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
        
    /**
     * Retorna un bloque de la Grilla en específico.
     * @param x Fila de la Grilla.
     * @param y Columna de la Grilla.
     * @return Bloque de la posición (x,y) de la Grilla.
     */
    public Bloque getBloque(int x,int y) {
    	return grilla[x][y];
    }
        
    /**
     * Retorna el origen de la Grilla.
     * @return Origen de la grilla.
     */
    public Par getOrigenGrilla() {
    	return origenGrilla;
    }
     
    /**
     * Establece un nuevo bloque en una posición específica de la Grilla.
     * @param x Coordenada x de la Grilla.
     * @param y Coordenada y de la Grilla.
     * @param b Bloque a establecer.
     */
    public void setBloque(int x, int y, Bloque b) {
    	grilla[x][y] = b;
    }
        
    /**
     * Actualiza el color de un bloque específico en la Grilla.
     * @param x Coordenada x de la Grilla.
     * @param y Coordenada y de la Grilla.
     * @param color Color a establecer.
     */
    public void actualizarColorBloque(int x, int y, ImageIcon color) {
    	grilla[x][y].setColor(color);
    }        
        
    /**
     * Elimina una linea de la grilla.
     * @param fila Fila / Linea que debe ser eliminada.
     */
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
        
    /**
     * Acopla el tetrimino a la grilla.
     * @param t Tetrimino a acoplar.
     */
    public void acoplarTetriminoAGrilla(Tetrimino t) {
    	Par[] posicionesAOcupar = t.getPosicionesActuales();

    	for (Par p: posicionesAOcupar) {
    		grilla[p.getY() + t.getCentroPieza().getY()][p.getX() + t.getCentroPieza().getX()].setColor(t.getColor());
        }       
    }
    /**
     * Resetea la grilla 
     */
    public void reset() {
		for(int filas = 0; filas<22; filas++) {
            for(int columnas = 0; columnas < 10; columnas++) {                    
                grilla[filas][columnas].setColor(negro);     
            }
        }
	}    
}