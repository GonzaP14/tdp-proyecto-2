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
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con un movimiento a izquierda.
	 * @return Posiciones del tetrimino con movimiento a izquierda.
	 */
	public abstract Par[] dondeMoverIzquierda();
		
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con un movimiento a derecha.
	 * @return Posiciones del tetrimino con movimiento a derecha.
	 */
	public abstract Par[] dondeMoverDerecha();
	
	/**
	 * Retorna las posiciones a las cuales se trasladar�a el tetrimino con un movimiento hacia abajo.
	 * @return Posiciones del tetrimino con movimiento hacia a abajo.
	 */
	public abstract Par[] dondeMoverAbajo();
	
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
	public abstract Par [] getPosicionesCuadrado();
	
	/**
	 * Establece las posiciones del tetrimino. 
	 * @param posicionesCuadrados Posiciones nuevas del tetrimino.
	 */
	public abstract void setPosicionesCuadrado(Par [] posicionesCuadrados);
	
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
	 * Establece la rotaci�n del tetrimino.
	 * @param rotacionActual Rotacion nueva del tetrimino.
	 */
	public abstract void setRotacion(int rotacionActual);
}