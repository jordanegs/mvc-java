package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Model {
    static final String pathDB = "./db.txt";
    
    static long actualizarContraseña(Usuario user){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        File file = new File(pathDB);
        
        usuarios = traerUsuarios();
        file.delete();
        
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(user.getEmail())) {
                usuario.setContraseña(user.getContraseña());
            }
            crearUsuario(usuario);
        }
        
        return 1;
    }
    
    static boolean crearUsuario(Usuario user) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(pathDB, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(user.getId().toString() + "," + user.getNombres()
                + "," + user.getApellidos()+ "," + user.getEmail()+ ","
                + user.getContraseña()+ "," + user.getTipo()+ "\n");
            bfwriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    static ArrayList<Usuario> traerUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        File file = new File(pathDB);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);			
                    delimitar.useDelimiter("\\s*,\\s*");
                    Usuario u= new Usuario();
                    u.setId(UUID.fromString(delimitar.next()));
                    u.setNombres(delimitar.next());
                    u.setApellidos(delimitar.next());
                    u.setEmail(delimitar.next());
                    u.setContraseña(delimitar.next());
                    u.setTipo(Integer.parseInt(delimitar.next()));
                    usuarios.add(u);
            }
            scanner.close();
            return usuarios;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    
    static boolean validarUsuario(Usuario user, boolean pass){
        File file = new File(pathDB);
        Scanner scanner;
        boolean valid = false;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);			
                    delimitar.useDelimiter("\\s*,\\s*");
                    Usuario u = new Usuario();
                    u.setId(UUID.fromString(delimitar.next()));
                    u.setNombres(delimitar.next());
                    u.setApellidos(delimitar.next());
                    u.setEmail(delimitar.next());
                    u.setContraseña(delimitar.next());
                    u.setTipo(Integer.parseInt(delimitar.next()));
                    if(pass) {
                        if(u.getEmail().equals(user.getEmail()) && u.getContraseña().equals(user.getContraseña())) {
                            valid = true;
                        }
                    } else {
                        if(u.getEmail().equals(user.getEmail())) {
                            valid = true;
                        }
                    }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return valid;
        }
        return valid;
    }
}
