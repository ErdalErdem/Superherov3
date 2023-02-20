package controllers;

import model.Superhero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import respositories.SuperheroRepository;

import java.awt.print.Book;

@Controller
@RequestMapping("Superhero")
public class SuperheroController {
    SuperheroRepository superheroRepository = new SuperheroRepository();
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Book getSuperhero(@PathVariable String id) {
        return findSuperhero();
    }

    public Superhero findSuperhero(String name) {
        for (Superhero p : superheroRepository.getHeroDatabase()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

}

