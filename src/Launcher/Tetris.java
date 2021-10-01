package Launcher;

import java.awt.EventQueue;
import EntidadesGraficas.GUI;

/**
 * Class Tetris - Modela el Launcher del juego.
 * @author Grupo N°2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Martín, Mandolesi Bruno.
 */
public class Tetris {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}
