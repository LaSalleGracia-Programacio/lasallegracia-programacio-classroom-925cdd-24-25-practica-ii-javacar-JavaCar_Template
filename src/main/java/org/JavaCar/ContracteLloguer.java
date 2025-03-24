package org.JavaCar;

import org.JavaCar.Vehicle;



// import org.JavaCar.Client;
// import org.JavaCar.Vehicle;

class ContracteLloguer {
    private int idContracte;
    private Client client;
    private Vehicle vehicle;
    private int diesLloguer;
    private double preuTotal;

    public ContracteLloguer(int idContracte, Client client, Vehicle vehicle, int diesLloguer, double preuTotal) {
        this.idContracte = idContracte;
        this.client = client;
        this.vehicle = vehicle;
        this.diesLloguer = diesLloguer;
        this.preuTotal = vehicle.calcularPreu(diesLloguer);
    }

    public int getIdContracte() {
        return idContracte;
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPreuTotal() {
        return preuTotal;
    }
}


}
