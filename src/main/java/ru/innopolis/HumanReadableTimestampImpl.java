package ru.innopolis;

import java.time.Duration;
import java.time.LocalDateTime;

public class HumanReadableTimestampImpl extends HumanReadableTimestamp {

        @Override
        public String getTimestamp(LocalDateTime eventTimestamp) {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(eventTimestamp, now);

            long minutes = duration.toMinutes();
            long hours = duration.toHours();
            long days = duration.toDays();

            if (days > 0) {
                // Если публикация была более суток назад
                if (days == 1) {
                    return "опубликовано вчера";
                } else {
                    return String.format("опубликовано %d %s назад", days, getDaysSuffix(days));
                }
            } else if (hours > 0) {
                // Если публикация была менее суток, но более часа
                return String.format("опубликовано %d %s назад", hours, getHoursSuffix(hours));
            } else if (minutes >= 0) {
                // Если публикация была менее часа назад
                return String.format("опубликовано %d %s назад", minutes, getMinutesSuffix(minutes));
            }

            return "опубликовано только что"; // В случае, если время публикации совпадает с текущим
        }

        private String getDaysSuffix(long days) {
            if (days % 10 == 1 && days % 100 != 11) {
                return "день";
            } else if ((days % 10 >= 2 && days % 10 <= 4) && (days % 100 < 10 || days % 100 >= 20)) {
                return "дня";
            } else {
                return "дней";
            }
        }

        private String getHoursSuffix(long hours) {
            if (hours % 10 == 1 && hours % 100 != 11) {
                return "час";
            } else if ((hours % 10 >= 2 && hours % 10 <= 4) && (hours % 100 < 10 || hours % 100 >= 20)) {
                return "часа";
            } else {
                return "часов";
            }
        }

        private String getMinutesSuffix(long minutes) {
            if (minutes % 10 == 1 && minutes % 100 != 11) {
                return "минуту";
            } else if ((minutes % 10 >= 2 && minutes % 10 <= 4) && (minutes % 100 < 10 || minutes % 100 >= 20)) {
                return "минуты";
            } else {
                return "минут";
            }
        }
    }
