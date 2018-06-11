package modelo.adm;


import app.modelo.db.Conecta;
import app.modelo.vo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class UsuarioAdm {
    public ArrayList<Usuario> getListaUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        Conecta conecta = new Conecta();
        
        try {
            Connection conn = conecta.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_USU, NOMBRE, CONTRA, ID_PERFIL FROM USU");
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setID_USU(rs.getString(1));
                usu.setNOMBRE(rs.getString(2));
                usu.setCONTRA(rs.getString(3));
                usu.setID_PERFIL(rs.getInt(4));

                listaUsuarios.add(usu);
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println("Se conecto a la bd");
        } catch (Exception e) {
                System.out.println("No se pudo obtener los registros de usuarios de la base de datos. Mensaje: "+ e.getMessage());
        }
        
        return listaUsuarios;
    }
    
    
    public int registrarUsuario(Usuario usu){
        int result = 0;
        Conecta conecta = new Conecta();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("INSERT INTO USU "+
                "VALUES (?,?,?,?)");
                ps.setString(1, usu.getID_USU());
                ps.setString(2, usu.getNOMBRE());
                ps.setString(3, usu.getCONTRA());
                ps.setInt(4, usu.getID_PERFIL());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }

    public int eliminarUsuario(Usuario usu) {
         int result = 0;
        Conecta conecta = new Conecta();
        Connection conn = conecta.getConnection();
        try {
            PreparedStatement ps = 
                conn.prepareStatement("DELETE FROM USU WHERE ID_USU = ?");
                ps.setString(1, usu.getID_USU());
                
                result = ps.executeUpdate();
                
                ps.close();
                ps = null;
                conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo Eliminar el registro en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
}

