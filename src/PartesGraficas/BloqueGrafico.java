package PartesGraficas;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Class BloqueGrafico - Modela un la parte gráfica asociada a un bloque.
 * @author Grupo N°.
 */
public class BloqueGrafico {
    
	// Atributos de instancia.
	
	private ImageIcon cuadrado;
    private String[] imagenes;
    
    // Constructor.
    
    /**
     * Crea un nuevo Bloque Gráfico. 
     */
    public BloqueGrafico () {
        this.cuadrado = new ImageIcon(Toolkit.getDefaultToolkit().getImage(BloqueGrafico.class.getResource("/Imagenes/CuadradoNegro.png")));
       	this.imagenes = new String[]{"/Imagenes/CuadradoAmarillo.png", "/Imagenes/CuadradoAzul.png","/Imagenes/CuadradoCyan.png","/Imagenes/CuadradoNaranja.png","/Imagenes/CuadradoNegro.png","/Imagenes/CuadradoRojo.png","/Imagenes/CuadradoVerde.png","/Imagenes/CuadradoVioleta.png"};
    }
    
    // Métodos
    
    /**
     * Actualiza el índice del Bloque Gráfico.
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
	 * Establece un nuevo cuadrado al Bloque Gráfico.
	 * @param cuadrado Nueva ImageIcon asociada al Bloque Gráfico.
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