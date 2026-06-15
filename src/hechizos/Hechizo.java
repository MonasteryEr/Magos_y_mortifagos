package hechizos;

import personaje.Personaje;

public interface Hechizo {
	
	public void ejecutar(Personaje lanzador, Personaje objetivo);
	String getNombre();
	TipoHechizo getTipo();
}
