import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class Logging {
    public static void main(String[] args) {
        Logger log = new LeveledLogger(LogLevel.Info, new TimestampedLogger(new ConsoleLogger(new FileLogger("log.txt"))));
        log.info("Hello, world!"); // 2019-05-02T12:03:25.519 [Info]: Hello, world!
        log.warn("Some warning");  // 2019-05-02T12:03:25.678 [Warn]: Some warning
        log.trace("This will be filtered");  // no output
    }
}

enum LogLevel {
    Trace,
    Debug,
    Info,
    Warn,
    Error;
}

interface Logger {
    default void trace(String format, Object... args) {
        this.log(LogLevel.Trace, format, args);
    }
    default void debug(String format, Object... args) {
        this.log(LogLevel.Debug, format, args);
    }
    default void info(String format, Object... args) {
        this.log(LogLevel.Info, format, args);
    }
    default void warn(String format, Object... args) {
        this.log(LogLevel.Warn, format, args);
    }
    default void error(String format, Object... args) {
        this.log(LogLevel.Error, format, args);
    }
    void setLogLevel(LogLevel level);
    void log(LogLevel level, String format, Object... args);
}

class ConsoleLogger implements Logger {

    Logger otherLogger;
    LogLevel logLevel;

    public ConsoleLogger() {
    }

    public ConsoleLogger(Logger otherLogger) {
        this.otherLogger = otherLogger;
    }

    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    public void log(LogLevel level, String format, Object... args) {
        if (this.otherLogger != null) {
            this.otherLogger.log(level, format, args);
        }
        System.out.println(String.format(format, args));
    }
}

class FileLogger implements Logger {

    Logger otherLogger;
    String filePath;
    LogLevel logLevel;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    public FileLogger(String filePath, Logger otherLogger) {
        this.filePath = filePath;
        this.otherLogger = otherLogger;
    }

    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    public void log(LogLevel level, String format, Object... args) {
        if (this.otherLogger != null) {
            this.otherLogger.log(level, format, args);
        }
        try {
            FileWriter writer = new FileWriter(this.filePath);
            String message = String.format(format, args);
            writer.write(message, 0, message.length());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

public class TimestampedLogger implements Logger {

    Logger otherLogger;
    LogLevel logLevel;

    public TimestampedLogger(Logger otherLogger) {
        this.otherLogger = otherLogger;
    }

    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    public void log(LogLevel level, String format, Object... args) {
        if (this.otherLogger != null) {
            this.otherLogger.log(level, String.format("%s %s", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), String.format(format, args)));
        }
    }
}

class LeveledLogger implements Logger {

    Logger otherLogger;
    LogLevel logLevel;

    public LeveledLogger(LogLevel level, Logger otherLogger) {
        this.otherLogger = otherLogger;
        this.logLevel = level;
    }

    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    public void log(LogLevel level, String format, Object... args) {
        if (this.otherLogger != null && level.compareTo(this.logLevel) >= 0) {
            this.otherLogger.log(level, String.format("[%s]: %s", level.toString(), String.format(format, args)));
        }
    }
}
