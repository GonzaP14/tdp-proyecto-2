package EntidadesLogicas;

public class Tiempo implements Runnable{
	private Logica miLogica;
	/**
	 * Se crea un tiempo real para la Logica
	 * @param LOGICA a la cual se le informa el tiempo transcurrido
	 */
	public Tiempo(Logica LOGICA) {
		this.miLogica = LOGICA;
	}
    
	/**
	 * Inicia el tiempo del juego
	 */
	@Override
	public void run() {
		while (!miLogica.gameOver()) {
			if(!miLogica.estaPausado()) {
	        	try {
					Thread.sleep(1000);
					miLogica.aumentarTiempo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}else {
        		synchronized(miLogica.obtenerObjTiempo()) {
                    while (miLogica.estaPausado()) {
                    	try {
                    		miLogica.obtenerObjTiempo().wait();
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


