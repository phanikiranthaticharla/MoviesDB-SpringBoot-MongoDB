# MoviesDB-SpringBoot-MongoDB
This is a simple Movies database application written using SpringBoot and MongDB. 

### Update 
UI for this backend application is written using Angular2 and can be found [here](https://github.com/phanikiranthaticharla/moviesdb-ui-angular2/)
This is a basic UI with search functionality based on movie name, actors, description or language. 

![movies_db](https://user-images.githubusercontent.com/8190677/128804176-9e62e5f9-c947-4f86-8dba-25f867b3352a.png)


[REST API Documentation ](https://documenter.getpostman.com/view/4456235/TzskEiFE)

### Prerequisites
* [MongoDB](https://docs.mongodb.com/manual/installation/)
* [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Intellij IDE](https://www.jetbrains.com/idea/) (Optional)

### Features 
* Add a movie
* List all available movies 
* Get movie details based on ID 
* Search for a movie 

### Steps

* Firstly, make sure mongodb server is running.
* The application.properties file located in the root directory contains the connection details to mongodb server. 
* The defaults are `spring.data.mongodb.host=localhost` and `spring.data.mongodb.port=27017`
* Navigate to project directory. 
* To compile the project, run: 
* `mvn compile`
* To run the spring boot application 
* `mvn spring-boot:run`
* Test the application using the [REST API Documentation ](https://documenter.getpostman.com/view/4456235/TzskEiFE) 
