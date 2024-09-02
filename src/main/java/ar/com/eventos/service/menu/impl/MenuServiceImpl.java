package ar.com.eventos.service.menu.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import ar.com.eventos.domain.Chef;
import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resena;
import ar.com.eventos.service.chef.ChefInterface;
import ar.com.eventos.service.evento.EventoInterface;
import java.util.Scanner;
import java.util.UUID;

import ar.com.eventos.service.menu.MenuServiceInterface;
import ar.com.eventos.service.participante.ParticipanteInterface;
import ar.com.eventos.service.resena.ResenaInterface;
import ar.com.eventos.utils.Exporter.Exporter;

public class MenuServiceImpl implements MenuServiceInterface {

    private EventoInterface eventoService;
    private ParticipanteInterface participanteService;
    private ChefInterface chefService;
    private ResenaInterface resenaService;

    public MenuServiceImpl(EventoInterface eventoService, ParticipanteInterface participanteService, ChefInterface chefService, ResenaInterface resenaService) {
        this.eventoService = eventoService;
        this.participanteService =participanteService;
        this.chefService = chefService;
        this.resenaService = resenaService;

    }

    
    @Override
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menú de Gestión de Eventos ===");
            System.out.println("1. Crear un nuevo evento");
            System.out.println("2. Inscribir un participante a un evento");
            System.out.println("3. Listar eventos disponibles");
            System.out.println("4. Exportar eventos llenos");
            System.out.println("5. Dejar una reseña para un evento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearEvento(scanner);
                    break;
                case 2:
                    inscribirParticipante(scanner);
                    break;
                case 3:
                    listarEventosDisponibles(scanner);
                    break;
                case 4:
                    exportarEventosNoDisponibles(scanner);
                    break;
                case 5:
                    dejarResena(scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo del sistema..");
                    break;            
                default:
                    System.out.println("Opción no válida. Intente nuevamente");

            }
        }
        scanner.close();
    }

    private void crearEvento(Scanner scanner) {
        System.out.print("Nombre del evento: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripcion del evento: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha y Hora del evento (AAAA-MM-DD HH:MM): ");
        String fechaHoraStr = scanner.nextLine();
        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm"));
        System.out.print("Ubicación del evento: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Capacidad máxima del evento: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        Chef chef = chefService.obtenerChefPorId(1);

        Evento evento = new Evento(0, nombre, descripcion, fechaHora, ubicacion, capacidad, chef);
        eventoService.crearEvento(evento);
        System.out.println("Evento creado exitosamente.");
        
    }

    private void inscribirParticipante(Scanner scanner) {
        System.out.print("ID del evento: ");
        int idEvento = scanner.nextInt();
        scanner.nextLine();

        Evento evento = eventoService.obtenerEventoPorId(idEvento);

        if (evento == null) {
            System.out.println("Evento no encontrado.");
            return;
        }

        System.out.print("Nombre del participante: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del parcipante: ");
        String apellido = scanner.nextLine();
        System.out.print("Intereses culinarios del participante: ");
        String intereses = scanner.nextLine();

        Participante participante = new Participante(0, nombre, apellido, intereses);
        boolean inscrito = eventoService.inscribirParticipante(evento, participante);

        if (inscrito) {
            System.out.println("Participante inscrto de manera exitosa.");
            
        }else {
            System.out.println("No se pudo inscribir al participante, el evento está lleno.");

        }
    }

    private void listarEventosDisponibles(Scanner scanner) {
        System.out.print("Ingrese la fecha a partir de la cual listar los eventos (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.parse(fechaStr + "T00:00:00");

        List<Evento> eventos = eventoService.listarEventosDisponibles(fecha);
        System.out.print("Eventos disponibles:");
        for (Evento evento : eventos) {
            System.out.println("- " + evento.getNombre() + " (Capacidad: " + evento.getCapacidad() + ")");

        }
    }

    private void exportarEventosNoDisponibles(Scanner scanner) {
        System.out.print("Ingrese la fecha a partir de la cual exportar (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.parse(fechaStr + "T00:00:00");

        List<Evento> eventosNoDisponibles = eventoService.listarEventosNoDisponibles(fecha);
        if (!eventosNoDisponibles.isEmpty()) {
            Exporter. exportarEventosNoDisponibles(eventosNoDisponibles, "eventosNoDisponibles.csv");
            System.out.println("Eventos no disponibles exportados a 'eventosNoDisponibles.csv'.");

        }else {
            System.out.println("No hay eventos llenos para exportar.");

        }
    }
    private void dejarResena(Scanner scanner) {
        System.out.print("ID del evento para dejar reseña: ");
        int idEvento = scanner.nextInt();
        scanner.nextLine();

        Evento evento = eventoService.obtenerEventoPorId(idEvento);

        if (evento == null) {
            System.out.println("Evento no encontrado.");
            return;
        }

        System.out.print("Nombre del participante: ");
        String nombreParticipante = scanner.nextLine();
        System.out.print("Apellido del participante: ");
        String apellidoParticipante = scanner.nextLine();
        System.out.print("Calificación del evento (1 a 5): ");
        int calificacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Reseña del evento: ");
        String comentario = scanner.nextLine();

        Participante participante = participanteService.obtenerParticipantePorNombreYApellido(nombreParticipante, apellidoParticipante);

        if (participante == null) {
            System.out.println("Participante no encontrado.");
            return;
        }

        String id = UUID.randomUUID().toString();
        Resena resena = new Resena(id, evento, participante, calificacion, comentario);
        resenaService.crearResena(resena);
        System.out.println("Reseña dejada exitosamente.");
    }

}






    