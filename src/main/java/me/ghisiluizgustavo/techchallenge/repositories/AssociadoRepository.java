package me.ghisiluizgustavo.techchallenge.repositories;

import me.ghisiluizgustavo.techchallenge.models.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
