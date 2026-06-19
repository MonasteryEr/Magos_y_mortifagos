package hechizos;

import personaje.Personaje;

public class ExpectoPatronum implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		//objetivo.curar(lanzador.getManaAct());
		int cura = lanzador.calcularEfecto("CURACION",30); 
		lanzador.curar(cura);
		
	}

	@Override
	public String getNombre() {
		return "Espectro Patronum";
	}

	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.CURACION;
	}

}
