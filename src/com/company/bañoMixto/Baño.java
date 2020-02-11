package com.company.bañoMixto;

public class Baño {
    int cont=0;
    int limit;
    String sexo;

    public Baño(int limit) {
        this.limit = limit;
    }

    public synchronized int getCont() {
        return cont;
    }

    public synchronized String getSexo() {
        return sexo;
    }

    public synchronized void entrar(String sexo){
        if(cont == 0){
            this.sexo = sexo;
        }
            try {
                while (cont == limit || !getSexo().equals(sexo)) wait();
                cont++;
                notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }

    public synchronized void salir() {
        cont--;
        notifyAll();
        if(cont == 0){
            if(getSexo().equals("H")){
                this.sexo = "M";
            } else{
                this.sexo = "H";
            }
        }
    }
}
