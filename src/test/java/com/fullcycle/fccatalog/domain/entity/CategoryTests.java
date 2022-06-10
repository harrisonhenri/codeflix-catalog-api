package com.fullcycle.fccatalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTests {

  @Test
	void shouldThrowIllegalArgumentWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Category((UUID) null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Category((String) null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Category(""));
	}

  @Test
	void shouldCreateTheCategorySuccessfully() {
    final Category entity = new Category("Category");

    assertEquals("Category", entity.getName());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}
  
}
