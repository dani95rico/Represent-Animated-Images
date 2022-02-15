import java.awt.Color;

public class EfectoLibre implements Efecto {
	
	/**
	 * Genera una imagen de salida girada a partir de la imagen de entrada.
	 * @param original - imagen de entrada.
	 * @return la imagen de salida con el efecto aplicado.
	 */
	public Imagen transformar(Imagen original) {
		
		if (original == null)
			throw new IllegalArgumentException ("La imagen no puede ser null");
		
		Imagen resultado = new Imagen(original.getAlto(),original.getAncho());
		
		for(int x=0; x<original.getAncho(); x++) {
			for(int y=0; y<original.getAlto(); y++) {
				Color pixel = original.getColor (x,y);
				resultado.setColor (y, x, pixel);
			}
		}
		
		return resultado;
	}
	
}