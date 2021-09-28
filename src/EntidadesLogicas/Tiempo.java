package EntidadesLogicas;

public class Tiempo implements Runnable{
	Logica LOGICA;
	/**
	 * Se crea un tiempo real para la Logica
	 * @param LOGICA a la cual se le informa el tiempo transcurrido
	 */
	public Tiempo(Logica LOGICA) {
		this.LOGICA = LOGICA;
	}
    
	@Override
	public void run() {
		while (true) {
	        if(!LOGICA.gameOver()) {
	        	try {
					Thread.sleep(1000);
					LOGICA.aumentarTiempo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
		}
	}	
}


