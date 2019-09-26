package com.demo.model;

import com.demo.model.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public static List<Usuario> usuarios = new ArrayList<>();
    
    public static boolean register(Usuario usuario) {
        usuarios.add(usuario);
        return true;
    }
    
    public static boolean verifyUser(Usuario usuario) {
        return usuarios.stream().anyMatch((user) -> (user.getEmail().equals(usuario.getEmail()) && user.getContraseña().equals(usuario.getContraseña())));
    }
    
    public static long changePass(Usuario usuario) {
        long status = -1;
        for (Usuario user : usuarios) {
            if(user.getEmail().equals(usuario.getEmail())){
                user.setContraseña(usuario.getContraseña());
                status = 1;
            }
        }
        return status;
    }
}
