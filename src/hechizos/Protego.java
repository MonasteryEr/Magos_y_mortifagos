package hechizos;

import personaje.Personaje;

public class Protego implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		//objetivo.setDefenza(lanzador.getManaAct());
		
		lanzador.setDefenza(lanzador.calcularEfecto("DEFENSA", 20));
	}
	
	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.DEFENSA;
	}
	
	@Override
	public String getNombre() {
		
		return "Protego";
	}

}
