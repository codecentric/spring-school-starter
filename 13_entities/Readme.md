## JPA Entities

We want to store information about interactions with articles on our website.  

### Task 1
1. Start the application, It does nothing, but it shows you when you are doing something 
wrong.
2. Look at the class model for in the class_diagram.png. Please create classes for the model
3. Annotate the classes with JPA annotations, so they can be persisted.
4. Store an article in your local database.
5. Look at the logs - what can you see?

### Task 2
1. We want to keep track of when the article information and the score have been created 
   and updated, i.e. we want a created timestamp and an updated timestamp. How can you model 
   this without duplicating code?
2. It's tedious to always set the created and updated timestamps by hand. What other 
   way can we use?
3. Look at the logs - what can you see?
