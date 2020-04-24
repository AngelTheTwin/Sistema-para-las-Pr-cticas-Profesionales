/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author angel
 */
public class Profesor {
    private String numeroPersonalProfesor;
    private String nombreProfesor;
    private String apellidoPaternoProfesor;
    private String apellidoMaternoProfesor;
    private String turnoProfesor;
    private String contraseñaProfesor;
    private String estadoProfesor;
    private Date fechaRegistroProfesor;
    private int tiempoServicioProfesor;

    public String getNumeroPersonalProfesor() {
        return numeroPersonalProfesor;
    }

    public void setNumeroPersonalProfesor(String numeroPersonalProfesor) {
        this.numeroPersonalProfesor = numeroPersonalProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoPaternoProfesor() {
        return apellidoPaternoProfesor;
    }

    public void setApellidoPaternoProfesor(String apellidoPaternoProfesor) {
        this.apellidoPaternoProfesor = apellidoPaternoProfesor;
    }

    public String getApellidoMaternoProfesor() {
        return apellidoMaternoProfesor;
    }

    public void setApellidoMaternoProfesor(String apellidoMaternoProfesor) {
        this.apellidoMaternoProfesor = apellidoMaternoProfesor;
    }

    public String getTurnoProfesor() {
        return turnoProfesor;
    }

    public void setTurnoProfesor(String turnoProfesor) {
        this.turnoProfesor = turnoProfesor;
    }

    public String getContraseñaProfesor() {
        return contraseñaProfesor;
    }

    public void setContraseñaProfesor(String contraseñaProfesor) {
        this.contraseñaProfesor = contraseñaProfesor;
    }

    public String getEstadoProfesor() {
        return estadoProfesor;
    }

    public void setEstadoProfesor(String estadoProfesor) {
        this.estadoProfesor = estadoProfesor;
    }
    

    public Date getFechaRegistroProfesor() {
        return fechaRegistroProfesor;
    }

    public void setFechaRegistroProfesor(Date fechaRegistroProfesor) {
        this.fechaRegistroProfesor = fechaRegistroProfesor;
    }

    public int getTiempoServicioProfesor() {
        return tiempoServicioProfesor;
    }

    public void setTiempoServicioProfesor(int tiempoServicioProfesor) {
        this.tiempoServicioProfesor = tiempoServicioProfesor;
    }
}
