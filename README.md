# Assert

[![CodeBeat badge](https://codebeat.co/badges/034ebd51-86c8-479a-9e52-59c95019aeb5)](https://codebeat.co/projects/github-com-montealegreluis-assert-main)
[![CI workflow](https://github.com/montealegreluis/assert/actions/workflows/ci.yml/badge.svg)](https://github.com/montealegreluis/assert/actions/workflows/ci.yml)
[![Release workflow](https://github.com/montealegreluis/assert/actions/workflows/release.yml/badge.svg)](https://github.com/montealegreluis/assert/actions/workflows/release.yml)
[![semantic-release: conventional-commits](https://img.shields.io/badge/semantic--release-conventionalcommits-e10079?logo=semantic-release)](https://github.com/semantic-release/semantic-release)

Assert is a Maven package with assertions (guard clauses) for input validation. Assert can be used to implement pre-/post-conditions on input data.

When assertions fail, an exception is thrown, removing the necessity for if-clauses in your code.

All assertions in the `Assert` class throw an `IllegalArgumentException` if they fail.

## Installation

1. [Authenticating to GitHub Packages](https://github.com/MontealegreLuis/assert/blob/main/docs/installation/authentication.md)
2. [Maven](https://github.com/MontealegreLuis/assert/blob/main/docs/installation/maven.md)
3. [Gradle](https://github.com/MontealegreLuis/assert/blob/main/docs/installation/gradle.md)

## Examples

```java
public final class Username {
  private String username;
    
  public Username(String username) {
    Assert.notBlank(username);
    this.username = username;
  }
}
```


### Assertions

The `Assert` class provides the following assertions

| Method     | Description                                                                                             | Message                                                        |
|------------|---------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| `notNull`  | Check that a value is not `null`                                                                        | `Value cannot be null`                                         |
| `isTrue`   | Check that a value is `true`                                                                            | `Value cannot be false`                                        |
| `notEmpty` | Check that a collection is not empty                                                                    | `Collection cannot be empty`                                   |
| `notBlank` | Check that a String is not blank or `null`                                                              | `Value cannot be blank or null. '%s' given.`                   |
| `uuid`     | Check that a String is a valid UUID                                                                     | `'%s' is not a valid UUID`                                     |
| `min`      | Check that a number is greater than a minimum value                                                     | `Value must be greater than or equal to %2$s. %s given`        |
| `pattern`  | Check that a String matches a given pattern                                                             | `'%s' doesn't match pattern '%2$s'`                            |
| `email`    | Check that a String is a valid email according to [RFC (5322)](https://www.rfc-editor.org/info/rfc5322) | `'%s' is not a valid email address`                            |
| `notIn`    | Check that a a value is not in a given collection                                                       | `Value '%s' was not expected to be one of the values in: %2$s` |

### Custom exception messages

You can pass a custom exception message, as shown in the snippet below.

```java
public final class Username {
  private String username;
    
  public Username(String username) {
    Assert.notBlank(username, "Username cannot be blank or null. '%s' given");
    this.username = username;
  }
}
```

This package provides consistent placeholder ordering for all assertions:

- `%s` for the tested value, e.g. `"value"`.
- `%2$s`, `%3$s`, ... for all additional assertion-specific values, e.g. the minimum/maximum value, etc.

## Contribute

Please refer to [CONTRIBUTING](https://github.com/MontealegreLuis/assert/blob/main/CONTRIBUTING.md) for information on how to contribute to Assert.

## License

Released under the [BSD-3-Clause](https://github.com/MontealegreLuis/assert/blob/main/LICENSE).
