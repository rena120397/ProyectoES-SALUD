package modelo;
import java.sql.Date;
public class cita {
    private String codcita;
    private String ndocum;
    private String idmedico;
    private String nomedico;
    private String espemedico;
    private Date fecha;
    private Date hinicio1;
    private Date hinicio2;
    private Date hfin1;
    private Date hfin2;
    private int cupo;
    private String visible;
    private String noma;
    
    public String getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(String idmedico) {
        this.idmedico = idmedico;
    }

    public String getNomedico() {
        return nomedico;
    }

    public void setNomedico(String nomedico) {
        this.nomedico = nomedico;
    }

    public String getEspemedico() {
        return espemedico;
    }

    public void setEspemedico(String espemedico) {
        this.espemedico = espemedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHinicio1() {
        return hinicio1;
    }

    public void setHinicio1(Date hinicio1) {
        this.hinicio1 = hinicio1;
    }

    public Date getHinicio2() {
        return hinicio2;
    }

    public void setHinicio2(Date hinicio2) {
        this.hinicio2 = hinicio2;
    }

    public Date getHfin2() {
        return hfin2;
    }

    public void setHfin2(Date hfin2) {
        this.hfin2 = hfin2;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Date getHfin1() {
        return hfin1;
    }

    public void setHfin1(Date hfin1) {
        this.hfin1 = hfin1;
    }

    public String getCodcita() {
        return codcita;
    }

    public void setCodcita(String codcita) {
        this.codcita = codcita;
    }

    public String getNdocum() {
        return ndocum;
    }

    public void setNdocum(String ndocum) {
        this.ndocum = ndocum;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }
    
}