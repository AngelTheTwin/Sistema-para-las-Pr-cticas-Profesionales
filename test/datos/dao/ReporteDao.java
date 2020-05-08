/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.Reporte;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface ReporteDao {
    List<Reporte> getAllReportes();
    Reporte getReporteByIdReporte(String idReporte);
    void saveReporte(Reporte reporte);
    void deleteReporte(Reporte reporte);
}
