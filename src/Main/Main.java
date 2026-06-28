package Main;

import batallon.Batallon;
import java.util.Random;
import personaje.Personaje;

import java.util.Random;

public class Main {

    // Colores ANSI
    static final String RESET  = "\u001B[0m";
    static final String BOLD   = "\u001B[1m";
    static final String BLUE   = "\u001B[34m";
    static final String CYAN   = "\u001B[36m";
    static final String RED    = "\u001B[31m";
    static final String YELLOW = "\u001B[33m";
    static final String GREEN  = "\u001B[32m";

    public static void main(String[] args) {

        Batallon batallonMagos = new Batallon();
        Batallon batallonMortifagos = new Batallon();

        for (int i = 0; i < 3; i++) {
            batallonMagos.agregarMagoAleatorio(5);
            batallonMortifagos.agregarMortifagoAleatorio(5);
        }

        Random rand = new Random();

        // Mostrar equipos iniciales
        titulo("✦  MAGOS  ✦", BLUE);
        for (Personaje p : batallonMagos.getPersonajes()) {
            mostrarPersonaje(p, BLUE);
        }

        System.out.println();

        titulo("☠  MORTÍFAGOS  ☠", RED);
        for (Personaje p : batallonMortifagos.getPersonajes()) {
            mostrarPersonaje(p, RED);
        }

        System.out.println();

        // Batalla
        int ronda = 1;
        while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {

            separador(ronda);

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

            // Estado después de la ronda
            System.out.println();
            System.out.println(BLUE + BOLD + "  Magos:" + RESET);
            for (Personaje p : batallonMagos.getPersonajes()) {
                mostrarPersonaje(p, BLUE);
            }
            
            System.out.println(RED + BOLD + "  Mortífagos:" + RESET);
            for (Personaje p : batallonMortifagos.getPersonajes()) {
                mostrarPersonaje(p, RED);
            }

            ronda++;
        }

        System.out.println();

        // Resultado final
        if (batallonMagos.tienePersonajesSaludables()) {
        	
            titulo("✦  ¡VICTORIA PARA LOS MAGOS!  ✦", GREEN);
            
        } else {
        	
            titulo("☠  ¡VICTORIA PARA LOS MORTÍFAGOS!  ☠", RED);
            
        }
    }

    // Métodos auxiliares para formatear salida por pantalla

    static void titulo(String texto, String color) {
        int ancho = 42;
        String linea = "═".repeat(ancho);
        int espacios = (ancho - texto.length()) / 2;
        int espaciosDer = ancho - texto.length() - espacios;
        System.out.println(color + BOLD
            + "╔" + linea + "╗\n"
            + "║" + " ".repeat(espacios) + texto + " ".repeat(espaciosDer) + "║\n"
            + "╚" + linea + "╝" + RESET);
    }

    static void separador(int ronda) {
        String texto = "  ⚔  ──── RONDA " + ronda + " ────  ⚔  ";
        System.out.println("\n" + YELLOW + BOLD + texto + RESET);
    }

    static void barraDeVida(int vida, int vidaMax) {
        int total = 20;
        int bloques = (vidaMax > 0) ? (int) ((vida / (double) vidaMax) * total) : 0;
        bloques = Math.max(0, Math.min(bloques, total));

        String color;
        if (bloques > 13)       color = GREEN;
        else if (bloques > 6)   color = YELLOW;
        else                    color = RED;

        String barra = "█".repeat(bloques) + "░".repeat(total - bloques);
        System.out.print(color + "[" + barra + "] " + vida + "/" + vidaMax + RESET);
    }

    static void mostrarPersonaje(Personaje p, String colorNombre) {
        int vidaMax = p.getVidaMax();
        System.out.print("  " + colorNombre + BOLD + p.getEtiqueta() + RESET + "  Vida: ");
        barraDeVida(p.getPuntosVida(), vidaMax);
        System.out.println();
    }
}
