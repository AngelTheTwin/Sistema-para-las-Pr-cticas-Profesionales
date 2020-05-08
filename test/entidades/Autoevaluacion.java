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
public class Autoevaluacion extends Documento{
    private String idAutoevaluacion;
    private File archivoAutoevaluacion;

    public String getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(String idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public File getArchivoAutoevaluacion() {
        return archivoAutoevaluacion;
    }

    public void setArchivoAutoevaluacion(File archivoAutoevaluacion) {
        this.archivoAutoevaluacion = archivoAutoevaluacion;
    }
}
