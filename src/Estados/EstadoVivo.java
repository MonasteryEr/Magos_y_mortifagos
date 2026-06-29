package Estados;

import personaje.Personaje;

public class EstadoVivo extends EstadoPersonaje {

	public EstadoVivo(Personaje pj) {
		super(pj);
		
	}

	@Override
	public String morir() {
		personaje.cambiarEstado(new EstadoMuerto(personaje));
		return personaje.getEtiqueta() + " pasa a estado Muerto";
	}

	@Override
	public String enfurecerse() {
		personaje.cambiarEstado(new EstadoFurioso(personaje));
		return personaje.getEtiqueta() + " pasa a estado Furioso";
	}

}
