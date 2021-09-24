package Tetrimino;

import javax.swing.ImageIcon;

import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

public abstract class Tetrimino {

    // Atributos de clase.
	
    protected static final int cantidadCuadrados = 4;
    
    // Atributos de instancia.
    
    protected Grilla miGrilla;
    protected Par [][] rotaciones;
    protected Par [] posicionesActuales;
    protected ImageIcon color;
    protected int rotacionActual;
    protected Par centroPieza;

    /*
     * Rota el tetrimino hacia la derecha.
     */
    public boolean rotarDerecha() {
    	int rotacionSiguiente = (rotacionActual + 1) % 4; 
    	boolean check = miGrilla.buscarColisiones (centroPieza.getX(), centroPieza.getY(), rotaciones [rotacionSiguiente]);
    	
    	if (!check) {
    		posicionesActuales = rotaciones [rotacionSiguiente];
    		rotacionActual = rotacionSiguiente;
    	}
    	
    	return !check;
    }

    /*
     * Rota el tetrimino hacia la izquierda.
     */
    public boolean rotarIzquierda() {
    	int rotacionSiguiente = (rotacionActual == 0) ? 3 : (rotacionActual - 1) ;
    	boolean check = miGrilla.buscarColisiones (centroPieza.getX(), centroPieza.getY(), rotaciones [rotacionSiguiente]);
    	
    	if (!check) {
    		posicionesActuales = rotaciones [rotacionSiguiente];
    		rotacionActual = rotacionSiguiente;
    	}
    	return !check;
    }
    
    /**
     * @return true si el movimiento a derecha fue posible y false en caso contrario.
     */
    public boolean moverDerecha() {
        return moverLateralmente(1);
    }
    
    /**
     * @return true si el movimiento a izquierda fue posible y false en caso contrario.
     */
    public boolean moverIzquierda() {
        return moverLateralmente(-1);
    }
    
    /**
     * @param i parametro de desplazamiento: 1 (movimiento a derecha) y -1 (movimiento a izquierda)
     * @return true si el movimiento lateral fue posible y false en caso contrario.
     */
    private boolean moverLateralmente(int i) {
    	boolean check = miGrilla.buscarColisiones(centroPieza.getX() + i, centroPieza.getY(), rotaciones[rotacionActual]);
        
        if (!check) {
            centroPieza.setX(centroPieza.getX() + i);
        }
        
        return (!check);	
    }
    
    /**
     * @return true si el movimiento hacia abajo fue posible y false en caso contrario.
     */
    public boolean moverAbajo() {
    	boolean check = miGrilla.buscarColisiones(centroPieza.getX(), centroPieza.getY() + 1, rotaciones[rotacionActual]);
    	
    	if (!check) {
    		centroPieza.setY(centroPieza.getY() + 1);
    	}
    	
    	return (!check);
    }

    /*
     * Retorna las posiciones actuales del tetrimino.
     * @return Posiciones del tetrimino.
     */
    public Par [] getPosicionesActuales() {
        return posicionesActuales;
    }

    /*
     * @return ImageIcon del Color del tetrimino.
     */
    public ImageIcon getColor () {
    	return color;
    }
 
	public Par getCentroPieza() {
		return centroPieza;
	}
	
	public abstract Tetrimino clone();
	
}
