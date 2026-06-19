package personaje.mortifago;

import hechizos.TipoHechizo;
import personaje.Personaje;
import personaje.TipoPersonaje;

public abstract class Mortifagos extends Personaje {

	public Mortifagos(TipoPersonaje tipo, int nivelMagia, int vidaMax, int manaMax, int manaAct, int dañoAtaque, int defenza) {
		super(tipo, nivelMagia, vidaMax, manaMax, manaAct, dañoAtaque, defenza);
		setPasiva(TipoHechizo.ATAQUE);
		
		
	}

	@Override
	public int calcularEfecto(String tipo, int dañoBase) {
		return (int)(dañoBase * modificadorMagia());
	}

	
	public abstract String getEtiqueta();
	@Override
	public double modificadorMagia() {
		return 1;
	}

}
