package com.deures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Magatzem {
    private ArrayList<Producte> productes;
    private int capacitat;
    private final PropertyChangeSupport support;

    public Magatzem() {
        this.productes = new ArrayList<>();
        this.capacitat = 10; // Capacitat inicial
        support = new PropertyChangeSupport(this);
    }

    public ArrayList<Producte> getProductes() {
        return new ArrayList<>(productes);
    }

    public void addProducte(Producte producte) {
        productes.add(producte);
        capacitat--;
        support.firePropertyChange("magatzemAdd", null, producte);
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                Producte removedProducte = productes.remove(i);
                capacitat++;
                support.firePropertyChange("magatzemRemove", removedProducte, null);
                return;
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Magatzem{" +
               "productes=" + productes +
               ", capacitat=" + capacitat +
               '}';
    }
}

