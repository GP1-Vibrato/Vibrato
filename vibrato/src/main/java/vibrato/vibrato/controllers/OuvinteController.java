package vibrato.vibrato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vibrato.vibrato.repositories.OuvinteRepository;
import vibrato.vibrato.entidades.Ouvinte;
import vibrato.vibrato.services.OuvinteService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ouvintes")
public class OuvinteController {
    private OuvinteService ouvinteService;

    public OuvinteController(OuvinteService ouvinteService){
        this.ouvinteService = ouvinteService;
    }

    @PostMapping
    public ResponseEntity<Ouvinte> criarOuvinte(@RequestBody Ouvinte novoOuvinte){
        return ResponseEntity.status(201).body(ouvinteService.addOuvinte(novoOuvinte));
    }

    @GetMapping
    public ResponseEntity<List<Ouvinte>> listar() {
        List<Ouvinte> ouvintes = ouvinteService.listarOuvinte();
        if (ouvintes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(ouvinteService.listarOuvinte());
    }


}
