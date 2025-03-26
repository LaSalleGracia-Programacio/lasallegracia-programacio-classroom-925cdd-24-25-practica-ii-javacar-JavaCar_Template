package org.JavaCar;

public class Client {

    private String nom;
    private String dni;
    private String telefon;

    public Client(String nom, String dni, String telefon) {
        this.nom = nom;
        this.dni = dni;
        this.telefon = telefon;
    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefon() {
        return telefon;
    }

}

