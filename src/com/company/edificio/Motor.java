package com.company.edificio;


public class Motor extends Thread {
    Ascensor ascensor;

    public Motor(Ascensor ascensor) {
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        for(;;){
            if(ascensor.numPiso<ascensor.limitPiso){
                try {
                    Thread.sleep ((int) ((Math.random()*1000)+600));
                }catch (InterruptedException e){ e.printStackTrace();}
                ascensor.numPiso++;
                System.out.println("SUBIENDO " + ascensor.numPiso );

            } else {
                try {
                    Thread.sleep ((int) ((Math.random()*1000)+600));
                }catch (InterruptedException e){ e.printStackTrace();}
                System.out.println("BAJANDO " + ascensor.numPiso );
                ascensor.numPiso--;
            }
        }
    }
}
