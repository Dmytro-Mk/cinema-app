# 🎥 Cinema web app

### 📄 Project description:

Simple proof of concept web app that follows RESTful API rules and supports user authentication, authorization as well as various CRUD operations. Created using popular Java frameworks Spring & Hibernate.

### 💻 Current project functionality:
Here is the scheme of this app to better understand its functionality:
![pic](src/main/resources/Cinema_scheme.png)
And here is the list of all endpoints with role required for access and their short description:
- POST: /register - (all) - register as a new user.
- GET: /cinema-halls - (user/admin) - get a list of all cinema halls.
- POST: /cinema-halls - (admin) - create a new cinema hall.
- GET: /movies - (user/admin) - get a list of all movies.
- POST: /movies - (admin) - create a new movie.
- GET: /movie-sessions/available - (user/admin) - returns available movie sessions for specified movie and date.
- POST: /movie-sessions - (admin) - create movie session.
- PUT: /movie-sessions/{id} - (admin) - update movie session.
- DELETE: /movie-sessions/{id} - (admin) - delete movie session.
- GET: /orders - (user) - get list of orders for current user.
- POST: /orders/complete - (user) - create a new order for current user (transfer movie tickets from shopping cart to order and clear shopping cart).
- PUT: /shopping-carts/movie-sessions - (user) - creates a ticket for specified movie session and adds it to shopping cart of current user.
- GET: /shopping-carts/by-user - (user) - get shopping cart of current user.
- GET: /users/by-email - (admin) - get user by email.  

As you can see above this app has currently only two roles: user and admin. User role is assigned automatically to every new user created.  
User and admin roles as well as user with role admin are created by config/DataInitializer if they are missing in db.

### 📂 Project has the following structure:

#### java/

- config -contains config classes required by Spring & Hibernate.
- controller -all http controllers.
- dao -classes responsible for crud operations with db.
- dto -dtos that are used for http requests and responses.
- exception -custom exceptions.
- lib -custom validators for email, password and confirm password.
- model -model classes for entities shown in scheme above.
- service -classes that are responsible for business logic and connecting dao with controllers
- service/mapper -mappers that are used to parse dto to entity and entity to dto.
- util -util class containing date pattern to parse date from json.

#### resources/
- db.properties -file containing database and Hibernate properties.

#### other
- Pom.xml -contains maven build configs and dependencies.
- Procfile and system.properties are needed for proper heroku deployment.

### 🔨 Technologies used

Java 17, Spring Web MVC, Spring Security, Hibernate, MySql, Tomcat, Maven.

### 🔮 How to use app

This app is hosted on herokuapp.com. You can access it by following this [link](https://peaceful-dusk-12107.herokuapp.com/login).
To log in as admin use email: _admin@email.com_, password: _admin_. To log in as user you will need to create a new user first.  
To test this app api you can use postman. Here is [link](https://www.postman.com/dark-rocket-956702/workspace/cinema-app-public/collection/25473680-a2f0d637-5ebc-4421-ac0a-f0e48f69de29?ctx=documentation) to public collection of http requests that you can run.

Alternatively you can run this app by yourself (**requires Intellij and jdk 17 already installed**). First you will need to pull this project from github. You can do this by running below command in terminal:
```
git clone git@github.com:dmytro-mk/cinema-app.git
```
##### To run app locally on your pc you will need to install tomcat 9.0.50 and mysql 8.0. After that:

1. Replace username, password, driver and url in resources/db.properties with your own.
2. Create new run configuration tomcat_local (requires Intellij premium).
3. Delete heroke related plugin from pom.xml.
4. Run ```mvn package``` command in termanal.
5. Click debug configuration.
6. Enjoy :smiley:

##### If you want to host your version of this app on heroku:
1. Create remote MySql db.
2. Replace username, password, driver and url in resources/db.properties with your own.
3. Create heroku account and run following commands:
```
git add .
git commit -m "ready to deploy"
heroku login
heroku create
git push heroku master
heroku open
```
4. Enjoy :smiley:

