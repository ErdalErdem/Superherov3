package com.example.superherov3.model;

public class Superhero {

        private String name;
        private boolean isHuman;
        private String superPower;
        private int creationYear;
        private double strength;


    public Superhero(String name, boolean isHuman, String superPower, int creationYear, double strength) {
            this.name = name;
            this.isHuman = isHuman;
            this.superPower = superPower;
            this.creationYear = creationYear;
            this.strength = strength;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getisHuman() {
            return isHuman;
        }

        public void setHuman(boolean human) {
            isHuman = human;
        }

        public String getSuperPower() {
            return superPower;
        }

        public void setSuperPower(String superPower) {
            this.superPower = superPower;
        }

        public int getCreationYear() {
            return creationYear;
        }

        public void setCreationYear(int creationYear) {
            this.creationYear = creationYear;

        }

        public double getStrength() {
            return strength;
        }

        public void setStrength(double strength) {
            this.strength = strength;
        }

        // ToString - Dette printer info om en superhelt
        public String toString() {
            return "Real name: " + name + "\nIs human?" + " " + isHuman + "\nSuperpower: " + superPower + "\nYear of publication: " + creationYear + "\nStrength: " + strength + "\n";

        }

    }

