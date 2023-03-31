package vibrato.vibrato.entidades;

import javax.persistence.*;

@Entity
@Table(name ="artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArtista")
    private Integer idArtista;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

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



    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

}
