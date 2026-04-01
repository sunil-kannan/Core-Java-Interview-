

## 1. Facade

Purpose: Provides a simplified interface to a complex subsystem, hiding its complexity from clients.
Importance: Ranked first because it’s one of the most frequently used structural patterns. Facades are ubiquitous in APIs, libraries, and frameworks to make complex functionality accessible through a simple interface.
How It Works:

A Facade class provides a high-level interface that delegates calls to one or more classes in a subsystem.
It reduces coupling between the client and the subsystem, making the system easier to use and maintain.


### Example:

A media player API that provides a simple play(file) method, hiding the complexity of codecs, file parsers, and rendering engines.
Code:

```java
class MediaPlayerFacade {
    private AudioDecoder audioDecoder = new AudioDecoder();
    private VideoRenderer videoRenderer = new VideoRenderer();
    private FileParser fileParser = new FileParser();
    public void play(String file) {
        fileParser.parse(file);
        audioDecoder.decode();
        videoRenderer.render();
    }
}
```

When to Use:

- To simplify interaction with a complex subsystem (e.g., a database library or graphics engine).
- To reduce coupling between clients and subsystems.
- To provide a unified entry point for multiple operations.

## 2. Adapter

**Purpose**: Converts the interface of a class into another interface that a client expects, enabling compatibility between incompatible systems.
Importance: Ranked second because it’s a go-to solution for integrating legacy systems, third-party libraries, or mismatched interfaces, which is a common challenge in software development.
How It Works:

An Adapter class implements the target interface and wraps an adaptee (the incompatible class), translating calls from the client to the adaptee.
Can be implemented as object adapter (using composition) or class adapter (using inheritance).


Example:

Adapting a legacy OldLogger class (with a logMessage() method) to a new Logger interface (with a log() method).
Code:
```java
interface Logger {
    void log(String message);
}
    
class OldLogger {
    void logMessage(String msg) { System.out.println("Old: " + msg); }
}
    
class LoggerAdapter implements Logger {
    private OldLogger oldLogger;
    public LoggerAdapter(OldLogger oldLogger) { this.oldLogger = oldLogger; }
    public void log(String message) { oldLogger.logMessage(message); }
}
```
### When to Use:

To integrate legacy code or third-party libraries with a new system.
To make incompatible interfaces work together (e.g., adapting a JSON parser to an XML-based system).

Comparison to Abstract Factory/Strategy:

Unlike Abstract Factory (which creates new objects), Adapter reuses existing objects by translating their interfaces.
Unlike Strategy (which changes behavior), Adapter changes the interface, not the underlying functionality.

Why Important: Adapter is critical for system integration, especially in enterprise environments with legacy systems or diverse APIs.

## 3. Decorator

Purpose: Dynamically adds responsibilities or behaviors to an object without modifying its code, using composition.
Importance: Ranked third because it’s widely used in systems requiring flexible, runtime extension of object functionality, such as UI frameworks or stream-based I/O.
How It Works:

A Decorator class implements the same interface as the component it decorates and holds a reference to a component.
It delegates calls to the component while adding new behavior before or after the delegation.


Example:

Adding compression and encryption to a data stream in Java’s I/O system.
Code:
```java
interface DataSource {
    void writeData(String data);
}

class FileDataSource implements DataSource {
    public void writeData(String data) { System.out.println("Writing: " + data); }
}

class CompressionDecorator implements DataSource {
    private DataSource source;
    public CompressionDecorator(DataSource source) { this.source = source; }
    public void writeData(String data) {
        String compressed = compress(data);
        source.writeData(compressed);
    }
    private String compress(String data) { return "Compressed(" + data + ")"; }
}
```


When to Use:

To extend object functionality dynamically (e.g., adding logging, compression, or UI features like scrollbars).
When subclassing is impractical due to many possible combinations.


Comparison to Abstract Factory/Strategy:

Unlike Abstract Factory (which creates objects), Decorator modifies existing objects by wrapping them.
Unlike Strategy (which replaces an entire algorithm), Decorator adds behavior incrementally.


Why Important: Decorator is prevalent in frameworks (e.g., Java’s InputStream/OutputStream) and UI systems, offering flexibility without deep inheritance hierarchies.




