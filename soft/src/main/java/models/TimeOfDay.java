package models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeOfDay {

    public static String getCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter HHmm = DateTimeFormatter.ofPattern("HH:mm");

        return currentTime.format(HHmm); // currentTime.toString();
    }

    public static String getTimeOfDay() {
        LocalTime currentTime = LocalTime.now();

        LocalTime morning = LocalTime.of(6, 0);
        LocalTime midday = LocalTime.of(9, 0);
        LocalTime afternoon = LocalTime.of(12, 0);
        LocalTime evening = LocalTime.of(18, 0);
        LocalTime night = LocalTime.of(23, 59);

        if (currentTime.isAfter(morning) && currentTime.isBefore(midday)) {
            return "God morgen!";
        }
        else if (currentTime.isAfter(midday) && currentTime.isBefore(afternoon)) {
            return "God formiddag!";
        }
        else if (currentTime.isAfter(afternoon) && currentTime.isBefore(evening)) {
            return "God ettermiddag!";
        }
        else if (currentTime.isAfter(evening) && currentTime.isBefore(night)) {
            return "God kveld!";
        }
        else {
            return "God natt!";
        }
    }
}
