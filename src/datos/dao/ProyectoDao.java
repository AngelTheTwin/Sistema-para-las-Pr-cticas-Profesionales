/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Proyecto;
import java.util.List;

/**
 *
 * @author angel
 */
public interface ProyectoDao {
    public List<Proyecto> getAllProyectos();
    Proyecto getProyectoByNombreProyecto (String nombreProyecto);
    void saveProyecto(Proyecto proyecto);
    void deleteProyecto (Proyecto proyecto);
}
