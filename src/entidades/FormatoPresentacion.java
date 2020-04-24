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
 * @author angel
 */
public class FormatoPresentacion extends Documento{
    String idFormatoPresentacion;
    File archivoFormatoPresentacion;
    
    public String getIdFormatoPresentacion() {
        return idFormatoPresentacion;
    }

    public void setIdFormatoPresentacion(String idFormatoPresentacion) {
        this.idFormatoPresentacion = idFormatoPresentacion;
    }

    public File getArchivoFormatoPresentacion() {
        return archivoFormatoPresentacion;
    }

    public void setArchivoFormatoPresentacion(File archivoFormatoPresentacion) {
        this.archivoFormatoPresentacion = archivoFormatoPresentacion;
    }
}
