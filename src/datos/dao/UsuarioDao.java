/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author dagam
 */
public interface UsuarioDao {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioByMatricula(String matricula);
    void saveUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
}
