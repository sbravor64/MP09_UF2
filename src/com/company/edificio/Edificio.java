package com.company.edificio;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
    public static void main(String[] args) {

        Ascensor ascensor = new Ascensor(10);

        Motor motor = new Motor(ascensor);
        List<Persona> personas = new ArrayList<>();

        Persona andres = new Persona("Andres", ascensor, 5);
        Persona roberto = new Persona("Roberto", ascensor, 2);
        Persona rodrigo = new Persona("Rodrigo", ascensor, 4);
        Persona jesus = new Persona("Jesus", ascensor, 3);
        Persona marco = new Persona("Marco", ascensor, 1);

        personas.add(andres);
        personas.add(roberto);
        personas.add(rodrigo);
        personas.add(jesus);
        personas.add(marco);

        motor.start();

        for (Persona p: personas) {
            p.start();
        }
    }
}
