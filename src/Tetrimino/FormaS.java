package Tetrimino;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

/**
 * Class FormaS - Modela un Tetrimino 'S' del Juego.
 * @author Grupo N°2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Martín, Mandolesi Bruno.
 */
public class FormaS extends Tetrimino {

	/**
	 * Crea un nuevo tetrimino con la forma S, rotacion y centro de pieza por defecto.
	 * @param miGrilla Grilla a la cual el tetrimino pertenece
	 */
    public FormaS (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }
    
    /**
	 * Crea un nuevo tetrimino con la forma S
	 * @param miGrilla Grilla a la cual el tetrimino pertenece
	 * @param r Rotacion actual del tetrimino
	 * @param centro Coordenadas actuales del bloque central del tetrimino en cuestion
	 */
    public FormaS (Grilla miGrilla, int r, Par centro) {
        rotaciones = crearRotaciones();
        rotacionActual = r;
        posicionesActuales = rotaciones[rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoVerde.png")));
        imagen = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/TetriminoS.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }

    /**
	 * @return Devuelve las rotaciones posibles del Tetrimino 'S'.
	 */
	public Par[][] crearRotaciones() {
		Par[][] rotaciones = new Par[][]{ 
        	{ new Par(1, 0), new Par(2, 0), new Par(0, 1), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) },
			{ new Par(1, 0), new Par(2, 0), new Par(0, 1), new Par(1, 1) },
			{ new Par(0, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) } 
		};
		return rotaciones;
	}
    
	@Override
    public Tetrimino clone() {
        return new FormaS (miGrilla, rotacionActual, centroPieza.clone());
    }
}
