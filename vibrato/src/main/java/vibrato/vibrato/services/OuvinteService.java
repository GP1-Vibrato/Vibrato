package vibrato.vibrato.services;

import org.springframework.stereotype.Service;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.entidades.Ouvinte;
import vibrato.vibrato.repositories.OuvinteRepository;

import java.util.List;

@Service
public class OuvinteService {
private OuvinteRepository ouvinteRepository;

public OuvinteService(OuvinteRepository ouvinteRepository){
    this.ouvinteRepository = ouvinteRepository;
}

public List<Ouvinte> listarOuvinte(){
    List<Ouvinte> lista = ouvinteRepository.findAll();
    return lista;
}

public Ouvinte getById(Long id){
    Ouvinte ouvinteBanco = ouvinteRepository.getById(id);
    return ouvinteBanco;
}

public Ouvinte addOuvinte(Ouvinte novoOuvinte){
    Ouvinte ouvinteBanco = ouvinteRepository.save(novoOuvinte);
    return ouvinteBanco;
}

    public Ouvinte getLogin(Ouvinte loginOuvinte){
        List<Ouvinte> loginLista = ouvinteRepository.findAll();
        for (Ouvinte o: loginLista) {
            if (o.getEmail().equals(loginOuvinte.getEmail())){
                return o;
            }
        }
        return null;
    }
}
