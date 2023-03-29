package me.ghisiluizgustavo.techchallenge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime duracao = LocalTime.of(0, 1);

    @OneToMany
    private List<Voto> votos;




}
