package modelo;

public class SensorVoltaje extends SensorSimulado {

    public SensorVoltaje(String id) {
        super(id, "VOLTAJE", "V");
    }

    @Override
    protected double generarValor() {
        return aleatorio(9, 12.6);
    }

    @Override
    public String evaluarEstado(double valor) {

        if(valor < 10.5)
            return "BATERIA_BAJA";

        return "NORMAL";
    }
}