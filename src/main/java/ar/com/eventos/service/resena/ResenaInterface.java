package ar.com.eventos.service.resena;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Resena;
import java.util.List;


public interface ResenaInterface {

    void agregarResena(Resena resena);

    List<Resena> obtenerResenasPorEvento(Evento evento);

    void crearResena(Resena resena);

}
