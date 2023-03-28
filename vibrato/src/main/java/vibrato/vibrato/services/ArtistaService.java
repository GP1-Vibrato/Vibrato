package vibrato.vibrato.services;


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

    public Artista addArtista(Artista novoOuvinte){
        Artista artistaBanco = artistaRepository.save(novoOuvinte);
        return artistaBanco;
    }



}
