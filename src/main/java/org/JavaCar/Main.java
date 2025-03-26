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



    }
}