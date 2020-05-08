/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package entidades;

/**
 *
 * @author dagam
 */
public class OrganizacionVinculada {
    private String nombreOrganizacion;
    private String Direccion;
    private String ciudad;
    private String estado;
    private String Sector;
    private String telefonoOrganizacion;
    private String emailOrganizacion;

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String Sector) {
        this.Sector = Sector;
    }

    public String getTelefonoOrganizacion() {
        return telefonoOrganizacion;
    }

    public void setTelefonoOrganizacion(String telefonoOrganizacion) {
        this.telefonoOrganizacion = telefonoOrganizacion;
    }

    public String getEmailOrganizacion() {
        return emailOrganizacion;
    }

    public void setEmailOrganizacion(String emailOrganizacion) {
        this.emailOrganizacion = emailOrganizacion;
    }
}
