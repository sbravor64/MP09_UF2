package com.company.costura;

public class Cistell {
    int numMax;
    int cont=0;
    String nom;

    public Cistell(int numMax) {
        this.numMax = numMax;
    }

    public synchronized int getCont() {
        return cont;
    }

    public synchronized void agafar(){
        try {
            while (cont == 0) wait();
            cont--;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void deixar() {

        try {
            while (cont == numMax) wait();
            cont++;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
