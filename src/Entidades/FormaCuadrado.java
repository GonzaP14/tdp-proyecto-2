package Entidades;

import java.awt.Color;

public class FormaCuadrado extends Tetrimino {
	
	public FormaCuadrado (Grilla miGrilla) {
		rotacionActual = 0;
		rotaciones = new Par[][]
			{ { new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) } };
		posicionesActuales = rotaciones[0];
		color = Color.yellow;
		centroPieza = miGrilla.getOrigenGrilla();
		this.miGrilla = miGrilla;
	}

	@Override
	public Tetrimino clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}