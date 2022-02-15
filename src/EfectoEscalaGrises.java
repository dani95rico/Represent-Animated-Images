import java.awt.Color;

public class EfectoEscalaGrises implements Efecto {
	
	/**
	 * Genera una imagen de salida a partir de la imagen de entrada aplicando el efecto que corresponda.
	 * @param original - imagen de entrada.
	 * @return a imagen de salida con el efecto aplicado.
	 */
	public Imagen transformar (Imagen original) {
		
		if (original == null)
			throw new IllegalArgumentException ("La imagen no puede ser null");
		
		Imagen resultado = new Imagen (original.getAncho(), original.getAlto());
		
		for(int x=0; x<original.getAncho(); x++) {
			for(int y=0; y<original.getAlto(); y++) {
				Color pixel = original.getColor(x,y);
				int grayLevel = (int)(pixel.getRed()*0.299 + pixel.getGreen()*0.587 + pixel.getBlue()*0.114);
				resultado.setColor (x, y, new Color (grayLevel, grayLevel, grayLevel));
			}
		}
		
		return resultado;
	}
	
}
