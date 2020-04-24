/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.File;
import logica.Documento;

/**
 *
 * @author dagam
 */
public class Cronograma extends Documento{
   private String idCronograma;
   private File archivoCronograma;

    public String getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(String idCronograma) {
        this.idCronograma = idCronograma;
    }

    public File getArchivoCronograma() {
        return archivoCronograma;
    }

    public void setArchivoCronograma(File archivoCronograma) {
        this.archivoCronograma = archivoCronograma;
    }
}
