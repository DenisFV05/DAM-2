package com.deures;

public class Objecte {

    private String nom;
    private String cognom;
    private int edat;

    private static Objecte instance;

    private Objecte() {
    }

    public static Objecte getInstance() {
        if (instance == null) {
            instance = new Objecte();
        }
        return instance;
    }

    public void setDades(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Objecte [nom=" + nom + ", cognom=" + cognom + ", edat=" + edat + "]";
    }
}

