package personaje.mortifago;

import java.util.List;

import hechizos.Hechizo;
import personaje.Personaje;

public class Mortifagos extends Personaje {

	public Mortifagos(String nombre, int vida, int mana, List<Hechizo> hechizos) {
		super(nombre, vida, mana);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getModificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
