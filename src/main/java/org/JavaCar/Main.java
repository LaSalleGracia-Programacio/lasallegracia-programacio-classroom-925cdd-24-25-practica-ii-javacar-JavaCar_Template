package org.JavaCar;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcio;
        do {
            System.out.println("\n     ██╗ █████╗ ██╗   ██╗ █████╗  ██████╗ █████╗ ██████╗ \n" +
                    "     ██║██╔══██╗██║   ██║██╔══██╗██╔════╝██╔══██╗██╔══██╗\n" +
                    "     ██║███████║██║   ██║███████║██║     ███████║██████╔╝\n" +
                    "██   ██║██╔══██║╚██╗ ██╔╝██╔══██║██║     ██╔══██║██╔══██╗\n" +
                    "╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║╚██████╗██║  ██║██║  ██║\n" +
                    " ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝\n" +
                    "                                                         ");
            System.out.println("1. Crear vehicle");
            System.out.println("2. Veure vehicles");
            System.out.println("3. Llogar vehicle");
            System.out.println("4. Retornar vehicle");
            System.out.println("5. Crear informe dels vehicles");
            System.out.println("6. Sortir");
            opcio = pedirOpcion(1, 6);

            switch (opcio) {
                case 1:
                    crearVehicle();
                    break;
                case 2:
                    veureVehicles();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (opcio != 6);
        System.out.println("Sortint del programa...");
    }

    public static int pedirOpcion(int v1, int v2) {
        int opcio;
        do {
            System.out.print("Selecciona una opció: ");
            while (!input.hasNextInt()) {
                System.out.println("Opció incorrecta. Torna a introduir un número:");
                input.next();
            }
            opcio = input.nextInt();
        } while (opcio < v1 || opcio > v2);
        input.nextLine();
        return opcio;
    }

    public static void crearVehicle() {
        System.out.println("Quin tipus de vehicle vols crear?");
        System.out.println("1. Cotxe");
        System.out.println("2. Moto");
        System.out.println("3. Furgoneta");
        int opcio = pedirOpcion(1, 3);

        switch (opcio) {
            case 1:
                crearCoche();
                break;
            case 2:
                crearMoto();
                break;
            case 3:
                crearFurgoneta();
                break;
        }
    }

    public static void crearCoche() {
        System.out.print("Introdueix la matrícula: ");
        String matricula = input.nextLine();

        System.out.print("Introdueix la marca: ");
        String marca = input.nextLine();

        System.out.print("Introdueix el model: ");
        String model = input.nextLine();

        System.out.print("Introdueix el preu base: ");
        double preuBase = input.nextDouble();

        System.out.print("Introdueix el nombre de places: ");
        int nombrePlaces = input.nextInt();
        input.nextLine(); // Limpiar buffer

        System.out.print("Introdueix el tipus de motor: ");
        String tipusMotor = input.nextLine();

        System.out.print("Introdueix la potència del motor: ");
        int potenciaMotor = input.nextInt();
        input.nextLine();

        Motor motor = new Motor(tipusMotor, potenciaMotor);

        System.out.print("Introdueix el diàmetre de les rodes: ");
        double diametre = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix la marca de les rodes: ");
        String marcaRoda = input.nextLine();

        Roda[] rodes = {new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre),
                new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre)};

        Vehicle cotxe = new Cotxe(matricula, marca, model, preuBase, nombrePlaces, motor, rodes);
        vehicles.add(cotxe);

        System.out.println("Cotxe creat correctament!");
    }

    public static void crearMoto() {
        System.out.print("Introdueix la matrícula: ");
        String matricula = input.nextLine();

        System.out.print("Introdueix la marca: ");
        String marca = input.nextLine();

        System.out.print("Introdueix el model: ");
        String model = input.nextLine();

        System.out.print("Introdueix el preu base: ");
        double preuBase = input.nextDouble();

        System.out.print("Introdueix la cilindrada: ");
        double cilindrada = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix el tipus de motor: ");
        String tipusMotor = input.nextLine();

        System.out.print("Introdueix la potència del motor: ");
        int potenciaMotor = input.nextInt();
        input.nextLine();

        Motor motor = new Motor(tipusMotor, potenciaMotor);

        System.out.print("Introdueix el diàmetre de les rodes: ");
        double diametre = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix la marca de les rodes: ");
        String marcaRoda = input.nextLine();

        Roda[] rodes = {new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre)};

        Vehicle moto = new Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes);
        vehicles.add(moto);

        System.out.println("Moto creada correctament!");
    }

    public static void crearFurgoneta() {
        System.out.print("Introdueix la matrícula: ");
        String matricula = input.nextLine();

        System.out.print("Introdueix la marca: ");
        String marca = input.nextLine();

        System.out.print("Introdueix el model: ");
        String model = input.nextLine();

        System.out.print("Introdueix el preu base: ");
        double preuBase = input.nextDouble();

        System.out.print("Introdueix la capacitat de càrrega: ");
        double capacitatCarga = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix el tipus de motor: ");
        String tipusMotor = input.nextLine();

        System.out.print("Introdueix la potència del motor: ");
        int potenciaMotor = input.nextInt();
        input.nextLine();

        Motor motor = new Motor(tipusMotor, potenciaMotor);

        System.out.print("Introdueix el diàmetre de les rodes: ");
        double diametre = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix la marca de les rodes: ");
        String marcaRoda = input.nextLine();

        Roda[] rodes = {new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre),
                new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre)};

        Vehicle furgoneta = new Furgoneta(matricula, marca, model, preuBase, capacitatCarga, motor, rodes);
        vehicles.add(furgoneta);

        System.out.println("Furgoneta creada correctament!");
    }

    public static void veureVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println("Matrícula: " + v.getMatricula() + ", Marca: " + v.getMarca() + ", Model: " + v.getModel());
        }
    }
}
