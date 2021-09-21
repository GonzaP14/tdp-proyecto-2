package Logica;

import java.awt.Color;
import java.util.Random;

import Entidades.*;
import GUI.GUI;

public class Logica {
    //Atributos
    private Grilla miGrilla;
    private Reloj miReloj;
    private Tetrimino tetriminoActual;
    private final Tetrimino[] arregloTetriminos;
    private Tetrimino tetriminoSiguiente;
    private Tetrimino tetriminoGuardado;
    private GUI miGui;
    
    private int nivelActual, puntajeActual;
    private boolean estaPausado, gameOver;

    Thread relojThread;

    //Constructor
    public Logica() {
    	miGrilla = new Grilla();
        miReloj = new Reloj(this);
        //tetriminoActual = nuevo tetrimino random;
        //tetriminoSiguiente = nuevo tetrimino random;
        arregloTetriminos = new Tetrimino[]{new FormaCubo(miGrilla), new FormaI(miGrilla), new FormaJ(miGrilla), new FormaL(miGrilla), new FormaS(miGrilla), new FormaT(miGrilla), new FormaZ(miGrilla)};
        tetriminoGuardado = null;
        miGui = new GUI();
        
        nivelActual = 0;
        puntajeActual = 0;
        estaPausado = false;
        gameOver = false;
        
        relojThread = new Thread(miReloj);
        iniciarReloj();
    }

    public boolean estaPausado() {
    	return estaPausado;
    }
    
    public boolean gameOver() {
    	return gameOver;
    }
    
    public int getNivelActual() {
    	return nivelActual;
    }
    
    public void pausar() {
        if (estaPausado())
        	estaPausado = false;
        else
        	estaPausado = true;
    }

    public void guardarBloque() {
    	tetriminoGuardado = tetriminoActual;
    	// to-do
    }

    private void borrarLineas() {
		boolean lineaCompleta;
		int lineasBorradas = 0;
		
		for (int j = 21; j > 0; j--) {
			lineaCompleta = true;
			for (int i = 1; i < 11; i++) {
				if (miGrilla[i][j] == Color.BLACK) {
					lineaCompleta = false;
					break;
				}
			}
			if (lineaCompleta) {
				limpiarFila(j);
				j++;
				lineasBorradas++;
			}
		}
    
		switch (lineasBorradas) {
		case 1:
			aumentarPuntaje(100);
			break;
		case 2:
			aumentarPuntaje(300);
			break;
		case 3:
			aumentarPuntaje(500);
			break;
		case 4:
			aumentarPuntaje(800);
			break;
		}

    }
    
    private void limpiarFila(int fila) {
		for (int j = fila - 1; j > 0; j--) {
			for (int i = 1; i < 11; i++) {
				miGrilla[i][j+1] = miGrilla[i][j];
			}
		}
	}
    

    public void aumentarPuntaje(int puntosNuevos) {
    	puntajeActual += puntosNuevos;
	    if (puntajeActual >= 2000) {
	    	nivelActual = 4;
	    }
	    else if (puntajeActual >= 1200) {
	    	nivelActual = 3;
	    }
	    else if (puntajeActual >= 800) {
	    	nivelActual = 2;
	    }
	    else if(puntajeActual >= 400) {
	    	nivelActual = 1;
	    }
    }

    public void moverAbajo() {
    	// to-do
    }

    public void moverIzquierda() {
    	if (tetriminoActual.moverIzquierda()) {
    		miGrilla.actualizar(); // a decidir
    		// GUI.actualizarGrilla(); ó GrillaGUI.actualizar();
    	}
    }

    public void moverDerecha() {
    	if (tetriminoActual.moverDerecha()) {
    		miGrilla.actualizar(); // a decidir
    		// GUI.actualizarGrilla(); ó GrillaGUI.actualizar();
    }

	public void rotarDerecha() {
		if (tetriminoActual.rotarDerecha()) {
    		miGrilla.actualizar(); // a decidir
    		// GUI.actualizarGrilla(); ó GrillaGUI.actualizar();
		}
	}
	public void rotarIzquierda() {
		if (tetriminoActual.rotarIzquierda()) {
    		miGrilla.actualizar(); // a decidir
    		// GUI.actualizarGrilla(); ó GrillaGUI.actualizar();
		}
	}
    	
    public Tetrimino elegirNuevoTetrimino() {
    	int aleatorio = new Random().nextInt(arregloTetriminos.length);
    	return arregloTetriminos[aleatorio];
    }
    
    public void setTetriminoActual() {
    	tetriminoActual = tetriminoSiguiente;
    	setTetriminoSiguiente();
    }

    public void setTetriminoSiguiente() {
    	tetriminoSiguiente = elegirNuevoTetrimino();
    }
    private void terminarJuego() {
    	gameOver = true; // to-do
    }

    public void iniciarReloj() {
    	relojThread.start();
    }

}
