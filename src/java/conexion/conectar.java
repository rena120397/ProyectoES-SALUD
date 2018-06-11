package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
public class conectar 
{
    String url="jdbc:oracle:thin:@localhost:1521:XE";
    String user="usuario";
    String clave="root";
    
    public Connection getConnection()
    {
        Connection conn=null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, user, clave);
            conn.setAutoCommit(true);
        
        }catch(Exception e){
            
            System.out.println("No se pudo generar la conexión. Mensaje:" + e.getMessage());
        }
        return conn;
    }
}
