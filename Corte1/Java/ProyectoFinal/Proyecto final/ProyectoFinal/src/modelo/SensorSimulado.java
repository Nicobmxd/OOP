package modelo;

import java.util.Random;

public abstract class SensorSimulado {

    private String id;
    private String tipo;
    private String unidad;

    private Random random;

    public SensorSimulado(String id,
                          String tipo,
                          String unidad) {

        this.id = id;
        this.tipo = tipo;
        this.unidad = unidad;

        random = new Random();
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUnidad() {
        return unidad;
    }

    protected double aleatorio(double min,
                               double max) {

        return min + (max - min) * random.nextDouble();
    }

    public Medicion generarMedicion() {

        double valor = generarValor();

        return new Medicion(
                id,
                tipo,
                valor,
                unidad,
                evaluarEstado(valor)
        );
    }

    protected abstract double generarValor();

    public abstract String evaluarEstado(double valor);
}