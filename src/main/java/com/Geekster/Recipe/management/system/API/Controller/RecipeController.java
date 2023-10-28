package com.Geekster.Recipe.management.system.API.Controller;

import com.Geekster.Recipe.management.system.API.Model.Recipe;
import com.Geekster.Recipe.management.system.API.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    //CREATE
    @PostMapping("Create/Recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.addTask(recipe);
    }

    //READ

    @GetMapping("Read/Recipes")
    public List<Recipe> getRecipe(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("Recipes/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    //UPDATE
    @PutMapping("Recipes")
    public Recipe UpdateRecipes(@RequestBody Recipe recipe) {
        return recipeService.UpdateRecipes(recipe);
    }

    //DELETE

    @DeleteMapping("Recipe/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) {
        return recipeService.deleteRecipe(recipeId);
    }
}
