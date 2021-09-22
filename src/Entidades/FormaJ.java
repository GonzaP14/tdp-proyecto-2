package Entidades;

import java.awt.Color;

public class FormaJ extends Tetrimino {	
	
	public FormaJ (Grilla miGrilla , int r , Par centro ) {		
		rotacionActual = r;
		rotaciones = new Par[][]{
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(2, 0) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(2, 2) },
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(0, 2) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(0, 0) } 
		};
		posicionesActuales = rotaciones[rotacionActual];
		color = Color.blue;
		centroPieza = centro;
		this.miGrilla = miGrilla;
	}
	
	public FormaJ( Grilla miGrilla ) {
		this(miGrilla , 0 , miGrilla.getOrigenGrilla() );
	}
	@Override
	public Tetrimino clone() {
		return new FormaJ(miGrilla , rotacionActual , centroPieza.clone() );
	}
	
}
