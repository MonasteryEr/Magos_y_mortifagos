package personaje.mago;

import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Alumno extends Mago {

	public Alumno(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(), tipo.getManaInicial(), 0);
		
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new Protego());
		aprenderHechizo(new ExpectoPatronum());
	}

	@Override
	public double modificadorMagia() {
		return 1.25;
	}

}