package personaje.mago;

import java.util.List;

import hechizos.Hechizo;
import personaje.Personaje;

public abstract class Mago extends Personaje{
	
	/*
	public Mago(String nombre, int vida, int mana, List<Hechizo> hechizos) {
		super(nombre, vida, mana, hechizos);
		// TODO Auto-generated constructor stub
	}
*/
	public Mago(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
	}

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		
		return 0;
	}

	@Override
	public double getModificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	};

}
