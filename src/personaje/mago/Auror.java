package personaje.mago;

import java.util.Set;

import hechizos.Expelliarmus;

public class Auror extends Mago {

	private static final int VIDA_POR_NIVEL = 100;

	public Auror(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		aprenderHechizo(new Expelliarmus());
		setPuntosVida(nivelMagia * VIDA_POR_NIVEL);
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
