package com.montealegreluis.assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

final class AssertTest {
  @Test
  void it_prevents_null_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notBlank(null));

    assertEquals("Expected a not blank value. 'null' given.", exception.getMessage());
  }

  @Test
  void it_prevents_empty_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notBlank(""));

    assertEquals("Expected a not blank value. '' given.", exception.getMessage());
  }

  @Test
  void it_prevents_blank_values() {
    var exception = assertThrows(IllegalArgumentException.class, () -> Assert.notBlank(" "));

    assertEquals("Expected a not blank value. ' ' given.", exception.getMessage());
  }

  @Test
  void it_reports_custom_message_on_blank_values() {
    var customErrorMessage = "Value cannot be null or empty";

    var exception =
        assertThrows(
            IllegalArgumentException.class, () -> Assert.notBlank(null, customErrorMessage));

    assertEquals(customErrorMessage, exception.getMessage());
  }
}
