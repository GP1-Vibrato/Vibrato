package vibrato.vibrato.services.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vibrato.vibrato.dominio.entidades.Artista;

import java.util.Collection;
public class ArtistaDetalhesDto implements UserDetails {
    private final String email;
    private final String nome;
    private final String senha;

    public ArtistaDetalhesDto(Artista artista) {
        this.email = artista.getEmail();
        this.senha = artista.getSenha();
        this.nome = artista.getNome();
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
