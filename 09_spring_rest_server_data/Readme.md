# Extend our REST Server with database functionality

Be aware that lombok is used in the project. Install the IntelliJ
plugin if not yet done so.

## Task

Extend the previous application by now using a database to query the users.
To achieve this we will replace the UsersJsonLoader with a real database.

- Extend the pom with the necessary dependencies (h2, spring-boot-starter-data-jpa)
- Configure the h2 in the application properties (see https://www.baeldung.com/spring-boot-h2-database or solution)
- Add an sql script for creating the user table and init some users
- Use @Entity to get our database entity and access the h2 via a jpa repository
- Map the returned entities to DTO's and return them

## Bonus Task 1

Extend our interface with the possibility to add a new user.

- @PostMapping identifies our controller method for this usecase.
- @RequestBody identifies the value we expect. In this case a user that is represented as json.

