package Entidades;

import java.awt.Color;

public class FormaI extends Tetrimino {
	
	public FormaI() {
		rotacionActual = 0;
		posicionesCuadrados = new Par[4];
		for( int i = 0; i < cantidadCuadrados ; i++) {
			posicionesCuadrados[i] = new Par(i,0);
		}
		color = Color.cyan;
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
	
}
