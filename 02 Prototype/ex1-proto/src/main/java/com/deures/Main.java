package com.deures;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Crear llista original d'electrodomèstics
        List<Electrodomestic> electrodomestics = new ArrayList<>();
        
        // Afegir dues rentadores
        electrodomestics.add(new Rentadora("Rentadora A", "Blanc", 300.0, "MarcaX", "A++", 1200, 50));
        electrodomestics.add(new Rentadora("Rentadora B", "Gris", 350.0, "MarcaY", "A+", 1400, 55));
        
        // Afegir dues neveres
        electrodomestics.add(new Nevera("Nevera A", "Negre", 500.0, "MarcaZ", "A++", 300, 40));
        electrodomestics.add(new Nevera("Nevera B", "Blanc", 450.0, "MarcaW", "A+", 250, 45));
        
        // Afegir dos forns
        electrodomestics.add(new Forn("Forn A", "Blanc", 200.0, "MarcaT", "B", 250, true));
        electrodomestics.add(new Forn("Forn B", "Inox", 250.0, "MarcaS", "A", 300, false));

        // Crear la llista de clones
        List<Electrodomestic> clones = new ArrayList<>();
        for (Electrodomestic e : electrodomestics) {
            clones.add((Electrodomestic) e.clone());
        }

        // Comparar la llista original amb ella mateixa
        System.out.println("Comparant la llista original amb ella mateixa:");
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic original = electrodomestics.get(i);
            System.out.println("Objecte " + i + ": mateix objecte? " + (original == original));
            System.out.println("Objecte " + i + ": mateixa classe? " + (original.getClass() == original.getClass()));
            System.out.println("Objecte " + i + ": iguals dades? " + original.equals(original));
        }

        // Comparar la llista original amb la dels clones
        System.out.println("\nComparant la llista original amb la dels clones:");
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic original = electrodomestics.get(i);
            Electrodomestic clon = clones.get(i);
            System.out.println("Objecte " + i + ": objectes diferents? " + (original != clon));
            System.out.println("Objecte " + i + ": mateixa classe? " + (original.getClass() == clon.getClass()));
            System.out.println("Objecte " + i + ": iguals dades? " + original.equals(clon));
        }
    }
}
