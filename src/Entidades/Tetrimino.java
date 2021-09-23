package Entidades;

import java.awt.Color;

public abstract class Tetrimino{

    // Atributos de clase.
	
    protected static final int cantidadCuadrados = 4;
    
    // Atributos de instancia.
    
    protected Grilla miGrilla;
    protected Par [][] rotaciones;
    protected Par [] posicionesActuales;
    protected Color color;
    protected int rotacionActual;
    protected Par centroPieza;

    /*
     * Rota el tetrimino hacia la derecha.
     */
    public boolean rotarDerecha() {
    	int rotacionSiguiente = (rotacionActual == 3) ? 0 : (rotacionActual + 1) % 4; 
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
    	int rotacionSiguiente = (rotacionActual == 0) ? 3 : (rotacionActual - 1) % 4;
    	boolean check = miGrilla.buscarColisiones (centroPieza.getX(), centroPieza.getY(), rotaciones [rotacionSiguiente]);
    	
    	if (!check) { 
    		posicionesActuales = rotaciones [rotacionSiguiente];
    		rotacionActual = rotacionSiguiente;
    	}
    	
    	return !check;
    }
    
    /**
     * Mueve el tetrimino a derecha.
     * @return
     */
    public boolean moverDerecha() {
        boolean check = miGrilla.buscarColisiones(centroPieza.getX() + 1, centroPieza.getY(), rotaciones[rotacionActual]);
        
        if (!check) 
            centroPieza.setX(centroPieza.getX() + 1);
        
        return !check;
    }
    
    /*
     * Mueve el tetrimino a izquierda.
     */
    public boolean moverIzquierda() {
        boolean check = miGrilla.buscarColisiones(centroPieza.getX() - 1, centroPieza.getY(), rotaciones[rotacionActual]);
        
        if (!check) 
            centroPieza.setX(centroPieza.getX() - 1);
        
        return !check;
    }
    
    public boolean moverAbajo() {
    	boolean check = miGrilla.buscarColisiones(centroPieza.getX(), centroPieza.getY() + 1, rotaciones[rotacionActual]);
    	if (!check) 
    		centroPieza.setY(centroPieza.getY() + 1);	
    	return !check;
    }

    /*
     * Retorna las posiciones actuales del tetrimino.
     * @return Posiciones del tetrimino.
     */
    public Par [] getPosicionesActuales() {
        return posicionesActuales;
    }

    /*
     * Retorna el color del tetrimino. 
     * @return Color del tetrimino.
     */
    public Color getColor() {
        return color;
    }

	public Par getCentroPieza() {
		return centroPieza;
	}
	
	public int getRotacionActual() {
		return rotacionActual;
	}
	
	public abstract Tetrimino clone();
}
