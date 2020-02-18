package com.company.edificio;

public class Persona extends Thread {
    String nom;
    Ascensor ascensor;
    int numPisoEntrada;
    int numPisoSalida;

    public Persona(String nom, Ascensor ascensor, int numPisoEntrada, int numPisoSalida) {
        this.nom = nom;
        this.ascensor = ascensor;
        this.numPisoEntrada = numPisoEntrada;
        this.numPisoSalida = numPisoSalida;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for(;;){
//            try { Thread.sleep ((int) ((Math.random()*1000)+600));
//            }catch (InterruptedException e){ e.printStackTrace();}

            try { Thread.sleep(3000);
            } catch (InterruptedException e) {e.printStackTrace();}

            ascensor.entrar(numPisoEntrada);
            System.out.println(getNom() + " acaba de entrar al ascensor | " +  "Nº PISO: "+ ascensor.numP + " | Nº Personas: " + ascensor.getCont());

            ascensor.salir(numPisoSalida);
            System.out.println(getNom() + " acaba de salir del ascensor | " + "Nº: "+ ascensor.numP + " | Nº Personas: " + ascensor.getCont());
        }
    }
}
