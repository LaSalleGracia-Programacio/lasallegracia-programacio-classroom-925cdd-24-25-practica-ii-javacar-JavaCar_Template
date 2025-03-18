package org.JavaCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvingut a CarManager");
    }

    public class sistemaLogin{
        static String[][] usuaris = new String[100][2];
        static int numUsuaris = 0;
        Scanner input = new Scanner(System.in);

        public static void registrarUsuari(){
            Scanner input = new Scanner(System.in);
            System.out.println("Introdueix un nom d'usuari: ");
            String nomUsuari = input.nextLine();
            System.out.println("Introdueix una contrasenya: ");
            String contrasenya = input.nextLine();

        }
    }
}