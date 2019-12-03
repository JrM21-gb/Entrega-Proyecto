
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.MySQL;



public class Usuario {
    private int id_usuario;
    private String apodo;
    private String clave;
    private int vigente;
    
    public Usuario() {
        
    }
    
    public static boolean conectar(String usuario, String clave) {
        boolean valido = false;
        MySQL sql = new MySQL();
        String query = "SELECT * FROM usuario WHERE";
        query += " apodo = '" + usuario + "'";
        query += " AND clave = '" + clave + "'";
        
        try {
            Statement s = sql.conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            int filas = 0;
            while(rs.next()){
                filas++;
            }
            if (filas == 1) {
                valido = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }
} 
