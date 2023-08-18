package com.claseweb.springdatajpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int copas_internacionales;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre, int copas_internacionales) {
        this.nombre = nombre;
        this.copas_internacionales = copas_internacionales;
    }

    public Equipo() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCopas_internacionales() {
        return copas_internacionales;
    }

    public void setCopas_internacionales(int copas_internacionales) {
        this.copas_internacionales = copas_internacionales;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", copas_internacionales=" + copas_internacionales +
                ", jugadores=" + jugadores +
                '}';
    }
}
