package com.company.e1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class AlumneCallable implements Callable<Integer> {

    String nom;
    private int nota;

    public AlumneCallable(String nom) {
        this.nom = nom;
    }

    @Override
    public Integer call() throws Exception {
        nota = (int)(Math.random()*10);
        return nota;
    }

    public int nota(){
        nota = (int)(Math.random()*10);
        return nota;
    }

    public String getNom() {
        return nom;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        List<AlumneCallable> llistaAlumne= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AlumneCallable alumneP = new AlumneCallable("alumne " + i);
            alumneP.nota();
            llistaAlumne.add(alumneP);
        }

        List <Future<Integer>> llistaResultats;
        llistaResultats = executor.invokeAll(llistaAlumne);

        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println("Resultat nota del "+llistaAlumne.get(i).getNom()+ " és: " + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
            }
        }

        System.out.println("--------SECUENCIAL---------");
        for (int i = 0; i <llistaAlumne.size() ; i++) {
            int resultat = llistaAlumne.get(i).nota();
            System.out.println("Resultat nota del "+llistaAlumne.get(i).getNom()+ " és: " + resultat);
        }


    }

}
