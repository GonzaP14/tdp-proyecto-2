package Tetrimino;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

public class FormaZ extends Tetrimino {

	/**
	 * Crea un nuevo tetrimino con la forma Z, rotacion y centro de pieza por defecto.
	 * @param miGrilla Grilla a la cual el tetrimino pertenece
	 */
    public FormaZ (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

    /**
	 * Crea un nuevo tetrimino con la forma Z
	 * @param miGrilla Grilla a la cual el tetrimino pertenece
	 * @param r Rotacion actual del tetrimino
	 * @param centro Coordenadas actuales del bloque central del tetrimino en cuestion
	 */
    public FormaZ (Grilla miGrilla, int rotacion, Par centro) {
        rotaciones = crearRotaciones();
        rotacionActual = rotacion;
        posicionesActuales = rotaciones[rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoRojo.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }
	
	/**
	 * 
	 * @return Devuelve las rotaciones posibles del tetrimino en cuestion
	 */
	public Par[][] crearRotaciones() {
		Par[][] rotaciones = new Par[][]{
	    	{ new Par(0, 0), new Par(1, 0), new Par(1, 1), new Par(2, 1) },
			{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(0, 2) },
			{ new Par(0, 0), new Par(1, 0), new Par(1, 1), new Par(2, 1) },
			{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(0, 2) }
	    };
		return rotaciones;
	}
	
    public Tetrimino clone() {
        return new FormaZ (miGrilla, rotacionActual, centroPieza.clone());
    }

}
