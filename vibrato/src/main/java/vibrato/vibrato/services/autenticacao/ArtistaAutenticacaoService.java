package vibrato.vibrato.services.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.entidades.repositories.ArtistaRepository;
import vibrato.vibrato.services.autenticacao.dto.ArtistaDetalhesDto;
import vibrato.vibrato.services.autenticacao.dto.ArtistaTokenDto;

import java.util.Optional;

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
