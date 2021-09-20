package Entidades;

import java.awt.Color;

public class FormaL extends Tetrimino {
	
	public FormaL (Par [] posicionesCuadrados, Color color) {
		this.posicionesCuadrados = posicionesCuadrados;
		this.color = color;
		this.rotacionActual = 0;
	}

	@Override
	public Par[] dondeRotarDerecha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Par[] dondeRotarIzquierda() {
		// TODO Auto-generated method stub
		return null;
	}

}