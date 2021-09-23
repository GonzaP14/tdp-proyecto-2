package Entidades;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class FormaZ extends Tetrimino {

    public FormaZ (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }

    public FormaZ (Grilla miGrilla, int rotacion, Par centro) {
        rotaciones =  new Par [][] {
        { new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
        { new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) },
        { new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
        { new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) }
    };
        rotacionActual = rotacion;
        posicionesActuales = rotaciones[rotacionActual];
        color = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoVerde.png")));
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }

    public Tetrimino clone() {
        return new FormaZ (miGrilla, rotacionActual, centroPieza.clone());
    }

}
