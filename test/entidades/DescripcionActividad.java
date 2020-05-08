/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author dagam
 */
public class DescripcionActividad {
    private String idActividad;
    private String tituloActividad;
    private String descripcionActividad;
    private Date fechaEntregaActividad; 

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripciónActividad) {
        this.descripcionActividad = descripciónActividad;
    }

    public Date getFechaEntregaActividad() {
        return fechaEntregaActividad;
    }

    public void setFechaEntregaActividad(Date fechaEntregaActividad) {
        this.fechaEntregaActividad = fechaEntregaActividad;
    }
}

