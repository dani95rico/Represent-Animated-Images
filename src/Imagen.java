/******************************************************************************
 *
 *	Clase que permite manipular el color de los pixels de una imagen. La imagen 
 *	se lee desde un fichero con formato jpg, gif o png, o tambien se puede crear
 *	una imagen vacia de un tamanno dado. La imagen puede guardarse en un fichero.
 *
 *	@author	PRL, DTE UPM
 ******************************************************************************/

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;


public final class Imagen  {
    private BufferedImage imagen;	// imagen Java
    private int ancho, alto;		// ancho y alto
    private String fichero;
   /**
     * Crea una  nueva imagen vacia de <tt>ancho</tt> x <tt>alto</tt> en color negro.
     *
     * @param ancho el ancho de la imagen
     * @param alto el alto de la imagen
     */
    public Imagen(int ancho, int alto) {
        if (ancho < 0) throw new IllegalArgumentException("El ancho no puede ser negativo");
        if (alto < 0) throw new IllegalArgumentException("El alto no puede ser negativo");
        this.ancho  = ancho;
        this.alto = alto;
        imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
    }

    
    /**
     * Crea una imagen a partir del  fichero (formato .png, .gif, o .jpg)
     * cuyo nombre se pasa como par·metro
     *
     * @param nombre el nombre del fichero
     */
    public Imagen(String nombre) {
        this.fichero = nombre;
        try {
            // Intentar leer utilizando el directorio de trabajo
            File file = new File(nombre);
            if (file.isFile()) {
                imagen = ImageIO.read(file);
            }

            // Intentar leer utilizando el directorio de las clases .class
            else {
                URL url = getClass().getResource(nombre);
                if (url == null) {
                    url = new URL(nombre);
                }
                imagen = ImageIO.read(url);
            }
            ancho = imagen.getWidth(null);
            alto = imagen.getHeight(null);
        }
        catch (IOException e) {
            throw new RuntimeException("No se puedo abrir el fichero: " + nombre);
        }
    }

    /**
     * Crea una imagen a partir del  fichero que se pasa como par·metro
     *
     * @param fichero el fichero
     */
      public Imagen(File fichero) {
        this(fichero.getName());
    }


   /**
    * Devuelve la imagen Java
	 * @return the imagen
	 */
	public BufferedImage getImagen() {
		return imagen;
	}


	/**
     * Devuelve el alto de la imagen
     * @return el alto de la imagen (en pixels)
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Devuelve el ancho de la imagen
     * @return el ancho de la imagen (en pixels)
     */
    public int getAncho() {
        return ancho;
    }

   /**
     * Devuelve el color de un pixel (<tt>columna</tt>, <tt>fila</tt>).
     * El origen de coordenadas (0,0) se corresponde con la esquina superior izquierda de la imagen.
     * @param x la columna
     * @param y la fila
     * @return el color del pixel (<tt>x</tt>, <tt>y</tt>)
    
     */
    public Color getColor(int x, int y) {
        if (x < 0 || x >= ancho)  throw new IndexOutOfBoundsException("La columna debe estar comprendida entre 0 y " + (ancho-1));
        if (y < 0 || y >= alto) throw new IndexOutOfBoundsException("La fila debe estar comprendida entre 0 y " + (alto-1));
        return new Color(imagen.getRGB(x, y));
       
    }

    /**
     * Cambia el color de un pixel (<tt>columna</tt>, <tt>fila</tt>).
     * El origen de coordenadas (0,0) se corresponde con la esquina superior izquierda de la imagen.
     * @param x la columna
     * @param y la fila
     * @param color el color
     */
    public void setColor(int x, int y, Color color) {
        if (x < 0 || x >= ancho)  throw new IndexOutOfBoundsException("La columna debe estar comprendida entre 0 y " + (ancho-1));
        if (y < 0 || y >= alto) throw new IndexOutOfBoundsException("La fila debe estar comprendida entre 0 y " + (alto-1));
        if (color == null) throw new NullPointerException("El color no puede ser nulo");
        imagen.setRGB(x, y, color.getRGB());

    }

   /**
     * Devueve si esta imagen es igual que otra imagen.
     * @param o la otra imagen
     * @return <tt>true</tt> si las imagenes son iguales 
     */
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        Imagen otra = (Imagen) o;
        if (this.ancho  != otra.ancho)  return false;
        if (this.alto != otra.alto) return false;
        for (int x = 0; x < ancho; x++)
            for (int y = 0; y < alto; y++)
                if (!this.getColor(x, y).equals(otra.getColor(x, y))) return false;
        return true;
    }

  
    /**
     * Guarda la imagen en el fichero del que procede, actualizandolo
     */
    public void save() {
    	if (fichero==null) throw  new RuntimeException("La imagen no se puede salvar porque no procede de un fichero.");
    	save(fichero);
    }
    
   /**
     * Guarda la imagen en el fichero cuyo nombre se pasa como parametro
     * El tipo del fichero debe ser  .png o .jpg.
     * @param nombreFichero el nombre del fichero
     */
    public void save(String nombreFichero) {
        String tipo = nombreFichero.substring(nombreFichero.lastIndexOf('.') + 1);
        tipo = tipo.toLowerCase();
        if (tipo.equals("jpg") || tipo.equals("png")) {
            try {
                ImageIO.write(imagen, tipo, new File(nombreFichero));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Error: el fichero debe ser .jpg o .png");
        }
    }


}
