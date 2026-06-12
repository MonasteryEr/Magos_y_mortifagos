package personaje.mago;

import hechizos.Protego;
import hechizos.TipoHechizo;

public class Alumno extends Mago{

	private static final int VIDA_POR_NIVEL = 60;
	
	public Alumno(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		aprenderHechizo(new Protego());
		setPuntosVida(nivelMagia * VIDA_POR_NIVEL);
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPasiva(TipoHechizo pasiva) {
		// VER
		
	}

}