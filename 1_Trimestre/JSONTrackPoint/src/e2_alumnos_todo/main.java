package e2_alumnos_todo;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class main {

	public static void main(String[] args) {
		
		//TODO: carga el archivo trail.json

        //TODO: comprueba que la lista no este vacia
       

        //TODO: llama al metodo calcularElevacionMaxMin
        
		//TODO: llama al metodo calcularLaps
		
    }

    // Método para cargar los puntos de seguimiento desde un archivo JSON
    public static List<TrackPoint> cargarTrackPoints(String rutaArchivo) {
        //TODO: completa el metodo
        return null;
    }

    // Método para calcular y mostrar la elevación máxima y mínima
    public static void calcularElevacionMaxMin(List<TrackPoint> trackPoints) {
        double elevacionMaxima = Double.NEGATIVE_INFINITY;
        double elevacionMinima = Double.POSITIVE_INFINITY;

        for (TrackPoint point : trackPoints) {
            if (point.getEle() > elevacionMaxima) {
                elevacionMaxima = point.getEle();
            }
            if (point.getEle() < elevacionMinima) {
                elevacionMinima = point.getEle();
            }
        }

        System.out.printf("Elevación máxima: %.2f metros\n", elevacionMaxima);
        System.out.printf("Elevación mínima: %.2f metros\n", elevacionMinima);
    }

    // Método para calcular las vueltas (laps) de 1000 metros
    public static void calcularLaps(List<TrackPoint> trackPoints) {
        double distanciaAcumulada = 0.0;
        int lapCount = 1;
        TrackPoint lapInicio = trackPoints.get(0);

        for (int i = 1; i < trackPoints.size(); i++) {
            TrackPoint actual = trackPoints.get(i);
            distanciaAcumulada += actual.calcularDistancia(trackPoints.get(i - 1));

            if (distanciaAcumulada >= 1000) {
                long tiempoLap = lapInicio.calcularTiempoEnSegundos(actual);
                Duration duracion = Duration.ofSeconds(tiempoLap);
                long minutos = duracion.toMinutes();
                long segundos = duracion.minusMinutes(minutos).getSeconds();

                System.out.printf("Lap %d: 1000 m efectuada en %02d:%02d\n", lapCount, minutos, segundos);

                // Reiniciar para la siguiente vuelta
                lapInicio = actual;
                lapCount++;
                distanciaAcumulada -= 1000;
            }
        }

        // Imprimir la última vuelta si queda una distancia menor a 1000 m
        if (distanciaAcumulada > 0) {
            long tiempoLap = lapInicio.calcularTiempoEnSegundos(trackPoints.get(trackPoints.size() - 1));
            Duration duracion = Duration.ofSeconds(tiempoLap);
            long minutos = duracion.toMinutes();
            long segundos = duracion.minusMinutes(minutos).getSeconds();

            System.out.printf("Lap %d: %.0f m efectuada en %02d:%02d\n", lapCount, distanciaAcumulada, minutos, segundos);
        }
    }

}
