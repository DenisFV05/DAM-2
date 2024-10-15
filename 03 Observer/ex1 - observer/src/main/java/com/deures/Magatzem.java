package com.deures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Magatzem {
    private ArrayList<Producte> productes;
    private int capacitat;
    private PropertyChangeSupport support;

    public Magatzem() {
        this.productes = new ArrayList<>();
        this.capacitat = 10; // Capacidad inicial
        this.support = new PropertyChangeSupport(this);
    }

    public ArrayList<Producte> getProductes() {
        return productes;
    }

    public void addProducte(Producte producte) {
        if (productes.size() < capacitat) {
            productes.add(producte);
            support.firePropertyChange("magatzemAdd", null, producte.getId());
            System.out.printf("S’ha afegit el producte amb id %d al magatzem, capacitat: %d%n",
                    producte.getId(), capacitat - productes.size());
        } else {
            System.out.println("Magatzem ple, no es pot afegir el producte.");
        }
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                Producte producte = productes.remove(i);
                support.firePropertyChange("magatzemRemove", producte.getId(), null);
                System.out.printf("S’ha esborrat el producte amb id %d del magatzem, capacitat: %d%n",
                        producte.getId(), capacitat - productes.size());
                return;
            }
        }
        System.out.println("Producte no trobat al magatzem.");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Productes al Magatzem:\n");
        for (Producte producte : productes) {
            sb.append("- ").append(producte.getNom()).append(" (ID: ").append(producte.getId()).append(")\n");
        }
        return sb.toString();
    }
}
