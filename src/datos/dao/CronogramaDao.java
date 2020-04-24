/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Cronograma;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface CronogramaDao {
    List<Cronograma> getAllCronogramas();
    Cronograma getCronogramaByIdCronograma(String idCronograma);
    void saveCronograma(Cronograma cronograma);
    void deleteCronograma(Cronograma cronograma);
}
