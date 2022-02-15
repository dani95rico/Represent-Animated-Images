import java.util.*;

public class GaleriaF2 implements IGaleria {
	
	//Constantes
	private static final int ANCHO = 300;
	private static final int ALTO = 300;
	private static final int RETARDO = 200;
	
	//Atributos
	private Set <Album> albumes; 
	
	public GaleriaF2(){
		albumes = new HashSet <Album> ();
	}

	public boolean crearAlbum (String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		
		albumes.add(new Album (nombre));
		return true;
	}

	public Album getAlbum(String album) {
		
		if (album == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		
		Album res = null;
		boolean encontrado=false;
		Iterator <Album> iter = albumes.iterator();
		
		while(iter.hasNext() && !encontrado){
			Album aux = iter.next();
			if(aux.getNombre().equals(album)) {
				encontrado = true;
				res = aux;
			}
		}
		
		return res;
	}

	public Album delAlbum(String album) {
		
		if (album == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		
		Album res = null;
		boolean encontrado=false;
		Iterator <Album> iter = albumes.iterator();
		
		while(iter.hasNext() && !encontrado){
			Album aux = iter.next();
			if(aux.getNombre().equals(album)) {
				encontrado = true;
				iter.remove();
				res = aux;
			}
		}
		
		return res;
	}

	public String[] getAlbumes() {
		String [] nombres;
		
		if(albumes.size() != 0) {
			nombres = new String[albumes.size()];
		
			Iterator <Album> iter = albumes.iterator();
			int i = 0;
		
			while(iter.hasNext()){
				nombres[i] = new String(iter.next().getNombre());
				i++;
			}
		}
		else 
			nombres = null;
			
		return nombres;
	}

	public void presentarAlbum(String album) throws GaleriaException {

		try {
			Album aux = getAlbum(album);
			String [] nombres = new String[aux.getNumFotos()];
			for(int i=0; i<aux.getNumFotos(); i++){
				Foto foto = aux.getFoto(i);
				nombres[i]=foto.getNomFichero();
			}
			AnimacionImagenes a = new AnimacionImagenes(album,ANCHO,ALTO,nombres);
			player(a);
			
		} catch(AnimacionException e){
			throw new GaleriaException(e.getMessage());
		  }
	}
	
	/**
	 * Metodo que presenta la animacion
	 * @param a - animacion a ejecutar
	 * @throws Exception 
	 */
	private static void player (Animacion a) {
		while (!a.estaFinalizada()) {
			a.ejecutarPaso();
			try {
				Thread.sleep(RETARDO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

