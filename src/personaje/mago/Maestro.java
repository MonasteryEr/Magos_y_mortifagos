package personaje.mago;

import hechizos.AvadaKedabra;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Maestro extends Mago {

	public Maestro(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new AvadaKedabra());
		aprenderHechizo(new Protego());
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

}
