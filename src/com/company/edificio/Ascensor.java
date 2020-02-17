package com.company.edificio;

public class Ascensor {
    int cont=0;
    int numPiso;
    int limitPerson=4;
    int limitPiso;

    public Ascensor(int limitPiso) {
        this.limitPiso = limitPiso;
        numPiso = 0;
    }

    public int getCont() {
        return cont;
    }

    public synchronized void entrar(){
        try {
            while (cont== limitPerson) wait();
            cont++;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void salir(int numPiso, boolean c) {
        if(this.numPiso==numPiso){
            cont--;
            c=true;
        }else {
            c=false;
        }
        notifyAll();
    }
}
