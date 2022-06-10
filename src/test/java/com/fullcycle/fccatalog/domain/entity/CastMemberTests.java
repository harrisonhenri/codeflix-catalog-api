package com.fullcycle.fccatalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CastMemberTests {

  @Test
	void shouldThrowIllegalArgumentWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember((String) null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember(""));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameAndTypeIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember((String) null, null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenNameIsEmptyAndTypeIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember("", null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenTypeIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember("Ow", null));
	}

  @Test
	void shouldThrowIllegalArgumentWhenTypeIsNotValid() throws IllegalArgumentException {
    assertThrows(IllegalArgumentException.class, () -> {
      CastMember entity = mock(CastMember.class);

      entity.setName("Eila");
      doThrow(IllegalArgumentException.class).when(entity).setType(CastMemberType.TYPE2);
      entity.setType(CastMemberType.TYPE2);
    });
	}

  @Test
  @EnumSource(value = CastMemberType.class)
	void shouldCreateTheCastMemberWithType() {
    final CastMember entity = new CastMember("CastMember", CastMemberType.TYPE1);

    assertEquals("CastMember", entity.getName());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertEquals(CastMemberType.TYPE1, entity.getType());
	}

  @Test
	void shouldCreateTheCastMemberWithName() {
    final CastMember entity = new CastMember("CastMember");

    assertEquals("CastMember", entity.getName());
    assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertNull(entity.getType());
	}

}
