package personaje.mortifago;

import hechizos.TipoHechizo;
import personaje.Personaje;
import personaje.TipoPersonaje;

public class Mortifagos extends Personaje {

	public Mortifagos(TipoPersonaje tipo, int nivelMagia, int vidaMax, int manaMax, int manaAct, int dañoAtaque) {
		super(tipo, nivelMagia, vidaMax, manaMax, manaAct, dañoAtaque);
		setPasiva(TipoHechizo.ATAQUE);
	}

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		return 0;
	}

	@Override
	public double modificadorMagia() {
		return 0;
	}

}
