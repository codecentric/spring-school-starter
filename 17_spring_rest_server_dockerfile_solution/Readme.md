# Extend REST Server

Be aware that lombok is used in the project. Install the IntelliJ
plugin if not yet done so.

Take a look at the hello package to get "inspiration".

## Task

Implement a REST resource 'users'. Extend the existing skeleton
'UserController' class and implementing a HTTP GET endpoint for
fetching all users at once. Using HTTP GET for url
http://localhost:8080/users should get all users.

Use the JSON file 'users.json' as data source of your REST
service. Do not return the plain file content. Load the JSON,
map every user to a domain object 'User', and store all the users
in a collection.

Verify your controller with command line tools like wget/curl,
with the browser or special REST clients (there are a lot:
https://insomnia.rest/, http://www.swensensoftware.com/im-only-resting,
https://www.getpostman.com/, ...)

## Bonus Task 1

Add an endpoint to get the data of one user by id. How should
the id be given? What should happen when no user was found for
the given id?

Implement the endpoint and test it like you did in the main task.

## Bonus Task 2

The list functionality is usually extended by supporting
- filtering (only a certain list of users is returned)
- sorting (sort by one of the attributes ascending or descending)
- pagination (show only 20 users at a time with variable offset)

Design how the client would request these information. Implement
the server side (start with one feature) and test it.
