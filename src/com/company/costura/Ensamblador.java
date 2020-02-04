package com.company.costura;

public class Ensamblador extends Thread {
    Cistell cistellCossos;
    Cistell cistellManigues;
    String tipoCostura;
    String nombre;

    public Ensamblador(Cistell cistellCossos, Cistell cistellManigues, String tipoCostura) {
        this.cistellCossos = cistellCossos;
        this.cistellManigues = cistellManigues;
        this.tipoCostura = tipoCostura;
        setNombre("Ensamblador");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (;;){
            cistellCossos.agafar();
            cistellManigues.agafar();
            cistellManigues.agafar();
            System.out.println(getNombre() + " agafa manigues y cos de la cesta");
            System.out.println("  |  COSOS: " + cistellCossos.getCont() + " MANIGUES: " + cistellManigues.getCont());
            try {
                Thread.sleep ((int) ((Math.random()*3000)+3000));
            }catch (InterruptedException e){ e.printStackTrace();}

            System.out.println(getNombre() + " acaba de hacer el jersey");

            try {
                Thread.sleep ((int) ((Math.random()*200)+200));
            }catch (InterruptedException e){ e.printStackTrace();}
        }
    }
}
