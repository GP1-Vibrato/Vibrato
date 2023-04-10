package vibrato.vibrato.entidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.entidades.Ouvinte;

import java.util.Optional;
@Repository
public interface OuvinteRepository extends JpaRepository<Ouvinte,Long> {
    Optional<Ouvinte> findByEmail(String email);
}
