package com.company.e4;

public class Cargol implements Runnable {
    private String Nom;
    private int metres;

    public Cargol(String nom) {
        Nom = nom;
    }

    public void addMetres(int m) {
        metres += m;
    }

    public String getNom() {
        return Nom;
    }

    public int getMetres() {
        return metres;
    }

    @Override
    public void run() {
        int sprint = (int) Math.floor(Math.random()*100);
        addMetres(sprint);
        System.out.println(Nom + ": he fet " + sprint +" metres");
    }
}
