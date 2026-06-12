package personaje.mortifago;

import hechizos.AvadaKedabra;

public class Comandante extends Mortifagos {

	private static final int VIDA_POR_NIVEL = 120;
	
	public Comandante(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		aprenderHechizo(new AvadaKedabra());
		setPuntosVida(nivelMagia * VIDA_POR_NIVEL);
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

}