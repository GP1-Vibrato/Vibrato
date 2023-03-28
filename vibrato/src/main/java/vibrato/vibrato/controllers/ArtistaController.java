package vibrato.vibrato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vibrato.vibrato.repositories.ArtistaRepository;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.services.ArtistaService;

import java.util.List;

public class ArtistaController {

    private ArtistaService artistaService;
    public ArtistaController(ArtistaService artistaService){
        this.artistaService = artistaService;

    }
    @PostMapping
    public ResponseEntity<Artista> criarArtista(
            @RequestBody Artista novoArtista) {
        return ResponseEntity.status(201).body(artistaService.addArtista(novoArtista));
    }

    @GetMapping
    public ResponseEntity<List<Artista>> listar() {
        List<Artista> artistas = artistaService.listarArtista();

        if (artistas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(artistaService.listarArtista());
    }

}