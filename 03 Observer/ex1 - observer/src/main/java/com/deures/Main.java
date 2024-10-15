package com.deures;

public class Main {
    public static void main(String[] args) {
        // Creació de productes
        Producte p0 = new Producte(0, "Llibre");
        Producte p1 = new Producte(1, "Boli");
        Producte p2 = new Producte(2, "Rotulador");
        Producte p3 = new Producte(3, "Carpeta");
        Producte p4 = new Producte(4, "Motxilla");

        // Creació de magatzem i entregues
        Magatzem magatzem = new Magatzem();
        Entregues entregues = new Entregues();

        // Afegir listeners (aquí podrías implementar los listeners necesarios si quieres)
        // Ejemplo: magatzem.addPropertyChangeListener(listener);

        // Modificacions als productes
        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");

        // Afegir productes al magatzem
        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        // Esborrar productes del magatzem
        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        // Entregar productes
        entregues.addProducte(p0);
        entregues.removeProducte(2); // Producte 2 no existeix, no farà res
        entregues.removeProducte(3); // Producte 3 no existeix, no farà res

        // Mostrar productes del magatzem i entregues
        System.out.println(magatzem);
        System.out.println(entregues);
    }
}
