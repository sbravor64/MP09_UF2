package com.company.costura;

public class Taller {

    public static void main(String[] args) {
        Cistell cistell_maniques = new Cistell(8);
        Cistell cistell_cossos = new Cistell(5);

        Cosidor cosidor_manigues = new Cosidor(cistell_maniques, "andres", "manigues");
        Cosidor cosidor_cossos = new Cosidor(cistell_cossos, "robert", "cos");

        Ensamblador ensamblador = new Ensamblador(cistell_cossos, cistell_maniques, "Peça");

        cosidor_manigues.start();
        cosidor_cossos.start();
        ensamblador.start();
    }
}
