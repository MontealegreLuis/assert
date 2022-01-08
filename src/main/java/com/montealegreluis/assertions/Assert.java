package com.montealegreluis.assertions;

import java.util.Collection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Assert {
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

  private static void reportIllegalArgument(String message) {
    throw new IllegalArgumentException(message);
  }
}
