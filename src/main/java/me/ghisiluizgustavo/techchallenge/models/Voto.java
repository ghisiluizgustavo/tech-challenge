package me.ghisiluizgustavo.techchallenge.models;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;
import me.ghisiluizgustavo.techchallenge.models.enums.VotoEnum;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VotoEnum voto;

    @ManyToOne
    @JoinColumn(name="id_associado", nullable=false)
    private Associado associado;

    @ManyToOne
    @JoinColumn(name="id_pauta", nullable=false)
    private Pauta pauta;

    public Long getIdAssociado(){
        return this.associado.getId();
    }

}
