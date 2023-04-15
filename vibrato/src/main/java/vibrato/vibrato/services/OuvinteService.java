package vibrato.vibrato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vibrato.vibrato.api.configuration.security.jwt.GerenciadorTokenJwt;
import vibrato.vibrato.dominio.entidades.Ouvinte;
import vibrato.vibrato.dominio.entidades.repositories.OuvinteRepository;
import vibrato.vibrato.services.autenticacao.OuvinteAutenticacaoService;
import vibrato.vibrato.services.dto.OuvinteLoginDto;
import vibrato.vibrato.services.dto.OuvinteTokenDto;

import java.util.List;

@Service
public class OuvinteService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OuvinteRepository ouvinteRepository;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;

    public OuvinteTokenDto autenticarOuvinte(OuvinteLoginDto ouvinteLoginDto){
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                ouvinteLoginDto.getEmail(), ouvinteLoginDto.getSenha());
        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Ouvinte ouvinteAutenticado = ouvinteRepository.findByEmail(ouvinteLoginDto.getEmail())
                .orElseThrow(
                        () -> new ResponseStatusException(404, "Email de usuário não cadastrado", null)
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = gerenciadorTokenJwt.generateToken(authentication);
        return OuvinteAutenticacaoService.of(ouvinteAutenticado, token);
    }

public OuvinteService(OuvinteRepository ouvinteRepository){
    this.ouvinteRepository = ouvinteRepository;
}

public List<Ouvinte> listarOuvinte(){
    List<Ouvinte> lista = ouvinteRepository.findAll();
    return lista;
}

public Ouvinte getById(Long id){
    Ouvinte ouvinteBanco = ouvinteRepository.getById(id);
    return ouvinteBanco;
}

public Ouvinte addOuvinte(Ouvinte novoOuvinte){
    String senhaCriptografada = passwordEncoder.encode(novoOuvinte.getSenha());
    novoOuvinte.setSenha(senhaCriptografada);
    Ouvinte ouvinteBanco = ouvinteRepository.save(novoOuvinte);
    return ouvinteBanco;
}

    public Ouvinte getLogin(Ouvinte loginOuvinte){
        List<Ouvinte> loginLista = ouvinteRepository.findAll();
        for (Ouvinte o: loginLista) {
            if (o.getEmail().equals(loginOuvinte.getEmail())){
                return o;
            }
        }
        return null;
    }
}
