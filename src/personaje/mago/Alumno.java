package personaje.mago;

import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Alumno extends Mago {
	private static int contador = 1;
    private int numero;
	public Alumno(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new Protego());
		aprenderHechizo(new ExpectoPatronum());
		this.numero = contador++;
	}
	
	public String getEtiqueta(){
		
		return "ALUMNO " + numero;
	}
	
	@Override
	public double modificadorMagia() {
		return 1;
	}

}