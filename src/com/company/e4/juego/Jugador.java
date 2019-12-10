package com.company.e4.juego;

public class Jugador {
    private String Nom;
    private int puntos;

    public Jugador(String nom) {
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
