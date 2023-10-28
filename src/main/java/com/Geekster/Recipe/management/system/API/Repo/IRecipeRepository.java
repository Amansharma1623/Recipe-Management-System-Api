package com.Geekster.Recipe.management.system.API.Repo;

import com.Geekster.Recipe.management.system.API.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<Recipe, Long> {
}
