package modelo;

import java.util.Date;

public class MantenimientoHistorialPreventivo {
    private int id;
    private String fecha;
    private String tipoMatto;
    private String obervacionesHardware;
    private String observacionesSoftware;

    public MantenimientoHistorialPreventivo() {
    }

    public MantenimientoHistorialPreventivo(int id, String fecha, String tipoMatto, String obervacionesHardware, String observacionesSoftware) {
        this.id = id;
        this.fecha = fecha;
        this.tipoMatto = tipoMatto;
        this.obervacionesHardware = obervacionesHardware;
        this.observacionesSoftware = observacionesSoftware;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoMatto() {
        return tipoMatto;
    }

    public void setTipoMatto(String tipoMatto) {
        this.tipoMatto = tipoMatto;
    }

    public String getObervacionesHardware() {
        return obervacionesHardware;
    }

    public void setObervacionesHardware(String obervacionesHardware) {
        this.obervacionesHardware = obervacionesHardware;
    }

    public String getObservacionesSoftware() {
        return observacionesSoftware;
    }

    public void setObservacionesSoftware(String observacionesSoftware) {
        this.observacionesSoftware = observacionesSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MantenimientoHistorialPreventivo other = (MantenimientoHistorialPreventivo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


    
}
