package respositories;

import model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SuperheroRepository {

        Superhero sh1 = new Superhero("n", true, "br", 2000, 192.0);
        Superhero sh2 = new Superhero("ma", false, "pea", 2002, 1.0);

        ArrayList<Superhero> heroDatabase = new ArrayList<>();
        //private ArrayList<Superhero> heroDatabase = new ArrayList<>();

        public Superhero findSuperhero(String name) {
            for (Superhero p : heroDatabase) {
                if (p.getName().equals(name)) {
                    return p;
                }
            }
            return null;
        }

        public void addSuperheroes(String name, boolean isHuman, String superPower, int creationYear, double strength) {
            Superhero superhero = new Superhero(name, isHuman, superPower, creationYear, strength);
            heroDatabase.add(superhero);
        }

        public ArrayList<Superhero> getHeroDatabase() {
            return heroDatabase;
        }


        public void editSuperhero(String name, boolean isHuman, String superPower, int creationYear, double strength) {
            Superhero editSuperhero = new Superhero(name, isHuman, superPower, creationYear, strength);
        }

        public void deleteHero(int heroToDelete) {

            int deleteOnIndex = heroToDelete - 1;

            System.out.println(heroDatabase.get(deleteOnIndex).getName() + " has been deleted");

            heroDatabase.remove(deleteOnIndex);
        }

        public void deleteHeroSearch(String name) {
            for (int i = 0; i < heroDatabase.size(); i++){
                Superhero s = heroDatabase.get(i);
                if (s.getName().equals(name)){
                    heroDatabase.remove(s);
                }
            }
        }

    }
}
