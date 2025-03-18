package org.JavaCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvingut a CarManager");
        Scanner input = new Scanner(System.in);
    }

    public class sistemaLogin{
        static String[][] usuaris = new String[100][2];
        static int numUsuaris = 0;

        public static void registrarUsuari(){
            Scanner input = new Scanner(System.in);
            System.out.println("Introdueix un nom d'usuari: ");
            String nomUsuari = input.nextLine();
            System.out.println("Introdueix una contrasenya: ");
            String contrasenya = input.nextLine();

            usuaris[numUsuaris][0] = nomUsuari;
            usuaris[numUsuaris][1] = contrasenya;
            numUsuaris++;
        }
        public static boolean login(){
            Scanner input = new Scanner(System.in);
            System.out.println("Introdueix el nom d'usuari: ");
            String nomUsuari = input.nextLine();
            System.out.println("Introdueix la contrasenya: ");
            String contrasenya = input.nextLine();

            for (int i = 0; i < usuaris.length; i++) {
                //en el cas que l'usuari coincideixi (retornem true)
                if (usuaris[i][0].equals(nomUsuari) && usuaris[i][1].equals(contrasenya)) {
                    return true;
                }
            }
                //en el cas que l'usuari no coincideixi (retornem false)
            System.out.println("L'Usuari o la contrasenya no coincideixen");
            return false;
        }
    }

}