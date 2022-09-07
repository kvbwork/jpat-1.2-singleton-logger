package kvbdev;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance = null;

    protected int num = 1;
    protected DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public void log(String msg) {
        String dateTimeStr = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println("[" + dateTimeStr + " " + num++ + "] " + msg);
    }
}