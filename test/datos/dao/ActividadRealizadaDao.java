/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.ActividadRealizada;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface ActividadRealizadaDao {
    List<ActividadRealizada> getAllActividadesRealizadas();
    ActividadRealizada getActividadRealizadaByIdActividadRealizada(String idActividadRealizada);
    void saveActividadRealizada(ActividadRealizada actividadRealizada);
    void deleteActividadRealizada(ActividadRealizada actividadRealizada);
}
