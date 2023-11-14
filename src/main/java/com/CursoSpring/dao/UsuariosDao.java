package com.CursoSpring.dao;

import java.util.List;

import com.CursoSpring.models.Usuario;

public interface UsuariosDao {

    List<Usuario> getUsuarios();
    
    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarEmailPassword(Usuario usuario);
}
