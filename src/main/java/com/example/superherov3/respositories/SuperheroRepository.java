package com.example.superherov3.respositories;

import com.example.superherov3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SuperheroRepository {

        Superhero sh1 = new Superhero("Batman", true, "Bat abilities", 1939, 100.0);
        Superhero sh2 = new Superhero("Superman", false, "Super abilities", 1938, 1000.0);

        ArrayList<Superhero> heroDatabase = new ArrayList<>();

        public SuperheroRepository(){
            heroDatabase.add(sh1);
            heroDatabase.add(sh2);
        }

        //private ArrayList<Superhero> heroDatabase = new ArrayList<>();

        public void addSuperheroes(String name, boolean isHuman, String superPower, int creationYear, double strength) {
            Superhero superhero = new Superhero(name, isHuman, superPower, creationYear, strength);
            heroDatabase.add(superhero);
        }


        public Superhero findSuperhero(String name) {
            for (Superhero p : heroDatabase) {
                if (p.getName().equals(name)) {
                    return p;
                }
            }
            return null;
        }


        public ArrayList<Superhero> getHeroDatabase() {
            return heroDatabase;
        }

        public void editSuperhero(String name, boolean isHuman, String superPower, int creationYear, double strength) {
            Superhero s = findSuperhero(name);
            s.setName(name);
            s.setHuman(isHuman);
            s.setSuperPower(superPower);
            s.setCreationYear(creationYear);
            s.setStrength(strength);
        }

        //This method is only useful to the user interface in the original project
        /*public void deleteHero(int heroToDelete) {

            int deleteOnIndex = heroToDelete - 1;

            System.out.println(heroDatabase.get(deleteOnIndex).getName() + " has been deleted");

            heroDatabase.remove(deleteOnIndex);
        }*/

        public void deleteHeroSearch(String name) {
            for (int i = 0; i < heroDatabase.size(); i++){
                Superhero s = heroDatabase.get(i);
                if (s.getName().equals(name)){
                    heroDatabase.remove(s);
                }
            }
        }

    }

