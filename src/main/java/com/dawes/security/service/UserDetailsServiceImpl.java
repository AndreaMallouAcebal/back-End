package com.dawes.security.service;

import com.dawes.model.Usuario;
import com.dawes.security.entity.UsuarioWeb;
import com.dawes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByEmail(userEmail).get();
        return UsuarioWeb.build(usuario);
    }
}
