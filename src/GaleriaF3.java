import java.util.*;

public class GaleriaF3 implements IGaleria {

	//Constantes
	private static final int ANCHO = 300;
	private static final int ALTO = 300;
	private static final int RETARDO = 200;
		
	//Atributos
	private Map <String,Album> mapa;

	public GaleriaF3(){
		mapa = new HashMap <String,Album> ();
	}

	public boolean crearAlbum(String album){
		
		if(album==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		Album albumNuevo = new Album(album);
		mapa.put(album, albumNuevo);
		
		return true;
	}
	
	public Album getAlbum(String album){
		
		if(album==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		return mapa.get(album);
	}
	
	public Album delAlbum(String album){
		
		if(album==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		return mapa.remove(album);
	}
	
	public String[] getAlbumes(){
		
		String [] nombres;
		
		if(mapa.size() == 0){
			nombres = new String[mapa.size()];
			
			Iterator <String> iter = mapa.keySet().iterator();
			int i = 0;
			
			while(iter.hasNext()){
				nombres[i]=new String(iter.next());
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
			String [] nombres = new String [aux.getNumFotos()];
			for(int i=0; i<aux.getNumFotos(); i++){
				Foto foto = aux.getFoto(i);
				nombres[i]=foto.getNomFichero();
			}
			AnimacionImagenes a = new AnimacionImagenes(album,ANCHO,ALTO,nombres);
			player(a);
			
		} catch(AnimacionException e) {
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
