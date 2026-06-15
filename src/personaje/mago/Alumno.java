package personaje.mago;

import hechizos.Protego;
import personaje.TipoPersonaje;

public class Alumno extends Mago {

	public Alumno(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Protego());
	}

	@Override
	public double modificadorMagia() {
		return 0;
	}

}