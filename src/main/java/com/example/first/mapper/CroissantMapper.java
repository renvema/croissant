package com.example.first.mapper;

import com.example.first.entity.Croissant;
import com.example.first.repository.DTO.CroissantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CroissantMapper {

    CroissantDTO fromEntity(Croissant croissant);

    Croissant toEntity(CroissantDTO croissantDTO);
}
