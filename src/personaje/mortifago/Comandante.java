package personaje.mortifago;

import hechizos.AvadaKedabra;
import personaje.TipoPersonaje;

public class Comandante extends Mortifagos {

	public Comandante(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new AvadaKedabra());
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

}