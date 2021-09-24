package Entidades;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FormaS extends Tetrimino {

    public FormaS (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

    public FormaS (Grilla miGrilla, int r, Par centro) {
        rotaciones =  new Par [][] { 
        	{ new Par(1, 0), new Par(2, 0), new Par(0, 1), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) },
			{ new Par(1, 0), new Par(2, 0), new Par(0, 1), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) } 
		};
        rotacionActual = r;
        posicionesActuales = rotaciones[rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoVerde.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }

    public Tetrimino clone() {
        return new FormaS (miGrilla, rotacionActual, centroPieza.clone());
    }
}
