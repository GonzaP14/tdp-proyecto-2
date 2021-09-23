package Logica;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

import Entidades.*;
import GUI.GUI;
import PartesGraficas.GrillaGrafica;

public class Logica {
	
    //Atributos de instancia.
    private GrillaGrafica miGrillaGrafica;
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
    protected final ImageIcon negro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoNegro.png")));

    //Constructores.
    
    /**
     * Crea una nueva lógica.
     * @param miGui Gui asociada al juego.
     */
    public Logica (GrillaGrafica miGrillaGrafica, GUI miGui) {
    	this.miGrillaGrafica = miGrillaGrafica;
    	this.miGui = miGui;
    	miGrilla = new Grilla ();
    	
        arregloTetriminos = crearArregloTetriminos();
        
        tetriminoGuardado = null;
        nivelActual = 0;
        puntajeActual = 0;
        estaPausado = false;
        gameOver = false;

        miReloj = new Reloj (this);
        relojThread = new Thread(miReloj);
        iniciarJuego(); 
    }

    /**
     * 
     * @return Devuelve un iterable con todos los tetriminos posibles
     */
    private Tetrimino[] crearArregloTetriminos(){
    	Tetrimino[] arregloTetriminos;
    	arregloTetriminos = new Tetrimino[] { 
	        new FormaO(miGrilla), 
	        new FormaI(miGrilla), 
	        new FormaJ(miGrilla), 
	        new FormaL(miGrilla), 
	        new FormaS(miGrilla), 
	        new FormaT(miGrilla), 
	        new FormaZ(miGrilla) 
    	};   
    	return arregloTetriminos;
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
     * Retorna el puntaje actual de la partida en curso
     * @return puntaje actual.
     */
    public int getPuntajeActual() {
    	return puntajeActual;
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
    
    
    /*private void borrarLineas() {
		boolean lineaCompleta;
		int lineasBorradas = 0, limiteSuperior, limiteInferior, valorCentroEnX;
		valorCentroEnX = tetriminoActual.getCentroPieza().getX();
		limiteSuperior = (valorCentroEnX == 0)? valorCentroEnX : valorCentroEnX - 1;
		limiteInferior = (valorCentroEnX > 18)? 21 : valorCentroEnX + 2;

		for (int j = limiteInferior; j > limiteSuperior; j--) {
			lineaCompleta = true;
			for (int i = 1; i < 11; i++) {
				if (miGrilla.getBloque(i, j).getColor() == Color.black) {
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

    }*/
    
    public void borrarLineas() {
    	boolean hueco;
    	int filasEliminadas = 0;
    	
    	for (int i = 21; i > 0; i --) { 
    		hueco = false;
    		
    		for (int j = 0; j < 10; j ++) {
    			if (miGrilla.getBloque(i, j).getColor() == miGrilla.getNegro()) {
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
    	miGrilla.eliminarLinea(fila);
		miGrillaGrafica.eliminarLinea(fila);
	} 
    
    
    private void limpiarFila(int fila) {
		miGrilla.eliminarLinea(fila);
		miGrillaGrafica.eliminarLinea(fila);
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
	    else if(puntajeActual >= 500) {
	    	nivelActual = 1;
	    }
    }

    public void moverAbajo() {
    	// Si puede mover abajo
    	if (tetriminoActual.moverAbajo()) {
    		Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
    	}
    	// Si no puede mover abajo, y además colisiona en el spawn / origen de la grilla, pierde
    	else if (tetriminoActual.getCentroPieza().getX() == miGrilla.getOrigenGrilla().getX() && tetriminoActual.getCentroPieza().getY() == miGrilla.getOrigenGrilla().getY()){
    		terminarJuego();
    	}
    	// Si no puede mover abajo, y colisiona en un lugar diferente al spawn / origen de la grilla, se acopla el tetrimino a la imagen de bloques apilados
    	else {
    		agregarAGrilla();
    	}
    }

    public void moverIzquierda() {
    	if (tetriminoActual.moverIzquierda()) {
    		Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
    	}
    }

    public void moverDerecha() {
    	if (tetriminoActual.moverDerecha()) {
    		Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
    	}
    }

	public void rotarDerecha() {
		if (tetriminoActual.rotarDerecha()) {
			Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
			miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
		}
	}
	public void rotarIzquierda() {
		if (tetriminoActual.rotarIzquierda()) {
			Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
			for (Par parBloqueActual : posicionesNuevas) {
				parBloqueActual.setX(parBloqueActual.getX() + tetriminoActual.getCentroPieza().getX());
				parBloqueActual.setY(parBloqueActual.getY() + tetriminoActual.getCentroPieza().getY());
			}
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
		}
	}
	
	
	/**
	 * 
	 * @param posicionesNuevas El conjunto de pares referido a la posicion de los bloques del tetrimino sin sumarle centroPieza
	 * @return Devuelve el conjunto de pares final referido a la posicion de los bloques del tetrimino (le suma el valor de centroPieza a la rotacion actual)
	 */
	private Par[] posicionesParaGUI(Par[] posicionesNuevas) {
		Par[] posicionesParaGUI = new Par[4];
		for (int i = 0; i < 4; i++) {
			posicionesParaGUI[i] = new Par(0, 0);
			posicionesParaGUI[i].setX(posicionesNuevas[i].getX() + tetriminoActual.getCentroPieza().getX()); 
			posicionesParaGUI[i].setY(posicionesNuevas[i].getY() + tetriminoActual.getCentroPieza().getY()); 
		}
		return posicionesParaGUI;
	}
	
	private void agregarAGrilla() {
		miGrilla.acoplarTetriminoAGrilla(tetriminoActual);
		miGrillaGrafica.acoplarTetriminoAGrillaGrafica(posicionesParaGUI(tetriminoActual.getPosicionesActuales()), tetriminoActual.getColor());
		
		borrarLineas();
		
		agregarNuevoTetrimino();
	}
    	
	/**
	 * 
	 * @return Devuelve un nuevo tetrimino aleatorio entre las siete formas posibles
	 */
    private Tetrimino nuevoTetrimino() {
    	int aleatorio = new Random().nextInt(arregloTetriminos.length);
    	return arregloTetriminos[aleatorio];
    }
    
    /**
     * Establece el tetrimino siguiente como tetrimino actual de la partida, un nuevo tetrimino aleatorio como siguiente tetrimino,
     * y decide si es posible mostrar un nuevo tetrimino en la partida, o bien, el jugador pierde (por colisión en el spawn / origen de la grilla)
     */
    private void agregarNuevoTetrimino() {
    	tetriminoActual = tetriminoSiguiente.clone();
    	tetriminoSiguiente = nuevoTetrimino();
    	boolean check = miGrilla.buscarColisiones(tetriminoActual.getCentroPieza().getX(), tetriminoActual.getCentroPieza().getY(), tetriminoActual.getPosicionesActuales());
    	if (check) {
    	}
    	else {
    		miGrillaGrafica.mostrarNuevoTetrimino(posicionesParaGUI(tetriminoActual.getPosicionesActuales()), tetriminoActual.getColor());
    	}
    }
    
    public void iniciarJuego() {
    	tetriminoSiguiente = nuevoTetrimino();
    	agregarNuevoTetrimino();
    	
    	iniciarReloj();
    }
    
    private void terminarJuego() {
    	gameOver = true;
    }

    private void iniciarReloj() {
    	relojThread.start();
    }
    
}
