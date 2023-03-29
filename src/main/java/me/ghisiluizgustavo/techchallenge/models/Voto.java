package me.ghisiluizgustavo.techchallenge.model;

import jakarta.persistence.*;
import lombok.Data;
import me.ghisiluizgustavo.techchallenge.model.enums.VotoEnum;

@Entity
@Data
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VotoEnum voto;

    @ManyToOne
    private Associado idAssociado;
}
