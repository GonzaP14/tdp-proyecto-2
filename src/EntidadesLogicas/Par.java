package EntidadesLogicas;

public class Par {
	
	private int x;
	private int y;
	/**
	 * Creo un par de coordenadas x e y
	 * @param x coordenada x
	 * @param y coordenada y
	 */
	public Par(int x,int y) {
        this.x = x;
        this.y = y;
    }
	/**
	 * Obtengo la coordenada x de un Par
	 * @return coordenada x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Modifico la coordenada x de un Par
	 * @param x coordenada x que voy a darle al Par
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Obtengo la coordenada Y de un Par
	 * @return coordenada Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Modifico la coordenada y de un Par
	 * @param y coordenada y que voy a darle al Par
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Clono un par 
	 */
	public Par clone() {
		return new Par (x, y);
	}

}
