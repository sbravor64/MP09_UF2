package com.company.e4.juego;

public class AlimentarPuntsJugador implements Runnable {
    Jugador jugador;

    public AlimentarPuntsJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void addPuntos(int m) {
        jugador.setPuntos(jugador.getPuntos()+m);
    }

    @Override
    public void run() {
        int sprint = (int) Math.floor(Math.random()*10);
        addPuntos(sprint);
        System.out.println(jugador.getNom() + " ha fet " + sprint +" puntos");
    }
}
