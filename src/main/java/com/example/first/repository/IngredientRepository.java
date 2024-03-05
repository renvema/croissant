package com.example.first.repository;

import com.example.first.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IngredientRepository extends JpaRepository <Ingredient, Long>{ }