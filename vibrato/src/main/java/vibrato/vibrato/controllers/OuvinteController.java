package vibrato.vibrato.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vibrato.vibrato.entidades.Ouvinte;
import vibrato.vibrato.services.OuvinteService;
import vibrato.vibrato.services.autenticacao.dto.OuvinteLoginDto;
import vibrato.vibrato.services.autenticacao.dto.OuvinteTokenDto;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ouvintes")
public class OuvinteController {
    private OuvinteService ouvinteService;

    public OuvinteController(OuvinteService ouvinteService){
        this.ouvinteService = ouvinteService;
    }

    @PostMapping("/ouvinte")
    public ResponseEntity<Ouvinte> criarOuvinte(@RequestBody Ouvinte novoOuvinte){
        return ResponseEntity.status(201).body(ouvinteService.addOuvinte(novoOuvinte));
    }

    @GetMapping("/ouvinte")
    public ResponseEntity<List<Ouvinte>> listar() {
        List<Ouvinte> ouvintes = ouvinteService.listarOuvinte();
        if (ouvintes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(ouvinteService.listarOuvinte());
    }

    @GetMapping("/login/ouvinte")
    public ResponseEntity<OuvinteTokenDto> login(@RequestBody OuvinteLoginDto ouvinteLoginDto){
        OuvinteTokenDto ouvinteToken = this.ouvinteService.autenticarOuvinte(ouvinteLoginDto);
        return ResponseEntity.status(200).body(ouvinteToken);
        /*
         List<Ouvinte> ouvintes = ouvinteService.listarOuvinte();

         for (Ouvinte o: ouvintes){
            if (o.getEmail().equals(loginOuvinte.getEmail()) && o.getSenha().equals(loginOuvinte.getSenha())){
                o.setLogado(true);
                return ResponseEntity.status(202).body(ouvinteService.getLogin(loginOuvinte));
            }
        }
        return ResponseEntity.status(404).build();
        */
    }

    @PutMapping("/{id}/ouvinte")
    public ResponseEntity<Void> logoff(@PathVariable Long id){
        if (id <= ouvinteService.listarOuvinte().size() && id > 0){
            Ouvinte o = ouvinteService.getById(id);
            o.setLogado(false);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
