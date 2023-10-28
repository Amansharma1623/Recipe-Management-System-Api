package com.Geekster.Recipe.management.system.API.Service;

import com.Geekster.Recipe.management.system.API.Model.Recipe;
import com.Geekster.Recipe.management.system.API.Repo.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    IRecipeRepository recipeRepository;

    //CREATE
    public Recipe addTask(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    //READ
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    //DELETE
    public String deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
        return "task - "+recipeId+" deleted";
    }

    //UPDATE
    public Recipe UpdateRecipes(Recipe recipe) {
        Recipe existingRecipe =  recipeRepository.findById(recipe.getId()).get();

        existingRecipe.setName(recipe.getName());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setInstructions(recipe.getInstructions());

        return recipeRepository.save(existingRecipe);
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }
}
