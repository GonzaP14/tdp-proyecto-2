package Tetrimino;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

public class FormaO extends Tetrimino {
	 /**
	  * Crea un nuevo tetrimino con la forma O
	  * @param miGrilla Grilla a la cual el tetrimino pertenece
	  * @param r Rotacion actual del tetrimino
	  * @param centro Coordenadas actuales del bloque central del tetrimino en cuestion
	  */
	public FormaO (Grilla miGrilla , int r , Par centro) {
		rotacionActual = r;
		rotaciones = crearRotaciones();
		posicionesActuales = rotaciones[rotacionActual];
		color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoAmarillo.png")));
		centroPieza = centro;
		this.miGrilla = miGrilla;
	}
	
	/**
	 * Crea un nuevo tetrimino con la forma O, rotacion y centro de pieza por defecto.
	 * @param miGrilla Grilla a la cual el tetrimino pertenece
	 */
	public FormaO (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

	/**
	 * 
	 * @return Devuelve las rotaciones posibles del tetrimino en cuestion
	 */
	public Par[][] crearRotaciones() {
		Par[][] rotaciones = new Par[][]{{ new Par(0, 0), new Par(0, 1), new Par(1, 0), new Par(1, 1) }};
		return rotaciones;
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