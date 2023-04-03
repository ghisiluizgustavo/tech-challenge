package me.ghisiluizgustavo.techchallenge.repositories;

import me.ghisiluizgustavo.techchallenge.models.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
