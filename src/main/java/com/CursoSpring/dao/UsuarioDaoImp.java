package com.CursoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CursoSpring.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository //Acceso al repositorio de la base de datos
@Transactional //Consultas sql
public class UsuarioDaoImp implements UsuariosDao{

    @PersistenceContext
    private EntityManager entityManager; //Conexión a la base de datos

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario"; //Consulta a hibernate // "Usuario" hace referencia al nombre de la calse que tenémos en el proyecto "models/Usuario.java"
        return entityManager.createQuery(query).getResultList(); 
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);

        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
    
}
