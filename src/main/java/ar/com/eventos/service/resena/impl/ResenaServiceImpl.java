package ar.com.eventos.service.resena.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Resena;
import ar.com.eventos.service.resena.ResenaInterface;

public class ResenaServiceImpl implements ResenaInterface {

    @Override
    public void agregarResena(Resena resena){
        resenas.add(resena);
        System.out.println("Reseña creada: " + resena.getComentario());
    }
    private List<Resena> resenas =new ArrayList<>();
    
    public List<Resena> obtenerResenas() {
        return resenas;
    }

    @Override
   public List<Resena> obtenerResenasPorEvento(Evento evento) {
        return resenas.stream()
                      .filter(resena -> resena.getEvento().equals(evento))
                      .toList();
    }

    @Override
    public void crearResena(Resena resena) {
        agregarResena(resena);
    }
}
