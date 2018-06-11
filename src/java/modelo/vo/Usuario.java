package app.modelo.vo;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Usuario {
     String ID_USU;
     String NOMBRE;
     String CONTRA;
     int ID_PERFIL;

    public String getID_USU() {
        return ID_USU;
    }

    public void setID_USU(String ID_USU) {
        this.ID_USU = ID_USU;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCONTRA() {
        return CONTRA;
    }

    public void setCONTRA(String CONTRA) {
        this.CONTRA = CONTRA;
    }

    public int getID_PERFIL() {
        return ID_PERFIL;
    }

    public void setID_PERFIL(int ID_PERFIL) {
        this.ID_PERFIL = ID_PERFIL;
    }
    
    

    
}
