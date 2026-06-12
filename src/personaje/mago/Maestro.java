package personaje.mago;

import hechizos.AvadaKedabra;
import hechizos.Expelliarmus;
import hechizos.Protego;


public class Maestro extends Mago{
	private static final int VIDA_POR_NIVEL = 75;

	public Maestro(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new AvadaKedabra());
		aprenderHechizo(new Protego());
		setPuntosVida(nivelMagia * VIDA_POR_NIVEL);
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
