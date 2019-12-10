package com.company.e4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CursadeCargols {
    public static void main(String[] args) {
        Cargol treubanya = new Cargol("Treubanya");
        Cargol bover = new Cargol("Bover");

        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        schExService.scheduleWithFixedDelay(treubanya, 2, 1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(bover, 4, 4, TimeUnit.SECONDS);

        // Esperem a que passin els 25s o bé a que acabin tots
        try {
            schExService.awaitTermination(25, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schExService.shutdownNow();

        System.out.println("\nTotal "+ treubanya.getNom() + ":" + treubanya.getMetres());
        System.out.println("Total "+ bover.getNom() + ":" + bover.getMetres());
    }
}
