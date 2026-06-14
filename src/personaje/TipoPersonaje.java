package personaje;

public enum TipoPersonaje {
	AUROR(-40, -10, -50, -20), ALUMNO(-40, -10, -40, 0), COMANDANTE(20, 10, 0, 20), MAESTRO(-30, 0, 0, -20),
	SEGUIDOR(-40, -10, -40, -10);

	private final int modVida;
	private final int modDanio;
	private final int modMana;
	private final int manaInicial;

	TipoPersonaje(int modVida, int modDanio, int modMana, int manaInicial) {
		this.modVida = modVida;
		this.modDanio = modDanio;
		this.modMana = modMana;
		this.manaInicial = manaInicial;
	}

	public int getModVida() {
		return modVida;
	}

	public int getModDanio() {
		return modDanio;
	}

	public int getModMana() {
		return modMana;
	}

	public int getManaInicial() {
		return manaInicial;
	}

}
