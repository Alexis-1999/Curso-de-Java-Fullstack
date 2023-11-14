package com.CursoSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CursoSpring.dao.UsuariosDao;
import com.CursoSpring.models.Usuario;

@RestController
public class AuthController {

    @Autowired //Trae datos de la clase UsuarioDao("un copiar") //No es el significado real
    private UsuariosDao usuariosDao;

    @RequestMapping(value= "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuariosDao.verificarEmailPassword(usuario)){
            return "OK";
        };
        return "FAIL";
    }
}
