package EntidadesLogicas;

import javax.swing.ImageIcon;

public class Bloque {
		private ImageIcon color;
		
		public Bloque(ImageIcon color) {
			this.color = color;
		}
		
		public ImageIcon getColor() {
			return color;
		}

		public void setColor(ImageIcon color) {
			this.color = color;
		}
		
}