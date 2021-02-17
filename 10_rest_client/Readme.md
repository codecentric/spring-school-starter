# Rest Client with RestTemplate

In the last exerise a REST server was implmented. This service should now
be consumed.

## Task

Implement a REST client to GET all user data from the REST resource you
implemented before.

Map the four fields of the response to the existing User class.

Implement that client in class UserClient. It should have a method like
  public List<User> getAllUsers()
Use class HelloClient as a blueprint for your new client.

Use properties in the application.yml for injecting the URL.

There are multiple ways to test your client:
1. With a unit test using mocked data (look at HelloClientMockTest)
2. With a integration test accessing the real service (look at HelloClientSystemTest)
3. During the startup of the App (look at App.main)

## Bonus Task

Add a method to retrieve one user. Test the method.
