package com.company.filosofus;

public class Cuchara {
    boolean lliure;
    private String nom;

    public Cuchara(String nom) {
        this.nom = nom;
        lliure=true;
    }

    synchronized String getNom(){
        return nom;
    }

    public synchronized void agafar(){
        try {
            while (!lliure) wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        lliure=false;
        notifyAll();
    }

    public synchronized void deixar() {
        lliure=true;
        notifyAll();
    }
}
