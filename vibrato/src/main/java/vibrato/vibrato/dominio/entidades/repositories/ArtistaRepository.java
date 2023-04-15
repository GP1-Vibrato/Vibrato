package vibrato.vibrato.dominio.entidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vibrato.vibrato.dominio.entidades.Artista;

import java.util.Optional;
@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByEmail(String email);
}
