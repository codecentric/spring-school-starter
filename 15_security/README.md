# Spring Security

We want to secure the web application and give access to specific roles.  

## Task 1

1. Start the application and open the browser, oh it is secure and usable? We want to use the web application. 
2. Create two user in the UserDetailsService bean. Hint: use the InMemoryUserDetailsManager. 
   A user should have the role "USER" and another the role "ADMIN".
3. Configure that the access also works without login to the static resources, the URLs "/" and "/index".
4. Allow users to access "/car/index" only with the role "USER" and "/car/edit" to those with the role "ADMIN". 
   Any other request should be authenticated.
 
## Bonus

1. We want to use the custom login page, forward after successful login to "/car/index" and in case of an error to "/login-error".
2. We want to logout and invalidate the current session, delete the "JSESSIONID" cookie and forward to "/"
3. Enable debug information - what can you see?
