package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PartesGraficas.GrillaGrafica;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Entidades.Bloque;
import Entidades.Par;
import Logica.Logica;

import javax.swing.border.BevelBorder;

public class GUI {
	private Logica logica;
	private JFrame frame;
	private JPanel contentPane;
	private Par[] ultimaActualizacion;
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
		
		logica=new Logica(this);	
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 515,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(23, 11, 320, 720);
		
		frame.getContentPane().add(contentPane);	
		contentPane.setLayout(new GridLayout(22, 10, 0, 0));
		
		repintar() ;
		
		frame.addKeyListener(new KeyListener () {
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_DOWN:
					logica.moverAbajo();;
					repintar() ;
					break;
				case KeyEvent.VK_LEFT:
					logica.moverIzquierda();
					repintar() ;
					break;
				case KeyEvent.VK_RIGHT:
					logica.moverDerecha();
					repintar() ;
					
					break;
				}
				
			}
			public void keyReleased(KeyEvent e) {
			}});		
		
	}
	
		public void repintar() {
			Par[] coordenadas=logica.getTetriminoActual().getPosicionesActuales();
	        
	        for(int i=0;i<22;i++) {
	            for(int j=0;j<10;j++) {        
	            	if(coordenadas[0].getY()==i && coordenadas[0].getX()+logica.getTetriminoActual().getCentroPieza().getX()==j ||coordenadas[1].getY()==i && coordenadas[1].getX()+logica.getTetriminoActual().getCentroPieza().getX()==j ||coordenadas[2].getY()==i && coordenadas[2].getX()+logica.getTetriminoActual().getCentroPieza().getX()==j ||coordenadas[3].getY()==i && coordenadas[3].getX()+logica.getTetriminoActual().getCentroPieza().getX()==j  ){
	                    if(logica.getTetriminoActual().getColor()== Color.yellow) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 0);    
	                    }
	                    else if(logica.getTetriminoActual().getColor()== Color.blue) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 1);    
	                    }
	                    else if(logica.getTetriminoActual().getColor()== Color.cyan) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 2);    
	                    }
	                    else if(logica.getTetriminoActual().getColor()== Color.orange) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 3);    
	                    }
	                    else if(logica.getTetriminoActual().getColor()== Color.red) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 5);    
	                    }
	                    else if(logica.getTetriminoActual().getColor()== Color.green) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 6);    
	                    }
	                    else if(logica.getTetriminoActual().getColor()== Color.magenta) {
	                        logica.getGrillaGrafica().actualizarColorBloque(i,j, 7);    
	                    }
	                }
	                    JLabel cuadrado=new JLabel();    
	                    cuadrado.setBounds(0, 0,30, 30);                
	                    cuadrado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	                    ImageIcon ico= new ImageIcon();
	                    ico= logica.getGrillaGrafica().getBloque(i, j).getBloqueGrafico().getCuadrado();
	                    ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), Image.SCALE_SMOOTH));
	                    cuadrado.setIcon(img);
	                    contentPane.add(cuadrado);    
	            }
	        }    
		}
	
	
	}


	
	

