package com.Geekster.Recipe.management.system.API.Controller;

import com.Geekster.Recipe.management.system.API.Model.Comment;
import com.Geekster.Recipe.management.system.API.Model.Recipe;
import com.Geekster.Recipe.management.system.API.Service.CommentService;
import com.Geekster.Recipe.management.system.API.Service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    RecipeService recipeService;

    @PostMapping("/{id}/comments")
    public Comment createComment(@PathVariable Long id, @Valid @RequestBody Comment comment) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);

        if (recipe.isPresent()) {
            return commentService.createComment(recipe.get(), comment);
        } else {
            return null; // Recipe with the given id not found
        }
    }

    @GetMapping("Recipe/{recipe}")
    public List<Comment> getCommentsByRecipe(@PathVariable Recipe recipe){
        return commentService.getCommentsByRecipe(recipe);
    }
}
