package Entidades;

import java.awt.Color;

public class FormaZ extends Tetrimino {
	
	public FormaZ (Grilla miGrilla) {	
		rotacionActual = 0;
		rotaciones = new Par[][]{
			{ new Par(0, 0), new Par(1, 0), new Par(1, 1), new Par(2, 1) },
			{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(0, 2) },
			{ new Par(0, 0), new Par(1, 0), new Par(1, 1), new Par(2, 1) },
			{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(0, 2) } 
		};
		posicionesActuales = rotaciones[0];
		color = Color.green;
		centroPieza = miGrilla.getOrigenGrilla();
		this.miGrilla = miGrilla;
	}

	@Override
	public Tetrimino clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
