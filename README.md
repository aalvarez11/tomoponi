# Tomoponi
Capstone project for Per Scholas' Seattle Java Full-stack Dev cohort Mar-Jul 2022. The concept of this project lies on the nostalgia for caring for virtual pets back in the early 2000's. Though potentially out of scope for a capstone, this site follows design in a vein most similar to that of Neopets. That is, new accounts get a pet on joining, play minigames to earn coins, buy or find food to give their pets, and can buy plenty of other items to keep their pets happy and healthy. Being a fan of one of the newer My Little Pony series and knowing where to find some nice little sprites, I designed this app as a bit of a pony-virtual-pet site and mixed Tomodachi, the Japanese word for 'Friend(s)' to show the spirit of the show and the app mixing together. 

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
- Maven
- Lombok
- JUnit
- BCrypt
- Bootstrap 5
- Thymeleaf
- MariaDB

### <a name="models"></a> Models

#### User

The core model of the application. Users are the accounts of site users, which hold information like their email and password, but also contain site-specific data for coins, a link to what items each individual user has and a list of pets the user has gotten.

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

#### Pet

The heart of the application. A pet has multiple stats to be tracked by users so that they may act accordingly. These stats are health, hunger and happiness which deteriorate and must be tended to by players. Pets also have a type which are for future endeavors...

### <a name="controllers"></a> Controllers

### <a name="testing"></a> Unit Testing

### <a name="stories"></a> User Stories

As a User, I want to see my pets, so that I can tell if they are hungry or sick. 

As a User, I want to feed my pet, so that they don't go hungry.

As a User, I want to give my pet toys, so that they are happy.

As a User, I want to get new pets, so that my first pet can have friends.

As a User, I want to earn coins, so that I may buy my pets food and new things.

As a Guest, I want to make an account, so that I can take care of a pet of my own.

As an Admin, I want to add new seasonal items, so that the site can have longevity.

As an Admin, I want to be able to delete users, so that I can protect visitors from unlawful or belligerent behavior.

As the Site Owner, I want to view users, so that I may see site growth/usage.

### <a name="credits"></a> CREDITS

Icons used for eggs, from Lugia-sea on Deviantart
https://www.deviantart.com/lugia-sea/art/Pokemon-Type-Icons-Vector-869706864

Pony sprites used for pets, from multiple creators, currently maintained by RoosterDragon on GitHub
https://github.com/RoosterDragon/Desktop-Ponies