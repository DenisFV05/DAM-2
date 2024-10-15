package com.deures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Entregues {
    private ArrayList<Producte> productes;
    private PropertyChangeSupport support;

    public Entregues() {
        this.productes = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public ArrayList<Producte> getProductes() {
        return productes;
    }

    public void addProducte(Producte producte) {
        productes.add(producte);
        support.firePropertyChange("entreguesAdd", null, producte.getId());
        System.out.printf("S’ha afegit el producte amb id %d a la llista d'entregues%n", producte.getId());
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                Producte producte = productes.remove(i);
                support.firePropertyChange("entreguesRemove", producte.getId(), null);
                System.out.printf("S’ha entregat el producte amb id %d%n", producte.getId());
                return;
            }
        }
        System.out.println("Producte no trobat a la llista d'entregues.");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Productes a Entregues:\n");
        for (Producte producte : productes) {
            sb.append("- ").append(producte.getNom()).append(" (ID: ").append(producte.getId()).append(")\n");
        }
        return sb.toString();
    }
}


