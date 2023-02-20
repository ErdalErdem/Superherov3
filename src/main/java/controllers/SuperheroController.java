package controllers;

import model.Superhero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import respositories.SuperheroRepository;
import services.SuperheroService;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {
    private SuperheroService superheroService;
   public SuperheroController(SuperheroService superheroService) {
       this.superheroService = superheroService;
   }

   // GetMapping fungere nu, men kunne ikke få de andre til at fungere.
    // Mener det er vores metoder som driller.
    @GetMapping(path = "welcome")
    public ResponseEntity<List<Superhero>> readSuperheroes(){
        List superheroList = superheroService.getSuperHero();
        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);
    }
}

