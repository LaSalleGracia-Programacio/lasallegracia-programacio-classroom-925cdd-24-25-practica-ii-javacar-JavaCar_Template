package org.JavaCar;

import java.util.*;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        // Crear rodes i motors
        List<Roda> rodesCotxe = Arrays.asList(new Roda("Michelin", 150), new Roda("Michelin", 150), new Roda("Michelin", 150), new Roda("Michelin", 150));
        Motor motorCotxe = new Motor("Gasolina", 120);

        List<Roda> rodesMoto = Arrays.asList(new Roda("Pirelli", 100), new Roda("Pirelli", 100));
        Motor motorMoto = new Motor("Gasolina", 80);

        List<Roda> rodesFurgoneta = Arrays.asList(new Roda("Bridgestone", 200), new Roda("Bridgestone", 200), new Roda("Bridgestone", 200), new Roda("Bridgestone", 200));
        Motor motorFurgoneta = new Motor("Dièsel", 150);


        // Afegir vehicles a la llista
        vehicles.add(new Cotxe("1234-ABC", "Toyota", "Corolla", 2020, "Gasolina", "C", rodesCotxe, motorCotxe, 5));
        vehicles.add(new Moto("5678-DEF", "Honda", "CBR500", 2019, "Gasolina", "B", rodesMoto, motorMoto, 500));
        vehicles.add(new Furgoneta("9012-GHI", "Ford", "Transit", 2021, "Dièsel", "C", rodesFurgoneta, motorFurgoneta, 1200));


        boolean sortir = false;

        while (!sortir) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar vehicles disponibles");
            System.out.println("2. Llogar un vehicle");
            System.out.println("3. Sortir");
            System.out.print("Selecciona una opció: ");

            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {

                case 1:
                    System.out.println("\nVehicles disponibles:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i).getMarca() + " " + vehicles.get(i).getModel());
                    }
                    break;

                case 2:
                    System.out.println("\nSelecciona el vehicle que vols llogar:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i).getMarca() + " " + vehicles.get(i).getModel());
                    }
                    System.out.print("Introdueix el número del vehicle: ");
                    int index = scanner.nextInt() - 1;

                    if (index >= 0 && index < vehicles.size()) {
                        System.out.print("Quants dies vols llogar-lo? ");
                        int dies = scanner.nextInt();
                        scanner.nextLine();

                        Client client = new Client("Joan Pérez", "12345678A", "654321987");
                        ContracteLloguer contracte = new ContracteLloguer(1, client, vehicles.get(index), dies);

                        System.out.println("\nContracte creat!");
                        System.out.println("Client: " + contracte.getClient().getNom());
                        System.out.println("Vehicle: " + contracte.getVehicle().getMarca() + " " + contracte.getVehicle().getModel());
                        System.out.println("Preu total del lloguer: " + contracte.getPreuTotal() + "€");
                    } else {
                        System.out.println("Opció no vàlida.");
                    }
                    break;

                case 3:
                    sortir = true;
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }


            scanner.close();
        }




    }
}