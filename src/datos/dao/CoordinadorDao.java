/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Coordinador;
import java.util.List;

/**
 *
 * @author angel
 */
public interface CoordinadorDao {
    List<Coordinador> getAllCoordinadores();
    Coordinador getCoordinadorByNumEmpleado(String numeroPersonalEmpleado);
    void saveCoordinador(Coordinador coordinador);
    void deleteCoordinador(Coordinador coordinador);
}
