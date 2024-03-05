package com.example.first.controller;

import com.example.first.service.IngredientService;
import com.example.first.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping()
    public List<Ingredient> getIngredients() {
        return ingredientService.getIngredients();
    }

    @PostMapping()
    public ResponseEntity<Object> createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }


}