package personaje.mortifago;

import hechizos.TipoHechizo;
import personaje.Personaje;

public class Mortifagos extends Personaje {

	public Mortifagos(String nombre, int vida) {
		super(nombre, vida);
		setPasiva(TipoHechizo.ATAQUE);
	}

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
