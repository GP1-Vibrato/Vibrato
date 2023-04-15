package vibrato.vibrato.api.configuration.security;

import jakarta.security.auth.message.AuthException;
import jakarta.security.auth.message.config.AuthConfigProvider;
import jakarta.security.auth.message.config.ServerAuthConfig;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import vibrato.vibrato.services.autenticacao.ArtistaAutenticacaoService;

import javax.security.auth.callback.CallbackHandler;

public class ArtistaAutenticacaoProvider implements AuthenticationProvider {
    private final ArtistaAutenticacaoService artistaAutenticacaoService;
    private final PasswordEncoder passwordEncoder;

    public ArtistaAutenticacaoProvider(ArtistaAutenticacaoService artistaAutenticacaoService,
                                       PasswordEncoder passwordEncoder){
        this.artistaAutenticacaoService = artistaAutenticacaoService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException{
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        UserDetails userDetails = this.artistaAutenticacaoService.loadUserByUsername(username);

        if (this.passwordEncoder.matches(password,userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }else{
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }
    }

}
