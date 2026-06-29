package personaje;

import java.util.Random;
import personaje.mago.Alumno;
import personaje.mago.Auror;
import personaje.mago.Maestro;
import personaje.mortifago.Comandante;
import personaje.mortifago.Seguidor;

public class FabricaPersonaje {
	private static Random rand = new Random();

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

	public static Personaje crearMagoAleatorio(int nivel) {

		TipoPersonaje[] magos = { TipoPersonaje.AUROR, TipoPersonaje.ALUMNO, TipoPersonaje.MAESTRO };

		return crear(magos[rand.nextInt(magos.length)], nivel);
	}

	public static Personaje crearMortifagoAleatorio(int nivel) {

		TipoPersonaje[] mortifagos = { TipoPersonaje.SEGUIDOR, TipoPersonaje.COMANDANTE };

		return crear(mortifagos[rand.nextInt(mortifagos.length)], nivel);
	}

}
