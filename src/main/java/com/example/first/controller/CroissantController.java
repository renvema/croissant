package com.example.first.controller;

import com.example.first.service.CroissantService;
import com.example.first.service.IngredientService;
import com.example.first.model.Croissant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/croissant")
public class CroissantController {

    @Autowired
    private CroissantService croissantService;

    @Autowired
    private IngredientService inredientService;

    @GetMapping()
    public List<Croissant> getCroissants() {
        return croissantService.getCroissants();
    }

    @PostMapping()
    public ResponseEntity<Object> createCroissant(@RequestBody Croissant croissant) {
        return croissantService.save(croissant);
    }

    @PutMapping()
    public ResponseEntity<Object> updateCroissant(@RequestBody Croissant croissant) {
        return croissantService.update(croissant);
    }

    @PutMapping("/{croissantId}/ingredients/{ingredientId}")
    public ResponseEntity<Object> addIngredient(
            @PathVariable Long croissantId,
            @PathVariable Long ingredientId
    ) {
        return croissantService.update(croissantId, ingredientId);
    }
}