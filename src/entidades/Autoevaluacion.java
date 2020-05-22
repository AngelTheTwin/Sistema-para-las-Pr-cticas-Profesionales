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
    private int idAutoevaluacion;
    private File archivoAutoevaluacion;

    public int getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(int idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public File getArchivoAutoevaluacion() {
        return archivoAutoevaluacion;
    }

    public void setArchivoAutoevaluacion(File archivoAutoevaluacion) {
        this.archivoAutoevaluacion = archivoAutoevaluacion;
    }
}
