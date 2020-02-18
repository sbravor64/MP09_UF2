package com.company.edificio;


public class Motor extends Thread {
    Ascensor ascensor;
    Nivel nivel;
    enum Nivel{
        SUBIENDO,
        BAJANDO
    }

    public Motor(Ascensor ascensor) {
        nivel = Nivel.SUBIENDO;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        for(;;){
            switch (nivel){
                case SUBIENDO:
                    if(ascensor.numP <=ascensor.limitPiso){
                        if(ascensor.numP ==ascensor.limitPiso){nivel = Nivel.BAJANDO;}
                        else{
                            try { Thread.sleep(1000);
                            } catch (InterruptedException e) {e.printStackTrace();}
                            ascensor.numP++;
                            System.out.println("SUBIENDO AL " + ascensor.numP);
                        }
                        }
                    break;
                case BAJANDO:
                    if(ascensor.numP >= 0){
                        if(ascensor.numP ==0){nivel = Nivel.SUBIENDO;}
                        else{
                            try { Thread.sleep(1000);
                            } catch (InterruptedException e) {e.printStackTrace();}
                            ascensor.numP--;
                            System.out.println("BAJANDO AL " + ascensor.numP);
                        }
                    }
                    break;
            }
        }
    }
}
