package personaje;

import hechizos.Hechizo;
import java.util.List;
import java.util.ArrayList;
/*
public abstract class Personaje {
	private String nombre;
	private int vida;
	private int mana;
	private List<Hechizo> hechizos; 

	public Personaje(String nombre, int vida, int mana, List<Hechizo> hechizos) {
		this.nombre = nombre;
		this.vida = vida;
		this.mana = mana;
		this.hechizos = new ArrayList<>(hechizos);
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {};
	
	public abstract int calcularEfecto(String tipo, int dañoBase);
}*/

public abstract class Personaje {

    private String nombre;
    private int nivelMagia;
    private int puntosVida;
    private List<Hechizo> hechizos;

    public Personaje(String nombre, int nivelMagia, int puntosVida) {
        this.nombre = nombre;
        this.nivelMagia = nivelMagia;
        this.puntosVida = puntosVida;
        this.hechizos = new ArrayList<>();
    }

    // =====================
    // Getters
    // =====================

    public String getNombre() {
        return nombre;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public List<Hechizo> getHechizos() {
        return new ArrayList<>(hechizos);
    }

    // =====================
    // Gestión de hechizos
    // =====================

    public void aprenderHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
    }

    public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
        if (!estaVivo()) {
            throw new IllegalStateException(
                nombre + " está eliminado y no puede lanzar hechizos."
            );
        }

        hechizo.ejecutar(this, objetivo);
    }

    // =====================
    // Vida
    // =====================

    public void recibirDanio(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(
                "El daño no puede ser negativo."
            );
        }

        puntosVida -= cantidad;

        if (puntosVida < 0) {
            puntosVida = 0;
        }
    }

    public void curar(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(
                "La curación no puede ser negativa."
            );
        }

        puntosVida += cantidad;
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    // =====================
    // Polimorfismo
    // =====================

    /**
     * Permite que cada tipo de personaje
     * modifique la potencia de sus hechizos.
     */
    public abstract double getModificadorMagia();

}
