package persistencia;

import modelo.Medicion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CSVManager {

    private final String archivo;

    public CSVManager(String archivo) {
        this.archivo = archivo;
        crearSiNoExiste();
    }

    private void crearSiNoExiste() {
        File file = new File(archivo);

        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {

                writer.write(
                        "fecha,hora,idSensor,tipoSensor,valor,unidad,estado\n"
                );

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void guardar(Medicion medicion) {

        try (FileWriter writer = new FileWriter(archivo, true)) {

            writer.write(
                    LocalDate.now() + "," +
                    LocalTime.now().withNano(0) + "," +
                    medicion.getIdSensor() + "," +
                    medicion.getTipoSensor() + "," +
                    medicion.getValor() + "," +
                    medicion.getUnidad() + "," +
                    medicion.getEstado() + "\n"
            );

        } catch (IOException e) {
            System.out.println("Error guardando CSV");
        }
    }
}