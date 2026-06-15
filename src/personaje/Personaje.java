package personaje;

import hechizos.Hechizo;
import hechizos.TipoHechizo;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
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
	
}*/

public abstract class Personaje {
	protected static final int VIDA_MAX_POR_NIVEL = 100;
	protected static final int DAÑO_POR_NIVEL = 30;
	protected static final int MANA_INI_POR_NIVEL = 30;
	protected static final int MANA_MAX_POR_NIVEL = 100;

	private TipoPersonaje tipo;
	private int nivelMagia;
	private int vidaAct;
	private int vidaMax;
	private int manaMax;
	private int manaAct;
	private int dañoAtaque;
	private int defenza;
	private TipoHechizo pasiva;
	private Set<Hechizo> hechizos;

	public Personaje(TipoPersonaje tipo, int nivelMagia, int vidaMax, int manaMax, int manaAct, int dañoAtaque, int defenza) {
		this.tipo = tipo;
		this.nivelMagia = nivelMagia;

		hechizos = new HashSet<>();
	}

	public void estadisticasIniciales(TipoPersonaje nombre) {
		System.out.println("Vida Maxima: " + getVidaMax() + "Mana Maximo: " + getManaMax() + "Mana Inicial: "
				+ getManaAct() + "Daño: " + getDañoAtaque());
	}

	public void setVidaAct(int puntosVida) {
		this.vidaAct = puntosVida;
	}

	public void setPasiva(TipoHechizo pasiva) {
		this.pasiva = pasiva;
	}

	public void setHechizos(Set<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}
	
	public void setDefenza(int defenza) {
		this.defenza = defenza;
	}

	public int getDañoAtaque() {
		return dañoAtaque;
	}

	public TipoPersonaje getNombre() {
		return tipo;
	}

	public int getNivelMagia() {
		return nivelMagia;
	}

	public int getPuntosVida() {
		return vidaAct;
	}

	public List<Hechizo> getHechizos() {
		return new ArrayList<>(hechizos);
	}

	public TipoHechizo getPasiva() {
		return pasiva;
	}

	public void aprenderHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}

	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		if (!estaVivo()) {
			throw new IllegalStateException(tipo + " está eliminado y no puede lanzar hechizos.");
		}
		hechizo.ejecutar(this, objetivo);
	}

	public void recibirDanio(int cantidad) {
		if (cantidad < 0) {
			throw new IllegalArgumentException("El daño no puede ser negativo.");
		}
		if(defenza >= cantidad) {
			cantidad = 0;
		}else {
			cantidad-= defenza;
		}
		vidaAct -= cantidad;
		if (vidaAct < 0) {
			vidaAct = 0;
		}
	}

	public void curar(int cantidad) {
		if (cantidad < 0) {
			throw new IllegalArgumentException("La curación no puede ser negativa.");
		}
		vidaAct += cantidad;
	}

	public boolean estaVivo() {
		return vidaAct > 0;
	}

	// =====================
	// Polimorfismo
	// =====================

	/**
	 * Permite que cada tipo de personaje modifique la potencia de sus hechizos.
	 */
	public abstract double modificadorMagia(); // dañoAtaque * dañoHechizo / 60

	public abstract int calcularEfecto(String tipo, int dañoBase);

	public int getManaMax() {
		return manaMax;
	}

	public int getManaAct() {
		return manaAct;
	}

	public void setManaAct(int manaAct) {
		this.manaAct = manaAct;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setManaIni(int cantidad) {
		this.manaAct = nivelMagia + MANA_INI_POR_NIVEL + cantidad;
	}

	public void setManaMax(int cantidad) {
		this.manaMax = nivelMagia + MANA_MAX_POR_NIVEL + cantidad;
	}

	public void setVidaMax(int cantidad) {
		vidaMax = nivelMagia + VIDA_MAX_POR_NIVEL - cantidad;
		vidaAct = vidaMax;
	}

	public void setDañoAtaque(int cantidad) {
		dañoAtaque = nivelMagia + DAÑO_POR_NIVEL + cantidad;
	}

}
