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
	public abstract void rotarDerecha();
	
	/**
	 * Rota el tetrimino hacia la izquierda.
	 */
	public abstract void rotarIzquierda();
	
	/**
	 * Retorna las posiciones a las cuales se trasladaría el tetrimino con un movimiento a izquierda.
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
	 * Retorna las posiciones a las cuales se trasladaría el tetrimino con un movimiento a derecha.
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
	 * Retorna las posiciones a las cuales se trasladaría el tetrimino con un movimiento hacia abajo.
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
	 * Retorna las posiciones a las cuales se trasladaría el tetrimino con una rotación a derecha.
	 * @return Posiciones del tetrimino con rotación a derecha.
	 */
	public abstract Par[] dondeRotarDerecha();
	
	/**
	 * Retorna las posiciones a las cuales se trasladaría el tetrimino con una rotación a izquierda.
	 * @return Posiciones del tetrimino con rotación a izquierda.
	 */
	public abstract Par[] dondeRotarIzquierda();
	
	/**
	 * Retorna las posiciones actuales del tetrimino.
	 * @return Posiciones del tetrimino.
	 */
	public abstract Par [] getPosicionesCuadrado();
		
	/**
	 * Retorna el color del tetrimino. 
	 * @return Color del tetrimino.
	 */
	public abstract Color getColor();
	
	/**
	 * Establece el color del tetrimino.
	 * @param color Color nuevo del tetrimino.
	 */
	public abstract void setColor(Color color);
	
	/**
	 * Retorna la rotacion actual del tetrimino.
	 * @return Rotacion actual del tetrimino.
	 */
	public abstract int getRotacion();
	
	/**
	 * Establece la rotación del tetrimino.
	 * @param rotacionActual Rotacion nueva del tetrimino.
	 */
}
