package personaje.mago;

import hechizos.TipoHechizo;
import personaje.Personaje;

public abstract class Mago extends Personaje {

	public Mago(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		setPasiva(TipoHechizo.CURACION);
	}
	
	

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		return 0;
	}

	@Override
	public double modificadorMagia() {
		return 0;
	};

}
