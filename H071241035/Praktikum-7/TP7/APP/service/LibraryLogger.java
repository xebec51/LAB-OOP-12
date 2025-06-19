package APP.service;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = timestamp + ": " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}