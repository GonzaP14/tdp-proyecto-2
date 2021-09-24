package Entidades;

import javax.swing.ImageIcon;

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

    /**
     * Rota el tetrimino hacia la derecha.
     * @return true si el Tetrimino pudo rotar a derecha y false en caso contrario.
     */
    public boolean rotarDerecha() {
    	return rotar(1);
    }

    /**
     * Rota el tetrimino hacia la izquierda.
     * @return true si el Tetrimino pudo rotar a izquierda y false en caso contrario.
     */
    public boolean rotarIzquierda() {
    	return rotar(-1);
    }
    
    /**
     * Rota el tetrimino a derecha o izquierda.
     * @param i Parametro de rotacion: 1 (Rotación a Derecha) y -1 (Rotación a Izquierda).
     * @return true si el Tetrimino pudo rotar y false en caso contrario.
     */
    private boolean rotar(int i) {
    	int rotacionSiguiente = 0;
    	boolean check;
    	
    	if (i == 1) {
    		rotacionSiguiente = (rotacionActual + 1) % 4;
    	} else if (i == -1) {
    		rotacionSiguiente = (rotacionActual == 0) ? 3 : (rotacionActual - 1) ;
    	}
    	
    	check = miGrilla.buscarColisiones (centroPieza.getX(), centroPieza.getY(), rotaciones [rotacionSiguiente]);
    	
    	if (!check) {
    		posicionesActuales = rotaciones [rotacionSiguiente];
    		rotacionActual = rotacionSiguiente;
    	}
    	
    	
    	return (!check);
    }
    
    
    /**
     * Mueve el Tetrimino hacia la derecha.
     * @return true si el movimiento a derecha fue posible y false en caso contrario.
     */
    public boolean moverDerecha() {
        return moverLateralmente(1);
    }
    
    /**
     * Mueve el Tetrimino hacia la izquierda.
     * @return true si el movimiento a izquierda fue posible y false en caso contrario.
     */
    public boolean moverIzquierda() {
        return moverLateralmente(-1);
    }
    
    /**
     * Mueve el Tetrimino lateralmente.
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
     * Mueve el Tetrimino hacia abajo.
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
	
	public abstract Tetrimino clone();
	
}
