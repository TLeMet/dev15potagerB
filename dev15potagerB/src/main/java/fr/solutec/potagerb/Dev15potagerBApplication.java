package fr.solutec.potagerb;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.dao.TypeTerrainRepository;
import fr.solutec.potagerb.dao.UserRepository;
import fr.solutec.potagerb.entities.*;


@SpringBootApplication
public class Dev15potagerBApplication implements CommandLineRunner{

	@Autowired
	private TerrainRepository terrRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private TypeTerrainRepository typeTRep;
	
	public static void main(String[] args) {
		SpringApplication.run(Dev15potagerBApplication.class, args);
		
		System.out.println("launch complete");
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		TypeTerrain typeT1 = new TypeTerrain("Jardin");
		typeTRep.save(typeT1);
		
		Terrain t1 = new Terrain();
		Terrain t2 = new Terrain();
		
		
		User u1 = new User("test1", "test1", "test1", "test1", "01", 1);
		User u2 = new User("test2", "test2", "test2", "test2", "02", 2);
		User u3 = new User("test3", "test3", "test3", "test3", "03", 3);
		userRep.save(u1);
		userRep.save(u2);
		userRep.save(u3);
		
		@SuppressWarnings("deprecation")
		Time time = new Time(0,0,1);
		
		Set<User> usersA = new HashSet<>();
		usersA.add(u1);
		usersA.add(u2);
		
		Set<User> usersB = new HashSet<>();
		usersB.add(u1);
		usersB.add(u3);
		
		t1 = new Terrain("terrain1", "1.1", "ad1", "Paris", 14.5, time, time, 10, "description", usersA, typeT1, u1);
		terrRep.save(t1);
		t2 = new Terrain("terrain2", "2.2", "ad2", "Paris", 14.5, time, time, 5, "description", usersB, typeT1, u3);
		terrRep.save(t2);
	}
}
