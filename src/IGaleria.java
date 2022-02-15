
public interface IGaleria {
	
	/**
	 * Crea un album y lo añade a la coleccion de base
	 * @param nombre - del album
	 * @throws IllegalArgumentException - si el nombre es null
	 */
	public boolean crearAlbum(String nombre); 
	
	/**
	 * Devuelve el citado album sin borrarlo de la coleccion
	 * @param album - nombre del album
	 * @return - el Album o null si no existe álbum con ese nombre
	 * @throws IllegalArgumentException - si el parametro nombre es null
	 */
	public Album getAlbum(String album);
	
	/**
	 * Borramos el citado album de la coleccion
	 * @param album - nombre del album
	 * @return el album borrado o null si no lo ha podido borrar por que no exista
	 * @throws IllegalArgumentException - si el parámetro album es null
	 */
	public Album delAlbum(String album);
	
	/**
	 * Devuelve los nombres de los albumes o null si no existe ninguno
	 * @return array de nombres
	 */
	public String[] getAlbumes();
	
	/**
	 * Visualizar las fotos de un determinado album a traves de la animacion AnimacionImagenesCircular
	 * @param album - nombre del album
	 * @param retardo - entre pasos de ejecucion
	 * @throws GaleriaException - si no existe el album o se produce la excepcion AnimacionException,
	 * IllegalArgumentException - si el album es null o retardo negativo
	 */
	void presentarAlbum(String album) throws GaleriaException;
}
