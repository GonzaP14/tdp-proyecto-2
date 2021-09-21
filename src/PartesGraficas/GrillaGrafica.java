package PartesGraficas;

	import java.awt.Color;

import Entidades.Bloque;

	public class GrillaGrafica {
	    //Atributos
		private Bloque grilla[][];

	    public GrillaGrafica() {
	    	 grilla = new Bloque[22][10];
		        Bloque b=new Bloque();
		        b.setIndice(4);
	        for(int filas=0;filas<21;filas++) {
	        	for(int columnas=0;columnas<10;columnas++) {	        		
	        		grilla[filas][columnas]=b;	   
	        }
	        }
	    }

	    //Buscar Colisiones
	    public Bloque getBloque(int x,int y) {
			return grilla[x][y];
		}
		public void setBloque(int x, int y, Bloque b) {
			grilla[x][y]=b;
		}
		public void actualizarColorBloque(int x,int y,int indice) {
			grilla[x][y].setIndice(indice);
		}		
		
	}
	

