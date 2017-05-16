package com.javainuse.model;

public class Emprendedor {

    private boolean inversionista;
    private boolean emprendedor;

    // para reglas difusas
    private double patrimonio;
    private int experience;
    private double raiting;

    public double getRaiting() {
        return raiting;
    }

    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    public boolean isInversionista() {
        return inversionista;
    }

    public void setInversionista(boolean inversionista) {
        this.inversionista = inversionista;
    }

    public boolean isEmprendedor() {
        return emprendedor;
    }

    public void setEmprendedor(boolean emprendedor) {
        this.emprendedor = emprendedor;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
