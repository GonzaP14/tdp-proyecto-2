package Entidades;

import java.awt.Color;
import PartesGraficas.BloqueGrafico;

public class Bloque {
		private Color color;
		private Integer indice;
		private BloqueGrafico bloqueGrafico;
		
		public Bloque() {
			this.color = Color.black;
			this.indice = 4;
			this.bloqueGrafico= new BloqueGrafico();
		}
		
		public int getCantElementos() {
			return this.bloqueGrafico.getImagenes().length;
		}
		public Integer getIndice() {
			return indice;
		}
		public void setIndice(Integer indice) {
			if(indice!=null && indice< this.getCantElementos()) {
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
		
		public BloqueGrafico getBloqueGrafico() {
			return this.bloqueGrafico;
		}
		
		public void setBloqueGrafico(BloqueGrafico b) {
			this.bloqueGrafico=b;
		}
		
		public Color getColor() {
			return color;
		}
		
}