package PartesGraficas;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Class BloqueGrafico - Modela un la parte gr�fica asociada a un bloque.
 * @author Grupo N�.
 */
public class BloqueGrafico {
    
	// Atributos de instancia.
	
	private ImageIcon cuadrado;
    private String[] imagenes;
    
    // Constructor.
    
    /**
     * Crea un nuevo Bloque Gr�fico. 
     */
    public BloqueGrafico () {
        this.cuadrado = new ImageIcon(Toolkit.getDefaultToolkit().getImage(BloqueGrafico.class.getResource("/Imagenes/CuadradoNegro.png")));
       	this.imagenes = new String[]{"/Imagenes/CuadradoAmarillo.png", "/Imagenes/CuadradoAzul.png","/Imagenes/CuadradoCyan.png","/Imagenes/CuadradoNaranja.png","/Imagenes/CuadradoNegro.png","/Imagenes/CuadradoRojo.png","/Imagenes/CuadradoVerde.png","/Imagenes/CuadradoVioleta.png"};
    }
    
    // M�todos
    
    /**
     * Actualiza el �ndice del Bloque Gr�fico.
     * @param indice Indice nuevo asociado.
     */
    public void actualizar (int indice) {
    	if (indice < this.imagenes.length) {
    		ImageIcon imageIcon= new ImageIcon(this.getClass().getResource(this.imagenes[indice]));
    		this.cuadrado.setImage(imageIcon.getImage());
    	}
    }
    
    /**
     * Retorna el cuadrado asociado al indice actual.
     * (Discutir Nombre Representativo)
     * @return ImageIcon asociada al cuadrado.
     */
	public ImageIcon getCuadrado() {
		return cuadrado;
	}

	/**
	 * Establece un nuevo cuadrado al Bloque Gr�fico.
	 * @param cuadrado Nueva ImageIcon asociada al Bloque Gr�fico.
	 */
	public void setCuadrado(ImageIcon cuadrado) {
		this.cuadrado = cuadrado;
	}
	
	/**
	 * Retorna el conjunto completo de imagenes (cuadrados).
	 * @return Arreglo de String con las imagenes correspondintes.
	 */
	public String[] getImagenes() {
		return imagenes;
	}

	/**
	 * Establece un nuevo conjunto de imagenes (cuadrados).
	 * @param imagenes Arreglo que contiene las nuevas imagenes a asociar.
	 */
	public void setImagenes(String[] imagenes) {
		this.imagenes = imagenes;
	}

}