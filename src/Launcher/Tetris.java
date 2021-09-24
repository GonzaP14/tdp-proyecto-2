package Launcher;

//import PartesGraficas.GUI;

/**
 * Class Tetris - Modela el Launcher del juego.
 * @author Grupo N°.
 */
public class Tetris {
	
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//GUI window = new GUI();
            	//window.setVisible(true);
            }
        });
    }
	
}
