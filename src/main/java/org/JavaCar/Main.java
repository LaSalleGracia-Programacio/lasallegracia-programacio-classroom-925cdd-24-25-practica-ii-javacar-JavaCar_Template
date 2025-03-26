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

                case 4:
                    System.out.print("Ingrese la matrícula del vehículo para alquilar: ");
                    matricula = scanner.nextLine();
                    Vehicle vehicleAlquilado = null;
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.getMatricula().equals(matricula)) {
                            vehicleAlquilado = vehicle;
                            break;
                        }
                    }
                    if (vehicleAlquilado != null) {
                        System.out.print("Ingrese su ID de cliente: ");
                        String clientId = scanner.nextLine();
                        System.out.print("Ingrese la fecha de inicio (yyyy-mm-dd): ");
                        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
                        System.out.print("Ingrese la fecha de fin (yyyy-mm-dd): ");
                        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

                        int dias = fechaInicio.until(fechaFin).getDays();
                        double precioTotal = vehicleAlquilado.calcularPreu(dias);

                        if (dias > 7) {
                            precioTotal *= 0.9;
                        }

                        Lloguer alquiler = new Lloguer(vehicleAlquilado, clientId, fechaInicio, fechaFin, precioTotal);
                        historial.add(alquiler);
                        System.out.println("Alquiler registrado con éxito. Precio total: " + precioTotal);
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese su ID de cliente para ver el historial: ");
                    String clientIdHistorial = scanner.nextLine();
                    System.out.println("Historial de alquileres:");
                    for (Lloguer alquiler : historial) {
                        if (alquiler.getClientId().equals(clientIdHistorial)) {
                            System.out.println("Vehículo: " + alquiler.getVehicle().getMarca() + " " + alquiler.getVehicle().getModel());
                            System.out.println("Fechas: " + alquiler.getDataInici() + " - " + alquiler.getDataFi());
                            System.out.println("Precio pagado: " + alquiler.getPreuPagat());
                        }
                    }
                    break;

                case 6:
                    double ingresosTotales = historial.stream().mapToDouble(Lloguer::getPreuPagat).sum();
                    System.out.println("Ingresos totales: " + ingresosTotales);
                    break;

                case 7:
                    System.out.print("Ingrese la matrícula del vehículo para ver la etiqueta ambiental: ");
                    matricula = scanner.nextLine();
                    found = false;
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.getMatricula().equals(matricula)) {
                            found = true;
                            System.out.println("Etiqueta ambiental del vehículo: " + vehicle.getEtiquetaAmbiental());
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("Gracias por usar el sistema de alquiler. ¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}