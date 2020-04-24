/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.FormatoPresentacion;
import java.util.List;

/**
 *
 * @author angel
 */
public interface FormatoPresentacionDao {
    List<FormatoPresentacion> getAllPresentaciones();
    FormatoPresentacion getFormatoPresentacionByIdFormato(String idFormato);
    void saveFormatoPresentacion(FormatoPresentacion formatoPresentacion);
    void deleteFormatoPresentacion(FormatoPresentacion formatoPresentacion);
}
