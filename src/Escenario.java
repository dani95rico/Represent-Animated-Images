import java.awt.*;

import javax.swing.*;

/**
 * Esta clase permite mostrar una ventana grafica en pantalla. En esta ventana se
 * podran dibujar imagenes indicando la posicion (x,y). El origen de coordenadas (0,0)
 * esta situado en el vertice superior izquierdo de la ventana. El vertice inferior derecho
 * se corresponde con la posicion (ancho,alto).
 * 
 * @author PRL, DTE-UPM
 *
 */

@SuppressWarnings("serial")
public class Escenario extends JFrame {

	/**
	 * Crea una ventana grafica de titulo el parametro nombre y
	 * de tamanno correspondiente a ancho x alto (en pixels)
	 * 
	 * @param nombre - el titulo de la ventana
	 * @param ancho - el ancho de la ventana
	 * @param alto - el alto de la ventana
	 */
	public Escenario(String nombre, int ancho, int alto) 
	{
		super(nombre);
		MiPanel mipanel;
		mipanel = new MiPanel();
		mipanel.setPreferredSize(new Dimension(ancho,alto));
		this.ancho = ancho;
		this.alto = alto;
		setBackground(Color.WHITE);
		add(mipanel); 
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	/**
	 * Permite dibujar una imagen en la ventana en la posicion especificada (x,y)
	 * Para crear (a partir del nombre de un fichero) un objeto de clase Imagen 
	 * se puede utilizar:
	 * 	Imagen imagen = new Imagen (nombreFichero);
	 * @param x - columna inicial 
	 * @param y - fila inicial
	 * @param imagen - imagen a dibujar
	 */
	public void dibujarImagen(int x, int y, Imagen imagen) {
		this.x = x;
		this.y = y;
		image = imagen.getImagen();
		repaint();
	}
	
	/**
	 * Devuelve el ancho de la ventana
	 * @return el ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Devuelve el alto de la ventana
	 * @return el alto
	 */
	public int getAlto() {
		return alto;
	}

	// Declaraciones privadas
	
	// Componente intermedio para disponer de double buffering en la animaciÛn al pintar las imagenes
	private	class MiPanel extends JPanel {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
			    super.paintComponent(g);
			    g.clearRect(0, 0, getWidth(), getHeight());
			    g.drawImage(image, x, y, this);
			}
		}	
	
	// Variables privadas
	private Image image;
	private int x,y,ancho,alto;

}
