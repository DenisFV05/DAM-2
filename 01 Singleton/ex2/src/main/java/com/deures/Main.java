package com.deures;

public class Main {
    public static void main(String[] args) {
        try {
            // primera instància
            Objecte obj1 = Objecte.getNewDestroyedInstance("Denis", "Fernández", 20);
            System.out.println("Instància 1: " + obj1);
            Thread.sleep(3000);
            // segona instància
            Objecte obj2 = Objecte.getNewDestroyedInstance("David", "Bargados", 18);
            System.out.println("Instància 2: " + obj2);
            Thread.sleep(3000);
            // tercera instància
            Objecte obj3 = Objecte.getNewDestroyedInstance("Adri", "Martínez", 27);
            System.out.println("Instància 3: " + obj3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
