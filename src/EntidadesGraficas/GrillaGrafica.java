package EntidadesGraficas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import EntidadesLogicas.Par;

/**
 * Class GrillaGrafica - Modela la GrillaGrafica del juego.
 * @author Grupo N°2: Messina Nicolas, Mazzino Albano Manuel, Perez Gonzalo Martín, Mandolesi Bruno.
 */
public class GrillaGrafica extends JPanel{
	
	// Atributos de Clase.
	
	protected static final long serialVersionUID = -3857957447580442863L;
	protected static final int cantidadDeFilas = 22;
	protected static final int cantidadDeColumas = 10;
	
	// Atributos de instancia.
	
	protected final ImageIcon negro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoNegro.png")));
	protected final List<JLabel> lista = new LinkedList<JLabel>();
	 
	// Constructor.
	
	 /**
	  * Crea una nueva GrillaGrafica.
	  */
    public GrillaGrafica() {	
		setBackground(Color.WHITE);
		setBounds(23, 11, 320, 720);
		setLayout(new GridLayout(cantidadDeFilas, cantidadDeColumas, 0, 0));
    	for (int i = 0; i < cantidadDeFilas * cantidadDeColumas; i++) {
    		JLabel cuadradoNegro = nuevoCuadradoNegro();
			lista.add(cuadradoNegro);
			this.add(cuadradoNegro);
        }
    	
    }
    
    // Métodos.
    
    /**
     * Retorna un nuevo cuadrado negro.
     * @return JLabel asociado a un cuadrado negro.
     */
    private JLabel nuevoCuadradoNegro() {
    	JLabel cuadrado = new JLabel();
        cuadrado.setBounds(0, 0, 30, 30);				
		cuadrado.setBorder(new LineBorder(Color.gray));
		ImageIcon imagenNegra = negro;
		ImageIcon img = new ImageIcon(imagenNegra.getImage().getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), Image.SCALE_SMOOTH));
		cuadrado.setIcon(img);	
		return cuadrado;
    }
    
    /**
     * Retorna el JLabel especifico de la Grilla.
     * @param f Indice fila del componente 
     * @param c Indice columna del componente
     * @return Devuelve el componente grafico en la posicion (f, c) de la grilla grafica. 
     */
    private JLabel getJLabelAt(int f, int c) {
         return lista.get(c * 10 + f);
    }

	/**
	 * Actualiza la imagen grafica por causa de un movimiento o rotacion del tetrimino
	 * @param posiciones Las posiciones a las cuales se le debe actualizar el color
	 * @param color El color con el que se actualizaran las posiciones
	 */
	public void actualizar(Par[] posiciones, ImageIcon color) {	
		for	(Par parNuevoActual : posiciones) {
			getJLabelAt(parNuevoActual.getX(), parNuevoActual.getY()).setIcon(color);
		}
		
	}
	
	/**
	 * Elimina una linea completa de la grilla grafica
	 * @param fila Fila a eliminar
	 */
	public void eliminarLinea(int fila) {
		for (int i = fila; i > 0; i --) {
            for (int j = 0; j < cantidadDeColumas; j++) {
                getJLabelAt(j, i).setIcon(getJLabelAt(j, i-1).getIcon());
            }
        }
    }		
	
	/**
	 * Reinicializa la grilla grafica
	 */
	public void reset() {
    	for(int filas=21; filas >= 0; filas--) {
            for (int j = 0; j < 10; j++) {
                getJLabelAt(j, filas).setIcon(negro);
            }
        }
    }
}
	