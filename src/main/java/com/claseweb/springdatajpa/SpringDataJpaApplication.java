package com.claseweb.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);

    }

    @Autowired
    private EquipRepository equipoRepository;

    @Override
    public void run(String... args) throws Exception {

//        Equipo equipo = new Equipo("Patriotas (Sogamoso Heroes)",0);
//
//        Jugador j1 = new Jugador("Ferchita","Ortiz","69","Defensa",21);
//        Jugador j2 = new Jugador("Guacaname","El profe","420","Delantero",21);
//
//        equipo.getJugadores().add(j1);
//        equipo.getJugadores().add(j2);
//
//        this.equipoRepository.save(equipo);

        List<Equipo> lista = this.equipoRepository.findAll();

        lista.stream().forEach(element -> System.out.println(element.getNombre() + element.getCopas_internacionales()));
    }
}
