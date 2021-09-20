package Entidades;

import java.awt.Color;

public class FormaI extends Tetrimino {
	
	public FormaI(Grilla miGrilla) {
		rotacionActual = 0;
		rotaciones = new Par[][]
				{ { new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
					{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) },
					{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
					{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) } };
			posicionesActuales = rotaciones[0];
			color = Color.cyan;
		centroPieza = origenGrilla;
		this.miGrilla = miGrilla;
	}

}
