/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package datos.dao;

import entidades.OrganizacionVinculada;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface OrganizacionVinculadaDao {
   List<OrganizacionVinculada> getAllOrganizacionesVinculadas();
    OrganizacionVinculada getOrganizacionVinculadaByNombreOrganizacion(String nombreOrganizacion);
    void saveOrganizacionVinculada(OrganizacionVinculada organizacionVinculada);
    void deleteOrganizacionVinculada(OrganizacionVinculada organizacionVinculada); 
}
