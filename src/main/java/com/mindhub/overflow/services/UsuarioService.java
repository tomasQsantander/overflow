package com.mindhub.overflow.services;

import com.mindhub.overflow.dtos.UsuarioDTO;
import com.mindhub.overflow.models.Usuario;
import com.mindhub.overflow.repositories.UsuarioRespository;
import com.mindhub.overflow.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    public UsuarioDTO getCurrentUser(HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null){
            return new UsuarioDTO(usuario);
        }

        return null;
    }


    public ResponseUtils logIn(String email, HttpSession session){
        ResponseUtils res = new ResponseUtils(true, 200, "usuario.login.successful");

        Usuario usuario = usuarioRespository.findByEmail(email).orElse(null);

        if (usuario == null){
            res = new ResponseUtils(false, 400, "usuario.login.failure.missingUser");
        }

        if (session.getAttribute("usuario") == null){
            session.setAttribute("usuario", usuario);
        }

        return res;
    }

    public ResponseUtils register(String name, String lastName, String email, HttpSession session){
        ResponseUtils res = new ResponseUtils(true, 200, "usuario.register.successful");

        Usuario usuario = new Usuario(name, lastName, email);

        if(usuarioRespository.findByEmail(email).orElse(null) != null){
            res = new ResponseUtils(false, 400, "usuario.register.failure.alreadyExists");
        }

        session.setAttribute("usuario", usuario);
        usuarioRespository.save(usuario);
        return res;
    }
}
