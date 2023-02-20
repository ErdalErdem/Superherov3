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

    private final SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
       this.superheroService = superheroService;
    }

    //If path is empty, client simply displays all superheroes in the database
    // http://localhost:8181/superhero/
    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> readSuperheroes(){
        List<Superhero> superheroList = superheroService.getSuperHeroes();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
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
    //Updating superhero name doesn't work because updateSuperhero searches object by name
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

    //URL: http://localhost:8181/superhero/format=html
    @GetMapping(path = "/format=html")
    public ResponseEntity<?> formatOutput(){
        StringBuilder sb = new StringBuilder();
        if (!superheroService.getSuperHeroes().isEmpty()){
            sb.append("<html>");
            sb.append("<head>").append("<meta charset=\"UTF-8\">").append("<title>Superhero v.3</title>").append("</head>");
            sb.append("<body>");
            sb.append("<h1>Welcome to the superhero database</h1>");
            sb.append("<table>");
            for (int i = 0; i < superheroService.getSuperHeroes().size(); i++){
                Superhero s = superheroService.getSuperHeroes().get(i);
                int position = i + 1;
                sb.append("<tr>");
                sb.append("<th>").append("Super hero: " + position).append("</th>");
                sb.append("<td>").append(s).append("</td>");
                sb.append("</tr>");
            }
            sb.append("</table>").append("</body>").append("</html>");
        }
        return new ResponseEntity<>( sb.toString(), HttpStatus.OK);
    }

}

