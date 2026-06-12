package personaje.mago;

import java.util.List;

import hechizos.Expelliarmus;
import hechizos.Hechizo;

public class Auror extends Mago {

	private final int VIDA_INICIAL = 100;
	private List<Hechizo> hechizosPropios;
	
	public Auror(String nombre, int nivelMagia) {
		super(nombre, nivelMagia);
		super.setPuntosVida(nivelMagia * VIDA_INICIAL);
		hechizosPropios.add(new Expelliarmus());
		setHechizos(hechizosPropios);
	}

}
