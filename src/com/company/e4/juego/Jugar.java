package com.company.e4.juego;

import com.company.e4.Cargol;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Jugar {

    public static void main(String[] args) {
        Jugador jugador = new Jugador("andres");
        Jugador jugador2 = new Jugador("jacky chan");

        AlimentarPuntsJugador alimentarPuntsJugador = new AlimentarPuntsJugador(jugador);
        AlimentarPuntsJugador alimentarPuntsJugador2 = new AlimentarPuntsJugador(jugador2);

        MonitorizarPuntsJugador monitorizarPuntsJugador = new MonitorizarPuntsJugador(jugador);
        MonitorizarPuntsJugador monitorizarPuntsJugador2 = new MonitorizarPuntsJugador(jugador2);

        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);

        schExService.scheduleWithFixedDelay(alimentarPuntsJugador, 2, 3, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(alimentarPuntsJugador2, 2, 3, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(monitorizarPuntsJugador, 3, 5, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(monitorizarPuntsJugador2, 3, 5, TimeUnit.SECONDS);

        // Esperem a que passin els 25s o bé a que acabin tots
        try {
            schExService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schExService.shutdownNow();

        System.out.println("\nTotal "+ jugador.getNom() + ":" + jugador.getPuntos());
        System.out.println("Total "+ jugador2.getNom() + ":" + jugador2.getPuntos());
    }
}
