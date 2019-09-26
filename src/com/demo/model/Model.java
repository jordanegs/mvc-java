package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Model {
    
    protected static boolean loginRest(Usuario usuario){
        try {
            URL url = new URL ("http://localhost:3000/api/login");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{\"email\":\""+ usuario.getEmail() +"\",\"contrasena\":\""+ usuario.getContraseña() +"\"}";
            
            OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return true;
            
        } catch (MalformedURLException | ProtocolException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    protected static boolean logupRest(Usuario usuario){
        try {
            URL url = new URL ("http://localhost:3000/api/register");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{"
                    + "\"nombres\":\""+ usuario.getNombres()
                    + "\",\"apellidos\":\""+ usuario.getApellidos()
                    + "\",\"email\":\""+ usuario.getEmail()
                    + "\",\"contrasena\":\""+ usuario.getContraseña() 
                    +"\"}";
            OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return true;
            
        } catch (MalformedURLException | ProtocolException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    protected static long resetRest(Usuario usuario){
        try {
            URL url = new URL ("http://localhost:3000/api/reset");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("PUT");
            //con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{"
                    + "\"email\":\""+ usuario.getEmail()
                    + "\",\"contrasena\":\""+ usuario.getContraseña() 
                    +"\"}";
            OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return 1;
            
        } catch (MalformedURLException | ProtocolException ex) {
            return -1;
        } catch (IOException ex) {
            return -1;
        }
    }
}
