package EntidadesGraficas;

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

import javax.swing.border.BevelBorder;

import EntidadesLogicas.Logica;

import java.awt.Font;
import java.awt.SystemColor;

public class GUI {
	
	// Atributos de instancia.
	
	private JFrame frame;
	private GrillaGrafica miGrillaGrafica;
	private Logica miLogica;
	private JLabel puntajeNum;
	private JLabel lineas;
	private JLabel nivel;
	private JLabel pausaLbl;
	private JLabel gameOverLbl;
	private JLabel tiempo;
	private JLabel tetriminoSiguiente;
	JLabel fondo;
	
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
		
		tiempo = new JLabel("00:00", SwingConstants.CENTER);
		tiempo.setForeground(SystemColor.activeCaption);
		tiempo.setFont(new Font("Ebrima", Font.BOLD, 41));
		tiempo.setBounds(515, 573, 129, 173);
		frame.getContentPane().add(tiempo);
			
		fondo = new JLabel();    		
		fondo.setBounds(0, 0,658, 762);                
		fondo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ImageIcon ico= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/fondo.png")));	
		ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(img);
		frame.getContentPane().add(fondo);
		
		miLogica = new Logica(miGrillaGrafica, this);
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
		
		gameOverLbl = new JLabel();
		gameOverLbl.setForeground(new Color(51, 102, 204));
		gameOverLbl.setBounds(200, 336, 260, 105);
		JLabel gameOverFoto = new JLabel();    
		gameOverFoto.setBackground(Color.WHITE);
		gameOverFoto.setBounds(0, 0,260, 105);                
		ImageIcon ico2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/GameOver.png")));	
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(gameOverFoto.getWidth(), gameOverFoto.getHeight(), Image.SCALE_SMOOTH));
		gameOverFoto.setIcon(img2);
		gameOverLbl.add(gameOverFoto);
		gameOverLbl.setVisible(false);

		tetriminoSiguiente = new JLabel("");
		tetriminoSiguiente.setBounds(40, 111, 78, 105);
		
		frame.getContentPane().add(gameOverLbl);
		frame.getContentPane().add(tetriminoSiguiente);
		frame.getContentPane().add(pausaLbl);
		frame.getContentPane().add(miGrillaGrafica);
		
		frame.addKeyListener(new KeyListener () {
			
            public void keyTyped(KeyEvent e) {
            }
            
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
	                case KeyEvent.VK_SPACE:
	                	miLogica.operar(Logica.moverAbajo);
	                    break;
	                case KeyEvent.VK_LEFT:
	                	miLogica.operar(Logica.moverIzquierda);
	                    break;
	                case KeyEvent.VK_RIGHT:
	                	miLogica.operar(Logica.moverDerecha);
	                    break;
	                case KeyEvent.VK_DOWN:
	                	miLogica.operar(Logica.rotarDerecha);
	                    break;
	                case KeyEvent.VK_UP:
	                	miLogica.operar(Logica.rotarIzquierda);
	                    break;
	                case KeyEvent.VK_P:
	                	miLogica.pausar_despausar();
	                	break;
	                case KeyEvent.VK_R:
	                	reset();
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
	 * Muestra el tiempo total desde que se comenzo a jugar
	 * @param minutos Minutos actuales transcurridos
	 * @param segundos Segundos actuales transcurridos
	 */
	public void mostrarTiempo(String minutos, String segundos) {
		tiempo.setText(minutos + ":" + segundos);
	}
	
	/**
	 * Muestra el cartel de 'GameOver' en pantalla.
	 */
	public void mostrarGameOver() {	
		gameOverLbl.setVisible(true);
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

	/**
	 * Muestra en pantalla el tetrimino siguiente que caera en la partida
	 * @param imagen La imagen del tetrimino en cuestion
	 */
	public void mostrarTetriminoSiguiente(ImageIcon imagen) {	
		ImageIcon img =new ImageIcon(imagen.getImage().getScaledInstance(tetriminoSiguiente.getWidth(), tetriminoSiguiente.getHeight(), Image.SCALE_SMOOTH));
		tetriminoSiguiente.setIcon(img);
	}
	
	/**
	 * Reinicializa el juego
	 */
	public void reset() {	
		pausaLbl.setVisible(false);
		gameOverLbl.setVisible(false);
		
		miLogica.reset();
		miGrillaGrafica.reset();
	}
}

