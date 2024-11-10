package ru.innopolis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class HumanReadableTimestamp {
    public static void main(String[]args){
        LocalDate publishDate = LocalDate.now().minusDays(3);
        LocalTime publishTime = LocalTime.now().minusHours(2);
        LocalDateTime timestamp = LocalDateTime.of(publishDate, publishTime);

        HumanReadableTimestamp humanReadableTimestamp = new HumanReadableTimestampImpl();
        String result = ((HumanReadableTimestampImpl) humanReadableTimestamp).getTimestamp(timestamp);
        System.out.println(result); // Выведет: опубликовано X Y назад
    }

    public abstract String getTimestamp(LocalDateTime eventTimestamp);
}
