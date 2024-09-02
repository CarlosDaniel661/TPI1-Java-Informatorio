package ar.com.eventos.service.inscripcion;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;

public interface InscripcionInterface {

    boolean inscribirParticipante(Evento evento, Participante participante);
    
}
