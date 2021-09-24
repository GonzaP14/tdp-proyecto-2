package Logica;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.ImageIcon;
import Entidades.*;
import PartesGraficas.GUI;
import PartesGraficas.GrillaGrafica;

public class Logica {
	
    //Atributos de instancia.
	
	final static Object objetoPausa = new Object(); 
    private GrillaGrafica miGrillaGrafica;
	private Grilla miGrilla;
    private Reloj miReloj;
    private Tetrimino tetriminoActual;
    private final Tetrimino[] arregloTetriminos;
    private Tetrimino tetriminoSiguiente;
    private Tetrimino tetriminoGuardado;
    private GUI miGui;
    private int nivelActual;
    private int lineasEliminadas;
    private int puntajeActual;
    private int tiempoActual;
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
        
        tiempoActual=0;
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
        	miGui.pausar();
        } else {
        	synchronized(objetoPausa) {
                objetoPausa.notify(); // Despausa el juego
            }
        	estaPausado = false;
        	miGui.despausar();
        }
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
     * Comando para borrar las lineas que se completan cuando acoplamos un tetrimino
     */
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
    /**
     * Comando para eliminar una linea en especifico
     * @param fila La linea o fila a eliminar 
     */
    private void eliminarLinea(int fila) {
    	miGrilla.eliminarLinea(fila);
		miGrillaGrafica.eliminarLinea(fila);
		lineasEliminadas++;
		miGui.aumentarLineasEliminadas(lineasEliminadas);
	} 
    
	
    /**
     * Aumenta el puntaje actual en la cantidad que le decimos por parametro
     * @param puntosNuevos puntos a sumarle al puntaje actual
     */
    private void aumentarPuntaje(int puntosNuevos) {
    	puntajeActual += puntosNuevos;
    	miGui.aumentarPuntaje(puntajeActual);
	    if (puntajeActual >= 2000) {
	    	nivelActual = 4;
	    	miGui.aumentarNivel(nivelActual);
	    }
	    else if (puntajeActual >= 1200) {
	    	nivelActual = 3;
	    	miGui.aumentarNivel(nivelActual);
	    }
	    else if (puntajeActual >= 800) {
	    	nivelActual = 2;
	    	miGui.aumentarNivel(nivelActual);
	    }
	    else if(puntajeActual >= 500) {
	    	nivelActual = 1;
	    	miGui.aumentarNivel(nivelActual);
	    }
    }
    /**
     * Aumenta el tiempo transcurrido del juego
     */
    public void aumentarTiempo() {
    	tiempoActual++;
    	miGui.mostrarTiempo(tiempoActual);
    }
    /**
     * Permite mover abajo el tetrimino si es posible,de lo contrario puede perder o acoplar el tetrimino a la posicion que debe
     */
    public void moverAbajo() {
    	// Si puede mover abajo
    	if (tetriminoActual.moverAbajo()) {
    		Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
    		aumentarPuntaje(1);
    	}
    	// Si no puede mover abajo, y además colisiona en el spawn / origen de la grilla, pierde
    	else if (tetriminoActual.getCentroPieza().getX() == miGrilla.getOrigenGrilla().getX() && tetriminoActual.getCentroPieza().getY() == miGrilla.getOrigenGrilla().getY()){
    		terminarJuego();
    		miGui.mostrarGameOver();
    	}
    	// Si no puede mover abajo, y colisiona en un lugar diferente al spawn / origen de la grilla, se acopla el tetrimino a la imagen de bloques apilados
    	else {
    		agregarAGrilla();
    	}
    }
    /**
     * Permite mover a la izquierda el tetrimino y mostrar el movimiento
     */
    public void moverIzquierda() {
    	if (tetriminoActual.moverIzquierda()) {
    		Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
    	}
    }
    /**
     * Permite mover a la derecha el tetrimino y mostrar el movimiento
     */
    public void moverDerecha() {
    	if (tetriminoActual.moverDerecha()) {
    		Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
    		miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
    	}
    }
    /**
     * Permite rotar a la derecha y mostrar la rotacion
     */
	public void rotarDerecha() {
		if (tetriminoActual.rotarDerecha()) {
			Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
			miGrillaGrafica.actualizar(posicionesParaGUI(posicionesNuevas), tetriminoActual.getColor());
		}
	}
	/**
	 * Permite rotar a la izquierda y mostrar la rotacion
	 */
	public void rotarIzquierda() {
		if (tetriminoActual.rotarIzquierda()) {
			Par[] posicionesNuevas = tetriminoActual.getPosicionesActuales();
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
	/**
	 * Permite acoplar el tetrimino,borrar las lineas si es necesario y agregar un nuevo tetrimino y mostrar todo esto
	 */
	private void agregarAGrilla() {
		miGrilla.acoplarTetriminoAGrilla(tetriminoActual);
		miGrillaGrafica.acoplarTetriminoAGrillaGrafica(posicionesParaGUI(tetriminoActual.getPosicionesActuales()), tetriminoActual.getColor());
		
		borrarLineas();
		
		agregarNuevoTetrimino();
	}
    	
	/**
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
    
    /**
     * Inicia el juego.
     */
    public void iniciarJuego() {
    	tetriminoSiguiente = nuevoTetrimino();
    	agregarNuevoTetrimino();
    	
    	iniciarReloj();
    }
    
    /**
     * Termina el juego.
     */
    private void terminarJuego() {
    	gameOver = true;
    }
    
    /**
     * Inicia la ejecución del reloj.
     */
    private void iniciarReloj() {
    	relojThread.start();
    }
    
    /**
     * Retorna el objecto asociado a la Pausa.
     * @return Objeto de Pausa.
     */
    public Object obtenerObj() {
    	return objetoPausa;
    }
}
