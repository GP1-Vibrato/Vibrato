package vibrato.vibrato.services.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vibrato.vibrato.dominio.entidades.Ouvinte;
import vibrato.vibrato.dominio.entidades.repositories.OuvinteRepository;
import vibrato.vibrato.services.dto.OuvinteDetalhesDto;
import vibrato.vibrato.services.dto.OuvinteTokenDto;

import java.util.Optional;

public class OuvinteAutenticacaoService implements UserDetailsService {
    @Autowired
    private OuvinteRepository ouvinteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Ouvinte> ouvinteOpt = ouvinteRepository.findByEmail(username);
        if (ouvinteOpt.isEmpty()){
            throw new UsernameNotFoundException(String.format("usuario: %s não encontrado", username));
        }
        return new OuvinteDetalhesDto(ouvinteOpt.get());
    }

    public static OuvinteTokenDto of(Ouvinte ouvinte, String token) {
        OuvinteTokenDto ouvinteTokenDto = new OuvinteTokenDto();

        ouvinteTokenDto.setUserId(ouvinte.getIdOuvinte());
        ouvinteTokenDto.setEmail(ouvinte.getEmail());
        ouvinteTokenDto.setNome(ouvinte.getNome());
        ouvinteTokenDto.setToken(token);

        return ouvinteTokenDto;
    }
}
