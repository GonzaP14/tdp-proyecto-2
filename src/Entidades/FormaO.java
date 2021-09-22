package Entidades;

import java.awt.Color;

public class FormaO extends Tetrimino {
	
	public FormaO (Grilla miGrilla , int r , Par centro) {
		rotacionActual = r;
		rotaciones = new Par[][]
			{ { new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) } };
		posicionesActuales = rotaciones[rotacionActual];
		color = Color.yellow;
		centroPieza = centro;
		this.miGrilla = miGrilla;
	}
	
	public FormaO (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

	public boolean rotarDerecha() {
		return false;
	}
	
	public boolean rotarIzquierda() {
		return false;
	}
	
	public Tetrimino clone() {
        return new FormaO (miGrilla, rotacionActual, centroPieza.clone());
    }
	
}