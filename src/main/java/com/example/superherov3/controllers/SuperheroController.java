package com.example.superherov3.controllers;

import com.example.superherov3.model.Superhero;
import com.example.superherov3.services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
       this.superheroService = superheroService;
    }

    @GetMapping("hello")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }

    @GetMapping("yo")
    public ResponseEntity<String> welcome2(){
        return new ResponseEntity<>("Yo World!", HttpStatus.OK);
    }

    //If path is empty, client simply displays all superheroes in the database
    // http://localhost:8181/superhero
    @GetMapping(path = "")
    public ResponseEntity<List<Superhero>> readSuperheroes(){
        List superheroList = superheroService.getSuperHeroes();
        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);
    }

    //Search superhero
    //Example: http://localhost:8181/superhero/Batman
    @GetMapping(path ="/{name}")
    public ResponseEntity<Superhero> findSuperhero(@PathVariable String name) {
        return new ResponseEntity<>(superheroService.findSuperhero(name), HttpStatus.OK);
    }

    //Create superhero
    //Example: http://localhost:8181/superhero/create/ole/true/fisker/1950/10
    @GetMapping(path ="create/{name}/{isHuman}/{superPower}/{creationYear}/{strength}")
    public ResponseEntity<Superhero> addSuperhero(@PathVariable String name, @PathVariable boolean isHuman, @PathVariable String superPower, @PathVariable int creationYear, @PathVariable double strength){
        superheroService.addSuperhero(name, isHuman, superPower, creationYear, strength);
        return new ResponseEntity<>(superheroService.findSuperhero(name), HttpStatus.OK);
    }

    //Update/edit superhero
    //Example: http://localhost:8181/superhero/update/ole/true/fisker/1950/1000000
    @GetMapping(path ="update/{name}/{isHuman}/{superPower}/{creationYear}/{strength}")
    public ResponseEntity<Superhero> updateSuperhero(@PathVariable String name, @PathVariable boolean isHuman, @PathVariable String superPower, @PathVariable int creationYear, @PathVariable double strength) {
        superheroService.updateSuperhero(name, isHuman, superPower, creationYear, strength);
        return new ResponseEntity<>(superheroService.findSuperhero(name), HttpStatus.OK);
    }

    //Delete superhero
    //Example: http://localhost:8181/superhero/delete/ole
    @GetMapping(path ="delete/{name}")
    public ResponseEntity<String> deleteSuperhero(@PathVariable String name){
        superheroService.deleteSuperhero(name);
        return new ResponseEntity<>(name + " deleted!", HttpStatus.OK);
    }

}

