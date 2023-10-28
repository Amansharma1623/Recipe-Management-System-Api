package com.Geekster.Recipe.management.system.API.Service;

import com.Geekster.Recipe.management.system.API.Model.Comment;
import com.Geekster.Recipe.management.system.API.Model.Recipe;
import com.Geekster.Recipe.management.system.API.Repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Recipe recipe, Comment comment) {
        comment.setRecipe(recipe);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByRecipe(Recipe recipe) {
        return commentRepository.findByRecipe(recipe);
    }
}
