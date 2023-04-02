package vibrato.vibrato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vibrato.vibrato.repositories.ArtistaRepository;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.services.ArtistaService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/artistas")
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
    
    @GetMapping
    public ResponseEntity<Artista> login(@RequestBody Artista loginArtista){
        List<Artista> artistas = artistaService.listarArtista();
        for (Artista a: artistas){
            if (a.getEmail().equals(loginArtista.getEmail()) && a.getSenha().equals(loginArtista.getSenha())){
                return ResponseEntity.status(202).body(artistaService.getLogin(loginArtista));
            }
        }
        return ResponseEntity.status(404).build();
    }

}
