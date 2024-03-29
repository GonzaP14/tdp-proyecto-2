package Tetrimino;

import javax.swing.ImageIcon;
import EntidadesLogicas.Grilla;
import EntidadesLogicas.Logica;
import EntidadesLogicas.Par;

/**
 * Class Tetrimino - Modela un Tetrimino del Juego.
 * @author Grupo N�2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Mart�n, Mandolesi Bruno.
 */
public abstract class Tetrimino {
    
    // Atributos de instancia.
    
    protected Grilla miGrilla;
    protected Par [][] rotaciones;
    protected Par [] posicionesActuales;
    protected ImageIcon color;
    protected ImageIcon imagen;
    protected int rotacionActual;
    protected Par centroPieza;
    
    /**
     * Consulta si es posible rotar en una direcci�n (izquierda o derecha).
     * @param i: Rotaci�n deseada.
     * @return true si puede realizar la rotaci�n y false en caso contrario.
     */
    public boolean puedeRotar (int i) {
    	return !miGrilla.buscarColisiones (centroPieza.getX(), centroPieza.getY(), rotaciones [rotacionSiguiente(i)]);
    }
    
    /**
     * Calcula la rotacionSiguiente del Tetrimino a partir de un par�metro determinado.
     * @param i: Par�metro de rotaci�n.
     * @return Rotaci�n siguiente del Tetrimino.
     */
    public int rotacionSiguiente (int i) {
    	int rotacionSiguiente = 0;
    	
    	if (i == Logica.rotarDerecha) {
    		rotacionSiguiente = (rotacionActual + 1) % 4;
    	} else if (i == Logica.rotarIzquierda) {
    		rotacionSiguiente = (rotacionActual == 0) ? 3 : (rotacionActual - 1) ;
    	}
    	return rotacionSiguiente;
    }
    
    /**
     * Rota el Tetrimino en una direcci�n (izquierda o derecha).
     * @param i: Parametro de rotaci�n.
     */
    public void rotar(int i) {
    	int nuevaRotacion = rotacionSiguiente(i);
    	
    	posicionesActuales = rotaciones [nuevaRotacion];
		rotacionActual = nuevaRotacion;
    }
    
    /**
     * Consulta si es posible mover en una direcci�n (izquierda, derecha y abajo).
     * @param i: Par�metro de movimiento.
     * @return true si pudo realizar el movimiento y false en caso contrario.
     */
    public boolean puedeMover (int i) {
    	boolean check = false;
    	
    	if (i == Logica.moverDerecha) { 
    		check = miGrilla.buscarColisiones(centroPieza.getX() + 1, centroPieza.getY(), rotaciones[rotacionActual]);
    	} 
    	else if (i == Logica.moverIzquierda) {
    		check = miGrilla.buscarColisiones(centroPieza.getX() - 1, centroPieza.getY(), rotaciones[rotacionActual]);
    	}
    	else if (i == Logica.moverAbajo) {
    		check = miGrilla.buscarColisiones(centroPieza.getX(), centroPieza.getY() + 1, rotaciones[rotacionActual]);
    	}
    	
    	return !check;
    }
    
    /**
     * Mueve el Tetrimino en el sentido correspondiente, segun el i dado.
     * @param i Parametro de movimiento.
     */
    public void mover(int i) {
    	if (i == Logica.moverDerecha) {
			moverDerecha();
		}
    	else if (i == Logica.moverIzquierda){
    		moverIzquierda();
    	}
    	else if (i == Logica.moverAbajo) {
    		moverAbajo();
    	}
	}
    
    /**
     * Mueve el Tetrimino hacia la izquierda.
     */
    private void moverIzquierda() {
    	centroPieza.setX(centroPieza.getX() - 1);
    }
    
    /**
     * Mueve el Tetrimino hacia la derecha.
     */
    private void moverDerecha () {
    	centroPieza.setX(centroPieza.getX() + 1);
    }
    
    /**
     * Mueve el Tetrimino hacia abajo.
     */
    private void moverAbajo () {
    	centroPieza.setY(centroPieza.getY() + 1);
    }
    
    /*
     * Retorna las posiciones actuales del Tetrimino.
     * @return Posiciones del Tetrimino.
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
     * @return Par asociado al centro Tetrimino.
     */
	public Par getCentroPieza() {
		return centroPieza;
	}
	
	/**
	 * Retorna la imagen de color asociada al Tetrimino.
	 * @return Imagen del Tetrimino en cuestion.
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
