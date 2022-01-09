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

    assertEquals("Value must be true", exception.getMessage());
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
}
