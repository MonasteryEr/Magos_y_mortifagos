package personaje;

public enum TipoPersonaje {
	//MAGOS
	ALUMNO(-10, -8, -10, -5), 
	MAESTRO(0, 5, -5, 5),
	AUROR(15, 13, 0, 10), 
	//MORTIFAGOS
	SEGUIDOR(-10, -8, -10, -5),
	COMANDANTE(20, 10, 0, 13);

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
