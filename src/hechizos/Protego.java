package hechizos;

import personaje.Personaje;

public class Protego implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.setDefenza(lanzador.getManaAct());
	}

	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.DEFENSA;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
	}

}
