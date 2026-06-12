package personaje;

import personaje.mago.Auror;

public class FabricaPersonaje {

	public static Personaje crear(String tipo, String nombre, int nivel) {
		return switch (tipo) {
		case "auror" -> new Auror(nombre, nivel);
		default -> throw new IllegalArgumentException(tipo);
		};
	}

}
