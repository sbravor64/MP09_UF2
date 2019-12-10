package com.company.e4.juego;

public class MonitorizarPuntsJugador implements Runnable {
    private Jugador jugador;

    public MonitorizarPuntsJugador(Jugador j) {
        jugador = j;
    }

    @Override
    public void run() {
        System.out.println(jugador.getNom()  + " acumula " + jugador.getPuntos() + " puntos");
    }
}
