//package com.example.first.service;
//
//import com.example.first.entity.Croissant;
//import com.example.first.entity.Ingredient;
//import com.example.first.repository.CroissantRepository;
//import com.example.first.repository.DTO.CroissantDTO;
//import com.example.first.repository.IngredientRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Example;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class CroissantServiceTest {
//
//    @Mock
//    private CroissantRepository croissantRepository;
//
//    @Mock
//    private IngredientRepository ingredientRepository;
//
//    @InjectMocks
//    private CroissantService croissantService;
//
//
//    @Test
//    void save() {
//        Croissant croissantDto = Croissant.builder()
//                .id(1L)
//                .name("Croissant")
//                .price(2.55)
//                .ingredients(Set.of(new Ingredient()))
//                .build();
//
//        CroissantDTO croissant = CroissantDTO.builder()
//                .name("Croissant")
//                .price(2.55)
//                .build();
//
////        Croissant expectedResult = new Croissant(1L, "Croissant", 2.55, Set.of(new Ingredient()));
//
//        when(croissantRepository.exists(Example.of(croissantDto))).thenReturn(false);
//        when(croissantRepository.save(croissantDto)).thenReturn(new Croissant(1L, "Croissant", 2.55, Set.of(new Ingredient())));
//        ResponseEntity<Object> actualResult = croissantService.save(croissant);
//
//        assertThat(actualResult.getStatusCode())
//                .isEqualTo(HttpStatus.OK);
//
//    }
//
//   @Test
//    void saveIfExist() {
//        Croissant expectedResult = Croissant.builder()
//                .id(1L)
//                .name("Croissant")
//                .price(2.55)
//                .ingredients(Set.of(new Ingredient()))
//                .build();
//
//        when(croissantRepository.exists(Example.of(expectedResult))).thenReturn(true);
//        ResponseEntity<Object> actualResult = croissantService.save(expectedResult);
//
//        assertThat(actualResult.getStatusCode())
//                .isEqualTo(HttpStatus.BAD_REQUEST);
//
//       assertThat(actualResult.getBody())
//               .isEqualTo("Croissant already exist");
//
//    }
//}