package Estados;

import personaje.Personaje;

public class EstadoFurioso extends EstadoPersonaje {

	public EstadoFurioso(Personaje personaje) {
		super(personaje);
		personaje.setVidaAct(personaje.getVidaMax());
	}


	@Override
	public String morir() {
		personaje.cambiarEstado(new EstadoMuerto(personaje));
		return personaje.getEtiqueta() + " pasa a estado Muerto";
	}

	@Override
	public String enfurecerse() {
		return personaje.getEtiqueta() + " Ya esta furioso.";
	}

}
