package batallon;

import java.util.*;

import Estados.EstadoMuerto;
import personaje.Personaje;
import personaje.FabricaPersonaje;
import hechizos.Hechizo;
import hechizos.TipoHechizo;

public class Batallon {

	private List<Personaje> personajes;
	private List<Personaje> secuenciaAtaques;
	private Map<Personaje, List<Hechizo>> hechizosLanzados;

	public Batallon() {

		personajes = new ArrayList<>();
		secuenciaAtaques = new ArrayList<>();
		hechizosLanzados = new HashMap<>();

	}

	public void agregarPersonaje(Personaje p) {

		personajes.add(p);

	}

	public boolean tienePersonajesSaludables() {

		for (Personaje p : personajes) {
			if (!p.estaMuerto()) {
				return true;
			}

		}
		return false;

	}

	public Personaje obtenerPersonajeAleatorio() {

		List<Personaje> vivos = new ArrayList<>();

		for (Personaje p : personajes) {

			if (!p.estaMuerto()) {
				vivos.add(p);
			}
		}

		Random rand = new Random();
		return vivos.get(rand.nextInt(vivos.size()));
	}

	public void atacar(Batallon enemigo) {

		Personaje atacante = obtenerPersonajeAleatorio();
		if (atacante.estaMuerto()) {
			return;
		}
		Personaje objetivo = enemigo.obtenerPersonajeAleatorio();

		Hechizo hechizo = atacante.obtenerHechizoDisponible();

		secuenciaAtaques.add(atacante);

		if (!hechizosLanzados.containsKey(atacante)) { //SI NO ATACO ANTES
			hechizosLanzados.put(atacante, new ArrayList<>()); //CREA LA LISTA
		}

		hechizosLanzados.get(atacante).add(hechizo); //AGREGA EL HECHIZO A LA LISTA

		if (hechizo.getTipo() == TipoHechizo.DEFENSA) {

			System.out.println(atacante.getEtiqueta() + " lanza " + hechizo.getNombre() + " sobre sí mismo.");

		} else if (hechizo.getTipo() == TipoHechizo.CURACION) {

			System.out.println(atacante.getEtiqueta() + " lanza " + hechizo.getNombre() + " sobre sí mismo.");

		} else {

			System.out
					.println(atacante.getEtiqueta() + " lanza " + hechizo.getNombre() + " sobre " + objetivo.getEtiqueta());

		}

		atacante.lanzarHechizo(hechizo, objetivo);

		if (hechizo.getTipo() == TipoHechizo.CURACION) {

			System.out
					.println(atacante.getEtiqueta() + " ahora tiene " + atacante.getPuntosVida() + " puntos de vida.");

		} else if (hechizo.getTipo() == TipoHechizo.DEFENSA) {

			System.out.println(atacante.getEtiqueta() + " aumenta su defensa en " + atacante.getDefensa());

		} else {

			System.out.println(objetivo.getEtiqueta() + " queda con " + objetivo.getPuntosVida() + " puntos de vida.");

			if (objetivo.estaMuerto()) {

				System.out.println(objetivo.getEtiqueta() + " ha sido eliminado.");

			}
		}

//		    System.out.println(
//		            objetivo.getNombre() +
//		            " queda con " +
//		            objetivo.getPuntosVida() +
//		            " puntos de vida.");
//
//		    if (!objetivo.estaVivo()) {
//		        System.out.println(
//		                objetivo.getNombre() +
//		                " ha sido eliminado.");
//		    }

		secuenciaAtaques.add(atacante);

		hechizosLanzados.computeIfAbsent(atacante, k -> new ArrayList<>()).add(hechizo);

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
