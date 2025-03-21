package org.JavaCar;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Motor motorCotxe = new Motor("Gasolina", 120);
        Motor motorMoto = new Motor("Elèctric", 50);
        Motor motorFurgoneta = new Motor("Dièsel", 150);


        Roda rodesCotxe = new Roda("Michelin", 16);
        Roda rodesMoto = new Roda("Pirelli", 14);
        Roda rodesFurgoneta = new Roda("Goodyear", 18);


        Cotxe cotxe = new Cotxe("1234XYZ", "Ford", "Focus", 50.0, "Gasolina", 4, "C", 5);
        Moto moto = new Moto("5678ABC", "Yamaha", "R1", 30.0, "Elèctric", 2, "Zero", 600);
        Furgoneta furgoneta = new Furgoneta("9012DEF", "Mercedes", "Sprinter", 80.0, "Dièsel", 4, "B", 2000);


        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(cotxe);
        vehicles.add(moto);
        vehicles.add(furgoneta);

        int opcio;
        do {
            System.out.println("\n*** Menú Principal ***");
            System.out.println("1. Mostrar vehicles disponibles");
            System.out.println("2. Calcular ingressos totals per lloguer");
            System.out.println("3. Filtrar vehicles per preu base");
            System.out.println("4. Sortir");
            System.out.print("Trieu una opció (1-4): ");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    mostrarVehicles(vehicles);
                    break;
                case 2:
                    System.out.print("Introduïu el nombre de dies per al lloguer: ");
                    int dies = scanner.nextInt();
                    double ingressos = Gestor_lloguer.calcularIngressosTotals(vehicles, dies);
                    System.out.println("Ingressos totals per " + dies + " dies: " + ingressos + "€");
                    break;
                case 3:
                    System.out.print("Introduïu el preu màxim per filtrar vehicles: ");
                    double preuMax = scanner.nextDouble();
                    List<Vehicle> vehiclesFiltrats = Gestor_lloguer.filtrarPerPreu(vehicles, preuMax);
                    System.out.println("Vehicles amb preu base ≤ " + preuMax + "€: " + vehiclesFiltrats.size());
                    mostrarVehicles(vehiclesFiltrats);
                    break;
                case 4:
                    System.out.println("Sortint del programa...");
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenta de nou.");
            }
        } while (opcio != 4);

        scanner.close();
    }


    public static void mostrarVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No hi ha vehicles disponibles.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println("Vehicle: " + v.getMarca() + " " + v.getModel() + ", Preu base: " + v.getPreuBase() + "€, Etiqueta ambiental: " + v.getEtiquetaAmbiental());
            }
        }
    }
}

