package Entidades;

import java.awt.Color;

public class FormaI extends Tetrimino {
	
	public FormaI() {
		rotacionActual = 0;
		posicionesCuadrados = new Par[4];
		for( int i = 0; i < cantidadCuadrados ; i++) {
			posicionesCuadrados[i] = new Par(i,0);
		}
		color = new Color(0,255,255);
	}


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

	@Override
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

	@Override
	//Hay que modificar rotaciones,no estan bien todavia
	public Par[] dondeRotarDerecha() {
		Par[] posicionesARotar = new Par[4];
		if( rotacionActual == 0 || rotacionActual == 180 ) {
			for(int i = 0; i < cantidadCuadrados ; i++) {
				posicionesARotar[i] = new Par( posicionesCuadrados[i].getX() + 1 , posicionesCuadrados[i].getY() );
			}
		}
		else {
			for(int i = 0; i < cantidadCuadrados ; i++) {
				posicionesARotar[i] = new Par( posicionesCuadrados[i].getX() + 1 , posicionesCuadrados[i].getY() );
			}
		}
		return posicionesARotar;
	}

	@Override
	public Par[] dondeRotarIzquierda() {
		Par[] posicionesARotar = new Par[4];
		if( rotacionActual == 0 || rotacionActual == 180 ) {
			for(int i = 0; i < cantidadCuadrados ; i++) {
				posicionesARotar[i] = new Par( posicionesCuadrados[i].getX() + 1 , posicionesCuadrados[i].getY() );
			}
		}
		else {
			for(int i = 0; i < cantidadCuadrados ; i++) {
				posicionesARotar[i] = new Par( posicionesCuadrados[i].getX() + 1 , posicionesCuadrados[i].getY() );
			}
		}
		return posicionesARotar;
	}


	@Override
	public Par[] getPosicionesCuadrado() {
		return posicionesCuadrados;
	}

	@Override
	public Color getColor() {
		return color;
	}


	@Override
	public void setColor(Color color) {
		color = this.color;
		
	}


	@Override
	public int getRotacion() {
		return rotacionActual;
	}

	
}
