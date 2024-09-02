package ar.com.eventos.service.inscripcion.impl;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;

public class InscripcionManager {
    public boolean inscribirParticipante(Evento evento, Participante participante) {
        if (evento.getCapacidad() > 0) {
            evento.setCapacidad(evento.getCapacidad() - 1);
            participante.getHistorialEventos().add(evento);
            return true;
        }
        return false;

    }
}
