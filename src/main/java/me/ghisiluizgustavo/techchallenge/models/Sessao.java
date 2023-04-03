package me.ghisiluizgustavo.techchallenge.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusEnum;

import java.time.LocalTime;

@Entity
@Data
@ToString
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime duracao = LocalTime.of(0, 1);

    private LocalTime dataFinal;

    @ManyToOne()
    @JoinColumn(name = "id_pauta", referencedColumnName = "id")
    private Pauta pauta;

    private StatusEnum status = StatusEnum.ABERTA;
}