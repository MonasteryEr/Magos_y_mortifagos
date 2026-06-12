package personaje.mortifago;

import hechizos.Expelliarmus;
import hechizos.Protego;

public class Seguidor extends Mortifagos {

	private static final int VIDA_POR_NIVEL = 60;
	
	public Seguidor(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		aprenderHechizo(new Protego());
		aprenderHechizo(new Expelliarmus());
		setPuntosVida(nivelMagia * VIDA_POR_NIVEL);
	}

	@Override
	public double modificadorMagia() {
		return 0;
	}

}