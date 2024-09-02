package ar.com.eventos.domain;
import java.util.ArrayList;
import java.util.List;

public class Chef {
    private int id;
    private String nombre;
    private String especialidad;
    private List<Evento> eventos;
    
    
    public Chef(int id, String nombre, String especialidad, List<Evento> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.eventos = new ArrayList<>();

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEspecialidad() {
        return especialidad;
    }


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public List<Evento> getEventos() {
        return eventos;
    }


    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }


    
    
}
