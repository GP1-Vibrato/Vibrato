package vibrato.vibrato.api.configuration.security.services.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vibrato.vibrato.dominio.entidades.Ouvinte;

import java.util.Collection;

public class OuvinteDetalhesDto implements UserDetails{
    private final String email;
    private final String nome;
    private final String senha;


    public OuvinteDetalhesDto(Ouvinte ouvinte) {
        this.email = ouvinte.getEmail();
        this.nome = ouvinte.getNome();
        this.senha = ouvinte.getSenha();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }
    @Override
    public String getPassword(){
        return senha;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
}
