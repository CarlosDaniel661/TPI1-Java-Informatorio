package ar.com.eventos.service.chef.impl;

import java.util.HashMap;
import java.util.Map;

import ar.com.eventos.domain.Chef;
import ar.com.eventos.domain.Evento;
import ar.com.eventos.service.chef.ChefInterface;

public class ChefService implements ChefInterface {
    
    private Map<Integer, Chef> chefs = new HashMap<>();

    public ChefService() {
        chefs.put(1, new Chef(1, "Victor Molinas", "Cocina Regional", null));
        chefs.put(2, new Chef(2, "Rigo Vargas", "Cocina Light", null));


    }

    @Override
    public Chef obtenerChefPorId(int id) {
        return chefs.get(id);

    }

    @Override
    public void agregarChef(Chef chef) {
        chefs.put(chef.getId(), chef);

    }

    @Override
    public void asignarEventoAChef(Chef chef, Evento evento) {
        chef.getEventos().add(evento);

    }

}

    