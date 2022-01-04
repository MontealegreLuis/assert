package com.montealegreluis.assertions;

public final class Assert {
  public static void notBlank(String value) {
    notBlank(value, String.format("Expected a not blank value. '%s' given.", value));
  }

  public static void notBlank(String value, String message) {
    if (value == null || value.trim().isEmpty()) {
      reportIllegalArgument(String.format(message, value));
    }
  }

  private static void reportIllegalArgument(String message) {
    throw new IllegalArgumentException(message);
  }

  private Assert() {}
}
