# Tomoponi
[Accompanying Presentation](https://docs.google.com/presentation/d/1KzClLIziuJLoZMwqc04RWcCeeWbFbwqq_sTVPTUmQFs/edit?usp=sharing)

Capstone project for TEKSystems Java Full-Stack Dev cohort Mar-Jul 2022. The concept of this project lies on the nostalgia for caring for virtual pets back in the early 2000's. Though potentially out of scope for a capstone, this site follows design in a vein most similar to that of Neopets. That is, new accounts get a pet on joining, play minigames to earn coins, buy or find food to give their pets, and can buy plenty of other items to keep their pets happy and healthy. Being a fan of one of the newer My Little Pony series and knowing where to find some nice little sprites, I designed this app as a bit of a pony-virtual-pet site and mixed Tomodachi, the Japanese word for 'Friend(s)' to show the spirit of the show and the app mixing together. 

Below is a list of premade accounts through the CommandLineRunner which you can log in with to view some site functionality.

| email                   | username (not needed for login) | password | Auth Groups |
|-------------------------|---------------------------------|----------|-------------|
| fireboy@psmail.com      | xXDragonXx                      | password | User        |
| own@psmail.com          | Oprah_Rulez                     | password | User        |
| animal_lover@psmail.com | Flutter                         | password | Admin, User |
| starscout@psmail.com    | Sunny Bun                       | password | Admin, User |

## Table of Contents
1. [Technologies Used](#technologies)
2. [Models](#models)
3. [Controllers](#controllers)
4. [Testing](#testing)
5. [User Stories](#stories)
6. [Credits](#credits)

### <a name="technologies"></a> Technologies used

- Spring Boot
- Spring JPA
- Spring Security
- Java Corretto 11
- Maven
- Lombok
- JUnit
- BCrypt
- Bootstrap 5
- Thymeleaf
- MariaDB

### <a name="models"></a> Models

Models require:

- constructors (no args, all args, req args)
- setters and getters
- toString()
- overridden equals() and hash()
- additional helper methods

#### User

The core model of the application. Users are the accounts of site users, which hold information like their email and password, but also contain site-specific data for coins, a link to what items each individual user has and a list of pets the user has gotten. 

| Field        | Datatype        | Description                              | Attributes                         |
|--------------|-----------------|------------------------------------------|------------------------------------|
| id           | int             | a unique identifier                      | PK, autoincrement                  |
| email        | String          | user's email they registered with        | not null, unique                   |
| username     | String          | user's display name on the site          | not null                           |
| password     | String          | user's sign-in password                  | not null                           |
| coins        | int             | the amount of site's currency a user has | not null                           |
| pets         | List<Pet>       | user's pets                              | OneToMany (one User has many Pets) |
| userItemList | List<UserItems> | user's items and each item's quantity    | join table ManyToMany with Items   |

#### Pet

Where users are the heart of the application, pets are the soul. A pet has multiple stats to be tracked by users so that they may act accordingly. These stats are health, hunger and happiness which deteriorate and must be tended to by players. Pets also have a type which are for future endeavors...

| Field     | Datatype           | Description                       | Attributes                               |
|-----------|--------------------|-----------------------------------|------------------------------------------|
| id        | int                | a unique identifier               | PK, autoincrement                        |
| name      | String             | pet's name given by their user    | not null                                 |
| image     | String             | relative path to the pet's image  | not null                                 |
| level     | int                | pet's level                       | not null                                 |
| health    | int                | pet's health                      | not null                                 |
| hunger    | int                | pet's hunger                      | not null                                 |
| happiness | int                | pet's happiness                   | not null                                 |
| element   | ElementType (enum) | a pet's elemental type, for later | not null                                 |
| user      | User               | user the pet belongs to           | ManyToOne (many Pets belong to one User) |

#### Item

In designing this app, I thought about using inheritance to distinguish that while most of the items are similar, they are functionally different. It was tricky to implement as jpa inheritance isn't part of the curriculum but it was a nice challenge that also taught me more about Spring's mapping tools available.

##### Egg

The first child of Item, is Egg, which is an item users can buy or obtain that hatches into a new pony/pet (This app is not using realistic biology). Eggs belong to one of six element types which I've noted as Enums: Fire, Water, Earth, Thunder, Light, and Dark. Depending on the type, there are 5 possible ponies that could hatch from a given egg.

##### Food

The second child of Item is Food, which users buy or acquire and is used to feed their hungry pets. The idea is pretty straightforward, and the implementation is that bigger foods will fill a pet's belly faster. 

##### Medicine

The next child of Item is Medicine, which is bought by users in the market to give to pets to restore their HP. 

##### Toy

The final child of Item is Toy, which is bought by users in the market and raises the happiness of a pet when given to them.

| Field             | Datatype           | Description                          | Attributes                                                                            |
|-------------------|--------------------|--------------------------------------|---------------------------------------------------------------------------------------|
| id                | int                | a unique identifier                  | PK, autoincrement                                                                     |
| name              | String             | item's name                          |                                                                                       |
| description       | String             | item's description                   |                                                                                       |
| image             | String             | relative path to the item's image    |                                                                                       |
| buyPrice          | int                | the item's cost at the market        |                                                                                       |
| sellPrice         | int                | the item's value when selling back   |                                                                                       |
| itemUserList      | List<userItems>    | items tied to a User                 | join table ManyToMany with Users                                                      |
| itemType          | String             | child class the instance belongs to  | join table with discriminator column where all Item children appear in a single table |
| hatchTime         | int                | how long an egg takes to hatch       | Egg-specific field                                                                    |
| element           | ElementType (enum) | the egg's elemental type, for later  | Egg-specific field                                                                    |
| fillAmount        | int                | how much hunger a food refills       | Food-specific field                                                                   |
| restorationAmount | int                | how much health a medicine restores  | Medicine-specific field                                                               |
| joyAmount         | int                | how much happiness a toy gives a pet | Toy-specific field                                                                    |

### <a name="controllers"></a> Controllers

#### MainController

As the name states, this is the main controller for the most basic or general mappings, that is; home, register, login, and the 403 page. 

#### UserController

The controller in charge of actions involving users. Registering a new account and getting the view of users for administrators are in this controller.

#### ItemController

The controller in charge of actions involving items. The request mapping for getting a user's items is in this controller.

#### PetController

The controller in charge of actions involving pets. The request mapping for getting a user's pets is in this controller.

### <a name="testing"></a> Unit Testing

Tests written for testing CRUD services for Users, Items and Pets

### <a name="stories"></a> User Stories

As a User, I want to see my pets, so that I can tell if they are hungry or sick. 

As a User, I want to feed my pet, so that they don't go hungry.

As a User, I want to give my pet toys, so that they are happy.

As a User, I want to get new pets, so that my first pet can have friends.

As a User, I want to earn coins, so that I may buy my pets food and new things.

As a Guest, I want to make an account, so that I can take care of a pet of my own.

As an Admin, I want to add new seasonal items, so that the site can have longevity.

As an Admin, I want to be able to edit a user's username, so that I can enforce the Terms of Service

As an Admin, I want to be able to delete users, so that I can protect visitors from unlawful or belligerent behavior.

As the Site Owner, I want to view users, so that I may see site growth/usage.

### <a name="credits"></a> CREDITS

This is a student project, ponies and their images are property of Hasbro Inc. 

Icons used for eggs, from Lugia-sea on Deviantart
https://www.deviantart.com/lugia-sea/art/Pokemon-Type-Icons-Vector-869706864

Pony sprites used for pets, from multiple creators, currently maintained by RoosterDragon on GitHub
https://github.com/RoosterDragon/Desktop-Ponies