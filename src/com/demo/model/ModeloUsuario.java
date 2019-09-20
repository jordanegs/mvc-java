package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ModeloUsuario extends Model {
    
    static public boolean logIn(Usuario user){
        boolean band;
        band = user.getEmail().compareTo("jordan@gmail.com") == 0 && user.getContraseña().compareTo("123456") == 0;
        return band;
    }
    
    static public long logUp(Usuario user){
        long status = 0;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("C:\\db\\usuarios.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(user.getId().toString() + ", " + user.getNombres() + ""  + "\n");
            bfwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(user);
        return status;
    }
    
    static public long recuperarClave(Usuario user){
        long status = 0;
        System.out.println(user);
        return status;
    }
}