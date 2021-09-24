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

public class GrillaGrafica extends JPanel{
	
	private static final long serialVersionUID = -3857957447580442863L;
	private final ImageIcon negro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/CuadradoNegro.png")));
	private Par[] posicionesAntiguas;
	private final List<JLabel> lista = new LinkedList<JLabel>();
	 
	 /**
	  * Se inicializa la grilla grafica en negro
	  */
    public GrillaGrafica() {	
		setBackground(Color.WHITE);
		setBounds(23, 11, 320, 720);
		setLayout(new GridLayout(22, 10, 0, 0));
    	for (int i = 0; i < 10 * 22; i++) {
    		JLabel cuadradoNegro = nuevoCuadradoNegro();
			lista.add(cuadradoNegro);
			this.add(cuadradoNegro);
        }
    	
    }
    /**
     * 
     * @return Devuelve un nuevo cuadrado negro
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
     * 
     * @param f Indice fila del componente 
     * @param c Indice columna del componente
     * @return Devuelve el componente grafico en la posicion (f, c) de la grilla grafica. 
     */
    private JLabel getJLabelAt(int f, int c) {
    	 int index = c * 10 + f;
         return lista.get(index);
    }
    
    /**
     * Al colisionar con los bloques ya apilados o llegar al suelo, el tetrimino se incorpora a la imagen de bloques apilados.
     * @param posicionesActuales Las posiciones que ocupa el tetrimino en la grilla
     * @param color El color del tetrimino a apilar
     */
	public void acoplarTetriminoAGrillaGrafica(Par[] posicionesActuales, ImageIcon color) {
		for	(Par parNuevoActual : posicionesActuales) 
			getJLabelAt(parNuevoActual.getX(), parNuevoActual.getY()).setIcon(color);
	}

	/**
	 * Actualiza la imagen grafica luego del movimiento o rotacion del tetrimino
	 * @param posicionesNuevas Las nuevas posiciones que ocupa el tetrimino en la grilla
	 * @param color El color del en movimiento
	 */
	public void actualizar(Par[] posicionesNuevas, ImageIcon color) {
		for	(Par parAntiguoActual : posicionesAntiguas) 
			getJLabelAt(parAntiguoActual.getX(), parAntiguoActual.getY()).setIcon(negro);
		
		for	(Par parNuevoActual : posicionesNuevas) 
			getJLabelAt(parNuevoActual.getX(), parNuevoActual.getY()).setIcon(color);
		
		posicionesAntiguas = posicionesNuevas;
	}

	/**
	 * Muestra un nuevo tetrimino cayendo en pantalla
	 * @param posicionesNuevas Las posiciones que ocupa el tetrimino en la grilla
	 * @param color El color del tetrimino a mostrar en pantalla
	 */
	public void mostrarNuevoTetrimino(Par[] posicionesNuevas, ImageIcon color) {
		posicionesAntiguas = posicionesNuevas.clone();

		for	(Par parNuevoActual : posicionesNuevas) 
			getJLabelAt(parNuevoActual.getX(), parNuevoActual.getY()).setIcon(color);
	}

	
	/**
	 * Elimina una linea completa de la grilla grafica
	 * @param fila fila a eliminar
	 */
	public void eliminarLinea(int fila) {
		for(int i = fila; i > 0; i --) {
            for (int j = 0; j < 10; j++) {
                getJLabelAt(j, i).setIcon(getJLabelAt(j, i-1).getIcon());
            }
        }
    }		
	
	
}
	
