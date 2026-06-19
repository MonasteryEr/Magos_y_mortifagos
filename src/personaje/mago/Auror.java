package personaje.mago;
import hechizos.Protego;
import hechizos.Expelliarmus;
import personaje.TipoPersonaje;
import hechizos.ExpectoPatronum;
public class Auror extends Mago {
	private static int contador = 1;
    private int numero;
	public Auror(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(),
				tipo.getManaInicial(),0);
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new Protego());
		aprenderHechizo(new ExpectoPatronum());
		
		this.numero = contador++;
	}
	public String getEtiqueta() {
        return "AUROR " + numero;
    }
	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 1.6;
	}

}
