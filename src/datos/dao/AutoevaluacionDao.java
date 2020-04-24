/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Autoevaluacion;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface AutoevaluacionDao {
    List<Autoevaluacion> getAllAutoevaluaciones();
    Autoevaluacion getAutoevaluacionByIdAutoevaluacion(String idAutoevaluacion);
    void saveAutoevaluacion(Autoevaluacion autoevaluacion);
    void deleteAutoevaluacion(Autoevaluacion autoevaluacion);
}
