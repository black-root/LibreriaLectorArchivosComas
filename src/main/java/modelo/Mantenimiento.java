package modelo;

import java.io.Serializable;
import java.util.Objects;


public class Mantenimiento implements Serializable{

    private static final long serialVersionUID = 1L;

    private int idMantenimiento;
    private String Encargado;
    private String historico; // no especifica el historico el pdf de ejemplos
    private String numeroInventario;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private String os;
    private boolean licencia;
    private String version;
    private String observaciones;

    public Mantenimiento(){}

    public Mantenimiento(int idMantenimiento, String historico, String numeroInventario, String marca,
                         String numeroSerie, String modelo, String Encargado,
                         String os, String version, boolean licencia,  String observaciones) {
        this.idMantenimiento = idMantenimiento;
        this.Encargado = Encargado;
        this.historico = historico;
        this.numeroInventario = numeroInventario;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.os = os;
        this.licencia = licencia;
        this.version = version;
        this.observaciones = observaciones;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getEncargado() {
        return Encargado;
    }

    public void setEncargado(String idEncargado) {
        this.Encargado = idEncargado;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public boolean isLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    //estos metodos sirven para comparar en la clase MantenimientoService
    //Hace posible que dos instancias que sean iguales si y solo si los ID sean iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mantenimiento)) return false;
        Mantenimiento that = (Mantenimiento) o;
        return getIdMantenimiento() == that.getIdMantenimiento();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdMantenimiento());
    }
}
