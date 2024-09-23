package com.deures;

public class Main {

    public static void main(String[] args) {
        try {
            Objecte obj = Objecte.getInstance();

            obj.setDades("Denis", "Fernández", 55);
            System.out.println("Primera instància: " + obj);

            Thread.sleep(3000);

            obj.setDades("David", "Bargados", 2);
            System.out.println("Segona instància: " + obj);

            Thread.sleep(3000);

            obj.setDades("Adri", "Martínez", 80);
            System.out.println("Tercera instància: " + obj);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
