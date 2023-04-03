package me.ghisiluizgustavo.techchallenge.services.feign;

import me.ghisiluizgustavo.techchallenge.models.dtos.StatusCPF;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusAssociadoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "validadorCpf", url = "http://localhost:8081/api/validate-cpf")
public interface ValidadorCpf {

    @GetMapping("/{cpf}")
    StatusCPF validarCpf(@PathVariable String cpf);
}
