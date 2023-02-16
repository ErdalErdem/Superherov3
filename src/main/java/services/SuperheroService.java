package services;

import org.springframework.stereotype.Service;
import respositories.SuperheroRepository;

@Service
public class SuperheroService {

    SuperheroRepository repo = new SuperheroRepository();

    public void addSuperhero(String name, boolean isHuman, String superPower, int creationYear, double strength){
        repo.addSuperheroes(name, isHuman, superPower, creationYear, strength);
    }

    public void readSuperhero(String name){
        repo.findSuperhero(name);
    }

    public void updateSuperhero(String name, boolean isHuman, String superPower, int creationYear, double strength) {
        repo.editSuperhero(name, isHuman, superPower, creationYear, strength);
    }

    public void deleteSuperhero(String name) {
        repo.deleteHeroSearch(name);

    }


}
