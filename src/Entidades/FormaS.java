package Entidades;

import java.awt.Color;

public class FormaS extends Tetrimino {
	
	public FormaS (Grilla miGrilla) {			
		rotacionActual = 0;
		rotaciones = new Par[][]
			{ { new Par(1, 0), new Par(2, 0), new Par(0, 1), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) },
			{ new Par(1, 0), new Par(2, 0), new Par(0, 1), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) } };
		posicionesActuales = rotaciones[0];
		color = Color.red;
		centroPieza = miGrilla.getOrigenGrilla();
		this.miGrilla = miGrilla;
	}

	@Override
	public Tetrimino clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
