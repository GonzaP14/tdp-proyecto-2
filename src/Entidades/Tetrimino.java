package Entidades;
import java.awt.Color;
public abstract class Tetrimino {
	protected int cantidadCuadrados;
	protected Par[] posicionesCuadrados;
	protected Color color;
	protected int rotacionActual;
	
	public abstract void rotarDerecha();
	
	public abstract void rotarIzquierda();
	
	public abstract Par[] dondeMoverIzquierda();
	
	public abstract Par[] dondeMoverDerecha();
	
	public abstract Par[] dondeMoverAbajo();
	
	public abstract Par[] dondeRotarDerecha();
	
	public abstract Par[] dondeRotarIzquierda();
}
