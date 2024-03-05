package com.example.first.service;

import com.example.first.model.Ingredient;
import com.example.first.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public ResponseEntity<Object> save(Ingredient ingredient) {

        if (isExist(ingredient)) {
            return ResponseEntity.badRequest().body("Ingredient already exists");
        }

        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return ResponseEntity.ok(savedIngredient);
    }

    private boolean isExist(Ingredient ingredient) {
        return ingredientRepository.exists(Example.of(ingredient));
    }
}