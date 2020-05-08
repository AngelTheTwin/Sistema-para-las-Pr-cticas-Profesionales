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
public class Horario extends Documento{
    private String idHorario;
    private File archivoHorario;

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public File getArchivoHorario() {
        return archivoHorario;
    }

    public void setArchivoHorario(File archivoHorario) {
        this.archivoHorario = archivoHorario;
    }
}
