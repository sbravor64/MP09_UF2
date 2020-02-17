package com.company.edificio;

public class Persona extends Thread {
    String nom;
    Ascensor ascensor;
    int numPiso;

    public Persona(String nom, Ascensor ascensor, int numPiso) {
        this.nom = nom;
        this.ascensor = ascensor;
        this.numPiso= numPiso;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        ascensor.entrar();
        System.out.println(getNom() + " acaba de entrar al ascensor | " +  "Nº: "+ ascensor.getCont());
        try {
            Thread.sleep ((int) ((Math.random()*1000)+600));
        }catch (InterruptedException e){ e.printStackTrace();}

        System.out.println(getNom() + " acaba de salir del ascensor | " + "Nº: "+ ascensor.getCont());
        try {
            Thread.sleep ((int) ((Math.random()*3000)+600));
        }catch (InterruptedException e){ e.printStackTrace();}

        ascensor.salir();
    }
}
