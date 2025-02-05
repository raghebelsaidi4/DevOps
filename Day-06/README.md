# Logging Levels in Java

Logging is an essential part of any application for debugging, monitoring, and troubleshooting. Java provides different logging levels to capture messages with varying degrees of importance.

## Log Levels

### 1. Trace
- **Definition**: Trace is the most granular logging level. It is used to track the detailed flow of execution in an application, including method calls and variable values.
- **Use Case**: When diagnosing hard-to-find issues or analyzing step-by-step execution.
- **Example**:
  ```java
  logger.trace("Entering method processOrder with parameters: " + orderId);
  ```

### 2. Debug
- **Definition**: Debug is less detailed than Trace but still provides comprehensive information useful for debugging.
- **Use Case**: Logging detailed messages about logic execution, calculations, and variable states.
- **Example**:
  ```java
  logger.debug("User authentication successful for user: " + username);
  ```

### 3. Info
- **Definition**: Logs high-level informational messages about the application's state.
- **Use Case**: Logging significant events that are not errors, such as application startup or configuration loading.
- **Example**:
  ```java
  logger.info("Application started successfully on port 8080");
  ```

### 4. Warn
- **Definition**: Logs potential issues that do not disrupt execution but require attention.
- **Use Case**: Deprecation warnings, high memory usage, or retries on failures.
- **Example**:
  ```java
  logger.warn("Memory usage is high: 85% used");
  ```

### 5. Error
- **Definition**: Logs serious issues where a part of the application has failed but the system continues running.
- **Use Case**: Exceptions, failed database connections, or API failures.
- **Example**:
  ```java
  try {
      int result = 10 / 0;
  } catch (ArithmeticException e) {
      logger.error("Division by zero error", e);
  }
  ```

### 6. Fatal
- **Definition**: Logs critical failures that cause the application or system to crash.
- **Use Case**: JVM crashes, server failures, or unrecoverable states.
- **Example**:
  ```java
  logger.fatal("Critical error! System shutting down.");
  ```

---

## Configuring Logging in Java

### Example Log4j Configuration (log4j.xml)

```xml
<Configuration>
    <Appenders>
        <Console name="ConsoleAppender" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %c{1} - %msg%n"/>
        </Console>
        <RollingFile name="FileAppender" fileName="logs/app.log"
                     filePattern="logs/app-%d{yyyy-MM-dd}.log">
            <PatternLayout>
                <Pattern>%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %c{1} - %msg%n</Pattern>
            </PatternLayout>
            <Policies>
                <SizeBasedTriggeringPolicy size="10MB"/>
            </Policies>
        </RollingFile>
    </Appenders>
    
    <Loggers>
        <Root level="error">
            <AppenderRef ref="ConsoleAppender"/>
            <AppenderRef ref="FileAppender"/>
        </Root>
    </Loggers>
</Configuration>
```

---

## Rolling File Appender

- If the application continuously logs, the file size will grow, making it difficult to search for logs.
- `RollingFileAppender` ensures logs do not exceed a specified size by rolling over to a backup file.
- Old logs can be archived based on policies such as file count or date.
- Example policy:
    - Max file size: 10MB
    - Rolling strategy: Create new log file daily

### Example Configuration:
```xml
<RollingFile name="FileAppender" fileName="logs/app.log"
             filePattern="logs/app-%d{yyyy-MM-dd}.log">
    <PatternLayout>
        <Pattern>%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %c{1} - %msg%n</Pattern>
    </PatternLayout>
    <Policies>
        <SizeBasedTriggeringPolicy size="10MB"/>
    </Policies>
</RollingFile>
```

---

## Conclusion

- Logging is crucial for tracking application behavior and diagnosing issues.
- Use the appropriate logging level based on the severity and detail of the message.
- Configure `RollingFileAppender` to manage log file sizes efficiently.
- Always log meaningful messages to facilitate debugging and monitoring.

---

### References
- [Log4j Documentation](https://logging.apache.org/log4j/2.x/manual/configuration.html)
- [Spring Boot Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging)

