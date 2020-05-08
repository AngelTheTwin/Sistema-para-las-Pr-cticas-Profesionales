/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Horario;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface HorarioDao {
    List<Horario> getAllHorarios();
    Horario getHorarioByIdHorario(String idHorario);
    void saveHorario(Horario horario);
    void deleteHorario(Horario horario);
}
