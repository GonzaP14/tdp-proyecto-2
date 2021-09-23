package Entidades;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FormaT extends Tetrimino {

    public FormaT (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }
    
    public FormaT (Grilla miGrilla, int rotacion, Par centro) {
        rotaciones =  new Par [][] {
    	{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(2, 1) },
		{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) },
		{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(1, 2) },
		{ new Par(1, 0), new Par(1, 1), new Par(2, 1), new Par(1, 2) }
    };
        rotacionActual = rotacion;
        posicionesActuales = rotaciones [rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoMagenta.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }

    public Tetrimino clone() {
        return new FormaT (miGrilla, rotacionActual, centroPieza.clone());
    }

}