package com.company.e2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PaletaRunnable implements Runnable {

    private String Nom;
    private int maons=2;

    public PaletaRunnable(String nom) {
        Nom = nom;
    }

    @Override
    public void run() {
        //Temps que triga a col·locar els maons entre 1 i 4 segons per cada maó
        System.out.println(Nom + " posant maons...");
        try {
            Thread.sleep((long) ((Math.random()*300)+100)*maons );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Nom + " ha acabat.");
    }

    public String getNom() {
        return Nom;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<PaletaRunnable> PList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            PaletaRunnable P = new PaletaRunnable("Paleta " + i);
            PList.add(P);
            executor.execute(P);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
