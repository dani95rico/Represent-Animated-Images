import java.util.*;
import java.io.Serializable;

public class Album implements Serializable{
	
	private final static long serialVersionUID = 1L;
	
	//Atributos del constructor
	private String nombre;
	List <Foto> fotos;
	
	/**
	 * Crea un album
	 * @param nombre - del album
	 * @throws IllegalArgumentException - si el nombre es null
	 */
	public Album (String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		
		this.nombre = nombre;
		fotos = new ArrayList<Foto>();
		
	}
	
	/**
	 * Obtiene el nombre del album
	 * @return el nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Annade una foto al album.
	 * @param foto - a agregar al album
	 * @return true si se annade la foto o false en caso contrario
	 * @throws IllegalArgumentException si la foto es null
	 */ 
	public boolean addFoto(Foto foto) {
		
		if (foto == null)
			throw new IllegalArgumentException ("La foto no puede ser null");
		
		return fotos.add(foto);
	}
	
	/**
	 * Borra la foto que ocupa esa posicion en la secuencia
	 * @param posicion
	 * @return la foto borrada o null si no se ha borrado por que no exista una foto en esa posicion.
	 */
	public Foto delFoto(int posicion) {
		Foto foto = null;
		if((posicion >= 0) && (posicion < fotos.size()))
			foto = fotos.remove(posicion);
		return foto;
		
	}
	
	/**
	 * Borra la foto que tiene el citado nombre de fichero
	 * @param nf - nombre de fichero
	 * @return true si se ha borrado o false si no existe una foto con ese nombre
	 */
	public boolean delFoto(String nf) {
		
		if(nf==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		boolean encontrado = false;
		Iterator <Foto> iter = fotos.iterator();
		
		while(iter.hasNext() && !encontrado) {
			Foto aux=iter.next();
			if(aux.getNomFichero().equals(nf)) {
				encontrado = true;
				iter.remove();
			}
		}
		
		return encontrado;
		
	}
	
	/**
	 * Devuelve la foto con ese nombre de fichero sin borrarla del álbum
	 * @param nf - nombre de fichero
	 * @return la foto con ese nombre de fichero, o null en caso de que no exista o el parametro nf sea null
	 */
	public Foto getFoto(String nf) {
		
		if(nf == null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		Foto foto = null;
		boolean encontrado = false;
		Iterator <Foto> iter = fotos.iterator();
		
		while(iter.hasNext() && !encontrado){
			Foto aux = iter.next();
			if(aux.getNomFichero().equals(nf)){
				encontrado = true;
				foto = aux;
			}
		}
		
		return foto;
		
	}
	
	/**
	 * Devuelve la foto que se encuentra en esa posicion de la secuencia sin borrarla del album
	 * @param posicion
	 * @return la foto o null si posición esta fuera de la secuencia
	 */
	public Foto getFoto(int posicion) {
		Foto foto = null;
		if((posicion >= 0) && (posicion < fotos.size()))
			foto = fotos.get(posicion);
		return foto;
	}
	
	/**
	 * Devuelve el numero de fotos que contiene el album
	 * @return numero de fotos
	 */
	public int getNumFotos() {
		return fotos.size();
	}
	
	/**
	 * Metodo de conveniencia para conjuntos. Dos albumes son iguales si tienen el mismo nombre
	 * @param o - objecto con el que nos comparamos. Son iguales si tienen el mismo nombre
	 * @return true si son iguales, false si no
	 */
	public boolean equals(Object o) {
		boolean iguales;
		iguales = false;
		
		if ((o != null) && (o instanceof Foto)) {
			
			Album album = (Album)o;
			iguales = nombre.equals(album.nombre);
		
		}
		return iguales;
	}
	
	/**
	 * Metodo de conveniencia para conjuntos. El atributo del que se obtiene el identificador hash es el nombre.
	 * @return 
	 */
	public int hashCode() {
		return nombre.hashCode();
	}
	

}
