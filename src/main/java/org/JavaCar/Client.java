package org.JavaCar;

public class Client {
        private String nom;
        private String dni;
        private String telefon;

        public Client(String nom, String dni, String telefon) {
            if (nom == null || nom.trim().isEmpty()) {
                throw new IllegalArgumentException("El nom no pot estar buit.");
            }
            if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
                throw new IllegalArgumentException("DNI no vàlid.");
            }
            if (!telefon.matches("\\d{9}")) {
                throw new IllegalArgumentException("El telèfon ha de tenir 9 dígits.");
            }

            this.nom = nom;
            this.dni = dni;
            this.telefon = telefon;
        }

        public String getNom() { return nom; }
        public String getDni() { return dni; }
        public String getTelefon() { return telefon; }

        public void setNom(String nom) {
            if (nom == null || nom.trim().isEmpty()) {
                throw new IllegalArgumentException("El nom no pot estar buit.");
            }
            this.nom = nom;
        }

        public void setDni(String dni) {
            if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
                throw new IllegalArgumentException("DNI no vàlid.");
            }
            this.dni = dni;
        }

        public void setTelefon(String telefon) {
            if (!telefon.matches("\\d{9}")) {
                throw new IllegalArgumentException("El telèfon ha de tenir 9 dígits.");
            }
            this.telefon = telefon;
        }
    }

