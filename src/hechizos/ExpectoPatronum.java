package hechizos;

import personaje.Personaje;

public class ExpectoPatronum implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.curar(lanzador.getManaAct());
	}

	@Override
	public String getNombre() {
		return "Especto Patronum";
	}

	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.CURACION;
	}

}
