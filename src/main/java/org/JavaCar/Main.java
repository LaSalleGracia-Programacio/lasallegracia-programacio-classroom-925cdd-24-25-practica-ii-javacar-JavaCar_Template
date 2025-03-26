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
    }
}