package com.fullcycle.fccatalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VideoTests {

  @Test
	void shouldThrowIllegalArgumentWhenTitleIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Video(null, "Description", 2010, false));
	}

  @Test
	void shouldThrowIllegalArgumentWhenTitleIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Video("", "Description", 2010, false));
	}

  @Test
	void shouldThrowIllegalArgumentWhenYearLaunchedIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Video("Title 1", "Description", null, false));
	}

  @Test
	void shouldThrowIllegalArgumentWhenYearLaunchedIsBetween0And1700() {
    assertThrows(IllegalArgumentException.class, () -> new Video("Title 1", "Description", 1500, false));
	}

  @Test
	void shouldThrowIllegalArgumentWhenYearLaunchedIsGreaterThanCurrentYear() {
    assertThrows(IllegalArgumentException.class, () -> new Video("Title 1", "Description", 2200, false));
	}
  
  @Test
	void shouldCreateTheVideoWithTitleAndYear() {
    final Video entity = new Video("Title", "Description", 2010, false);

    assertEquals("Title", entity.getTitle());
    assertEquals("Description", entity.getDescription());
    assertEquals(2010, entity.getYearLaunched());
    assertEquals(false, entity.getOpened());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}
  
  @Test
	void shouldCreateTheVideoWithTitleYearRatingAndDuration() {
    final Video entity = new Video("Title", "Description", 2010, false, "Rating", 10.0f);

    assertEquals("Title", entity.getTitle());
    assertEquals("Description", entity.getDescription());
    assertEquals(2010, entity.getYearLaunched());
    assertFalse(entity.getOpened());
    assertEquals(10f, entity.getDuration());
    assertEquals("Rating", entity.getRating());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}
  
  @Test
	void shouldCreateTheVideoWithoutFiles() {
    final Category category = new Category("Category");
    final ArrayList<Category> categories = new ArrayList<>();
    categories.add(category);
    final Genre genre = new Genre("Category");
    final ArrayList<Genre> genres = new ArrayList<>();
    genres.add(genre);
    final CastMember castMember = new CastMember("Category");
    final ArrayList<CastMember> castMembers = new ArrayList<>();
    castMembers.add(castMember);

    
    final Video entity = new Video("Title", "Description", 2010, 10.0f, categories, genres, castMembers);

    assertEquals("Title", entity.getTitle());
    assertEquals("Description", entity.getDescription());
    assertEquals(2010, entity.getYearLaunched());
    assertEquals(10f, entity.getDuration());
    assertEquals(1, entity.getCategories().size());
    assertEquals(1, entity.getGenres().size());
    assertEquals(1, entity.getCastMembers().size());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}

  @Test
	void shouldCreateTheVideoWithoutFilesAndAddCategories() {
    final Category category = new Category("Category");
    
    final Video entity = new Video("Title", "Description", 2010, 10.0f);
    entity.addCategory(category);

    assertEquals("Title", entity.getTitle());
    assertEquals("Description", entity.getDescription());
    assertEquals(2010, entity.getYearLaunched());
    assertEquals(10f, entity.getDuration());
    assertEquals(1, entity.getCategories().size());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}

  @Test
	void shouldCreateTheVideoWithoutFilesAndAddGenres() {
    final Genre genre = new Genre("Genre");
    
    final Video entity = new Video("Title", "Description", 2010, 10.0f);
    entity.addGenre(genre);

    assertEquals("Title", entity.getTitle());
    assertEquals("Description", entity.getDescription());
    assertEquals(2010, entity.getYearLaunched());
    assertEquals(10f, entity.getDuration());
    assertEquals(1, entity.getGenres().size());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}

  @Test
	void shouldCreateTheVideoWithoutFilesAndCastMember() {
    final CastMember castMember = new CastMember("CastMember");
    
    final Video entity = new Video("Title", "Description", 2010, 10.0f);
    entity.addCastMember(castMember);;

    assertEquals("Title", entity.getTitle());
    assertEquals("Description", entity.getDescription());
    assertEquals(2010, entity.getYearLaunched());
    assertEquals(10f, entity.getDuration());
    assertEquals(1, entity.getCastMembers().size());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
	}
}
