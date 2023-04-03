package me.ghisiluizgustavo.techchallenge.repositories;

import me.ghisiluizgustavo.techchallenge.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
}
