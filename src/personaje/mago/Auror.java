package personaje.mago;

import hechizos.Expelliarmus;
import personaje.TipoPersonaje;

public class Auror extends Mago {

	public Auror(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Expelliarmus());
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
