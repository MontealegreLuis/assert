package com.montealegreluis.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

final class AssertTest {
  @Test
  void not_null_assertion_allows_only_non_null_values() {
    assertDoesNotThrow(() -> Assert.notNull(true));
  }

  @Test
  void not_null_assertion_prevents_null_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notNull(null));

    assertEquals("Value cannot be null", exception.getMessage());
  }

  @Test
  void not_null_assertion_reports_custom_message_on_null_values() {
    var customErrorMessage = "Username cannot be null";
    String username = null;

    var exception =
        assertThrows(
            IllegalArgumentException.class, () -> Assert.notNull(username, customErrorMessage));

    assertEquals("Username cannot be null", exception.getMessage());
  }

  @Test
  void is_true_assertion_allows_only_true_values() {
    assertDoesNotThrow(() -> Assert.isTrue(true));
  }

  @Test
  void is_true_assertion_prevents_false_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.isTrue(false));

    assertEquals("Value cannot be false", exception.getMessage());
  }

  @Test
  void is_true_assertion_reports_custom_message_on_false_values() {
    var customErrorMessage = "Value must be greater than 3";

    var exception =
        assertThrows(
            IllegalArgumentException.class, () -> Assert.isTrue(2 > 3, customErrorMessage));

    assertEquals("Value must be greater than 3", exception.getMessage());
  }

  @Test
  void not_blank_assertion_allows_non_empty_value() {
    assertDoesNotThrow(() -> Assert.notBlank("Not blank value"));
    assertDoesNotThrow(() -> Assert.notBlank("Not blank value", "Custom message"));
  }

  @Test
  void not_blank_assertion_prevents_null_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notBlank(null));

    assertEquals("Value cannot be blank or null. 'null' given.", exception.getMessage());
  }

  @Test
  void not_blank_assertion_prevents_empty_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notBlank(""));

    assertEquals("Value cannot be blank or null. '' given.", exception.getMessage());
  }

  @Test
  void not_blank_assertion_prevents_blank_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notBlank(" "));

    assertEquals("Value cannot be blank or null. ' ' given.", exception.getMessage());
  }

  @Test
  void not_blank_assertion_reports_custom_message_on_blank_values() {
    var customErrorMessage = "Value cannot be null or empty. '%s' was provided";

    var exception =
        assertThrows(
            IllegalArgumentException.class, () -> Assert.notBlank(null, customErrorMessage));

    assertEquals("Value cannot be null or empty. 'null' was provided", exception.getMessage());
  }

  @Test
  void not_empty_assertion_accepts_non_empty_collections() {
    assertDoesNotThrow(() -> Assert.notEmpty(List.of("element")));
  }

  @Test
  void not_empty_assertion_prevents_empty_collections() {
    var exception =
        assertThrows(
            IllegalArgumentException.class, () -> Assert.notEmpty(Collections.emptyList()));

    assertEquals("Collection cannot be empty", exception.getMessage());
  }

  @Test
  void not_empty_assertion_reports_custom_message_on_empty_collections() {
    var customErrorMessage = "Shopping cart cannot be empty";

    var exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> Assert.notEmpty(Collections.emptyList(), customErrorMessage));

    assertEquals(customErrorMessage, exception.getMessage());
  }

  @Test
  void uuid_assertion_prevents_invalid_UUIDs() {
    assertThrows(IllegalArgumentException.class, () -> Assert.uuid(" "));
    assertThrows(IllegalArgumentException.class, () -> Assert.uuid(null));
    assertThrows(IllegalArgumentException.class, () -> Assert.uuid("not an UUID"));
  }

  @Test
  void uuid_assertion_accepts_valid_UUIDs() {
    assertDoesNotThrow(() -> Assert.uuid("2ce88a3b-d393-4013-8ebc-7f8c9e0a6b01"));
  }

  @Test
  void uuid_assertion_reports_custom_message_on_invalid_UUIDs() {
    var exception =
        assertThrows(
            IllegalArgumentException.class, () -> Assert.uuid(null, "'%s' must be a valid UUID"));

    assertEquals("'null' must be a valid UUID", exception.getMessage());
  }

  @Test
  void min_assertion_prevents_values_less_than_minimum_value() {
    assertThrows(IllegalArgumentException.class, () -> Assert.min(0, 1));
  }

  @Test
  void min_assertion_accepts_values_less_than_or_equal_to_minimum_value() {
    assertDoesNotThrow(() -> Assert.min(1, 1));
    assertDoesNotThrow(() -> Assert.min(2, 1));
  }

  @Test
  void min_assertion__reports_custom_message_on_values_less_minimum_value() {
    var exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> Assert.min(0, 1, "Value is not greater than %2$s"));

    assertEquals("Value is not greater than 1", exception.getMessage());
  }
}
