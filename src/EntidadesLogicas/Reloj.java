package EntidadesLogicas;

public class Reloj implements Runnable{
	private Logica miLogica;
	/**
	 * Se crea un reloj con una logica 
	 * @param LOGICA asociada al reloj
	 */
	public Reloj(Logica LOGICA) {
		this.miLogica = LOGICA;
	}
    
	/**
	 * Inicia el reloj para la gravedad del juego
	 */
	@Override
	public void run() {
		while (!miLogica.gameOver()) {
	        if(!miLogica.estaPausado()) {
	        	try {
					miLogica.operar(Logica.moverAbajo);
					Thread.sleep(1400 - 200* miLogica.getNivelActual());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
	        else {
	        	synchronized(miLogica.obtenerObj()) {
                    while (miLogica.estaPausado()) {
                    	try {
                    		miLogica.obtenerObj().wait();
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

