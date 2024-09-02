package ar.com.eventos.utils.Exporter;

import ar.com.eventos.domain.Evento;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Exporter {
    public static void exportarEventosNoDisponibles(List<Evento> eventosLlenos, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Evento evento : eventosLlenos) {
                writer.write(evento.getNombre() + " - " + evento.getFechaHora());
                writer.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
