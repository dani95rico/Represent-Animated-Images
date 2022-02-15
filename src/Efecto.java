/**
 * Esta inferfaz describe la unica operacion que deben implementar las
 * clases que codifican algun efecto visual que se realiza sobre una imagen.
 * @author PRL, DTE-UPM
 *
 */

public interface Efecto {
	/**
	 * Genera una imagen de salida a partir de la imagen de entrada aplicando
	 * el efecto que corresponda.
	 * @param entrada imagen de entrada
	 * @return la imagen de salida con el efecto aplicado
	 */
	Imagen transformar (Imagen entrada);

}
