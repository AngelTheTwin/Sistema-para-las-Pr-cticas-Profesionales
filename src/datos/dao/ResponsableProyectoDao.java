/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.ResponsableProyecto;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface ResponsableProyectoDao {
    List<ResponsableProyecto> getAllidResponsableProyectos();
    ResponsableProyecto getResponsableProyectoByIdResponsableProyecto(String idResponsableProyecto);
    void saveResponsableProyecto(ResponsableProyecto responsableProyecto);
    void deleteResponsableProyecto(ResponsableProyecto responsableProyecto);
}
