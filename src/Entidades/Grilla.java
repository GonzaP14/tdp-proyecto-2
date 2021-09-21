package Entidades;

public class Grilla {
		
	// Atributos de clase
		
	protected static final Par origenGrilla = new Par(5, 0);
		
	   
	//Atributos de instancia
		
	private Bloque grilla[][];

	    
	public Grilla() {
		grilla = new Bloque [22][10];
	      
		for (int filas = 0; filas < 21; filas++) {
			for (int columnas = 0; columnas < 11; columnas ++) {
	        	grilla [filas][columnas] = new Bloque();	   
	        	grilla [filas][columnas].setIndice(4);
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
	    
	    public Par getOrigenGrilla() {
	    	return origenGrilla;
	    }
	    
		public void setBloque(int x, int y, Bloque b) {
			grilla[x][y]=b;
		}
		public void actualizarColorBloque(int x,int y,int indice) {
			grilla[x][y].setIndice(indice);
		}		
		
		//OcuparCelda
	    public void agregarNuevoTetrimino (Tetrimino t) {
	    	/*Par[]posiciones=t.getPosicionesCuadrado();
	    	
	    	for(int i=0;i<4;i++) {
	    		grilla[posiciones[i].getX()][posiciones[i].getY()]=t.getColor();
	    	}*/
	    	
	    	//GrillaGrafica.actualizar();
			
			//borrarLineas();
	    }
	    
	    public void actualizar () {
	    	//GrillaGrafica.actualizar();
	    }
	    
	    public void intercambiarBloques (int i1, int j1, int i2, int j2) {
	    	Bloque auxiliar;
	    	
	    	auxiliar = grilla [i1][j1];
	    	grilla [i1][j1] = grilla [i2][j2];
	    	grilla [i2][j2] = auxiliar;
	    }
	}
	

