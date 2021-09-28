package EntidadesLogicas;

public class Reloj implements Runnable{
	Logica LOGICA;
	/**
	 * Se crea un reloj con una logica 
	 * @param LOGICA asociada al reloj
	 */
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
	        else if(LOGICA.estaPausado()) {
	        	synchronized(LOGICA.obtenerObj()) {
                    while (LOGICA.estaPausado()) {
                    	try {
                    		LOGICA.obtenerObj().wait();
                        }
                    	catch(InterruptedException e) {
                    		e.printStackTrace();
                    	}
                    }
                }
	        }
		}
	}	
}

