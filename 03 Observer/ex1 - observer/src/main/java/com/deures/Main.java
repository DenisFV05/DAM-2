package com.deures;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {
    public static void main(String[] args) {
        // Creació dels productes
        Producte p0 = new Producte(0, "Llibre");
        Producte p1 = new Producte(1, "Boli");
        Producte p2 = new Producte(2, "Rotulador");
        Producte p3 = new Producte(3, "Carpeta");
        Producte p4 = new Producte(4, "Motxilla");

        // Creació del magatzem i entregues
        Magatzem magatzem = new Magatzem();
        Entregues entregues = new Entregues();

        // Afegir listeners
        PropertyChangeListener producteListener = evt -> {
            System.out.println("Producte ha canviat el/la " + evt.getPropertyName() + " de '" + evt.getOldValue() + "' a '" + evt.getNewValue() + "'");
        };

        PropertyChangeListener magatzemListener = evt -> {
            if ("magatzemAdd".equals(evt.getPropertyName())) {
                System.out.println("S'ha afegit el producte amb id " + ((Producte) evt.getNewValue()).getId() + " al magatzem, capacitat: " + magatzem.getProductes().size());
            } else if ("magatzemRemove".equals(evt.getPropertyName())) {
                System.out.println("S'ha esborrat el producte amb id " + ((Producte) evt.getOldValue()).getId() + " del magatzem, capacitat: " + magatzem.getProductes().size());
                entregues.addProducte((Producte) evt.getOldValue());
            }
        };

        PropertyChangeListener entreguesListener = evt -> {
            if ("entreguesAdd".equals(evt.getPropertyName())) {
                System.out.println("S'ha afegit el producte amb id " + ((Producte) evt.getNewValue()).getId() + " a la llista d'entregues");
            } else if ("entreguesRemove".equals(evt.getPropertyName())) {
                System.out.println("S'ha entregat el producte amb id " + ((Producte) evt.getOldValue()).getId());
            }
        };

        // Afegir els listeners als objectes
        p0.addPropertyChangeListener(producteListener);
        p1.addPropertyChangeListener(producteListener);
        p2.addPropertyChangeListener(producteListener);
        p3.addPropertyChangeListener(producteListener);
        p4.addPropertyChangeListener(producteListener);
        magatzem.addPropertyChangeListener(magatzemListener);
        entregues.addPropertyChangeListener(entreguesListener);

        // Modificar els productes
        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli nou");

        // Afegir productes al magatzem
        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        // Eliminar productes del magatzem
        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        // Eliminar productes de les entregues
        entregues.removeProducte(2);
        entregues.removeProducte(3);

        // Imprimir les llistes
        System.out.println(magatzem);
        System.out.println(entregues);
    }
}
