package modelo;

public class SensorTemperatura extends SensorSimulado {

    public SensorTemperatura(String id) {
        super(id, "TEMPERATURA", "C");
    }

    @Override
    protected double generarValor() {
        return aleatorio(20, 90);
    }

    @Override
    public String evaluarEstado(double valor) {

        if(valor >= 70)
            return "ALERTA";

        return "NORMAL";
    }
}