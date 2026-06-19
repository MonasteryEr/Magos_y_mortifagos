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
		return (int)(dañoBase * modificadorMagia());
	}
	
	public abstract String getEtiqueta();
	
	@Override
	public double modificadorMagia() {
		return 1; // Solo para probar los enfrentamientos el return 1 hay que ver como seria el tema de los modificadores
	};

}
