/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.DescripcionActividad;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface DescripcionActividadDao {
    List<DescripcionActividad> getAllDescripcionesActividades();
    DescripcionActividad getDescripcionActividadByIdActividad(String idActividad);
    void saveDescripcionActividad(DescripcionActividad descripcionActividad);
    void deleteDescripcionActividad(DescripcionActividad descripcionActividad);
}
