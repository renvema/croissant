package com.example.first.controller;

import com.example.first.entity.Croissant;
import com.example.first.repository.DTO.CroissantDTO;
import com.example.first.service.CroissantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/croissant")
public class CroissantController {

    @Autowired
    private CroissantService croissantService;


    @Operation(
            summary = "Get croissants",
            description = "Get all croissants from DB"
    )
    @GetMapping()
    public List<CroissantDTO> getCroissants() {
        return croissantService.getCroissants();
    }

    @PostMapping()
    public CroissantDTO createCroissant(@RequestBody CroissantDTO croissant) {
        return croissantService.save(croissant);
    }

    @PutMapping()
    public CroissantDTO updateCroissant(@RequestBody Croissant croissantDTO) {
        return croissantService.update(croissantDTO);
    }

    @PutMapping("/{croissantId}/ingredients/{ingredientId}")
    public ResponseEntity<Object> addIngredient(
            @PathVariable Long croissantId,
            @PathVariable Long ingredientId
    ) {
        return croissantService.update(croissantId, ingredientId);
    }
}