package PartesGraficas;

import javax.swing.ImageIcon;

public class BloqueGrafico {
    private ImageIcon cuadrado;
    private String[] imagenes;

    public BloqueGrafico () {
        this.cuadrado =new ImageIcon();
       	this.imagenes = new String[]{"/Imagenes/CuadradoAmarillo.png", "/Imagenes/CuadradoAzul.png","/Imagenes/CuadradoCyan.png","/Imagenes/CuadradoNaranja.png","/Imagenes/CuadradoNegro.png","/Imagenes/CuadradoRojo.png","/Imagenes/CuadradoVerde.png","/Imagenes/CuadradoVioleta.png"};
    }
    
    public void actualizar (int indice) {
    	if(indice<this.imagenes.length) {
    		ImageIcon imageIcon= new ImageIcon(this.getClass().getResource(this.imagenes[indice]));
    		this.cuadrado.setImage(imageIcon.getImage());
    	}
    }
    
	public ImageIcon getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(ImageIcon cuadrado) {
		this.cuadrado = cuadrado;
	}

	public String[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(String[] imagenes) {
		this.imagenes = imagenes;
	}

}