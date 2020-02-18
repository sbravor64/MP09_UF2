package com.company.edificio;

public class Ascensor {
    int cont=0;
    int numP=0;
    int limitPerson=5;
    int limitPiso;

    public Ascensor(int limitPiso) {
        this.limitPiso = limitPiso;
    }

    public int getCont() {
        return cont;
    }

    public synchronized void entrar(int numPiso){
        try {
            while (numP != numPiso){
                wait();
            }
            cont++;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void salir(int numPiso) {
        try {
            while (numP !=numPiso) wait();
            cont--;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        notifyAll();
    }
}
