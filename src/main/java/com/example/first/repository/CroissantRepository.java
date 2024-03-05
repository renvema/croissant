package com.example.first.repository;

import com.example.first.model.Croissant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CroissantRepository extends JpaRepository <Croissant, Long>{

   Optional <Croissant> findByNameAndPrice(String name, Double price);

}
