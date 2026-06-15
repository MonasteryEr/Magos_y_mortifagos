package hechizos;

import personaje.Personaje;

public class Expelliarmus implements  Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirDanio(lanzador.getDañoAtaque());
	}

	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.ATAQUE;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
	}

}
