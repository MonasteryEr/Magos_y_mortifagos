package personaje;

import java.util.List;

import hechizos.Hechizo;

public class Mortifagos extends Personaje {

	public Mortifagos(String nombre, int vida, int mana, List<Hechizo> hechizos) {
		super(nombre, vida, mana, hechizos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
