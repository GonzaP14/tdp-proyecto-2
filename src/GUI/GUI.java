package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import PartesGraficas.GrillaGrafica;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.awt.Color;
import Logica.Logica;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class GUI {
	// attributes
	private JFrame frame;
	private GrillaGrafica miGrillaGrafica;
	private Logica miLogica;
	private JLabel puntajeNum ;
	private JLabel lineas;
	private JLabel nivel;
	private JLabel pausaLbl;
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
			
		JLabel cuadrado=new JLabel();    
		frame.getContentPane().add(cuadrado);
		cuadrado.setBounds(0, 0,658, 762);                
		cuadrado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ImageIcon ico= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/fondo.png")));	
		ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), Image.SCALE_SMOOTH));
		cuadrado.setIcon(img);
		
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
		
		pausaLbl = new JLabel("PAUSADO", SwingConstants.CENTER);
		pausaLbl.setForeground(SystemColor.activeCaption);
		pausaLbl.setFont(new Font("Ebrima", Font.PLAIN, 32));
		pausaLbl.setBounds(218, 336, 210, 105);
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
	public void aumentarPuntaje(int puntos) {
		puntajeNum.setText(" " + puntos);
	}
	public void aumentarLineasEliminadas(int lineasEliminadas) {
		lineas.setText(""+lineasEliminadas);
	}
	public void aumentarNivel(int nivelActual) {
		nivel.setText(""+nivelActual);
	}
	public void mostrarGameOver() {
		
	}
	public void pausar() {
		pausaLbl.setVisible(true);
	}
	public void despausar() {
		pausaLbl.setVisible(false);
	}
}

