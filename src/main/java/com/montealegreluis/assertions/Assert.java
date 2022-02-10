package com.montealegreluis.assertions;

import io.vavr.control.Try;
import java.util.Collection;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Assert {
  public static void notNull(Object value) {
    notNull(value, "Value cannot be null");
  }

  public static void notNull(Object value, String message) {
    if (value == null) reportIllegalArgument(message);
  }

  public static void isTrue(boolean value) {
    isTrue(value, "Value cannot be false");
  }

  public static void isTrue(boolean value, String message) {
    if (!value) reportIllegalArgument(message);
  }

  public static void notEmpty(Collection<?> collection) {
    notEmpty(collection, "Collection cannot be empty");
  }

  public static void notEmpty(Collection<?> collection, String message) {
    if (collection.isEmpty()) reportIllegalArgument(message);
  }

  public static void notBlank(String value) {
    notBlank(value, String.format("Value cannot be blank or null. '%s' given.", value));
  }

  public static void notBlank(String value, String message) {
    if (value == null || value.trim().isEmpty()) {
      reportIllegalArgument(String.format(message, value));
    }
  }

  public static void uuid(String value) {
    uuid(value, String.format("'%s' is not a valid UUID", value));
  }

  public static void uuid(String value, String message) {
    Try.run(() -> UUID.fromString(value)).onFailure((e) -> reportIllegalArgument(message));
  }

  public static void min(long value, long minimumValue) {
    min(
        value,
        minimumValue,
        String.format(
            "Value must be greater than or equal to %2$s. %s given", value, minimumValue));
  }

  public static void min(long value, long minimumValue, String message) {
    if (value < minimumValue) reportIllegalArgument(message);
  }

  private static void reportIllegalArgument(String message) {
    throw new IllegalArgumentException(message);
  }
}
