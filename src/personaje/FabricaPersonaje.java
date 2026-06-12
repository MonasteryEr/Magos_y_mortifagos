package personaje;

import personaje.mago.Alumno;
import personaje.mago.Auror;
import personaje.mago.Maestro;
import personaje.mortifago.Comandante;
import personaje.mortifago.Seguidor;

public class FabricaPersonaje {

	public static Personaje crear(String tipo, String nombre, int nivel) {
		return switch (tipo) {
		case "auror" -> new Auror(nombre, nivel);
		case "alumno" -> new Alumno(nombre, nivel);
		case "maestro" -> new Maestro(nombre, nivel);
		case "comandante" -> new Comandante(nombre, nivel);
		case "seguidor" -> new Seguidor(nombre, nivel);
		default -> throw new IllegalArgumentException(tipo);
		};
	}

}
