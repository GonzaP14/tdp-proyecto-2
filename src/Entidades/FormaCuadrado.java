package Entidades;

import java.awt.Color;

public class FormaCuadrado extends Tetrimino {
	
	public FormaCuadrado (Grilla miGrilla , int r , Par centro) {
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
	
	public FormaCuadrado (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

	public Tetrimino clone() {
        return new FormaCuadrado (miGrilla, rotacionActual, centroPieza.clone());
    }
	
}