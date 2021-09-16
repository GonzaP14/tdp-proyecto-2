package Entidades;

import Logica.Logica;

public class Reloj implements Runnable{
	int fps = 120;
	double tiempoEntreTicks = 1000000000 / fps;
	double diff = 0;
	long tiempoActual;
	long ultimoTiempo = System.nanoTime();
	long timer = 0;
	int ticks = 0;
	Logica Logica;
	@Override
	public void run() {
		while (Logica.getEstaPausado() || Logica.GameOver()){
			tiempoActual = System.nanoTime();
			diff += (tiempoActual - ultimoTiempo) / tiempoEntreTicks;
			timer += tiempoActual - ultimoTiempo;
			ultimoTiempo = tiempoActual;
			if (diff >= 1) {
				ticks++;
				diff--;
				
				// Si los ticks satisfacen los ticks, delega en la Logica el comportamiento de bajar el tetrimino.
				if (ticks / (1 + Logica.getNivelActual()) > 4000) {
					Logica.bajarForma();
				}
				// Cada 10 segundos aumenta la velocidad a la que caen los tetriminos
				if (timer >= 10000000000) {
					fps = Logica.getNivelActual() * fps;
					ticks = 0;
					timer = 0;
				}
			}
			
		}
	}
	
	/**
	 * 
	 * @return Tiempo actual en milisegundos
	 */
	private static final long tiempoActual() {
        return System.nanoTime() / 1000000L;
    }
	
}
