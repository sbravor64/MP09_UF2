package com.company.costura;

public class Cosidor extends Thread {
    Cistell c;
    String nombre;
    String tipo;

    public Cosidor(Cistell c, String nombre, String tipo) {
        this.c = c;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void run() {
        for (;;){
            System.out.println(getNombre() + " está haciendo " + getTipo());
            try {
                Thread.sleep ((int) ((Math.random()*1000)+1000));
            }catch (InterruptedException e){ e.printStackTrace();}

            c.deixar();
            System.out.println(getNombre() + " deja " + getTipo() + " en el cistell");
            System.out.print( "  |  " + getTipo() + ": " + c.getCont() + "\n");

            try {
                Thread.sleep ((int) ((Math.random()*200)+200));
            }catch (InterruptedException e){ e.printStackTrace();}
        }
    }
}
