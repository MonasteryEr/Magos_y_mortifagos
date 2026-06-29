package Estados;

import personaje.Personaje;

public class EstadoMuerto extends EstadoPersonaje {

	public EstadoMuerto(Personaje personaje) {
		super(personaje);
	}

	@Override
	public String morir() {
		return  personaje.getEtiqueta() + " Ya esta muerto, no puede volver a morir";
	}

	@Override
	public String enfurecerse() {
		return  personaje.getEtiqueta() + " Ya esta muerto, no puede volver a enfurecerse";
	}

}
