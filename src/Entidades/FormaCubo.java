package Entidades;

import java.awt.Color;

public class FormaCubo extends Tetrimino {
	
	public FormaCubo (Par [] posicionesCuadrados, Color color) {
		this.posicionesCuadrados = posicionesCuadrados;
		this.color = color;
		this.rotacionActual = 0;
	}
	
	public Par[] dondeRotarDerecha() {
		return this.posicionesCuadrados;
	}

	public Par[] dondeRotarIzquierda() {
		return this.posicionesCuadrados;
	}
	
}