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
	        if( !LOGICA.getEstaPausado() ) {
	        	try {
					LOGICA.bajarForma();
					Thread.sleep(1400 - 200* LOGICA.getNivelActual());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
		}
	}	
}

