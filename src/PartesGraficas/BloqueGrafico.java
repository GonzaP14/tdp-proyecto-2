package PartesGraficas;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class BloqueGrafico {
    private ImageIcon cuadrado;
    private String[] imagenes;

    public BloqueGrafico () {
        this.cuadrado =new ImageIcon(Toolkit.getDefaultToolkit().getImage(BloqueGrafico.class.getResource("/Imagenes/CuadradoNegro.png")));
       	this.imagenes = new String[]{"/Imagenes/CuadradoAmarillo.png", "/Imagenes/CuadradoAzul.png","/Imagenes/CuadradoCyan.png","/Imagenes/CuadradoNaranja.png","/Imagenes/CuadradoNegro.png","/Imagenes/CuadradoRojo.png","/Imagenes/CuadradoVerde.png","/Imagenes/CuadradoVioleta.png"};
    }
    
    
    public ImageIcon getCuadrado(Color color) {
    	ImageIcon nuevoCuadrado;
    	if (color == Color.yellow) {
    		nuevoCuadrado = actualizar(0);
    	}
    	else if (color == Color.blue) {
    		nuevoCuadrado = actualizar(1);
    	}
		else if (color == Color.cyan) {
			nuevoCuadrado = actualizar(2);		
		}
		else if (color == Color.orange) {
			nuevoCuadrado = actualizar(3);
		}
		else if (color == Color.red) {
			nuevoCuadrado = actualizar(5);
		}
		else if (color == Color.green) {
			nuevoCuadrado = actualizar(6);
		}
		else {
			nuevoCuadrado = actualizar(7);
		}
    	return nuevoCuadrado;
    }
    
    public ImageIcon actualizar (int indice) {
    	if(indice<this.imagenes.length) {
    		ImageIcon imageIcon= new ImageIcon(this.getClass().getResource(this.imagenes[indice]));
    		return imageIcon;
    	}
    	return null;
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