package com.demo.model;

import com.demo.model.entity.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    protected static Connection connectDB(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://btrmtxdkndhn9c21wvcu-mysql.services.clever-cloud.com/btrmtxdkndhn9c21wvcu","uif3cxs2nsddrma1","KvPUgvlqmDxSTCzDfg11");
            System.out.println("Conectado correctamente");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar base de datos :(");
        }
        return connection;
    }
    
    protected static boolean registrar(Usuario user){
        String query = "INSERT INTO usuario (id, nombres, apellidos, email, contraseña, tipo)"
            + " values (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connectDB().prepareStatement(query);
            preparedStmt.setString(1, user.getId().toString());
            preparedStmt.setString(2, user.getNombres());
            preparedStmt.setString(3, user.getApellidos());
            preparedStmt.setString(4, user.getEmail());
            preparedStmt.setString(5, user.getContraseña());
            preparedStmt.setInt(6, 1);
            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    protected static boolean validarUsuario(Usuario user, boolean pass){
        String query;
        if(pass) {
            query = "SELECT * FROM usuario WHERE email = ? AND contraseña = ?";
        } else {
            query = "SELECT * FROM usuario WHERE email = ? ";
        }
        PreparedStatement preparedStmt;
        Usuario usuario = new Usuario();
        try {
            preparedStmt = connectDB().prepareStatement(query);
            preparedStmt.setString(1, user.getEmail());
            if(pass) preparedStmt.setString(2, user.getContraseña());
            ResultSet result = preparedStmt.executeQuery();
            int count = 0;
            while(result.next()) {
                count++;
            }
            
            if(count != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    protected static long actualizarContraseña(Usuario user){
        String query = "UPDATE usuario SET contraseña = ? WHERE email = ?";
        try {
            PreparedStatement preparedStmt;
            preparedStmt = connectDB().prepareStatement(query);
            preparedStmt.setString(1, user.getContraseña());
            preparedStmt.setString(2, user.getEmail());
            preparedStmt.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
