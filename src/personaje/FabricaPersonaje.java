package personaje;

import personaje.mago.Alumno;
import personaje.mago.Auror;
import personaje.mago.Maestro;
import personaje.mortifago.Comandante;
import personaje.mortifago.Seguidor;

public class FabricaPersonaje {

	public static Personaje crear(TipoPersonaje nombre, int nivel) {
		nivel *= 10;
		return switch (nombre) {
		case AUROR -> new Auror(nombre, nivel);
		case ALUMNO -> new Alumno(nombre, nivel);
		case MAESTRO -> new Maestro(nombre, nivel);
		case COMANDANTE -> new Comandante(nombre, nivel);
		case SEGUIDOR -> new Seguidor(nombre, nivel);
		};
	}

}
