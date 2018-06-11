package modelo;
import java.sql.Date;
public class perfil {
    private String nombre;
    private int edad;
    private Date nfecha;
    private Date ufecha;
    private String direccion;
    private String ndocum;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getUfecha() {
        return ufecha;
    }

    public void setUfecha(Date ufecha) {
        this.ufecha = ufecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getNfecha() {
        return nfecha;
    }

    public void setNfecha(Date nfecha) {
        this.nfecha = nfecha;
    }

    public String getNdocum() {
        return ndocum;
    }

    public void setNdocum(String ndocum) {
        this.ndocum = ndocum;
    }
}