package com.fullcycle.fccatalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GenreTests {

  @Test
	void shouldThrowIllegalArgumentWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre((UUID) null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre((String) null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Genre(""));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameAndCategoriesIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsEmptyAndCategoryIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
	}

  @Test
	void shouldCreateTheGenreWithCategories() {
    final Category category = new Category("Category");
    final ArrayList<Category> list = new ArrayList<>();
    list.add(category);
    final Genre entity = new Genre("Genre", list);

    assertEquals("Genre", entity.getName());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertEquals(1, entity.getCategories().size());
	}

  @Test
	void shouldCreateTheGenreWithName() {
    final Genre entity = new Genre("Genre");

    assertEquals("Genre", entity.getName());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertEquals(0, entity.getCategories().size());
	}

  @Test
	void shouldAddCategoryToGenre() {
    final Genre entity = new Genre("Genre");
    final Category category = new Category("Category");

    entity.addCategory(category);

    assertEquals(1, entity.getCategories().size());
	}

  @Test
	void shouldRemoveCategoryToGenre() {
    final Genre entity = new Genre("Genre");
    final Category category1 = new Category("Category 1");
    final Category category2 = new Category("Category 2");
    final Category category3 = new Category("Category 3");

    entity.addCategory(category1);
    entity.addCategory(category2);
    entity.addCategory(category3);

    entity.removeCategory(category2);
    assertEquals(2, entity.getCategories().size());
    entity.removeCategory(category3);
    assertEquals(1, entity.getCategories().size());
	}
  
}
