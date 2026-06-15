package hechizos;

import personaje.Personaje;

public class AvadaKedabra implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.setVidaAct(0);
	}

	@Override
	public TipoHechizo getTipo() {
		return TipoHechizo.DEFINITIVA;
	}

	@Override
	public String getNombre() {
		return "Avada Kedabra";
	}
	
	

}
