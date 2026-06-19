package personaje.mortifago;

import hechizos.AvadaKedabra;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Comandante extends Mortifagos {
	private static int contador = 1;
    private int numero;
	public Comandante(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new AvadaKedabra());
		aprenderHechizo(new Expelliarmus());
	    aprenderHechizo(new Protego());
	    this.numero = contador++;
	}
	
	    public String getEtiqueta() {
	        return "COMANDANTE " + numero;
	    }
	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 1.6;
	}

}