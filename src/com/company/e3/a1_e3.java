package com.company.e3;

import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a1_e3 {
    public static class Client {
        private String Nom;
        private List<Integer> carret;

        public Client(String nom, List<Integer> carret) {
            this.carret = carret;
            Nom = nom;
            this.carret = carret;
        }

        public String getNom() {
            return Nom;
        }

        public void setNom(String nom) {
            Nom = nom;
        }

        public List<Integer> getCarret() {
            return carret;
        }

        public void setCarret(List<Integer> carret) {
            this.carret = carret;
        }
    }

    public static class Caixa implements Runnable {

        private int id;
        private Client client;
        private int suma;

        public Caixa(int n) {
            id = n;
            suma = 0;
        }

        public void setClient(Client c) {
            client = c;
        }

        public int getSuma() {
            return suma;
        }

        @Override
        public void run() {
            System.out.println("Caixa " + id + " : " + client.getNom());

            client.getCarret().forEach(p -> suma += p);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        Client c1 = new Client("pep", Arrays.asList(1,2,3,4,20,30));
        Client c2 = new Client("anna", Arrays.asList(1,2,3,4));

        Caixa caixa1 = new Caixa(1);
        Caixa caixa2 = new Caixa(2);

        caixa1.setClient(c1);
        caixa2.setClient(c2);

        executor.execute(caixa1);
        executor.execute(caixa2);
        executor.shutdown();
        try {
            executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("suma caixa1: " + caixa1.getSuma());
        System.out.println("suma caixa2: " + caixa2.getSuma());
    }
}
