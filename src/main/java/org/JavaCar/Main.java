package org.JavaCar;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

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
                    llogarVehicle();
                    break;
                case 4:
                    retornarVehicle();
                    break;
                case 5:
                    crearInformeVehicles();
                    break;
                case 6:
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

        System.out.print("Introdueix l'autonomia del motor (en km): ");
        int autonomiaMotor = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix el mes de matriculació (1-12): ");
        int mesMatriculacio = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix l'any de matriculació: ");
        int anyMatriculacio = input.nextInt();
        input.nextLine();

        Motor motor = new Motor(tipusMotor, potenciaMotor, autonomiaMotor);

        System.out.print("Introdueix el diàmetre de les rodes: ");
        double diametre = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix la marca de les rodes: ");
        String marcaRoda = input.nextLine();

        Roda[] rodes = {new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre),
                new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre)};

        Vehicle cotxe = new Cotxe(matricula, marca, model, preuBase, nombrePlaces, motor, rodes, mesMatriculacio, anyMatriculacio);
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
        input.nextLine(); // Limpiar buffer

        System.out.print("Introdueix el tipus de motor: ");
        String tipusMotor = input.nextLine();

        System.out.print("Introdueix la potència del motor: ");
        int potenciaMotor = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix l'autonomia del motor (en km): ");
        int autonomiaMotor = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix el mes de matriculació (1-12): ");
        int mesMatriculacio = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix l'any de matriculació: ");
        int anyMatriculacio = input.nextInt();
        input.nextLine();

        // Crear el objeto Motor
        Motor motor = new Motor(tipusMotor, potenciaMotor, autonomiaMotor);

        System.out.print("Introdueix el diàmetre de les rodes: ");
        double diametre = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix la marca de les rodes: ");
        String marcaRoda = input.nextLine();

        Roda[] rodes = {new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre)};

        Vehicle moto = new Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes, mesMatriculacio, anyMatriculacio);
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
        input.nextLine(); // Limpiar buffer

        System.out.print("Introdueix el tipus de motor: ");
        String tipusMotor = input.nextLine();

        System.out.print("Introdueix la potència del motor: ");
        int potenciaMotor = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix l'autonomia del motor (en km): ");
        int autonomiaMotor = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix el mes de matriculació (1-12): ");
        int mesMatriculacio = input.nextInt();
        input.nextLine();

        System.out.print("Introdueix l'any de matriculació: ");
        int anyMatriculacio = input.nextInt();
        input.nextLine();

        // Crear el objeto Motor
        Motor motor = new Motor(tipusMotor, potenciaMotor, autonomiaMotor);

        System.out.print("Introdueix el diàmetre de les rodes: ");
        double diametre = input.nextDouble();
        input.nextLine();

        System.out.print("Introdueix la marca de les rodes: ");
        String marcaRoda = input.nextLine();

        // Crear las ruedas (una furgoneta tiene 4 ruedas)
        Roda[] rodes = {new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre),
                new Roda(marcaRoda, diametre), new Roda(marcaRoda, diametre)};

        // Crear el objeto Furgoneta y añadirlo a la lista de vehículos
        Vehicle furgoneta = new Furgoneta(matricula, marca, model, preuBase, capacitatCarga, motor, rodes, mesMatriculacio, anyMatriculacio);
        vehicles.add(furgoneta);

        System.out.println("Furgoneta creada correctament!");
    }

    public static void veureVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println("Matrícula: " + v.getMatricula() + ", Marca: " + v.getMarca() + ", Model: " + v.getModel());
        }
    }
    public static void llogarVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No hi ha vehicles disponibles.");
            return;
        }

        System.out.println("Llista de vehicles disponibles:");
        for (int i = 0; i < vehicles.size(); i++) {
            if (!vehicles.get(i).isLlogat()) {
                System.out.println(i + ". " + vehicles.get(i).getMatricula() + " - " + vehicles.get(i).getMarca() + " " + vehicles.get(i).getModel());
            }
        }

        System.out.print("Selecciona el número del vehicle que vols llogar: ");
        int index = input.nextInt();
        input.nextLine(); // Limpiar buffer

        if (index < 0 || index >= vehicles.size() || vehicles.get(index).isLlogat()) {
            System.out.println("Selecció no vàlida.");
            return;
        }

        System.out.print("Introdueix el nombre de dies de lloguer: ");
        int dies = input.nextInt();
        input.nextLine(); // Limpiar buffer

        double preuTotal = vehicles.get(index).calcularPreu(dies);
        vehicles.get(index).setLlogat(true);

        System.out.println("Has llogat el vehicle " + vehicles.get(index).getMatricula() + " per " + dies + " dies.");
        System.out.println("Preu total: " + preuTotal + "€");
    }

    public static void retornarVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No hi ha vehicles per retornar.");
            return;
        }

        System.out.println("Llista de vehicles llogats:");
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).isLlogat()) {
                System.out.println(i + ". " + vehicles.get(i).getMatricula() + " - " + vehicles.get(i).getMarca() + " " + vehicles.get(i).getModel());
            }
        }

        System.out.print("Selecciona el número del vehicle que vols retornar: ");
        int index = input.nextInt();
        input.nextLine(); // Limpiar buffer

        if (index < 0 || index >= vehicles.size() || !vehicles.get(index).isLlogat()) {
            System.out.println("Selecció no vàlida.");
            return;
        }

        vehicles.get(index).setLlogat(false);
        System.out.println("Has retornat el vehicle " + vehicles.get(index).getMatricula() + ".");
    }

    public static void crearInformeVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No hi ha vehicles registrats.");
            return;
        }

        String nombreArchivo = "informeJavaCar.txt";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("INFORME DE VEHICLES\n");
            writer.write("=====================\n");

            for (Vehicle v : vehicles) {
                writer.write("--------------------------------\n");
                writer.write("Matrícula: " + v.getMatricula() + "\n");
                writer.write("Marca: " + v.getMarca() + "\n");
                writer.write("Model: " + v.getModel() + "\n");
                writer.write("Preu base: " + v.getPreuBase() + "€\n");
                writer.write("Motor: " + v.getMotor().getTipus() + " - " + v.getMotor().getPotencia() + " CV\n");
                writer.write("Etiqueta Ambiental: " + v.getEtiquetaAmbiental() + "\n");
                writer.write("Estat: " + (v.isLlogat() ? "LLOGAT" : "DISPONIBLE") + "\n");
            }

            System.out.println("✅ Informe generat correctament en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error en guardar l'informe: " + e.getMessage());
        }
    }
}



