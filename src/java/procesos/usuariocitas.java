package procesos;
import conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.*;
public class usuariocitas implements icitas {//utilizar tabla usu
    
    
    public ArrayList listarDoctores()
    {
       ArrayList<doctor> listadoctor = new ArrayList();
       String sql="select ID_MEDICO, NOM_MEDICO, ESPE_MEDICO from MEDICOS";
       conectar con = new conectar();
       Connection co = con.getConnection();
       
       try
       {
           PreparedStatement pst=null;
           pst = co.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           
           while(rs.next())
           {
               doctor doc=new doctor();
               doc.setIdoctor(rs.getString(1));
               doc.setNombred(rs.getString(2));
               doc.setEspecialidad(rs.getString(3));
               listadoctor.add(doc);
           }
            rs.close();
            pst.close();
            co.close();
            co=null;
       }
       catch(Exception e)
       {
           System.out.println("No se pudo obtener los doctores de la base de datos. Mensaje: "+ e.getMessage());
       }
       return listadoctor;
    }
    
    public ArrayList listarcitas()
    {
        ArrayList<cita> listacita = new ArrayList();
        String sql="select MEDICOS.ID_MEDICO, MEDICOS.NOM_MEDICO, MEDICOS.ESPE_MEDICO, PROG_MEDIC.FECHA, PROG_MEDIC.H_INICIO_1,PROG_MEDIC.H_FIN_1, PROG_MEDIC.H_INICIO_2, PROG_MEDIC.H_FIN_2, CUPO_DISP from MEDICOS\n" +
                    "inner join PROG_MEDIC on MEDICOS.ID_MEDICO = PROG_MEDIC.ID_MEDICO where CUPO_DISP >=1";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst=null;
            pst = co.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                cita ci= new cita();
                ci.setIdmedico(rs.getString(1));
                ci.setNomedico(rs.getString(2));
                ci.setEspemedico(rs.getString(3));
                ci.setFecha(rs.getDate(4));
                ci.setHinicio1(rs.getDate(5));
                ci.setHfin1(rs.getDate(6));
                ci.setHinicio2(rs.getDate(7));
                ci.setHfin2(rs.getDate(8));
                ci.setCupo(rs.getInt(9));
                listacita.add(ci);        
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo obtener las citas de la base de datos. Mensaje: "+ e.getMessage());
        }
        return listacita;
    } 
    
    public perfil validacion(login lo)
    {   perfil per=null;
        String sql="select ESSALUD.HI_NOMBRE, ESSALUD.HI_FECNAC , ESSALUD.HI_DIRECC , ESSALUD.HI_FULTAT, ESSALUD.HI_NDOCUM from ESSALUD \n" +
                    "inner join AFILIADOS on AFILIADOS.HI_NDOCUM = ESSALUD.HI_NDOCUM where ESSALUD.HI_NDOCUM=? and AFILIADOS.HI_CONTRA= ?";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1, lo.getDni());
            pst.setString(2, lo.getPass());
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                per=new perfil();
                per.setNombre(rs.getString(1));
                per.setNfecha(rs.getDate(2));
                per.setDireccion(rs.getString(3));
                per.setUfecha(rs.getDate(4));
                per.setNdocum(rs.getString(5));
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo obtener el perfil de la base de datos. Mensaje: "+ e.getMessage());
        }
        return per;  
    }
    
    public int procita(cita ci)
    {
        int result=0;
        String sql="insert into CITAS (CODCITAS, HI_NDOCUM, ID_MEDICO,VISIBLE) values (?,?,?,?)";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1,generarcodigo("C"));
            ps.setString(2,ci.getNdocum());
            ps.setString(3,ci.getIdmedico());
            ps.setString(4,"t");
            
            result = ps.executeUpdate();
            ps.close();
            ps = null;
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo insertar la cita en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    public ArrayList listarhistorial(perfil per)
    {
        ArrayList<cita> listahistorial=new ArrayList();
        String sql="SELECT * FROM CITASDES where VISIBLE=? and HI_NDOCUM=?";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,"t");
            pst.setString(2, per.getNdocum());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                cita ci = new cita();
                ci.setCodcita(rs.getString(1));
                ci.setNdocum(rs.getString(2));
                ci.setNoma(rs.getString(3));
                ci.setIdmedico(rs.getString(4));
                ci.setNomedico(rs.getString(5));
                ci.setEspemedico(rs.getString(6));
                ci.setFecha(rs.getDate(7));
                listahistorial.add(ci);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)   
        {
            System.out.println("No se pudo listar la cita en la base de datos. Mensaje: "+ e.getMessage());
        }
        return listahistorial;
    }
    public int disminuircupo(String c)
    {   int result=0;
        conectar con = new conectar();
        Connection co = con.getConnection();
        String sql="UPDATE PROG_MEDIC SET CUPO_DISP=CUPO_DISP-1 WHERE ID_MEDICO=? ";
        try
        {
            PreparedStatement ps=co.prepareStatement(sql);
            ps.setString(1,c);
            ps.executeUpdate();
            ps.close();
            ps = null;
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo disminuir el cupo en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
    private String generarcodigo(String c)
    {
        String codigopedido="";
        String codigocoger=null;
        int numerocodigo=0;
        String numerocodigostring="";
        conectar con = new conectar();
        Connection co = con.getConnection();
        String sql="select max(CODCITAS) from CITAS where CODCITAS like ?";
        try
        {
            PreparedStatement pst=null;
            pst = co.prepareStatement(sql);
            pst.setString(1,c+"%");
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                codigocoger=rs.getString(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
        }
        catch(Exception e)
        {
            System.out.println("No se pudo conseguir el registro en la base de datos. Mensaje: "+ e.getMessage());
        }

        if (codigocoger==null)
        {
            codigopedido=c+"00001";
        }
        else
        {
            String[] parte=codigocoger.split(c);
            numerocodigo=Integer.parseInt(parte[1].trim());
            numerocodigo=numerocodigo+1;
            numerocodigostring=numerocodigo+"";
            if(numerocodigostring.length()==1)
            {
                codigopedido=c+"0000"+numerocodigostring;
            }
            else if(numerocodigostring.length()==2)
            {
                codigopedido=c+"000"+numerocodigostring;
            }
            else if(numerocodigostring.length()==3)
            {
                codigopedido=c+"00"+numerocodigostring;
            }
            else if(numerocodigostring.length()==4)
            {
                codigopedido=c+"0"+numerocodigostring;
            }  
            else if(numerocodigostring.length()==5)
            {
                codigopedido=c+""+numerocodigostring;
            }  
        }
        
        return codigopedido;
    }
    
    public int valida_replica(perfil per){
        int result=0;
        String sql="select count(HI_NDOCUM) from citas where HI_NDOCUM=?";
        conectar con = new conectar();
        Connection co = con.getConnection();
        try
        {
            PreparedStatement pst= co.prepareStatement(sql);
            pst.setString(1,per.getNdocum());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                result=rs.getInt(1);
            }
            rs.close();
            pst.close();
            co.close();
            co=null;
            
        }
        catch(Exception e)
        {
            System.out.println("No se pudo contar el registro en la base de datos. Mensaje: "+ e.getMessage());
        }
        return result;
    }
    
}