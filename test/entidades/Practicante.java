/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package entidades;

/**
 *
 * @author angel
 */
public class Practicante {
    private String matricula;
    private String nombrePracticante;
    private String apellidoPaternoPracticante;
    private String apellidoMaternoPracticante;
    private String turnoPracticante;
    private String contraseñaPracticante;
    private String generoPracticante;
    private int periodoPracticante;
    private String estadoPracticante;
    private int calificacion;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombrePracticante() {
        return nombrePracticante;
    }

    public void setNombrePracticante(String nombrePracticante) {
        this.nombrePracticante = nombrePracticante;
    }

    public String getApellidoPaternoPracticante() {
        return apellidoPaternoPracticante;
    }

    public void setApellidoPaternoPracticante(String apellidoPaternoPracticante) {
        this.apellidoPaternoPracticante = apellidoPaternoPracticante;
    }

    public String getApellidoMaternoPracticante() {
        return apellidoMaternoPracticante;
    }

    public void setApellidoMaternoPracticante(String apellidoMaternoPracticante) {
        this.apellidoMaternoPracticante = apellidoMaternoPracticante;
    }

    public String getTurnoPracticante() {
        return turnoPracticante;
    }

    public void setTurnoPracticante(String turnoPracticante) {
        this.turnoPracticante = turnoPracticante;
    }

    public String getContraseñaPracticante() {
        return contraseñaPracticante;
    }

    public void setContraseñaPracticante(String contraseñaPracticante) {
        this.contraseñaPracticante = contraseñaPracticante;
    }

    public String getGeneroPracticante() {
        return generoPracticante;
    }

    public void setGeneroPracticante(String generoPracticante) {
        this.generoPracticante = generoPracticante;
    }

    public int getPeriodoPracticante() {
        return periodoPracticante;
    }

    public void setPeriodoPracticante(int periodoPracticante) {
        this.periodoPracticante = periodoPracticante;
    }

    public String getEstadoPracticante() {
        return estadoPracticante;
    }

    public void setEstadoPracticante(String estadoPracticante) {
        this.estadoPracticante = estadoPracticante;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
