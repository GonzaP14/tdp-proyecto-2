package Entidades;

import java.awt.Color;

public class FormaJ extends Tetrimino {	
	
	public FormaJ (Grilla miGrilla) {		
		rotacionActual = 0;
		rotaciones = new Par[][]{
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(2, 0) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(2, 2) },
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(0, 2) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(0, 0) } 
		};
		posicionesActuales = rotaciones[0];
		color = Color.blue;
		centroPieza = miGrilla.getOrigenGrilla();
		this.miGrilla = miGrilla;
	}
	
}
