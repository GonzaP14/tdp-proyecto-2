package Entidades;

import java.awt.Color;

public class FormaT extends Tetrimino {
	
	public FormaT (Grilla miGrilla) {	
		rotacionActual = 0;
		rotaciones = new Par[][]
			{ { new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(2, 1) },
			{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) },
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(1, 2) },
			{ new Par(1, 0), new Par(1, 1), new Par(2, 1), new Par(1, 2) } };
		posicionesActuales = rotaciones[0];
		color = Color.magenta;
		centroPieza = miGrilla.getOrigenGrilla();
		this.miGrilla = miGrilla;
	}

	@Override
	public Tetrimino clone() {
		// TODO Auto-generated method stub
		return null;
	}

}