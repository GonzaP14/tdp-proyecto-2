package Tetrimino;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

public class FormaO extends Tetrimino {
	
	public FormaO (Grilla miGrilla , int r , Par centro) {
		rotacionActual = r;
		rotaciones = new Par[][] {{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) }};
		posicionesActuales = rotaciones[rotacionActual];
		color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoAmarillo.png")));
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