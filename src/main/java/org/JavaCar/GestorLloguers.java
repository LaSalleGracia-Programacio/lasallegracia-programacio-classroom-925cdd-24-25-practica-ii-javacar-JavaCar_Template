package org.JavaCar;

import java.util.List;
import java.util.ArrayList;

public class GestorLloguers {

    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double ingressosTotals = 0;
        for (Vehicle vehicle : vehicles) {
            ingressosTotals += vehicle.calcularPreu(dies);
        }
        return ingressosTotals;
    }

    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPreuBase() <= preuMax) {
                vehiclesFiltrats.add(vehicle);
            }
        }
        return vehiclesFiltrats;
    }
}
