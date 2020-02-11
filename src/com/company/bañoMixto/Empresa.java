package com.company.bañoMixto;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    public static void main(String[] args) {

        Baño baño = new Baño(5);

        Trabajador trabajador1 = new Trabajador("andres", baño, "H");
        Trabajador trabajador = new Trabajador("andrea", baño, "M");
        Trabajador trabajador2= new Trabajador("angela", baño, "M");
        Trabajador trabajador3= new Trabajador("alexa", baño, "M");
        Trabajador trabajador4= new Trabajador("patrik", baño, "H");
        Trabajador trabajador5= new Trabajador("adriana", baño, "M");
        Trabajador trabajador6= new Trabajador("messi", baño, "H");
        Trabajador trabajador7= new Trabajador("carlos", baño, "H");
        Trabajador trabajador8= new Trabajador("mely", baño, "M");
        Trabajador trabajador9= new Trabajador("marco", baño, "H");
        Trabajador trabajador10= new Trabajador("alejandro", baño, "H");
        Trabajador trabajador11= new Trabajador("profe", baño, "H");


        List<Trabajador> trabajadors = new ArrayList<>();
        trabajadors.add(trabajador1);
        trabajadors.add(trabajador);
        trabajadors.add(trabajador2);
        trabajadors.add(trabajador3);
        trabajadors.add(trabajador4);
        trabajadors.add(trabajador5);
        trabajadors.add(trabajador6);
        trabajadors.add(trabajador7);
        trabajadors.add(trabajador8);
        trabajadors.add(trabajador9);
        trabajadors.add(trabajador10);
        trabajadors.add(trabajador11);

        for (Trabajador t: trabajadors) {
            t.start();
        }

    }
}
