package ar.com.eventos;

import ar.com.eventos.service.chef.ChefInterface;
import ar.com.eventos.service.chef.impl.ChefService;
import ar.com.eventos.service.evento.EventoInterface;
import ar.com.eventos.service.evento.impl.EventoServiceImpl;
import ar.com.eventos.service.menu.MenuServiceInterface;
import ar.com.eventos.service.menu.impl.MenuServiceImpl;
import ar.com.eventos.service.participante.ParticipanteInterface;
import ar.com.eventos.service.participante.impl.ParticipanteServiceImpl;
import ar.com.eventos.service.resena.ResenaInterface;
import ar.com.eventos.service.resena.impl.ResenaServiceImpl;


public class App {
    public static void main(String[] args) {
        EventoInterface eventoService = new EventoServiceImpl();
        ParticipanteInterface participanteService = new ParticipanteServiceImpl();
        ChefInterface chefService = new ChefService();
        ResenaInterface resenaService = new ResenaServiceImpl();
        MenuServiceInterface menuService = new MenuServiceImpl(eventoService, participanteService, chefService, resenaService);


        menuService.mostrarMenu();

    }
}