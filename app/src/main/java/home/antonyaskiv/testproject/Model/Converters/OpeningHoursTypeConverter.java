package home.antonyaskiv.testproject.Model.Converters;

import android.arch.persistence.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */

public class OpeningHoursTypeConverter {
    private static final String SEPARATOR = ",";
    @TypeConverter
    public static List<String> stringToWeekdayText(String text) {
        return Arrays.asList(text.split(","));
    }


    @TypeConverter
    public static String weekdayTextToString(List<String> list) {
        StringBuilder csvBuilder = new StringBuilder();

        for(String s : list){
            csvBuilder.append(s);
            csvBuilder.append(SEPARATOR);
        }

        String csv = csvBuilder.toString();
        if(csv.length()>0) {
            csv = csv.substring(0, csv.length() - SEPARATOR.length());
        }
                return csv;
    }
}
