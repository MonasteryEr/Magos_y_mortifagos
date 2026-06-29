package personaje.mortifago;

import Estados.EstadoFurioso;
import Estados.EstadoVivo;
import hechizos.AvadaKedabra;
import hechizos.Expelliarmus;
import hechizos.Protego;
import personaje.TipoPersonaje;

public class Comandante extends Mortifagos {
	public Comandante(TipoPersonaje tipo, int nivelMagia) {
		super(tipo, nivelMagia, tipo.getModVida(), tipo.getModDanio(), tipo.getModMana(), tipo.getManaInicial(), 0);
		aprenderHechizo(new AvadaKedabra());
		aprenderHechizo(new Expelliarmus());
		aprenderHechizo(new Protego());
	}

	@Override
	public double modificadorMagia() {
		// TODO Auto-generated method stub
		return 1.6;
	}
	
	public void setVidaAct(int puntosVida) {
		if(puntosVida <= 0 && getEstado() instanceof EstadoVivo) {
			System.out.println(getEstado().enfurecerse());
		}else if( puntosVida <= 0 && getEstado() instanceof EstadoFurioso) {
			System.out.println(getEstado().morir());
			super.setVidaAct(0);
			
		}
		else
			super.setVidaAct(puntosVida);
	}
	

}