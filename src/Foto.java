import java.util.*;
import java.io.Serializable;

public class Foto implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	//Atributos del constructor
	private String descripcion;
	private Date fecha;
	private String nomFichero;
	
	/**
	 * Representa a una foto caracterizada por un nombre de fichero, la fecha de creacion (tipo Date) y una descripcion
	 * @param descripcion - descripcion libre
	 * @param fecha - fecha en la que se hizo la foto. Tipo Date
	 * @param nomFichero - el nombre de fichero
	 * @throws IllegalArgumentException - en el caso que alguno de los parámetros vayan a null
	 */
	public Foto (String descripcion, Date fecha, String nomFichero) {
		
		if (descripcion == null)
			throw new IllegalArgumentException ("La descripcion no puede ser null");
		if (fecha == null)
			throw new IllegalArgumentException ("La fecha no puede ser null");
		if (nomFichero == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");			
		
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.nomFichero = nomFichero;
	
	}
	
	/**
	 * Devuelve la descripcion de la foto
	 * @return la descripcion
	 */
	public String getDescripcion () {
		return descripcion;
	}
	
	/**
	 * Devuelve la fecha con la que se creo la foto
	 * @return la fecha de la foto
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * Devuelve el nombre del fichero al que esta vinculada la foto
	 * @return el nombre de la foto
	 */
	public String getNomFichero () {
		return nomFichero;
	}
	
	/**
	 * Metodo de conveniencia para representar textualmente el estado del objeto
	 * @return estado del objeto
	 */
	public String toString() {
		return nomFichero + " " + descripcion + " " + fecha;
	}

}
