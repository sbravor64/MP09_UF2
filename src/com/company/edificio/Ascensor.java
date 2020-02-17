package com.company.edificio;

public class Ascensor {
    int cont=0;
    int numPiso;
    int limit;

    public Ascensor(int limit) {
        this.limit = limit;
        numPiso = 0;
    }

    public int getCont() {
        return cont;
    }

    public synchronized void entrar(){
        try {
            while (cont==limit) wait();
            cont++;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void salir() {
        cont--;
        notifyAll();
    }
}
