/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author J R M
 */
public class MySQL {
    // Incorporamos la libreria MySQL
    private static String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    private static String database = "almacen";
    // URL del servidor MySQL
    private static String hostname = "localhost";
    // Numero de puerto de conexion
    private static String port = "3306";
    // Usuario de la base de datos
    private static String username = "root";
    // Clave del usuario de la base de datos
    private static String password = "Dancez_2001";
    // URL de conexion final
    private static String connectionURL;
    // Conector
    public static Connection conn;
    private Connection cn;
    
    /**
     * Constructor de la clase ConexionMySQL
     */
    public MySQL(){
        MySQL.connectionURL = "jdbc:mysql://";
        MySQL.connectionURL += hostname + ":" + port + "/" + database;
        MySQL.connectionURL += "?autoReconnect=true&useSSL=false";
        MySQL.getConnection();
    }

    /**
     * Retorna el conector a la base de datos 
     * @return Connection Conector a la base de datos
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(connectionURL, username, password);
            } catch(SQLException e) {
                System.out.print("No se puede conectar: "+e.getMessage());
            }
        } catch(ClassNotFoundException ex) {
            System.out.print("La clase "+driver+" no existe en el sistema");
        }
        return conn;
    } 

   }

