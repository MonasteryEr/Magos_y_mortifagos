package personaje.mago;

import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Maestro extends Mago {
private static int contador = 1;
private int numero;
	public Maestro(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new ExpectoPatronum());
		//aprenderHechizo(new AvadaKedabra()); //Es un hechizo oscuro me parece que lo usan los mortigagos.
		aprenderHechizo(new Protego());
		this.numero = contador++;
	}
	public String getEtiqueta() {
        return "MAESTRO " + numero;
    }
	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 1;
	}

}
