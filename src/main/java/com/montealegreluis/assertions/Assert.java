package com.montealegreluis.assertions;

import io.vavr.control.Try;
import java.util.Collection;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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

  public static void notIn(Object value, Collection<?> collection) {
    if (collection.contains(value))
      reportIllegalArgument(
          "Value '%s' was not expected to be one of the values in: %2$s",
          value, format(collection));
  }

  public static void notIn(Object value, Collection<?> collection, String message) {
    if (collection.contains(value)) reportIllegalArgument(message, value, format(collection));
  }

  public static void notBlank(String value) {
    notBlank(value, "Value cannot be blank or null. '%s' given.");
  }

  public static void notBlank(String value, String message) {
    if (value == null || value.trim().isEmpty()) {
      reportIllegalArgument(message, value);
    }
  }

  public static void uuid(String value) {
    uuid(value, "'%s' is not a valid UUID");
  }

  public static void uuid(String value, String message) {
    Try.run(() -> UUID.fromString(value)).onFailure((e) -> reportIllegalArgument(message, value));
  }

  public static <U extends Number, T extends Comparable<U>> void min(T value, U minimumValue) {
    min(value, minimumValue, "Value must be greater than or equal to %2$s. %s given");
  }

  public static <U extends Number, T extends Comparable<U>> void min(
      T value, U minimumValue, String message) {
    if (value.compareTo(minimumValue) < 0) reportIllegalArgument(message, value, minimumValue);
  }

  public static void pattern(String value, String pattern) {
    pattern(value, pattern, "'%s' doesn't match pattern '%2$s'");
  }

  public static void pattern(String value, String pattern, String message) {
    var matcher = Pattern.compile(pattern).matcher(value);
    if (!matcher.find()) reportIllegalArgument(message, value, pattern);
  }

  private static String format(Collection<?> collection) {
    return collection.stream().map(Object::toString).collect(Collectors.joining(", "));
  }

  private static void reportIllegalArgument(String message, Object... arguments) {
    throw new IllegalArgumentException(String.format(message, arguments));
  }
}
