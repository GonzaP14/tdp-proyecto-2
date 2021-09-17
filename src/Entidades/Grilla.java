package Entidades;


	import java.awt.Color;



	public class Grilla {
	    //Atributos
	    private Color grilla[][];

	    public Grilla() {
	        grilla = new Color[21][10];
	        for(int filas=0;filas<21;filas++) {
	        	for(int columnas=0;columnas<10;columnas++) {
	        		grilla[filas][columnas]=new Color(0,0,0);
	        	}
	        }
	    }

	    //Buscar Colisiones
	    public boolean buscarColisiones(Tetrimino t) {
	    	boolean retorno=false;
	    	float[] enCoordenada=null;
	    	Color negro=new Color(0,0,0);
	    	
	    	for(int i=0;i<4;i++) {
	    		if(t.dondeMoverIzquierda()[i]==null || t.dondeMoverDerecha()[i]==null || t.dondeMoverAbajo()==null) {
	    			retorno=true;
	    		}
	    		if( !grilla[t.dondeMoverIzquierda()[i].getX()][t.dondeMoverIzquierda()[i].getY()].equals(negro) || !grilla[t.dondeMoverDerecha()[i].getX()][t.dondeMoverDerecha()[i].getY()].equals(negro) || !grilla[t.dondeMoverAbajo()[i].getX()][t.dondeMoverAbajo()[i].getY()].equals(negro)) {
	    			retorno= true;
	    		}
	    	}
	    	return retorno;
	    }

	    //Evaluar linea
	    public boolean evaluarLinea(int x) {
	    	
	    	boolean aEliminar=false;

	    	Color negro=new Color(0,0,0);
	    	
	    	for(int columnas=0;columnas<10;columnas++) {
	    		if(grilla[x][columnas].equals(negro) ) {
	    			aEliminar=true; 
	    		}
	    	}
	    	return aEliminar;
	    }

	    //OcuparCelda
	    public void  ocuparCelda(Tetrimino t) {
	    	Par[]posiciones=t.getPosicionesCuadrado();
	    	Color algo=null;
	    	
	    	for(int i=0;i<4;i++) {
	    		grilla[posiciones[i].getX()][posiciones[i].getY()]=t.getColor();
	    	}
	    }
	    
	    
	    //Obtener color de celda
	    public Color obtenerColorCelda(Par p) {
	    	return grilla[p.getX()][p.getY()];
	    }
	    
	    
	    
	    public static void main(String args[]) {
			Grilla g=new Grilla();
			Par p= new Par (1,1);
			System.out.println(g.obtenerColorCelda(p));
			
			
		}
	}

