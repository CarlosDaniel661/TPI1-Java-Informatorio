package ar.com.eventos.service.evento;

import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Evento;
import java.time.LocalDateTime;
import java.util.List;


public interface EventoInterface {
    
    void crearEvento(Evento evento);
    boolean inscribirParticipante(Evento evento, Participante participante);
    List<Evento> listarEventosDisponibles(LocalDateTime fecha);
    List<Evento> listarEventosLlenos(LocalDateTime fecha);
    List<Evento> listarEventosNoDisponibles(LocalDateTime fecha);
    Evento obtenerEventoPorId(int idEvento);
    
    
}
