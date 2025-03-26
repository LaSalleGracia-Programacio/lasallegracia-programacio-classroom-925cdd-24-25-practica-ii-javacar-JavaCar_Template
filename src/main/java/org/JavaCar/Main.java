package org.JavaCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear vehículos de prueba
        Motor motorCoche = new Motor("gasolina", 110);
        Roda[] rodesCoche = {new Roda("Michelin", 16), new Roda("Michelin", 16)};
        Cotxe cotxe = new Cotxe("123ABC", "Toyota", "Corolla", 50.0, 5, motorCoche, rodesCoche);

        Motor motorMoto = new Motor("electric", 75);
        Roda[] rodesMoto = {new Roda("Dunlop", 18), new Roda("Dunlop", 18)};
        Moto moto = new Moto("456DEF", "Harley", "LiveWire", 30.0, 800, motorMoto, rodesMoto);

        Motor motorFurgoneta = new Motor("diesel", 130);
        Roda[] rodesFurgoneta = {new Roda("Bridgestone", 15), new Roda("Bridgestone", 15)};
        Furgoneta furgoneta = new Furgoneta("789GHI", "Ford", "Transit", 80.0, 1500, motorFurgoneta, rodesFurgoneta);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(cotxe);
        vehicles.add(moto);
        vehicles.add(furgoneta);

        List<Vehicle> historial = new ArrayList<>();

        System.out.println("Bienvenido al sistema de alquiler de vehículos.");
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver vehículos disponibles");
            System.out.println("2. Filtrar vehículos por precio");
            System.out.println("3. Ver detalles del vehículo");
            System.out.println("4. Registrar alquiler");
            System.out.println("5. Consultar historial de alquileres");
            System.out.println("6. Calcular ingresos totales");
            System.out.println("7. Consultar etiqueta ambiental");
            System.out.println("8. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Vehículos disponibles:");
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle.getMarca() + " " + vehicle.getModel());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el precio máximo: ");
                    double precioMax = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Vehículos dentro del presupuesto:");
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.calcularPreu(1) <= precioMax) {
                            System.out.println(vehicle.getMarca() + " " + vehicle.getModel() + " - Precio: " + vehicle.calcularPreu(1));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String matricula = scanner.nextLine();
                    boolean found = false;
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.getMatricula().equals(matricula)) {
                            found = true;
                            System.out.println("Detalles del vehículo: ");
                            System.out.println("Marca: " + vehicle.getMarca());
                            System.out.println("Modelo: " + vehicle.getModel());
                            System.out.println("Precio base: " + vehicle.getPreuBase());
                            System.out.println("Etiqueta ambiental: " + vehicle.getEtiquetaAmbiental());
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

        }
}