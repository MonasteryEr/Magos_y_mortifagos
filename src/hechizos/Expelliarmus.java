package hechizos;

import personaje.Personaje;

public class Expelliarmus implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		
		//objetivo.recibirDanio(lanzador.getDañoAtaque());
		int daño = lanzador.calcularEfecto("ATAQUE", lanzador.getDañoAtaque());
		objetivo.recibirDanio(daño);
	}

	@Override
	public String getNombre() {
		
		return "Expelliarmus";
	}
	
	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.ATAQUE;
	}

}
