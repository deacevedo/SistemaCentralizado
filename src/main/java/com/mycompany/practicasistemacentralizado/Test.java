/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicasistemacentralizado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danny
 */
public class Test {
    
    public static void main(String[] args) {
        
        Test t  = new Test();
        
        //t.insertar();
        //t.actualizar(2, "AZUCAR", 33.15);
        t.eliminar(2);

    }
   
    
    public Connection getConexion(){
        Connection conexion = null;
        String servidor = "localhost";
        String puerto = "5432";
        String baseDatos = "SUPERMERCADO";
        String url = "jdbc:postgresql://"+servidor+":"+puerto+"/"+baseDatos;
        String usuario = "postgres";
        String password="Dan.,.123";
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    return conexion;    
    }
    
    public void insertar(){
        Connection conexion = getConexion();
        String sql = "INSERT INTO producto (codigo_producto,nombre_producto,precio_producto) VALUES (3,'ACEITE',12.56);";
        //String sql = "insert into producto values (" + codigo + ",'" + nombre + "','" + precio + "')";
        try (Statement st = conexion.createStatement()) {
            
            //EL executeUpdate ES LA EJECUCIÓN DE LA SENTENCIA
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }   
    
    public void actualizar(int codigo, String nombre, double precio) {
         
        Connection conexion = getConexion();
        
        String sql = "UPDATE producto SET " + "nombre_producto='" + nombre + "'" + ",precio_producto=" + precio + "WHERE codigo_producto=" + codigo;
        try (Statement st = conexion.createStatement()) {
            
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    public void eliminar(int codigo) {
        
        Connection conexion = getConexion();
        
        String sql = "DELETE FROM producto WHERE codigo_producto = " + codigo;
        
        try (Statement st = conexion.createStatement()) 
        {
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }
    
}
