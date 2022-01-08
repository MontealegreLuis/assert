# Assert

[![CI workflow](https://github.com/montealegreluis/assert/actions/workflows/ci.yml/badge.svg)](https://github.com/montealegreluis/assert/actions/workflows/ci.yml)

Assert is a Maven package with assertions (guard clauses) for input validation. Assert can be used to implement pre-/post-conditions on input data.

When assertions fail, an exception is thrown, removing the necessity for if-clauses in your code.

All assertions in the `Assert` class throw an `IllegalArgumentException` if they fail.

## Installation

1. [Authenticating to GitHub Packages](https://github.com/MontealegreLuis/assert/blob/main/installation.md#authenticating-to-github-packages)
2. [Maven](https://github.com/MontealegreLuis/assert/blob/main/installation.md#maven)
3. [Gradle](https://github.com/MontealegreLuis/assert/blob/main/installation.md#gradle)

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

The default error message would be `Value cannot be blank or null. '%s' given.`

## Contribute

Please refer to [CONTRIBUTING](https://github.com/MontealegreLuis/assert/blob/main/CONTRIBUTING.md) for information on how to contribute to phUML.

## License

Released under the [BSD-3-Clause](https://github.com/MontealegreLuis/assert/blob/main/LICENSE).