package Tetrimino;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import EntidadesLogicas.Grilla;
import EntidadesLogicas.Par;

/**
 * Class FormaT - Modela un Tetrimino 'T' del Juego.
 * @author Grupo N°2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Martín, Mandolesi Bruno.
 */
public class FormaT extends Tetrimino {
	
	/**
	 * Crea un nuevo tetrimino con la forma T, rotacion y centro de pieza por defecto.
	 * @param miGrilla Grilla a la cual el tetrimino pertenece.
	 */
    public FormaT (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }
    
    /**
	 * Crea un nuevo tetrimino con la forma T.
	 * @param miGrilla Grilla a la cual el tetrimino pertenece.
	 * @param r Rotacion actual del tetrimino.
	 * @param centro Coordenadas actuales del bloque central del tetrimino en cuestion.
	 */
    public FormaT (Grilla miGrilla, int rotacion, Par centro) {
        rotaciones = crearRotaciones();
        rotacionActual = rotacion;
        posicionesActuales = rotaciones [rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoMagenta.png")));
        imagen = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/TetriminoT.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }
    
    /**
	 * @return Devuelve las rotaciones posibles del Tetrimino 'T'.
	 */
	public Par[][] crearRotaciones() {
		Par[][] rotaciones = new Par[][]{
	    	{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(2, 1) },
			{ new Par(1, 0), new Par(0, 1), new Par(1, 1), new Par(1, 2) },
			{ new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(1, 2) },
			{ new Par(1, 0), new Par(1, 1), new Par(2, 1), new Par(1, 2) }
	    };
		return rotaciones;
	}
    
	@Override
    public Tetrimino clone() {
        return new FormaT (miGrilla, rotacionActual, centroPieza.clone());
    }

}