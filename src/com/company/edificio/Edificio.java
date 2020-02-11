package com.company.edificio;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor(10);
        List<Persona> personas = new ArrayList<>();

        for (int i = 0; i <20 ; i++) {
            Persona persona = new Persona("P"+i, ascensor);
            personas.add(persona);
        }

    }
}
