/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package entidades;

import java.io.File;
import java.sql.Date;
import logica.Documento;

/**
 *
 * @author dagam
 */
public class Reporte extends Documento{
    private String idReporte;
    private File archivoReporte;
    private Date fechaEntregaReporte;

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public File getArchivoReporte() {
        return archivoReporte;
    }

    public void setArchivoReporte(File archivoReporte) {
        this.archivoReporte = archivoReporte;
    }

    public Date getFechaEntregaReporte() {
        return fechaEntregaReporte;
    }

    public void setFechaEntregaReporte(Date fechaEntregaReporte) {
        this.fechaEntregaReporte = fechaEntregaReporte;
    }    
}
