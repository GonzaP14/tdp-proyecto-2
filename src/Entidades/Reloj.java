package Entidades;

import Logica.Logica;

public class Reloj implements Runnable{
	Logica LOGICA;
	public Reloj(Logica LOGICA) {
		this.LOGICA = LOGICA;
	}
    
	@Override
	public void run() {
		while (true) {
	        if(!LOGICA.estaPausado() && !LOGICA.gameOver()) {
	        	try {
					LOGICA.moverAbajo();
					Thread.sleep(1400 - 200* LOGICA.getNivelActual());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
		}
	}	
}

