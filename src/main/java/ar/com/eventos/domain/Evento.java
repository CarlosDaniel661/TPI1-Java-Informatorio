package ar.com.eventos.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Evento {
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private int capacidad;
    private Chef chef;
    private List<Participante> inscritos;
    public Evento(int id, String nombre, String descripcion, LocalDateTime fechaHora, String ubicacion, int capacidad,
            Chef chef, List<Participante> inscritos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.chef = chef;
        this.inscritos = new ArrayList<>();
    }
    public Evento(int i, String nombre2, String descripcion2, LocalDateTime fechaHora2, String ubicacion2,
            int capacidad2, Chef chef2) {
        
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Chef getChef() {
        return chef;
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }
    public List<Participante> getParticipantes() {
        return inscritos;
    }
    public void setParticipantes(List<Participante> inscritos) {
        this.inscritos = inscritos;
    }
    public int getInscritos() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getInscritos'");
    }
    public void setInscritos(int i) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setInscritos'");
    }
    public void addParticipante(Participante participante) {
        
        throw new UnsupportedOperationException("Unimplemented method 'addParticipante'");
    }

    


}
    
    
    