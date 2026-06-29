package Estados;

import personaje.Personaje;

public abstract class EstadoPersonaje {

	Personaje personaje;

	public EstadoPersonaje(Personaje pj) {
		personaje = pj;
	}

	public abstract String morir();

	public abstract String enfurecerse();
}
