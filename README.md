# Tomoponi
Capstone project for Per Scholas' Seattle Java Full-stack Dev cohort Mar-Jul 2022. The concept of this project lies on the nostalgia for caring for virtual pets back in the early 2000's. Though potentially out of scope for a capstone, this site follows design in a vein most similar to that of Neopets. That is, new accounts get a pet on joining, play minigames to earn coins, buy or find food to give their pets, and can buy plenty of other items to keep their pets happy and healthy. Being a fan of one of the newer My Little Pony series and knowing where to find some nice little sprites, I designed this app as a bit of a pony-virtual-pet site and mixed Tomodachi, the Japanese word for 'Friend(s)' to show the spirit of the show and the app mixing together. 

## Table of Contents
1. [Models](#models)
2. [Controllers](#controllers)
3. [Testing](#testing)
4. [Stories](#stories)
5. [Credits](#credits)

### <a name="models"></a> Models

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

### <a name="controllers"></a> Controllers

### <a name="testing"></a> Unit Testing

### <a name="stories"></a> User Stories

As a User, I want to see my pets, so that I can tell if they are hungry or sick. 

As a User, I want to feed my pet, so that they may be healthy.

As a User, I want to give my pet toys, so that they may be happy.

As a User, I want to get new pets, so that my first pet can have friends.

As a User, I want to earn coins, so that I may buy my pets food and new things.

As an Admin, I want to add new seasonal items, so that the site can have longevity.

As an Admin, I want to be able to delete users, so that I can protect visitors from unlawful or belligerent behavior.

### <a name="credits"></a> CREDITS

Icons used for eggs, from Lugia-sea on Deviantart
https://www.deviantart.com/lugia-sea/art/Pokemon-Type-Icons-Vector-869706864