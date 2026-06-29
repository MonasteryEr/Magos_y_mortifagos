package personaje;


public class PersonajeMock extends Personaje {

    public PersonajeMock() {
        super(TipoPersonaje.ALUMNO, 0, -10, -8, -10, -5, 0);
    }

    @Override
    public double modificadorMagia() {
        return 1.0;
    }

    @Override
    public int calcularEfecto(String tipo, int cantidadBase) {
        return cantidadBase;
    }
}
