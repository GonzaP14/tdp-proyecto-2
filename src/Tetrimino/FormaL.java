package Tetrimino;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

public class FormaL extends Tetrimino {

    public FormaL (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

    public FormaL (Grilla miGrilla, int r, Par centro) {
        rotaciones =  new Par [][] { 
        	{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(2, 2) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(0, 2) },
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(0, 0) },
			{ new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(2, 0) } 
		};
        rotacionActual = r;
        posicionesActuales = rotaciones[rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoNaranja.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }

    public Tetrimino clone() {
        return new FormaL (miGrilla, rotacionActual, centroPieza.clone());
    }
}
