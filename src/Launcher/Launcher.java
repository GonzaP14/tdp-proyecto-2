package Launcher;

import GUI.GUI;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	GUI window = new GUI();
            	//window.setVisible(true);
            }
        });
    }
}