package com.deures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Entregues {
    private ArrayList<Producte> productes;
    private final PropertyChangeSupport support;

    public Entregues() {
        this.productes = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    public ArrayList<Producte> getProductes() {
        return new ArrayList<>(productes);
    }

    public void addProducte(Producte producte) {
        productes.add(producte);
        support.firePropertyChange("entreguesAdd", null, producte);
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                Producte removedProducte = productes.remove(i);
                support.firePropertyChange("entreguesRemove", removedProducte, null);
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
        return "Entregues{" +
               "productes=" + productes +
               '}';
    }
}

