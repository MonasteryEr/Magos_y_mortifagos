package personaje.mago;

import hechizos.TipoHechizo;
import personaje.Personaje;
import personaje.TipoPersonaje;

public abstract class Mago extends Personaje {

	public Mago(TipoPersonaje tipo, int nivelMagia, int vidaMax, int manaMax, int manaAct, int dañoAtaque,int defenza) {
		super(tipo, nivelMagia, vidaMax, manaMax, manaAct, dañoAtaque,defenza);
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
