package src.db;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeProvider 
{
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getCurrentDateTimeAsString()
    {
        LocalDateTime now = LocalDateTime.now();
        return now.format(FORMATTER);
    }
}
