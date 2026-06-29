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
	public int calcularEfecto(String tipo, int cantidadBase) {
		cantidadBase *= modificadorMagia();
		
		return switch (tipo) {
			case "ATAQUE" -> (int) (cantidadBase * 1.35);
			case "CURACION" -> (int) (cantidadBase * 1.25);
			case "DEFENSA" -> cantidadBase;
			default -> cantidadBase;
		};
	}

}
