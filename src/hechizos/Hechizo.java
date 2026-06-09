package hechizos;

import personaje.Personaje;

public interface Hechizo {
	
	public void ejecutar(Personaje lanzador, Personaje objetico);
	String getNombre();
	TipoHechizo getTipo();
}
