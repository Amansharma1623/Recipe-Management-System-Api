package com.Geekster.Recipe.management.system.API.Repo;

import com.Geekster.Recipe.management.system.API.Model.Comment;
import com.Geekster.Recipe.management.system.API.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipe(Recipe recipe);
}
