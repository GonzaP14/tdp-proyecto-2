package Logica;

import java.awt.Color;
import java.awt.Point;
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
    
    public Tetrimino getTetriminoActual() {
    	return tetriminoActual;
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
		int lineasBorradas = 0, limiteSuperior, limiteInferior, valorCentroEnX;
		valorCentroEnX = tetriminoActual.getCentroPieza().getX();
		limiteSuperior = (valorCentroEnX == 0)? valorCentroEnX : valorCentroEnX - 1;
		limiteInferior = (valorCentroEnX > 18)? 21 : valorCentroEnX + 2;

		for (int j = limiteInferior; j > limiteSuperior; j--) {
			lineaCompleta = true;
			for (int i = 1; i < 11; i++) {
				/*if (miGrilla[i][j] == Color.BLACK) {
					lineaCompleta = false;
					break;
				}*/
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
				//miGrilla[i][j+1] = miGrilla[i][j];
			}
		}
	}

    private void aumentarPuntaje(int puntosNuevos) {
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
    	if (!tetriminoActual.moverAbajo()) {
    		agregarAGrilla();
    	}
		//miGrilla.actualizar(); // a decidir
    	//GrillaGrafica.actualizar();
    }

    public void moverIzquierda() {
    	if (tetriminoActual.moverIzquierda()) {
    		//miGrilla.actualizar(); // a decidir
    		//GrillaGrafica.actualizar();
    	}
    }

    public void moverDerecha() {
    	if (tetriminoActual.moverDerecha()) {
    	    //miGrilla.actualizar(); // a decidir
    		//GrillaGrafica.actualizar();
    	}
    }

	public void rotarDerecha() {
		if (tetriminoActual.rotarDerecha()) {
    		//miGrilla.actualizar(); // a decidir
			//GrillaGrafica.actualizar();
		}
	}
	public void rotarIzquierda() {
		if (tetriminoActual.rotarIzquierda()) {
    		//miGrilla.actualizar(); // a decidir
			//GrillaGrafica.actualizar();
		}
	}
	
	private void agregarAGrilla() {

		miGrilla.ocuparCelda(tetriminoActual);
		//GrillaGrafica.actualizar();
		
		borrarLineas();
		caeNuevoTetrimino();
	}
    	
    private Tetrimino elegirNuevoTetrimino() {
    	int aleatorio = new Random().nextInt(arregloTetriminos.length);
    	return arregloTetriminos[aleatorio];
    }
    
    private void caeNuevoTetrimino() {
    	setTetriminoActual();
    	setTetriminoSiguiente();
    	// to-complete acá
    	miGrilla.nuevoTetrimino(getTetriminoActual());
    	//GrillaGrafica.actualizar();
    	//GUI.actualizarSiguiente();
    }
    
    private void setTetriminoActual() {
    	tetriminoActual = tetriminoSiguiente;

    }

    private void setTetriminoSiguiente() {
    	tetriminoSiguiente = elegirNuevoTetrimino();
    }
    private void terminarJuego() {
    	gameOver = true; // to-do
    }

    private void iniciarReloj() {
    	relojThread.start();
    }
    
}
    