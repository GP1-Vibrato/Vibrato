package vibrato.vibrato.entidades;

import javax.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArtista")
    private int idArtista;

    @Column(name = "nome", length = 200, nullable = true)
    private String nome;

    @Column(name = "senha",columnDefinition = "TEXT",nullable = true)
    private String senha;

    @Column(name = "email", length = 50, nullable = true)
    private String email;

    @Column(name = "username", length = 200, nullable = true)
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



    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

}
