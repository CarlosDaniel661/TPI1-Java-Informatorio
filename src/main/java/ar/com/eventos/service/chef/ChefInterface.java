package ar.com.eventos.service.chef;

import ar.com.eventos.domain.Chef;
import ar.com.eventos.domain.Evento;

public interface ChefInterface {

    void agregarChef(Chef chef);
    void asignarEventoAChef(Chef chef, Evento evento);
    Chef obtenerChefPorId(int id);
    
    
}
