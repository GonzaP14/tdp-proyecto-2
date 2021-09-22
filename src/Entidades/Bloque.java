package Entidades;

import java.awt.Color;
import PartesGraficas.BloqueGrafico;

/**
 * Clase Bloque: Bloque asociado a la gráfica del juego con su respectivo color en indice de imágen.
 * @author Grupo N°.
 */
public class Bloque {
	
	// Atributos de instancia.
	
	private Color color;
	private Integer indice;
	private BloqueGrafico bloqueGrafico;
	
	// Constructor.
	
	/**
	 * Crea un nuevo bloque.
	 */
	public Bloque() {
		this.color = Color.black;
		this.indice = 4;
		this.bloqueGrafico= new BloqueGrafico();
	}
	
	// Métodos.
	
	/**
	 * Retorna la cantidad de elementos (imagenes) que contiene el bloque gráfico. 
	 * (Discutir si es necesario)
	 * @return
	 */
	public int getCantElementos() {
		return this.bloqueGrafico.getImagenes().length;
	}
		
	/**
	 * Retorna el indice del bloque.
	 * @return indice actual del bloque.
	 */
	public Integer getIndice() {
		return indice;
	}
	
	/**
	 * Establece un nuevo indice al bloque y le asocia su respectivo color.
	 * (Discutir porque indice es de tipo Wrapper)
	 * @param indice neuvo indice del bloque.
	 */
	public void setIndice(Integer indice) {
		if (indice !=null && indice < this.getCantElementos()) {
			
			this.indice=indice;
			this.bloqueGrafico.actualizar(this.indice);
				
			switch (indice) {
				case 0: color = Color.yellow;
				break;
				
				case 1: color = Color.blue;
				break;
				
				case 2: color = Color.cyan;
				break;
				
				case 3: color = Color.orange;
				break;
				
				case 4: color = Color.black;
				break;	
			
				case 5: color = Color.red;
				break;			
			
				case 6: color = Color.green;
				break;				
				
				case 7: color = Color.magenta;
				break;
			
			}
				
		} else {
			this.indice=null;
		}
	}
		
	/**
	 * Retorna el bloque gráfico asoaciado al bloque.
	 * @return BloqueGrafico asociado.
	 */
	public BloqueGrafico getBloqueGrafico() {
		return this.bloqueGrafico;
	}
		
	/**
	 * Establece un bloque gráfico al bloque.
	 * @param b Nuevo BloqueGrafico asociado.
	 */
	public void setBloqueGrafico(BloqueGrafico b) {
		this.bloqueGrafico=b;
	}
		
	/**
	 * Retorna el color del bloque.
	 * @return Color actual del bloque.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Establece un color al bloque con su respectivo indice asociado.
	 * @param color nuevo color del bloque.
	 */
	public void setColor(Color color) {
		this.color = color;
			
		if (color == Color.yellow){
			indice = 0;
		} else if (color == Color.blue){
			indice = 1;
		} else if (color == Color.cyan) {
			indice = 2;
		} else if (color == Color.orange) {
			indice = 3;
		} else if (color == Color.black) {
			indice = 4;
		} else if (color == Color.red) {
			indice = 5;
		} else if (color == Color.green) {
			indice = 6;
		} else if (color == Color.magenta) {
			indice = 7;
		}
	}
		
}