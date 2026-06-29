package personaje;


public class PersonajeMock extends Personaje {

	// Usamos nivel de magia 0 para simplificar los calculos, y un 
	// ALUMNO como personaje "generico" para las pruebas de hechizos
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
