package com.company.filosofus;

import java.util.ArrayList;
import java.util.List;

public class Filosof extends Thread {
    String nombre;
    Cuchara c1;
    Cuchara c2;

    public String getNombre() {
        return nombre;
    }

    public Filosof(String nombre, Cuchara c1, Cuchara c2) {
        this.c1 = c1;
        this.c2 = c2;
        this.nombre=nombre;
    }

    @Override
    public void run() {
        for (;;){
            c1.agafar();
            c2.agafar();
            System.out.println(getNombre() + " comiendo" + " con: " + c1.getNom() + " y " + c2.getNom());

            try {
                Thread.sleep ((int) ((Math.random()*3000)+3000));
            }catch (InterruptedException e){ e.printStackTrace();}

            c1.deixar();
            c2.deixar();

            System.out.println(getNombre() + " No comiendo");


            try {
                Thread.sleep ((int) ((Math.random()*1000)+1000));
            }catch (InterruptedException e){ e.printStackTrace();}
        }
    }
}

class comer{
    public static void main(String[] args) throws InterruptedException {

        Cuchara c1=new Cuchara("c1");
        Cuchara c2=new Cuchara("c2");
        Cuchara c3=new Cuchara("c3");
        Cuchara c4=new Cuchara("c4");

        Filosof f1 = new Filosof("filosof 1",c1,c2);
        Filosof f2 = new Filosof("filosof 2",c2,c3);
        Filosof f3 = new Filosof("filosof 3",c3, c4);
        Filosof f4 = new Filosof("filosof 4",c4,c1);

        List<Filosof> filosofs = new ArrayList<>();

        filosofs.add(f1);
        filosofs.add(f2);
        filosofs.add(f3);
        filosofs.add(f4);

        for (Filosof f: filosofs) {
            f.start();
        }

        for (Filosof f: filosofs) {
            f.join();
        }


    }
}
