package Entidades;
import java.awt.Color;

public abstract class Tetrimino {
	
	// Atributos de clase.
	
	protected static final int cantidadCuadrados = 4;
	
	// Atributos de instancia.
	
	protected Par[] posicionesCuadrados;
	protected Color color;
	protected int rotacionActual;
	
	/**
	 * Rota el tetrimino hacia la derecha.
	 */
	public void rotarDerecha() {
		if(rotacionActual == 0) {
			rotacionActual = 270;
			posicionesCuadrados = dondeRotarDerecha();
		}
		else {
			rotacionActual -= 90;
			posicionesCuadrados = dondeRotarDerecha();
		}
	}
	
	/**
	 * Rota el tetrimino hacia la izquierda.
	 */
	public void rotarIzquierda() {
		if(rotacionActual == 270) {
			rotacionActual = 0;
			posicionesCuadrados = dondeRotarIzquierda();
		}
		else {
			rotacionActual += 90;
			posicionesCuadrados = dondeRotarIzquierda();
		}
	}
	
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con un movimiento a izquierda.
	 * @return Posiciones del tetrimino con movimiento a izquierda.
	 */
	public Par[] dondeMoverIzquierda() {
		Par[] posicionesAMover = new Par[4];
		for(int i = 0; i < cantidadCuadrados ; i++) {
			posicionesAMover[i] = new Par( posicionesCuadrados[i].getX() - 1 , posicionesCuadrados[i].getY() );
		}
		return posicionesAMover;
	}
		
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con un movimiento a derecha.
	 * @return Posiciones del tetrimino con movimiento a derecha.
	 */
	public Par[] dondeMoverDerecha() {
		Par[] posicionesAMover = new Par[4];
		for(int i = 0; i < cantidadCuadrados ; i++) {
			posicionesAMover[i] = new Par( posicionesCuadrados[i].getX() + 1 , posicionesCuadrados[i].getY() );
		}
		return posicionesAMover;
	}
	
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con un movimiento hacia abajo.
	 * @return Posiciones del tetrimino con movimiento hacia a abajo.
	 */
	public Par[] dondeMoverAbajo() {
		Par[] posicionesAMover = new Par[4];
		for(int i = 0; i < cantidadCuadrados ; i++) {
			posicionesAMover[i] = new Par( posicionesCuadrados[i].getX() , posicionesCuadrados[i].getY() - 1 );
		}
		return posicionesAMover;
	}
	
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con una rotaci�n a derecha.
	 * @return Posiciones del tetrimino con rotaci�n a derecha.
	 */
	public abstract Par[] dondeRotarDerecha();
	
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con una rotaci�n a izquierda.
	 * @return Posiciones del tetrimino con rotaci�n a izquierda.
	 */
	public abstract Par[] dondeRotarIzquierda();
	
	/**
	 * Retorna las posiciones actuales del tetrimino.
	 * @return Posiciones del tetrimino.
	 */
	public Par [] getPosicionesCuadrado() {
		return posicionesCuadrados;
	}
		
	/**
	 * Retorna el color del tetrimino. 
	 * @return Color del tetrimino.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Establece el color del tetrimino.
	 * @param color Color nuevo del tetrimino.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Retorna la rotacion actual del tetrimino.
	 * @return Rotacion actual del tetrimino.
	 */
	public int getRotacion() {
		return rotacionActual;
	}
}
