package modelo;

public class SensorDistancia extends SensorSimulado {

    public SensorDistancia(String id) {
        super(id, "DISTANCIA", "m");
    }

    @Override
    protected double generarValor() {
        return aleatorio(0.1, 2.0);
    }

    @Override
    public String evaluarEstado(double valor) {

        if(valor < 0.4)
            return "OBSTACULO_CERCANO";

        return "NORMAL";
    }
}