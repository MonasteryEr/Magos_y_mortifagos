package batallon;
import java.util.*;
import personaje.Personaje;
import personaje.FabricaPersonaje;
import hechizos.Hechizo;
import hechizos.TipoHechizo;
public class Batallon {

	private List<Personaje> personajes;
	private List<Personaje> secuenciaAtaques;
	private Map <Personaje,List<Hechizo>> hechizosLanzados;
	
	public Batallon() {
		personajes = new ArrayList<>();
		secuenciaAtaques = new ArrayList<>();
		hechizosLanzados = new HashMap<>();
	}
	
	
	public void agregarPersonaje(Personaje p) {
		personajes.add(p);
	}
	
	
	public boolean tienePersonajesSaludables() {
		for(Personaje p: personajes) {
			if(p.estaVivo()) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public Personaje obtenerPersonajeAleatorio() {
		List<Personaje> vivos = new ArrayList<>();
		
		for(Personaje p: personajes) {
			if(p.estaVivo()) {
				vivos.add(p);
			}
		}
		
		Random rand = new Random();
		return vivos.get(rand.nextInt(vivos.size()));
	}
	
	
	public void atacar(Batallon enemigo) {
		Personaje atacante = obtenerPersonajeAleatorio();
		
		if(!atacante.estaVivo()) {
			return;
		}
		
		Personaje objetivo = enemigo.obtenerPersonajeAleatorio();
		
		Hechizo hechizo = atacante.obtenerHechizoDisponible();
		
		secuenciaAtaques.add(atacante);
		
		if(!hechizosLanzados.containsKey(atacante)) {
			hechizosLanzados.put(atacante, new ArrayList <>());
		}
		
		hechizosLanzados.get(atacante).add(hechizo);
		
		if (hechizo.getTipo() == TipoHechizo.DEFENSA) {
		    System.out.println(
		         atacante.getEtiqueta()
		        + " lanza "
		        + hechizo.getNombre()
		        + " sobre sí mismo.");
		    
		} else if (hechizo.getTipo() == TipoHechizo.CURACION) {

		    System.out.println(
		        atacante.getEtiqueta()
		        + " lanza "
		        + hechizo.getNombre()
		        + " sobre sí mismo.");

		} else {

		    System.out.println(
		         atacante.getEtiqueta()
		        + " lanza "
		        + hechizo.getNombre()
		        + " sobre "
		        + objetivo.getTipo());

		}
		
		atacante.lanzarHechizo(hechizo, objetivo);
		 
		if (hechizo.getTipo() == TipoHechizo.CURACION) {
		    System.out.println(
		        atacante.getEtiqueta() +
		        " ahora tiene " +
		        atacante.getPuntosVida() +
		        " puntos de vida.");
		}
		else if (hechizo.getTipo() == TipoHechizo.DEFENSA) {
		    System.out.println(
		        atacante.getEtiqueta() +
		        " aumenta su defensa en " + atacante.getDefenza());
		}
		else {
		    System.out.println(
		        objetivo.getEtiqueta() +
		        " queda con " +
		        objetivo.getPuntosVida() +
		        " puntos de vida.");

		    if (!objetivo.estaVivo()) {
		        System.out.println(
		            objetivo.getEtiqueta() +
		            " ha sido eliminado.");
		    }
		}

	    secuenciaAtaques.add(atacante);

	    hechizosLanzados
	            .computeIfAbsent(atacante, k -> new ArrayList<>())
	            .add(hechizo);
		 
	}
	
	
	public void agregarMagoAleatorio(int nivel) {
	    personajes.add(FabricaPersonaje.crearMagoAleatorio(nivel));
	}

	public void agregarMortifagoAleatorio(int nivel) {
	    personajes.add(FabricaPersonaje.crearMortifagoAleatorio(nivel));
	}

	public List<Personaje> getPersonajes() {
	    return personajes;
	}
	
}
