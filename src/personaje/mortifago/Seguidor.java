package personaje.mortifago;

import hechizos.AvadaKedabra;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Seguidor extends Mortifagos {
	   private static int contador = 1;
	    private int numero;
	public Seguidor(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		
		aprenderHechizo(new Protego());
		aprenderHechizo(new AvadaKedabra());
		aprenderHechizo(new Expelliarmus());// me parece que van hechizos oscuros.
		
		this.numero = contador++;
		
	} 
	public String getEtiqueta() {
        return "SEGUIDOR " + numero;
    }
	@Override
	public double modificadorMagia() {
		return 1.35;
	}

}