package personaje;

import hechizos.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HechizoTest {

    private PersonajeMock lanzador;
    private PersonajeMock objetivo;

    // Este metodo se ejecuta antes de cada test
    @BeforeEach
    void setUp() {
        lanzador = new PersonajeMock(); // vida=90, daño=22, defensa=0
        objetivo = new PersonajeMock();
    }
    

    // AvadaKedabra 
    @Test
    @DisplayName("AvadaKedabra reduce la vida del objetivo al 80%")
    void avadaKedabra_reduceVidaAlOchentaPorciento() {
        new AvadaKedabra().ejecutar(lanzador, objetivo);
        assertEquals(72, objetivo.getPuntosVida()); // 90 * 0.8 = 72
    }

    @Test
    @DisplayName("AvadaKedabra no afecta al lanzador")
    void avadaKedabra_noAfectaLanzador() {
        new AvadaKedabra().ejecutar(lanzador, objetivo);
        assertEquals(90, lanzador.getPuntosVida());
    }

    @Test
    @DisplayName("AvadaKedabra es de tipo DEFINITIVA")
    void avadaKedabra_esTipoDefinitiva() {
        assertEquals(TipoHechizo.DEFINITIVA, new AvadaKedabra().getTipo());
    }
    

    // ExpectoPatronum 
    @Test
    @DisplayName("ExpectoPatronum cura al lanzador")
    void expectoPatronum_curaAlLanzador() {
        lanzador.setVidaAct(50);
        new ExpectoPatronum().ejecutar(lanzador, objetivo);
        assertEquals(80, lanzador.getPuntosVida()); // 50 + 30 = 80
    }

    @Test
    @DisplayName("ExpectoPatronum no supera la vida maxima")
    void expectoPatronum_noSuperaVidaMaxima() {
        new ExpectoPatronum().ejecutar(lanzador, objetivo);
        assertEquals(90, lanzador.getPuntosVida()); // ya tiene vida full
    }

    @Test
    @DisplayName("ExpectoPatronum no afecta al objetivo")
    void expectoPatronum_noAfectaObjetivo() {
        new ExpectoPatronum().ejecutar(lanzador, objetivo);
        assertEquals(90, objetivo.getPuntosVida());
    }

    @Test
    @DisplayName("ExpectoPatronum es de tipo CURACION")
    void expectoPatronum_esTipoCuracion() {
        assertEquals(TipoHechizo.CURACION, new ExpectoPatronum().getTipo());
    }
    

    // Expelliarmus 
    @Test
    @DisplayName("Expelliarmus reduce la vida del objetivo segun el daño del lanzador")
    void expelliarmus_reduceVidaObjetivo() {
        new Expelliarmus().ejecutar(lanzador, objetivo);
        assertEquals(68, objetivo.getPuntosVida()); // 90 - 22 = 68
    }

    @Test
    @DisplayName("Expelliarmus no afecta al lanzador")
    void expelliarmus_noAfectaLanzador() {
        new Expelliarmus().ejecutar(lanzador, objetivo);
        assertEquals(90, lanzador.getPuntosVida());
    }

    @Test
    @DisplayName("Expelliarmus es de tipo ATAQUE")
    void expelliarmus_esTipoAtaque() {
        assertEquals(TipoHechizo.ATAQUE, new Expelliarmus().getTipo());
    }
    

    // Protego 
    @Test
    @DisplayName("Protego sube la defensa del lanzador a 20")
    void protego_subeDefensaLanzador() {
        new Protego().ejecutar(lanzador, objetivo);
        assertEquals(20, lanzador.getDefenza()); // calcularEfecto devuelve 20 base
    }

    @Test
    @DisplayName("Protego no afecta la vida del objetivo")
    void protego_noAfectaObjetivo() {
        new Protego().ejecutar(lanzador, objetivo);
        assertEquals(90, objetivo.getPuntosVida());
    }

    @Test
    @DisplayName("Protego es de tipo DEFENSA")
    void protego_esTipoDefensa() {
        assertEquals(TipoHechizo.DEFENSA, new Protego().getTipo());
    }

    // Nombres 

    @Test
    @DisplayName("Cada hechizo devuelve el nombre correcto")
    void hechizos_devuelvenNombresCorrecto() {
        assertEquals("Avada Kedabra", new AvadaKedabra().getNombre());
        assertEquals("Espectro Patronum", new ExpectoPatronum().getNombre());
        assertEquals("Expelliarmus", new Expelliarmus().getNombre());
        assertEquals("Protego", new Protego().getNombre());
    }
}
