package com.example.first.service;

import com.example.first.entity.Croissant;
import com.example.first.entity.Ingredient;
import com.example.first.mapper.CroissantMapper;
import com.example.first.repository.CroissantRepository;
import com.example.first.repository.DTO.CroissantDTO;
import com.example.first.repository.IngredientRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CroissantService {

    @Autowired
    private CroissantRepository croissantRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CroissantMapper croissantMapper;

    public List<CroissantDTO> getCroissants() {
        return croissantRepository.findAll()
                .stream()
                .map(v -> croissantMapper.fromEntity(v))
                .collect(Collectors.toList());
    }

    public CroissantDTO save(CroissantDTO croissantDto) {
        Croissant croissant = croissantMapper.toEntity(croissantDto);
        if (isExist(croissant)) {
            throw new EntityExistsException("Croissant already exist");
        }
        Croissant saveCroissant = croissantRepository.save(croissant);
        return croissantMapper.fromEntity(saveCroissant);
    }

    public CroissantDTO update(Croissant updateCroissant) {

        Optional<Croissant> croissant = croissantRepository.findById(updateCroissant.getId());
        if (croissant.isEmpty()) {
            throw new EntityNotFoundException("Croissant is not exist");
        }
        Croissant newCroissant = croissant.get();
        newCroissant.setName(updateCroissant.getName());
        newCroissant.setPrice(updateCroissant.getPrice());

        return croissantMapper.fromEntity(croissantRepository.save(newCroissant));
    }

    public ResponseEntity<Object> update(Long croissantId, Long ingredientId) {
        Optional<Croissant> croissant = croissantRepository.findById(croissantId);
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if (croissant.isEmpty()) {
            return ResponseEntity.badRequest().body("Croissant does not exist");
        }
        if (ingredient.isEmpty()) {
            return ResponseEntity.badRequest().body("Ingredient does not exist");
        }

        Croissant existingCroissant = croissant.get();
        Ingredient existingIngredient = ingredient.get();
        existingCroissant.setIngredients(Set.of(existingIngredient));
//        existingIngredient.croissants.add(existingCroissant);

//        existingCroissant.setIngredients(Set.of(existingIngredient));
        ingredientRepository.saveAndFlush(existingIngredient);
        Croissant saved = croissantRepository.saveAndFlush(existingCroissant);

        return ResponseEntity.ok(saved);
    }

    private boolean isExist(Croissant croissant) {
        return croissantRepository.exists(Example.of(croissant));
    }
}