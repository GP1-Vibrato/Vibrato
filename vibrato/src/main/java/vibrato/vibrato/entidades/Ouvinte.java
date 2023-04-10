package vibrato.vibrato.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "ouvinte")
public class Ouvinte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOuvinte")
    private Long idOuvinte;
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "senha")
    private String senha;
    @Email
    @NotBlank
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;

    private Boolean isLogado;

    public Boolean getLogado() { return isLogado;}

    public void setLogado(Boolean logado) { isLogado = logado;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdOuvinte() {
        return idOuvinte;
    }

    public void setIdOuvinte(Long idOuvinte) {
        this.idOuvinte = idOuvinte;
    }




}
