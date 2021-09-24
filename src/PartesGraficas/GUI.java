package PartesGraficas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.awt.Color;
import Logica.Logica;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.SystemColor;

public class GUI {
	
	// Atributos de instancia.
	
	private JFrame frame;
	private GrillaGrafica miGrillaGrafica;
	private Logica miLogica;
	private JLabel puntajeNum ;
	private JLabel lineas;
	private JLabel nivel;
	private JLabel pausaLbl;
	private JLabel tiempo ;
	
	/**
	 * (Llevar a clase Tetris)
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
		miGrillaGrafica.setSize(320, 704);
		miGrillaGrafica.setLocation(172, 27);
		initialize();
		miLogica = new Logica(miGrillaGrafica, this);
		 
		puntajeNum = new JLabel("0",SwingConstants.CENTER);
		puntajeNum.setFont(new Font("Ebrima", Font.BOLD, 41));
		puntajeNum.setForeground(SystemColor.activeCaption);
		puntajeNum.setBounds(515, 21, 129, 173);
		frame.getContentPane().add(puntajeNum);
		 
		lineas = new JLabel("0", SwingConstants.CENTER);
		lineas.setForeground(SystemColor.activeCaption);
		lineas.setFont(new Font("Ebrima", Font.BOLD, 41));
		lineas.setBounds(515, 205, 129, 173);
		frame.getContentPane().add(lineas);
		
		nivel = new JLabel("0", SwingConstants.CENTER);
		nivel.setForeground(SystemColor.activeCaption);
		nivel.setFont(new Font("Ebrima", Font.BOLD, 41));
		nivel.setBounds(515, 389, 129, 173);
		frame.getContentPane().add(nivel);
		
		tiempo = new JLabel("0", SwingConstants.CENTER);
		tiempo.setForeground(SystemColor.activeCaption);
		tiempo.setFont(new Font("Ebrima", Font.BOLD, 41));
		tiempo.setBounds(515, 573, 129, 173);
		frame.getContentPane().add(tiempo);
			
		JLabel cuadrado=new JLabel();    		
		cuadrado.setBounds(0, 0,658, 762);                
		cuadrado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ImageIcon ico= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/fondo.png")));	
		ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), Image.SCALE_SMOOTH));
		cuadrado.setIcon(img);
		frame.getContentPane().add(cuadrado);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		pausaLbl = new JLabel();
		pausaLbl.setForeground(new Color(51, 102, 204));
		pausaLbl.setBounds(200, 336, 260, 105);
		
		JLabel pausefoto = new JLabel();    
		pausefoto.setBackground(Color.WHITE);
		pausefoto.setBounds(0, 0,260, 105);                
		ImageIcon ico = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/pausa.png")));	
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(pausefoto.getWidth(), pausefoto.getHeight(), Image.SCALE_SMOOTH));
		pausefoto.setIcon(img);
		pausaLbl.add(pausefoto);
		pausaLbl.setVisible(false);
		frame.getContentPane().add(pausaLbl);
		frame.getContentPane().add(miGrillaGrafica);
		
		frame.addKeyListener(new KeyListener () {
			
            public void keyTyped(KeyEvent e) {
            }
            
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
	                case KeyEvent.VK_SPACE:
	                    miLogica.moverAbajo();
	                    break;
	                case KeyEvent.VK_LEFT:
	                	miLogica.moverIzquierda();
	                    break;
	                case KeyEvent.VK_RIGHT:
	                	miLogica.moverDerecha();
	                    break;
	                case KeyEvent.VK_DOWN:
	                	miLogica.rotarDerecha();
	                    break;
	                case KeyEvent.VK_UP:
	                	miLogica.rotarIzquierda();
	                    break;
	                case KeyEvent.VK_P:
	                	miLogica.pausar_despausar();
	                	break;
                }
            }
            
            public void keyReleased(KeyEvent e) {
            }
            
		});
	}
	
	/**
	 * Aumenta el puntaje en pantalla.
	 * @param puntos Puntos a aumentar.
	 */
	public void aumentarPuntaje(int puntos) {
		puntajeNum.setText(String.valueOf(puntos));
	}
	
	/**
	 * Aumenta la cantidad de lineas eliminadas en pantalla.
	 * @param lineasEliminadas Cantiadad de lineas eliminadas.
	 */
	public void aumentarLineasEliminadas(int lineasEliminadas) {
		lineas.setText(String.valueOf(lineasEliminadas));
	}
	
	/**
	 * Aumenta el nivel actual mostrado en pantalla.
	 * @param nivelActual Nivel actual de la partida.
	 */
	public void aumentarNivel(int nivelActual) {
		nivel.setText(String.valueOf(nivelActual));
	}
	
	/**
	 * Aumenta el tiempo actual mostrado en pantalla.
	 * @param tiempoActual Tiempo transcurrido de la partida.
	 */
	public void mostrarTiempo(int tiempoActual) {
		tiempo.setText(String.valueOf(tiempoActual));
	}
	
	/**
	 * Muestra el cartel de 'GameOver' en pantalla.
	 */
	public void mostrarGameOver() {	
	}
	
	/**
	 * Muestra el cartel de 'Pause' en pantalla.
	 */
	public void pausar() {
		pausaLbl.setVisible(true);
	}
	
	/**
	 * Quita el cartel de 'Pause' en pantalla.
	 */
	public void despausar() {
		pausaLbl.setVisible(false);
	}
}
