package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PartesGraficas.GrillaGrafica;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Entidades.Bloque;

import javax.swing.border.BevelBorder;

public class GUI {

	private JFrame frame;
	private GrillaGrafica grilla;
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
		grilla= new GrillaGrafica();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 715, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(23, 11, 320, 720);
		frame.getContentPane().add(contentPane);
		
		contentPane.setLayout(new GridLayout(22, 10, 0, 0));
		
		
		
		for(int i=0;i<22;i++) {
			for(int j=0;j<10;j++) {				
				if(i==1 && j==4 ||i==1 && j==5 || i==1 && j==6 ||i==2 && j==5 ) {				
					grilla.actualizarColorBloque(i,j, 6);				
				}
					JLabel cuadrado=new JLabel();	
					cuadrado.setBounds(0, 0,30, 30);				
					cuadrado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					ImageIcon ico= new ImageIcon();
					ico= grilla.getBloque(i, j).getBloqueGrafico().getCuadrado();
					ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), Image.SCALE_SMOOTH));
					cuadrado.setIcon(img);
					contentPane.add(cuadrado);	
				
			}
		}
		
		
	}
}
