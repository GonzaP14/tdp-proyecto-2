package Entidades;

import java.awt.Color;

public class FormaT extends Tetrimino {

    public FormaT (Grilla miGrilla) {
        this (miGrilla, 0, miGrilla.getOrigenGrilla());
    }
    
    public FormaT (Grilla miGrilla, int rotacion, Par centro) {
        rotaciones =  new Par [][] {
        { new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
        { new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) },
        { new Par(0, 1), new Par(1, 1), new Par(2, 1), new Par(3, 1) },
        { new Par(1, 0), new Par(1, 1), new Par(1, 2), new Par(1, 3) }
    };
        rotacionActual = rotacion;
        posicionesActuales = rotaciones [rotacionActual];
        this.color = Color.magenta;
        centroPieza = centro;
        this.miGrilla = miGrilla;
    }

    public Tetrimino clone() {
        return new FormaT (miGrilla, rotacionActual, centroPieza.clone());
    }

}