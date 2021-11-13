package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion 
{
    public static final String URL = "jdbc:mysql://localhost:3306/bd_leantech";
    public static final String usuario = "root";
    public static final String clave = "Medellin2021";
    public static Connection con= null;
    
    public static Connection getConexion()
    {
        try {
            con = DriverManager.getConnection(URL, usuario, clave);
            
            if(con != null)
            {
                System.out.println("--------------------------------------");
                System.out.println("Conexion realizada");
                System.out.println("--------------------------------------");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
