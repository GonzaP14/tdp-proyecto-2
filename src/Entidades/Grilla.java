package Entidades;

	import java.awt.Color;

	public class Grilla {
	    //Atributos
		private Bloque grilla[][];

	    public Grilla() {
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
	    public boolean buscarColisiones(int valorX, int valorY, Par[] bloquesTetrimino) {
	    	return false;
	    }
	    
	    public Bloque getBloque(int x,int y) {
			return grilla[x][y];
		}
		public void setBloque(int x, int y, Bloque b) {
			grilla[x][y]=b;
		}
		public void actualizarColorBloque(int x,int y,int indice) {
			grilla[x][y].setIndice(indice);
		}		
		
		//OcuparCelda
	    public void  ocuparCelda(Tetrimino t) {
	    	/*Par[]posiciones=t.getPosicionesCuadrado();
	    	
	    	for(int i=0;i<4;i++) {
	    		grilla[posiciones[i].getX()][posiciones[i].getY()]=t.getColor();
	    	}*/
	    }
	}
	

