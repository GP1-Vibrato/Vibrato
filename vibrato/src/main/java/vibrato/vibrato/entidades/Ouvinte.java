package vibrato.vibrato.entidades;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ouvinte")
public class Ouvinte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOuvinte")
    private Integer idOuvinte;
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

    public Integer getIdOuvinte() {
        return idOuvinte;
    }

    public void setIdOuvinte(Integer idOuvinte) {
        this.idOuvinte = idOuvinte;
    }




}
