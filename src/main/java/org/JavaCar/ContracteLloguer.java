package org.JavaCar;
class ContracteLloguer {
    private int idContracte;
    private Client client;
    Private Vehicle vehicle;
    private int diesLloguer;
    private double preuTotal;


    public ContracteLloguer(int idContracte, Client client, Private vehicle, int diesLloguer, double preuTotal) {
        this.idContracte = idContracte;
        this.client = client;
        this.Vehicle = vehicle;
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
