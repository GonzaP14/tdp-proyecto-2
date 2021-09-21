package PartesGraficas;

public class TetriminoGrafico {
	private BloqueGrafico [][] grafico ;
	
	public TetriminoGrafico() {
		grafico=new BloqueGrafico[4][4];
	}
	
	public BloqueGrafico getBloque(int x,int y) {
		return grafico[x][y];
	}
	public void setBloqueGrafico(int x, int y, BloqueGrafico b) {
		grafico[x][y]=b;
	}
	public void actualizarColorBloque(int x,int y,int indice) {
		grafico[x][y].actualizar(indice);
	}
}
