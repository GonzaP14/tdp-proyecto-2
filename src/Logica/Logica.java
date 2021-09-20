package Logica;

public class Logica {
    
	// Atributos de instancia.
	
    private int nivelActual;
    private int puntajeActual;
    private boolean estaPausado;

    // Constructor.
   
    public Logica() {
        nivelActual = 0;
        puntajeActual = 0;
        estaPausado = false;
    }

    // Métodos.
       
    public void pausar() {
        estaPausado = true;
    }
    
    public void reanudar() {
        estaPausado = false;
    }

    public void guardarBloque() {

    }

    private void borrarLinea() {

    }

    public void aumentarPuntaje() {

    }

    public void bajarForma() {

    }

    public void moverIzq() {

    }

    public void moverDer() {

    }

    public void intercambiarTetrimonio() {

    }

    public void elegirTetrimonioProximo() {

    }

    private void terminarJuego() {

    }

    public void iniciarReloj() {

    }

    public void rotarTetriminoActual () {

    }
}
