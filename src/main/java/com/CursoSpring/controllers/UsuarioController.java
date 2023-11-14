package com.CursoSpring.controllers;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CursoSpring.dao.UsuariosDao;
import com.CursoSpring.models.Usuario;

@RestController
public class UsuarioController {

    //Inyección de Dependencias "@Autowired"
    @Autowired //Trae datos de la clase UsuarioDao("un copiar") //No es el significado real
    private UsuariosDao usuariosDao;
    
    @RequestMapping(value= "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Alexis");        
        usuario.setApellido("Aguilar");
        usuario.setEmail("alexis@gmail.com");
        usuario.setPassword("123456");
        usuario.setTelefono("0976254");
        
        return usuario;
    }

    @RequestMapping(value= "api/usuarios/", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuariosDao.getUsuarios();
    }

    @RequestMapping(value= "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuariosDao.eliminar(id);
    }

    @RequestMapping(value= "api/usuarios/", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuariosDao.registrar(usuario);
    }

}
