package Tetrimino;

import javax.swing.ImageIcon;
import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

/**
 * Class Tetrimino - Modela un Tetrimino del Juego.
 * @author Grupo N°2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Martín, Mandolesi Bruno.
 */
public abstract class Tetrimino {

    // Atributos de clase.
	
    protected static final int cantidadCuadrados = 4;
    protected static final int rotacionDerecha = 1;
    protected static final int rotacionIzquierda = -1;
    protected static final int movimientoIzquierda = 1;
    protected static final int movimientoDerecha = 1;
    protected static final int movimientoAbajo = -1;
    
    // Atributos de instancia.
    
    protected Grilla miGrilla;
    protected Par [][] rotaciones;
    protected Par [] posicionesActuales;
    protected ImageIcon color;
    protected ImageIcon imagen;
    protected int rotacionActual;
    protected Par centroPieza;
    
    /**
     * Consulta si es posible rotar en una dirección (izquierda o derecha).
     * @param i: Rotación deseada.
     * @return true si puede realizar la rotación y false en caso contrario.
     */
    public boolean puedeRotar (int i) {
    	return miGrilla.buscarColisiones (centroPieza.getX(), centroPieza.getY(), rotaciones [rotacionSiguiente(i)]);
    }
    
    /**
     * Calcula la rotacionSiguiente del Tetrimino a partir de un parámetro determinado.
     * @param i: Parámetro de rotación.
     * @return Rotación siguiente del Tetrimino.
     */
    public int rotacionSiguiente (int i) {
    	int rotacionSiguiente = 0;
    	
    	if (i == rotacionDerecha) {
    		rotacionSiguiente = (rotacionActual + movimientoDerecha) % 4;
    	} else if (i == rotacionIzquierda) {
    		rotacionSiguiente = (rotacionActual == 0) ? 3 : (rotacionActual + rotacionIzquierda) ;
    	}
    	
    	return rotacionSiguiente;
    }
    
    /**
     * Rota el Tetrimino en una dirección (izquierda o derecha).
     * @param i: Parametro de rotación.
     */
    public void rotar(int i) {
    	int nuevaRotacion = rotacionSiguiente(i);
    	
    	posicionesActuales = rotaciones [nuevaRotacion];
		rotacionActual = nuevaRotacion;
    }
    
    /**
     * Consulta si es posible mover en una dirección (izquierda, derecha y abajo).
     * @param i: Parámetro de movimiento.
     * @return true si pudo realizar el movimiento y false en caso contrario.
     */
    public boolean puedeMover (int i) {
    	boolean check = false;
    	
    	if (i == movimientoDerecha || i == movimientoIzquierda) { 
    		check = miGrilla.buscarColisiones(centroPieza.getX() + i, centroPieza.getY(), rotaciones[rotacionActual]);
    	} 
    	else if (i == movimientoAbajo) {
    		check = miGrilla.buscarColisiones(centroPieza.getX(), centroPieza.getY() + i, rotaciones[rotacionActual]);
    	}
    	
    	return check;
    }
    
    /**
     * Realiza un movimiento en una dirección (izquierda, derecha y abajo).
     * @param i: Parámetro de movimiento.
     */
    public void mover (int i) {
    	if (i == movimientoDerecha || i == movimientoIzquierda) { 
    		centroPieza.setX(centroPieza.getX() + i);
    	} 
    	else if (i == movimientoAbajo) {
    		centroPieza.setY(centroPieza.getY() + 1);
    	}
    }

    /*
     * Retorna las posiciones actuales del tetrimino.
     * @return Posiciones del tetrimino.
     */
    public Par [] getPosicionesActuales() {
        return posicionesActuales;
    }

    /**
     * Retorna la imagen de color asociada al Tetrimino.
     * @return Imagen asociada al Tetrimino.
     */
    public ImageIcon getColor () {
    	return color;
    }
 
    /**
     * Retorna el par centro del Tetrimino. 
     * @return Par asociado al centro Tetrimino
     */
	public Par getCentroPieza() {
		return centroPieza;
	}
	
	/**
	 * 
	 * @return Imagen del tetrimino en cuestion
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * Retorna un clone en profundidad asociado al Tetrimino.
	 * @return Clone del Tetrimino.
	 */
	public abstract Tetrimino clone();
	
}
