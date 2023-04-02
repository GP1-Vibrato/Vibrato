package vibrato.vibrato.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.repositories.ArtistaRepository;

import java.util.List;

@Service
public class ArtistaService {

    private ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository){
        this.artistaRepository = artistaRepository;
    }
    public List<Artista> listarArtista(){
        List<Artista> lista = artistaRepository.findAll();
        return lista;
    }

    public Artista addArtista(Artista novoArtista){
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
