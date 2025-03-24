package org.JavaCar;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvingut a CarManager");
        mostrarMenu1();
    }

    public static void mostrarMenu1() {
        Scanner input = new Scanner(System.in);
        int opcio;

        while (true) {
            System.out.println("Selecciona una opció:");
            System.out.println("(1) Iniciar Sessió");
            System.out.println("(2) Registrar-me");
            System.out.println("(3) Sortir");
            System.out.print("Opció: ");

            opcio = input.nextInt();
            input.nextLine(); // Consumir el salt de línia

            switch (opcio) {
                case 1:
                    if (SistemaLogin.login()){
                        menuGestioCoches();
                    }
                    break;
                case 2:
                    SistemaLogin.registrarUsuari();
                    break;
                case 3:
                    System.out.println("Chao Pescao...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opció no vàlida, intenta de nou.");
            }
        }
    }

    public static void menuGestioCoches() {
        Scanner input = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("--- Menú de Gestió de Cotxes ---");
            System.out.println("(1) Afegir cotxe");
            System.out.println("(2) Llogar cotxe");
            System.out.println("(3) Veure cotxes disponibles");
            System.out.println("(4) Tancar Sessió");
            System.out.print("Opció: ");

            opcion = input.nextInt();
            input.nextLine(); // Consumir el salt de línia

            switch (opcion) {
                case 1:
                    GestorCoches.afegirCotxe();
                    break;
                case 2:
                    GestorCoches.llogarCotxe();
                    break;
                case 3:
                    GestorCoches.mostrarCotxesDisponibles();
                    break;
                case 4:
                    System.out.println("Sessió tancada.");
                    return; // Tornar al menú principal
                default:
                    System.out.println("Opció no vàlida, intenta de nou.");
            }
        }
    }
}

// Definició de la classe SistemaLogin
class SistemaLogin {
    static String[][] usuaris = new String[100][2];
    static int numUsuaris = 0;

    public static void registrarUsuari() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix un nom d'usuari: ");
        String nomUsuari = input.nextLine();
        System.out.println("Introdueix una contrasenya: ");
        String contrasenya = input.nextLine();

        usuaris[numUsuaris][0] = nomUsuari;
        usuaris[numUsuaris][1] = contrasenya;
        numUsuaris++;

        System.out.println("Usuari registrat correctament!");
    }

    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix el nom d'usuari: ");
        String nomUsuari = input.nextLine();
        System.out.println("Introdueix la contrasenya: ");
        String contrasenya = input.nextLine();

        for (int i = 0; i < numUsuaris; i++) {
            if (usuaris[i][0] != null && usuaris[i][1] != null &&
                    usuaris[i][0].equals(nomUsuari) && usuaris[i][1].equals(contrasenya)) {
                System.out.println("Usuari correcte");
                return true;
            }
        }
        System.out.println("L'usuari o la contrasenya no són correctes. Chao Pescao...");
        System.exit(0);
        return false;
    }
}

// Definició de la classe GestorCoches

class GestorCoches {
    private static List<Cotxe> cotxesDisponibles = new ArrayList<>();

    // Afegir un cotxe a la llista
    public static void afegirCotxe() {
        Scanner input = new Scanner(System.in);

        System.out.print("Introdueix la matrícula: ");
        String matricula = input.nextLine();

        System.out.print("Introdueix la marca: ");
        String marca = input.nextLine();

        System.out.print("Introdueix el model: ");
        String model = input.nextLine();

        System.out.print("Introdueix el preu base per dia: ");
        double preuBase = input.nextDouble();
        input.nextLine(); // Consumir salt de línia

        System.out.print("Introdueix el nombre de places: ");
        int nombrePlaces = input.nextInt();
        input.nextLine(); // Consumir salt de línia

        // Crear objectes Motor i Roda (ara mateix, buits per simplicitat)
        Motor motor = new Motor("Gasolina", 100); // Exemple de motor
        Roda roda = new Roda("Michelin", 17); // Exemple de roda

        Cotxe nouCotxe = new Cotxe(matricula, marca, model, preuBase, motor, roda, nombrePlaces);
        cotxesDisponibles.add(nouCotxe);

        System.out.println("Cotxe afegit correctament: " + nouCotxe);
    }

    // Llogar un cotxe (elimina de la llista de disponibles)
    public static void llogarCotxe() {
        if (cotxesDisponibles.isEmpty()) {
            System.out.println("No hi ha cotxes disponibles per llogar.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Cotxes disponibles per llogar:");
        for (int i = 0; i < cotxesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + cotxesDisponibles.get(i));
        }

        System.out.print("Selecciona el número del cotxe que vols llogar: ");
        int index = input.nextInt() - 1;

        if (index >= 0 && index < cotxesDisponibles.size()) {
            Cotxe cotxeLlogat = cotxesDisponibles.remove(index);
            System.out.println("Has llogat el cotxe: " + cotxeLlogat);
        } else {
            System.out.println("Selecció no vàlida.");
        }
    }

    // Mostrar tots els cotxes disponibles
    public static void mostrarCotxesDisponibles() {
        if (cotxesDisponibles.isEmpty()) {
            System.out.println("No hi ha cotxes disponibles.");
        } else {
            System.out.println("Cotxes disponibles:");
            for (Cotxe cotxe : cotxesDisponibles) {
                System.out.println("- " + cotxe);
            }
        }
    }
}