package personaje;

import java.util.Random;
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
	private int numero;

	private Set<Hechizo> hechizosUsadosEnRonda;

	private static int contador = 1;

	public Personaje(TipoPersonaje tipo, int nivelMagia, int modVida, int modDanio, int modMana, int manaInicial,
			int defensa) {

		this.tipo = tipo;
		this.nivelMagia = nivelMagia;

		this.vidaMax = nivelMagia + VIDA_MAX_POR_NIVEL + modVida;
		this.vidaAct = vidaMax;

		this.manaMax = nivelMagia + MANA_MAX_POR_NIVEL + modMana;
		this.manaAct = nivelMagia + MANA_INI_POR_NIVEL + manaInicial;

		this.dañoAtaque = nivelMagia + DAÑO_POR_NIVEL + modDanio;

		this.defenza = defensa;

		hechizos = new HashSet<>();
		hechizosUsadosEnRonda = new HashSet<>();

		this.numero = contador++;

	}

//	//public Personaje(TipoPersonaje tipo, int nivelMagia, int vidaMax, int manaMax, int manaAct, int dañoAtaque, int defenza) {
//		this.tipo = tipo;
//		this.nivelMagia = nivelMagia;
//		this.vidaAct = vidaMax;
//		this.vidaMax = vidaMax;
//		
//		hechizos = new HashSet<>();
//		hechizosUsadosEnRonda = new HashSet<>();
//	}

	public void estadisticasIniciales(TipoPersonaje nombre) {
		System.out.println("Vida Maxima: " + getVidaMax() + "Mana Maximo: " + getManaMax() + "Mana Inicial: "
				+ getManaAct() + "Daño: " + getDañoAtaque());
	}

	// SETTERS
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

	// GETTERS
	public int getDañoAtaque() {
		return dañoAtaque;
	}

	public TipoPersonaje getTipo() {
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

	public String getEtiqueta() {

		return getTipo() + "" + numero;
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
		if (defenza >= cantidad) {
			cantidad = 0;
		} else {
			cantidad -= defenza;
		}
		vidaAct -= cantidad;
		if (vidaAct < 0) {
			vidaAct = 0;
		}
	}

	public void curar(int cantidad) {

		if (cantidad < 0) {
			throw new IllegalArgumentException("La curación no debe ser negativa.");
		}

		vidaAct += cantidad;

		if (vidaAct > vidaMax) {
			vidaAct = vidaMax; // No exceder mi limite de vida.
		}
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
	public abstract double modificadorMagia();

	public abstract int calcularEfecto(String tipo, int cantidadBase);

	public int getDefenza() {
		return defenza;
	}

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

	public Hechizo obtenerHechizoDisponible() {
		List<Hechizo> disponibles = new ArrayList<>();
		for (Hechizo h : hechizos) {
			if (!hechizosUsadosEnRonda.contains(h)) {
				disponibles.add(h);
			}
		}
		if (disponibles.isEmpty()) {
			hechizosUsadosEnRonda.clear();
			disponibles.addAll(hechizos);
		}
		Random rand = new Random();
		Hechizo elegido = disponibles.get(rand.nextInt(disponibles.size()));
		hechizosUsadosEnRonda.add(elegido);
		return elegido;
	}

}
