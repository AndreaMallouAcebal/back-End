package com.dawes.security.entity;


import com.dawes.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UsuarioWeb implements UserDetails {

    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private String contrasenia;
    private Collection <? extends GrantedAuthority> authorities;

    public UsuarioWeb(String nombre, String apellidos, String email, String dni, String contrasenia, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.dni = dni;
        this.contrasenia = contrasenia;
        this.authorities = authorities;
    }

    public static UsuarioWeb build(Usuario usuario){
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        return new UsuarioWeb(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getDni(), usuario.getContrasenia(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
