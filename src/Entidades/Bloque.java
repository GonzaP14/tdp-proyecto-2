package Entidades;

import PartesGraficas.BloqueGrafico;

public class Bloque {
		private Integer indice;
		private BloqueGrafico bloqueGrafico;
		
		public Bloque() {
			this.indice=null;
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
			}
			else {
				this.indice=null;
			}
		}
		public BloqueGrafico getBloqueGrafico() {
			return this.bloqueGrafico;
		}
		public void setBloqueGrafico(BloqueGrafico b) {
			this.bloqueGrafico=b;
		}
		
}