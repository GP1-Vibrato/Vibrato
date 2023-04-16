package vibrato.vibrato.api.configuration.security.services.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vibrato.vibrato.api.configuration.security.services.dto.ArtistaDetalhesDto;
import vibrato.vibrato.api.configuration.security.services.dto.ArtistaTokenDto;
import vibrato.vibrato.dominio.entidades.Artista;
import vibrato.vibrato.dominio.entidades.repositories.ArtistaRepository;

import java.util.Optional;
@Component
public class ArtistaAutenticacaoService  implements UserDetailsService {
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Artista> artistaOpt = artistaRepository.findByEmail(username);
        if (artistaOpt.isEmpty()) {
            throw new UsernameNotFoundException(String.format("usuario: %s não encontrado", username));
        }
        return new ArtistaDetalhesDto(artistaOpt.get());
    }

    public static ArtistaTokenDto of(Artista artista, String token) {
        ArtistaTokenDto artistaTokenDto = new ArtistaTokenDto();

        artistaTokenDto.setUserId(artista.getIdArtista());
        artistaTokenDto.setEmail(artista.getEmail());
        artistaTokenDto.setNome(artista.getNome());
        artistaTokenDto.setToken(token);

        return artistaTokenDto;
    }
}
