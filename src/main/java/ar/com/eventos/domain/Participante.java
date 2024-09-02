package ar.com.eventos.domain;
import java.util.ArrayList;
import java.util.List;


public class Participante {
    private String id;
    private String nombre;
    private String apellido;
    private List<String> interesesCulinarios;
    private List<Evento> historialEventos;

    public Participante(String id, String nombre, String apellido, List<String> interesesCulinarios, List<Evento> historialEventos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.interesesCulinarios = interesesCulinarios;
        this.historialEventos = new ArrayList<>();
    }

    public Participante(int i, String nombre2, String apellido2, String intereses) {
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getInteresesCulinarios() {
        return interesesCulinarios;
    }

    public void setInteresesCulinarios(List<String> interesesCulinarios) {
        this.interesesCulinarios = interesesCulinarios;
    }

    public List<Evento> getHistorialEventos() {
        return historialEventos;
    }

    public void setHistorialEventos(List<Evento> historialEventos) {
        this.historialEventos = historialEventos;
    }



    
}