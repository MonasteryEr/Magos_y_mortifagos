package Main;

import batallon.Batallon;
import java.util.Random;

import personaje.FabricaPersonaje;
import personaje.Personaje;
import personaje.TipoPersonaje;

public class Main {

	public static void main(String[] args) {

		Batallon batallonMagos = new Batallon();

		Batallon batallonMortifagos = new Batallon();

		/*
		 * for (int i = 0; i < 3; i++) { batallonMagos.agregarMagoAleatorio(5);
		 * batallonMortifagos.agregarMortifagoAleatorio(5); }
		 */
		batallonMagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.AUROR, 5));
		batallonMagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.ALUMNO, 5));
		batallonMagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.MAESTRO, 5));
		batallonMagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.MAESTRO, 5));
//		batallonMortifagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.SEGUIDOR, 5));
//		batallonMortifagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.SEGUIDOR, 5));
		batallonMortifagos.agregarPersonaje(FabricaPersonaje.crear(TipoPersonaje.COMANDANTE, 5));

		Random rand = new Random();

//		System.out.println("Magos:");

		for (Personaje p : batallonMagos.getPersonajes()) {
			
		}

//		System.out.println("Mortifagos:");

		for (Personaje p : batallonMortifagos.getPersonajes()) {
//			System.out.println(p.getEtiqueta() + " Vida: " + p.getPuntosVida());
		}

		while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {

			if (rand.nextBoolean()) {

				batallonMagos.atacar(batallonMortifagos);

				if (batallonMortifagos.tienePersonajesSaludables()) {

					batallonMortifagos.atacar(batallonMagos);

				}

			} else {

				batallonMortifagos.atacar(batallonMagos);

				if (batallonMagos.tienePersonajesSaludables()) {

					batallonMagos.atacar(batallonMortifagos);

				}

			}

			System.out.println("----------------------------");

		}

		if (batallonMagos.tienePersonajesSaludables()) {

			System.out.println("¡Los magos han ganado la batalla!");

		} else {

			System.out.println("¡Los mortífagos han ganado la batalla!");

		}

	}

}
