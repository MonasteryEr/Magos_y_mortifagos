package personaje.mortifago;

import hechizos.AvadaKedabra;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Comandante extends Mortifagos {
	
	public Comandante(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(), tipo.getManaInicial(), 0);
		
		aprenderHechizo(new AvadaKedabra());
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new Protego());
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 1.6;
	}

}