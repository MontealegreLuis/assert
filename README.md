# Assert

[![CI workflow](https://github.com/montealegreluis/assert/actions/workflows/ci.yml/badge.svg)](https://github.com/montealegreluis/assert/actions/workflows/ci.yml)

Assert is a Maven package with assertions (guard clauses) for input validation. Assert can be used to implement pre-/post-conditions on input data.

The main goal of Assert is to minimize the code to implement assertions. When assertions fail, an exception is thrown, removing the necessity for if-clauses in your code.

All assertions in the `Assert` class throw an `IllegalArgumentException` if they fail.

## Examples

```java
public final class Filename {
  private String filename;
    
  public Filename(String filename) {
    Assert.notBlank(filename);
    this.filename = filename;
  }
}
```

### Custom exception messages

You can pass a custom exception message, as shown in the snippet below.

```java
public final class Filename {
  private String filename;
    
  public Filename(String filename) {
    Assert.notBlank(filename, "Filename cannot be empty or null. '%s' given");
    this.filename = filename;
  }
}
```

The default error message would be `Expected a not blank value. '%s' given.`
