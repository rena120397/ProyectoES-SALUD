package procesos;
import java.util.ArrayList;
import modelo.cita;
import modelo.login;
import modelo.perfil;
public interface icitas {   
    public ArrayList listarDoctores();
    public ArrayList listarcitas();   
    public perfil validacion(login lo);
    public int procita(cita ci);
    public ArrayList listarhistorial(perfil per);
    public int disminuircupo(String c);
    public int valida_replica(perfil per);
}
