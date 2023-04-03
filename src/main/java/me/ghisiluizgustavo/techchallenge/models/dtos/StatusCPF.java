package me.ghisiluizgustavo.techchallenge.models.dtos;

import lombok.Data;
import lombok.ToString;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusAssociadoEnum;

@Data
@ToString
public class StatusCPF {
    private StatusAssociadoEnum status;
}
