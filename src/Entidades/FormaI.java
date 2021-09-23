package Entidades;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FormaI extends Tetrimino {
	
	public FormaI (Grilla miGrilla , int r , Par centro) {
		rotacionActual = r;
		rotaciones = new Par[][]{
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) },
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) }	
		};
		posicionesActuales = rotaciones[rotacionActual];
		color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoCyan.png")));
		centroPieza = centro;
		this.miGrilla = miGrilla;
	}
	
	public FormaI(Grilla miGrilla) {
		this(miGrilla , 0 , miGrilla.getOrigenGrilla() );
	}

	public Tetrimino clone() {
		return new FormaI(miGrilla , rotacionActual , centroPieza.clone() );
	}

	
	
	
	
}
