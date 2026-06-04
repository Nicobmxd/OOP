package modelo;

import java.util.Locale;

public class Medicion {

    private String idSensor;
    private String tipoSensor;
    private double valor;
    private String unidad;
    private String estado;

    public Medicion(String idSensor, String tipoSensor,
                     double valor, String unidad, String estado) {

        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.valor = valor;
        this.unidad = unidad;
        this.estado = estado;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String valorComoTexto() {
        return String.format(Locale.US, "%.2f", valor);
    }

    public String toMensajeSocket() {
        return idSensor + ";" +
               tipoSensor + ";" +
               valorComoTexto() + ";" +
               unidad;
    }
}