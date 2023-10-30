# Recipe-Management-System-Api

## Frameworks and Language Used
![Java](https://img.shields.io/badge/Language-Java-green)
![Spring Boot](https://img.shields.io/badge/Framework-Spring%20Boot-brightgreen)

## Data Flow
### Controller
- **RecipeController:**

  - 'GET /api/recipes/': Retrieves all recipes.
  - 'POST /api/recipes/': Creates a new recipe.
  - 'PUT /api/recipes/{id}': Updates an existing recipe by ID.
  - 'DELETE /api/recipes/{id}': Deletes a recipe by ID.
- **CommentController:**

  - 'GET /api/comments/': Retrieves all comments.
  - 'POST /api/comments/': Creates a new comment.
    
## Services
### RecipeService

- getAllRecipes(): Retrieves all recipes.
- getIdRecipes(): Retrieves Id recipes.
- createRecipe(Recipe recipe): Creates a new recipe.
- updateRecipe(Long id, Recipe updatedRecipe, String username): Updates an existing recipe by ID, with owner authentication.
- deleteRecipe(Long id): Deletes a recipe by ID.
  
### CommentService

- getAllComments(): Retrieves all comments.
- createComment(Comment comment): Creates a new comment.
  
## Repository
### IRecipeRepo
Manages database interactions for Recipe entities.

### ICommentRepo
Manages database interactions for Comment entities.

## DataBase Design
### Entities
### Recipe

- recipeId (Long, Primary Key)
- recipeName (String)
- recipeIngredients (String)
- recipeInstructions (String)
- owner (User)
### Comment

- commentId (Long, Primary Key)
- commentBody (String)
- recipe (Recipe)
  
## Data Structure Used in Your Project
 - I used lists as data structures used in my project.

## Project Summary
The Recipe Management System is a Java-based web application built using the Spring Boot framework. It provides a platform for users to manage recipes, allowing them to perform CRUD operations on recipes and add comments to existing recipes. The system enforces ownership privileges, ensuring that only the creator of a recipe can update it.

This version of the project leverages a Service layer to handle business logic, separating concerns and improving maintainability. The database is interacted with using Spring Data JPA, which simplifies database operations. The project aims to provide a foundation for further enhancements, such as user authentication, a user interface, and additional features to enhance the user experience.
