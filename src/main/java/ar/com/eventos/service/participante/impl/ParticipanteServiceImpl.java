package ar.com.eventos.service.participante.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.com.eventos.domain.Participante;
import ar.com.eventos.service.participante.ParticipanteInterface;

public class ParticipanteServiceImpl implements ParticipanteInterface{
    private List<Participante> participantes =new ArrayList<>();


    @Override
    public void registrarParticipante(Participante participante) {
        participantes.add(participante);
    }


    @Override
    public Participante obtenerParticipantePorNombreYApellido(String nombreParticipante, String apellidoParticipante) {
        Optional<Participante> participante = participantes.stream()
        .filter(p -> p.getNombre().equals(nombreParticipante) && p.getApellido().equals(apellidoParticipante))
        .findFirst();

    return participante.orElse(null);

    }

}
