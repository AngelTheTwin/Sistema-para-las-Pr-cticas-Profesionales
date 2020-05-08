/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package entidades;

import java.io.File;
import logica.Documento;

/**
 *
 * @author dagam
 */
public class ActividadRealizada extends Documento{
    private String idActividadRealizada;
    private File archivoActividad;

    public String getIdActividadRealizada() {
        return idActividadRealizada;
    }

    public void setIdActividadRealizada(String idActividadRealizada) {
        this.idActividadRealizada = idActividadRealizada;
    }

    public File getArchivoActividad() {
        return archivoActividad;
    }

    public void setArchivoActividad(File archivoActividad) {
        this.archivoActividad = archivoActividad;
    }
    
    
}
