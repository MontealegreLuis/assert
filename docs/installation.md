# Installation

## Authenticating to GitHub packages

This Maven package is distributed through the GitHub [package registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry).
In order to install this package you'll need a GitHub [access token](https://github.com/settings/tokens) with the following scope: `read:packages` as described in the [GitHub documentation](https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages#about-scopes-and-permissions-for-package-registries)

### Maven

You can authenticate to GitHub Packages with Apache Maven by editing your `~/.m2/settings.xml` configuration file.

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>

  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
        </repository>
        <repository>
          <id>github</id>
          <url>https://maven.pkg.github.com/montealegreluis/assert</url>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>USERNAME</username>
      <password>TOKEN</password>
    </server>
  </servers>
</settings>
```

Replace `USERNAME` and `TOKEN` accordingly.

Add the following entry to your `dependencies` in your project's `pom.xml` file.

```xml
<dependency>
  <groupId>com.montealegreluis</groupId>
  <artifactId>assert</artifactId>
  <version>1.1-SNAPSHOT</version>
</dependency>
```

### Gradle

Create a `gradle.properties` file with the following content.

```groovy
gpr.user=YOUR_USERNAME
gpr.token=YOUR_TOKEN
```

Add `gradle.properties` to your `.gitignore` to prevent accidentally leaking your access token.

Alternatively, you can set environment variables `USERNAME` and `TOKEN`.

Declare this project's Maven repository within `repositores` in your `build.gradle` file.

```groovy
maven {
    url = uri("https://maven.pkg.github.com/montealegreluis/assert")
    credentials {
        username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
    }
}
```

Lastly, add the following entry to your `dependencies` in your `gradle.build` file.

```groovy
implementation 'com.montealegreluis:assert'
```
