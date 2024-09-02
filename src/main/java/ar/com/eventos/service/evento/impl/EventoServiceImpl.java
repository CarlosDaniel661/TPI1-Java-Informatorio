package ar.com.eventos.service.evento.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.service.evento.EventoInterface;

public class EventoServiceImpl implements EventoInterface {
   private List<Evento> eventos;
   public EventoServiceImpl() {
    this.eventos =new ArrayList<>();
   }

   @Override
   public void crearEvento(Evento evento) {
    eventos.add(evento);

   }

   @Override
   public boolean inscribirParticipante(Evento evento, Participante participante) {
    if (evento.getInscritos() < evento.getCapacidad()) {
        evento.setInscritos(evento.getInscritos() + 1);
        evento.addParticipante(participante);
        participante.getHistorialEventos().add(evento);
        return true;
    }
    return false;
   }

   @Override
   public List<Evento> listarEventosDisponibles(LocalDateTime fecha) {
    List<Evento> disponibles = new ArrayList<>();
    for (Evento evento : eventos) {
        if (evento.getInscritos() < evento.getCapacidad() && evento.getFechaHora().isAfter(fecha)) {
            disponibles.add(evento);
        }
    }
    return disponibles;
    }


   @Override
   public List<Evento> listarEventosNoDisponibles(LocalDateTime fecha) {
    List<Evento> noDisponibles = new ArrayList<>();
    for (Evento evento : eventos) {
        if (evento.getInscritos() >= evento.getCapacidad() || evento.getFechaHora().isBefore(fecha)) {
            noDisponibles.add(evento);
        }
    }
    return noDisponibles;
    }

    @Override
    public List<Evento> listarEventosLlenos(LocalDateTime fecha) {
        List<Evento> llenos = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getInscritos() >= evento.getCapacidad() && evento.getFechaHora().isAfter(fecha)) {
                llenos.add(evento);
            }
        }
        return llenos;
    }

    @Override
    public Evento obtenerEventoPorId(int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getId() == idEvento) {
                return evento;
            }
        }
        return null;
    }



}