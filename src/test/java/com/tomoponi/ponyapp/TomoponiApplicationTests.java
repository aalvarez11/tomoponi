package com.tomoponi.ponyapp;

import com.tomoponi.ponyapp.controller.MainController;
import com.tomoponi.ponyapp.controller.UserController;
import com.tomoponi.ponyapp.model.*;
import com.tomoponi.ponyapp.repository.ItemRepository;
import com.tomoponi.ponyapp.repository.PetRepository;
import com.tomoponi.ponyapp.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@FieldDefaults(level = AccessLevel.PRIVATE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TomoponiApplicationTests {
	@Autowired
	MainController mainController;
	@Autowired
	UserController userController;
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ItemRepository itemRepo;
	@Autowired
	PetRepository petRepo;

	@Test
	void contextLoads() {
		assertThat(mainController).isNotNull();
		assertThat(userController).isNotNull();
	}

	@Test
	void testCreateEmptyUser() {
		User user = new User();
		user.setEmail("testUser@psmail.com");
		user.setPassword("password");
		user.setUsername("test_user");
		user.setCoins(0);

		User savedUser = userRepo.save(user);
		User existingUser = entityManager.find(User.class, savedUser.getId());

		assertThat(user.getEmail()).isEqualTo(existingUser.getEmail());
	}

	@Test
	void testCreateArgsUser() {
		User user = new User("test_user2", "testUser2@psmail.com", "PASSWORD", 100);

		User savedUser = userRepo.save(user);
		User existingUser = entityManager.find(User.class, savedUser.getId());

		assertThat(user.getEmail()).isEqualTo(existingUser.getEmail());
	}

	@Test
	void testCreateFood() {
		Item testFood = new Food("Test Food",
				"Food from the void for testing purposes",
				"/resources/static/assets/test.jpeg",
				5,
				5,
				1);

		Item savedItem = itemRepo.save(testFood);
		Item existingItem = entityManager.find(Item.class, savedItem.getId());

		assertThat(testFood.getName()).isEqualTo(existingItem.getName());
		assertThat(testFood.getDescription()).isEqualTo(existingItem.getDescription());
	}

	@Test
	void testCreateMedicine() {
		Item testMed = new Medicine("Test Med",
				"Medicine from the void for testing purposes",
				"/resources/static/assets/test.jpeg",
				5,
				5,
				1);

		Item savedItem = itemRepo.save(testMed);
		Item existingItem = entityManager.find(Item.class, savedItem.getId());

		assertThat(testMed.getName()).isEqualTo(existingItem.getName());
		assertThat(testMed.getDescription()).isEqualTo(existingItem.getDescription());
	}

	@Test
	void testCreateToy() {
		Item testToy = new Toy("Test Toy",
				"Toy from the void for testing purposes",
				"/resources/static/assets/test.jpeg",
				5,
				5,
				1);

		Item savedItem = itemRepo.save(testToy);
		Item existingItem = entityManager.find(Item.class, savedItem.getId());

		assertThat(testToy.getName()).isEqualTo(existingItem.getName());
		assertThat(testToy.getDescription()).isEqualTo(existingItem.getDescription());
	}

	@Test
	void testCreateEgg() {
		Item testMed = new Medicine("Test Med",
				"Medicine from the void for testing purposes",
				"/resources/static/assets/test.jpeg",
				5,
				5,
				1);

		Item savedItem = itemRepo.save(testMed);
		Item existingItem = entityManager.find(Item.class, savedItem.getId());

		assertThat(testMed.getName()).isEqualTo(existingItem.getName());
		assertThat(testMed.getDescription()).isEqualTo(existingItem.getDescription());
	}

	@Test
	void testCreatePet() {
		Pet testPet = new Pet("Test Pet",
				"/resources/static/assets/test.jpeg",
				1, 100, 100, 100, ElementType.FIRE);

		Pet savedPet = petRepo.save(testPet);
		Pet existingPet = entityManager.find(Pet.class, savedPet.getId());

		assertThat(testPet.getName()).isEqualTo(existingPet.getName());
		assertThat(testPet.getElement()).isEqualTo(existingPet.getElement());
	}
}
