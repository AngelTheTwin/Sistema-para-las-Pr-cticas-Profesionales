/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Practicante;
import java.util.List;

/**
 *
 * @author angel
 */
public interface PracticanteDao {
    List<Practicante> getAllPracticantes();
    Practicante getPracticanteByMatricula(String matricula);
    void savePracticante(Practicante practicante);
    void deletePracticante(Practicante practicante);
}
