# Maven

Maven is a powerful build tool primarily used for Java projects. It simplifies the build process by managing dependencies, compiling source code, packaging compiled code into JAR or WAR files, and much more. Below is an enhanced explanation of Maven, including examples and a structured README.md file.

## Table of Contents
1. [Introduction to Maven](#introduction-to-maven)
2. [Maven Tasks](#maven-tasks)
3. [Basic Building Blocks of Maven](#basic-building-blocks-of-maven)
4. [Examples](#examples)
5. [Conclusion](#conclusion)

## Introduction to Maven

Maven is a build automation tool used primarily for Java projects. It helps in:
- Downloading required third-party libraries.
- Setting up the classpath.
- Compiling Java files.
- Packaging compiled files into JAR or WAR files.

## Maven Tasks

### 1. Creating a Default Project Structure
Maven uses archetypes to create a default project structure. Here are some commonly used archetypes:

- **maven-archetype-quickstart**: Creates a basic code structure for standalone projects.
  ```bash
  mvn archetype:generate -DgroupId=com.example -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
  ```

- **maven-archetype-webapp**: Creates a basic code structure for web applications.
  ```bash
  mvn archetype:generate -DgroupId=com.example -DartifactId=my-webapp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
  ```

### 2. Downloading Dependencies
Maven downloads the required dependencies specified in the `pom.xml` file. For example:
```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 3. Compiling and Packaging
Maven compiles all `.java` files into `.class` files and packages them into `.jar` or `.war` files.
```bash
mvn compile
mvn package
```

### 4. Versioning of Artifacts
Maven handles versioning of artifacts, ensuring that the correct versions of dependencies are used.
```xml
<version>1.0-SNAPSHOT</version>
```

### 5. Generating Documentation
Maven can generate documentation from the Java source code.
```bash
mvn site
```

### 6. Plugin Integration
Maven integrates with various plugins to perform additional tasks. For example, the SonarQube plugin for code quality:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.sonarsource.scanner.maven</groupId>
            <artifactId>sonar-maven-plugin</artifactId>
            <version>3.7.0.1746</version>
        </plugin>
    </plugins>
</build>
```

## Basic Building Blocks of Maven

### GroupId
The `groupId` is a unique identifier for a group of projects. It usually represents the organization or group that the project belongs to.
```xml
<groupId>com.example</groupId>
```

### ArtifactId
The `artifactId` is the name of the project.
```xml
<artifactId>my-app</artifactId>
```

### Version
The `version` specifies the version of the project.
```xml
<version>1.0-SNAPSHOT</version>
```

### Dependencies and Inheritance
In a multi-module project, common dependencies can be added to the parent `pom.xml`, and they will be inherited by child projects.
```xml
<!-- Parent pom.xml -->
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<!-- Child pom.xml -->
<parent>
    <groupId>com.example</groupId>
    <artifactId>parent-project</artifactId>
    <version>1.0-SNAPSHOT</version>
</parent>
```

## Examples

### Example 1: Creating a Simple Maven Project
```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

### Example 2: Adding Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.12.0</version>
    </dependency>
</dependencies>
```

### Example 3: Multi-Module Project
**Parent `pom.xml`**:
```xml
<modules>
    <module>child-project-1</module>
    <module>child-project-2</module>
</modules>
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

**Child `pom.xml`**:
```xml
<parent>
    <groupId>com.example</groupId>
    <artifactId>parent-project</artifactId>
    <version>1.0-SNAPSHOT</version>
</parent>
<artifactId>child-project-1</artifactId>
```

## Conclusion

Maven is an essential tool for Java developers, streamlining the build process and managing dependencies efficiently. By understanding its core concepts and utilizing its features, you can significantly enhance your project's build and deployment process.

For more information, refer to the [Maven documentation](https://maven.apache.org/guides/).

---