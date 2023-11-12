package com.CursoSpring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CursoSpring.models.Usuario;

@RestController
public class UsuarioController {
    
    @RequestMapping(value= "usuario/{id}")
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

    @RequestMapping(value= "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(11L);
        usuario.setNombre("Alexis");        
        usuario.setApellido("Aguilar");
        usuario.setEmail("alexis@gmail.com");
        usuario.setPassword("123456");
        usuario.setTelefono("0971216254");

        Usuario usuario2 = new Usuario();
        usuario2.setId(22L);
        usuario2.setNombre("Ruben");        
        usuario2.setApellido("Aguilar");
        usuario2.setEmail("alexis@gmail.com");
        usuario2.setPassword("12351456");
        usuario2.setTelefono("097416254");

        Usuario usuario3 = new Usuario();
        usuario3.setId(33L);
        usuario3.setNombre("Gonzalez");        
        usuario3.setApellido("Aguilar");
        usuario3.setEmail("alexiss@gmail.com");
        usuario3.setPassword("123455156");
        usuario3.setTelefono("097625154");
        
        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }
}
