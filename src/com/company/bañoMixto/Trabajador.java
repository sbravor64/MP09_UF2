package com.company.bañoMixto;

public class Trabajador extends Thread {
    String nom;
    Baño baño;
    String sexo;

    public Trabajador(String nom, Baño baño, String sexo) {
        this.nom = nom;
        this.baño = baño;
        this.sexo = sexo;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for (;;){
            baño.entrar(sexo);
            System.out.println(getNom() + " acaba de entrar al baño | " +  "Nº: "+ baño.getCont());
            try {
                Thread.sleep ((int) ((Math.random()*1000)+600));
            }catch (InterruptedException e){ e.printStackTrace();}

            baño.salir();
            System.out.println(getNom() + " acaba de salir al baño | " + "Nº: "+ baño.getCont());
            try {
                Thread.sleep ((int) ((Math.random()*3000)+600));
            }catch (InterruptedException e){ e.printStackTrace();}
        }
    }
}
