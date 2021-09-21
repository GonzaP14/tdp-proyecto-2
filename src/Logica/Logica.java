package Logica;

import java.awt.Color;
//import java.awt.Color;
//import java.awt.Point;
import java.util.Random;

import Entidades.*;
import GUI.GUI;

public class Logica {
	
    //Atributos de instancia.
    
	private Grilla miGrilla;
    private Reloj miReloj;
    private Tetrimino tetriminoActual;
    private final Tetrimino[] arregloTetriminos;
    private Tetrimino tetriminoSiguiente;
    private Tetrimino tetriminoGuardado;
    private GUI miGui;
    private int nivelActual;
    private int puntajeActual;
    private boolean estaPausado;
    private boolean gameOver;
    Thread relojThread;

    //Constructores.
    
    /**
     * Crea una nueva lógica.
     * @param miGui Gui asociada al juego.
     */
    public Logica (GUI miGui) {
    	miGrilla = new Grilla ();
        miReloj = new Reloj (this);
        
        tetriminoActual = nuevoTetrimino();
        tetriminoSiguiente = nuevoTetrimino();
        
        arregloTetriminos = new Tetrimino[] { 
        new FormaCuadrado(miGrilla), 
        new FormaI(miGrilla), 
        new FormaJ(miGrilla), 
        new FormaL(miGrilla), 
        new FormaS(miGrilla), 
        new FormaT(miGrilla), 
        new FormaZ(miGrilla) 
        };
        
        tetriminoGuardado = null;
        this.miGui = miGui;
        nivelActual = 0;
        puntajeActual = 0;
        estaPausado = false;
        gameOver = false;
        
        relojThread = new Thread(miReloj);
        iniciarReloj();
    }

    /**
     * Retorna si el juego esta pausado actualmente.
     * @return true si el jeugo esta pausado y false en caso contrario.
     */
    public boolean estaPausado() {
    	return estaPausado;
    }
    
    /**
     * Retona si el juego se termino.
     * @return true si el juego finalizo y false en caso contrario.
     */
    public boolean gameOver() {
    	return gameOver;
    }
    
    /**
     * Retorna el nivel actual de la partida en curso.
     * @return nivel actual.
     */
    public int getNivelActual() {
    	return nivelActual;
    }
    
    /**
     * Retorna el tetrimino actual que cae en el juego.
     * @return Tetrimino actual de la partida.
     */
    public Tetrimino getTetriminoActual() {
    	return tetriminoActual;
    }
    
    /**
     * Posiblemente necesario
     * @return
     */
    public Tetrimino getTetriminoSiguiente () {
    	return tetriminoSiguiente;
    }
    
    /**
     * Si el juego no esta pausado, lo pausa. De lo contrario, no se modifica nada.
     */
    public void pausar_despausar() {
        if (!estaPausado()) {
        	estaPausado = true;
        } else estaPausado = false;
    }
   
    /**
     * Si no hay ningun tetrimino guardado, guarda el tetrimino actual.
     */
    public void guardarBloque() {	
    	if (tetriminoGuardado == null) {
    		tetriminoGuardado = tetriminoActual;
    	} 
    }
    
    /**
     * Si hay un Tetrimino guardado, lo elimina.
     */
    public void quitarBloqueGuardado() {
    	if (tetriminoGuardado != null) {
    		tetriminoGuardado = null;
    	}
    }
    
    /**
     * Borra las línea 
     */
    public void borrarLineas() {
    	boolean hueco;
    	int filasEliminadas = 0;
    	
    	for (int i = 21; i > 0; i --) { 
    		hueco = false;
    		
    		for (int j = 0; j < 11; j ++) {
    			if (miGrilla.getBloque(i, j).getColor() == Color.black) {
    				hueco = true;
    				break;
    			}
    		}
    		
    		if (!hueco) {
    			eliminarLinea (i);
    			i ++;
    			filasEliminadas ++;
    		}	
    	}
    	
    	switch (filasEliminadas) {
    	
	    	case 1: aumentarPuntaje(100);;
	    	break;
	    	
	    	case 2: aumentarPuntaje(300);
	    	break;
	    	
	    	case 3: aumentarPuntaje(500);
	    	break;
	    	
	    	case 4: aumentarPuntaje(800);
	    	break;
    	
    	}
    	
    }
    
