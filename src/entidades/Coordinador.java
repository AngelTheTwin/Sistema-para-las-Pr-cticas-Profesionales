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
public class Coordinador {
    private String numeroPersonalCoordinador;
    private String nombreCoordinador;
    private String apellidoPaternoCoordinador;
    private String apellidoMaternoCoordinador;
    private String contraseñaCoordinador;
    private Date fechaRegistroCoordinador;
    private int tiempoServicioCoordinador;
    private String turnoCoordinador;
    private String estadoCoordinador;

    public String getNumeroPersonalCoordinador() {
        return numeroPersonalCoordinador;
    }

    public void setNumeroPersonalCoordinador(String numeroPersonalCoordinador) {
        this.numeroPersonalCoordinador = numeroPersonalCoordinador;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public String getApellidoPaternoCoordinador() {
        return apellidoPaternoCoordinador;
    }

    public void setApellidoPaternoCoordinador(String apellidoPaternoCoordinador) {
        this.apellidoPaternoCoordinador = apellidoPaternoCoordinador;
    }

    public String getApellidoMaternoCoordinador() {
        return apellidoMaternoCoordinador;
    }

    public void setApellidoMaternoCoordinador(String apellidoMaternoCoordinador) {
        this.apellidoMaternoCoordinador = apellidoMaternoCoordinador;
    }

    public String getContraseñaCoordinador() {
        return contraseñaCoordinador;
    }

    public void setContraseñaCoordinador(String contraseñaCoordinador) {
        this.contraseñaCoordinador = contraseñaCoordinador;
    }

    public Date getFechaRegistroCoordinador() {
        return fechaRegistroCoordinador;
    }

    public void setFechaRegistroCoordinador(Date fechaRegistroCoordinador) {
        this.fechaRegistroCoordinador = fechaRegistroCoordinador;
    }

    public int getTiempoServicioCoordinador() {
        return tiempoServicioCoordinador;
    }

    public void setTiempoServicioCoordinador(int tiempoServicioCoordinador) {
        this.tiempoServicioCoordinador = tiempoServicioCoordinador;
    }

    public String getTurnoCoordinador() {
        return turnoCoordinador;
    }

    public void setTurnoCoordinador(String turnoCoordinador) {
        this.turnoCoordinador = turnoCoordinador;
    }

    public String getEstadoCoordinador() {
        return estadoCoordinador;
    }

    public void setEstadoCoordinador(String estadoCoordinador) {
        this.estadoCoordinador = estadoCoordinador;
    }
}
