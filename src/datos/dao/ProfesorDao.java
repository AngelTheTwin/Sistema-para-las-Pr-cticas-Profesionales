/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Profesor;
import java.util.List;

/**
 *
 * @author angel
 */
public interface ProfesorDao {
    List<Profesor> getAllProfesores();
    Profesor getProfesorByNumEmpleado(String numeroPersonalProfesor);
    void saveProfesor(Profesor profesor);
    void deleteProfesor(Profesor profesor);
}
