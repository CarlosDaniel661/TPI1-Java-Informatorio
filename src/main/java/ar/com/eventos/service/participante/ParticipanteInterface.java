package ar.com.eventos.service.participante;

import ar.com.eventos.domain.Participante;


public interface ParticipanteInterface {

    void registrarParticipante(Participante participante);

    Participante obtenerParticipantePorNombreYApellido(String nombreParticipante, String apellidoParticipante);


}
