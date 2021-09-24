package EntidadesLogicas;

import javax.swing.ImageIcon;

/**
 * Class Bloque - Modela un Bloque de la Grilla lógica.
 * @author Grupo N°2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Martín, Mandolesi Bruno.
 */
public class Bloque {
	
	// Atributos de instancia.
	
	private ImageIcon color;
	
	// Constructor.
	
	/**
	 * Crea un nuevo Bloque con un color asociado.
	 * @param color Color del bloque.
	 */
	public Bloque(ImageIcon color) {
		this.color = color;
	}
	
	// Métodos.
		
	/**
	 * Retorna la imagen del color asociado al Bloque.
	 * @return ImageIcon asociado al bloque.
	 */
	public ImageIcon getColor() {
		return color;
	}

	/**
	 * Establece la imagen del color asociado al Bloque.
	 * @param color ImageIcon a establecer.
	 */
	public void setColor(ImageIcon color) {
		this.color = color;
	}
		
}