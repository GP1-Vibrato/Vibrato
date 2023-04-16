package vibrato.vibrato.api.configuration.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vibrato.vibrato.api.configuration.security.jwt.GerenciadorTokenJwt;
import vibrato.vibrato.dominio.entidades.Artista;
import vibrato.vibrato.dominio.entidades.repositories.ArtistaRepository;
import vibrato.vibrato.api.configuration.security.services.autenticacao.ArtistaAutenticacaoService;
import vibrato.vibrato.api.configuration.security.services.dto.ArtistaLoginDto;
import vibrato.vibrato.api.configuration.security.services.dto.ArtistaTokenDto;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;


    public ArtistaTokenDto autenticarArtista(ArtistaLoginDto artistaLoginDto){
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                artistaLoginDto.getEmail(), artistaLoginDto.getSenha());
        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Artista artistaAutenticado = artistaRepository.findByEmail(artistaLoginDto.getEmail())
                .orElseThrow(
                        () -> new ResponseStatusException(404, "Email de usuário não cadastrado", null)
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = gerenciadorTokenJwt.generateToken(authentication);
        return ArtistaAutenticacaoService.of(artistaAutenticado, token);
    }

    public ArtistaService(ArtistaRepository artistaRepository){
        this.artistaRepository = artistaRepository;
    }
    public List<Artista> listarArtista(){
        List<Artista> lista = artistaRepository.findAll();
        return lista;
    }

    public Artista getById(Long id){
        Artista artistaBanco = artistaRepository.getById(id);
        return artistaBanco;
    }

    public Artista addArtista(Artista novoArtista){

        String senhaCriptografada = passwordEncoder.encode(novoArtista.getSenha());
        novoArtista.setSenha(senhaCriptografada);

        Artista artistaBanco = artistaRepository.save(novoArtista);

        return artistaBanco;
    }

    public Artista getLogin(Artista loginArtista){
        List<Artista> loginLista = artistaRepository.findAll();
        for (Artista a: loginLista) {
            if (a.getEmail().equals(loginArtista.getEmail())){
                return a;
            }
        }
        return null;
    }

}
