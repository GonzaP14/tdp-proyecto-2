package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PartesGraficas.GrillaGrafica;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Entidades.Bloque;
import Logica.Logica;

import javax.swing.border.BevelBorder;

public class GUI {
	// attributes
	private JFrame frame;
	private GrillaGrafica miGrillaGrafica;
	private Logica miLogica;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		miGrillaGrafica = new GrillaGrafica();
		initialize();
		miLogica = new Logica(miGrillaGrafica, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 715, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.add(miGrillaGrafica);
		
		frame.addKeyListener(new KeyListener () {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
	                case KeyEvent.VK_SPACE:
	                    miLogica.moverAbajo();
	                    //repintar();
	                    break;
	                case KeyEvent.VK_LEFT:
	                	miLogica.moverIzquierda();
	                    //repintar();
	                    break;
	                case KeyEvent.VK_RIGHT:
	                	miLogica.moverDerecha();
	                    //repintar();
	                    break;
	                case KeyEvent.VK_DOWN:
	                	miLogica.rotarDerecha();
	                    //repintar();
	                    break;
	                case KeyEvent.VK_UP:
	                	miLogica.rotarIzquierda();
	                    //repintar();
	                    break;
                }
            }
            public void keyReleased(KeyEvent e) {
            }
		});
	}
}

