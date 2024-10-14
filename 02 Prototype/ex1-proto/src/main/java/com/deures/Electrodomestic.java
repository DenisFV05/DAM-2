package com.deures;


// Classe base Electrodomestic
class Electrodomestic implements Cloneable {
    String nom;
    String color;
    double preu;
    String marca;
    String eficiencia;

    public Electrodomestic(String nom, String color, double preu, String marca, String eficiencia) {
        this.nom = nom;
        this.color = color;
        this.preu = preu;
        this.marca = marca;
        this.eficiencia = eficiencia;
    }

    // Mètode per clonar l'objecte
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Mètode per comparar les dades de dos objectes
    public boolean equals(Electrodomestic other) {
        return this.nom.equals(other.nom) &&
               this.color.equals(other.color) &&
               this.preu == other.preu &&
               this.marca.equals(other.marca) &&
               this.eficiencia.equals(other.eficiencia);
    }
}

// Subclasse Rentadora
class Rentadora extends Electrodomestic {
    int revolucions;
    int soroll;

    public Rentadora(String nom, String color, double preu, String marca, String eficiencia, int revolucions, int soroll) {
        super(nom, color, preu, marca, eficiencia);
        this.revolucions = revolucions;
        this.soroll = soroll;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Rentadora other) {
        return super.equals(other) &&
               this.revolucions == other.revolucions &&
               this.soroll == other.soroll;
    }
}

// Subclasse Nevera
class Nevera extends Electrodomestic {
    int frigories;
    int soroll;

    public Nevera(String nom, String color, double preu, String marca, String eficiencia, int frigories, int soroll) {
        super(nom, color, preu, marca, eficiencia);
        this.frigories = frigories;
        this.soroll = soroll;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Nevera other) {
        return super.equals(other) &&
               this.frigories == other.frigories &&
               this.soroll == other.soroll;
    }
}

// Subclasse Forn
class Forn extends Electrodomestic {
    int temperatura;
    boolean autoneteja;

    public Forn(String nom, String color, double preu, String marca, String eficiencia, int temperatura, boolean autoneteja) {
        super(nom, color, preu, marca, eficiencia);
        this.temperatura = temperatura;
        this.autoneteja = autoneteja;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Forn other) {
        return super.equals(other) &&
               this.temperatura == other.temperatura &&
               this.autoneteja == other.autoneteja;
    }
}
