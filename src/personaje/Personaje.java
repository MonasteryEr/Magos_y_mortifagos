package personaje;

import hechizos.Hechizo;
import java.util.List;

public abstract class Personaje {
	private String nombre;
	private int vida;
	private int mana;
	private List<Hechizo> hechizos; 
	
	
	
	public Personaje(String nombre, int vida, int mana, List<Hechizo> hechizos) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.mana = mana;
		this.hechizos = hechizos;
	}

	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {};
	
	public abstract int calcularEfecto(String tipo, int dañoBase);
}
