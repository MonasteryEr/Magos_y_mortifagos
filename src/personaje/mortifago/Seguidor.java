package personaje.mortifago;

import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Seguidor extends Mortifagos {

	public Seguidor(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Protego());
		aprenderHechizo(new Expelliarmus());
	}

	@Override
	public double modificadorMagia() {
		return 0;
	}

}