    private void eliminarLinea(int fila) {
    	for (int j = fila - 1; j > 0; j --) {
    		for (int i = 1; i < 11; i ++) {
    			miGrilla.intercambiarBloques(i, j + 1, i, j);
    		}
    	}
	}
    
    /*
     * for (int j = row-1; j > 0; j--) {
			for (int i = 1; i < 11; i++) {
				well[i][j+1] = well[i][j];
			}
		}
     */

	/*
     * 	public void clearRows() {
		boolean gap;
		int numClears = 0;
		
		for (int j = 21; j > 0; j--) {
			gap = false;
			for (int i = 1; i < 11; i++) {
				if (well[i][j] == Color.BLACK) {
					gap = true;
					break;
				}
			}
			if (!gap) {
				deleteRow(j);
				j += 1;
				numClears += 1;
			}
		}
		
		switch (numClears) {
		case 1:
			score += 100;
			break;
		case 2:
			score += 300;
			break;
		case 3:
			score += 500;
			break;
		case 4:
			score += 800;
			break;
		}
	}
     */
    
    /*
    private void borrarLineas() {
		boolean lineaCompleta;
		int lineasBorradas = 0, limiteSuperior, limiteInferior, valorCentroEnX;
		valorCentroEnX = tetriminoActual.getCentroPieza().getX();
		limiteSuperior = (valorCentroEnX == 0)? valorCentroEnX : valorCentroEnX - 1;
		limiteInferior = (valorCentroEnX > 18)? 21 : valorCentroEnX + 2;

		for (int j = limiteInferior; j > limiteSuperior; j--) {
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
    */
    /*
    private void limpiarFila(int fila) {
		for (int j = fila - 1; j > 0; j--) {
			for (int i = 1; i < 11; i++) {
				//miGrilla[i][j+1] = miGrilla[i][j];
			}
		}
	}
	*/

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
	    else if(puntajeActual >= 500) {
	    	nivelActual = 1;
	    }
    }

    public void moverAbajo() {
    	if (tetriminoActual.moverAbajo()) {
    		miGrilla.actualizar();
    	}
    }

    public void moverIzquierda() {
    	if (tetriminoActual.moverIzquierda()) {
    		miGrilla.actualizar();
    	}
    }

    public void moverDerecha() {
    	if (tetriminoActual.moverDerecha()) {
    	    miGrilla.actualizar();
    	}
    }

	public void rotarDerecha() {
		if (tetriminoActual.rotarDerecha()) {
			miGrilla.actualizar();
		}
	}
	public void rotarIzquierda() {
		if (tetriminoActual.rotarIzquierda()) {
    		miGrilla.actualizar();
		}
	}
	
	private void agregarAGrilla() {
		miGrilla.agregarNuevoTetrimino (tetriminoActual);
	}
    	
    private Tetrimino nuevoTetrimino() {
    	int aleatorio = new Random().nextInt(arregloTetriminos.length);
    	return arregloTetriminos[aleatorio];
    }
    
    private void agregarNuevoTetrimino() {
    	tetriminoActual = tetriminoSiguiente.clone();
    	tetriminoSiguiente = nuevoTetrimino();
    	miGrilla.actualizar();
    	
    }
    
    /*
    private void setTetriminoActual() {
    	tetriminoActual = tetriminoSiguiente;

    }

    private void setTetriminoSiguiente() {
    	tetriminoSiguiente = nuevoTetrimino();
    }
    */
    
    private void terminarJuego() {
    	gameOver = true;
    }

    private void iniciarReloj() {
    	relojThread.start();
    }
    
}
    