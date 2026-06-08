package personaje;

import hechizos.Hechizo;

public abstract class Personaje {
	private String nombre;
	private int vida;
	private int mana;
	private List<Hechizo> hechizos; 
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {};
	
	public abstract int calcularEfecto(String tipo, int dañoBase);
}
