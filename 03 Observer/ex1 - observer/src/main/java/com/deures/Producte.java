package com.deures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Producte {
    private int id;
    private String nom;
    private PropertyChangeSupport support;

    public Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.support = new PropertyChangeSupport(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        support.firePropertyChange("producteId", oldId, id);
        System.out.printf("Producte ha canviat l'id de %d a %d%n", oldId, id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        support.firePropertyChange("producteName", oldNom, nom);
        System.out.printf("Producte ha canviat el nom de '%s' a '%s'%n", oldNom, nom);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}


