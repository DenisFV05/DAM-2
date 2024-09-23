package com.deures;

import java.lang.reflect.Constructor;

public class Objecte {
    private static Objecte instance; 
    private String nom;
    private String cognom;
    private int edat;

    private Objecte(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public static Objecte getInstance(String nom, String cognom, int edat) {
        if (instance == null) {
            instance = new Objecte(nom, cognom, edat);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Nom: " + this.nom + ", Cognom: " + this.cognom + ", Edat: " + this.edat;
    }

    public static Objecte getNewDestroyedInstance(String nom, String cognom, int edat) {
        try {
            Constructor<Objecte> constructor = Objecte.class.getDeclaredConstructor(String.class, String.class, int.class);
            constructor.setAccessible(true); 
            return constructor.newInstance(nom, cognom, edat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
