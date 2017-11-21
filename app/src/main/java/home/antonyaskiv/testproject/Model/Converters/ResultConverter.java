package home.antonyaskiv.testproject.Model.Converters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import home.antonyaskiv.testproject.Model.Photo;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */

public class ResultConverter {
    private static final String SEPARATOR = ",";
    public static String strSeparator = "__,__";
    @TypeConverter
    public static List<String> stringToTypes(String text) {
        return Arrays.asList(text.split(","));
    }

    @TypeConverter
    public static String typesTextToString(List<String> list) {
        StringBuilder csvBuilder = new StringBuilder();

        for(String s : list){
            csvBuilder.append(s);
            csvBuilder.append(SEPARATOR);
        }

        String csv = csvBuilder.toString();
        csv = csv.substring(0, csv.length() - SEPARATOR.length());
        return csv;
    }
    @TypeConverter
    public static List<Photo> stringToPhoto(String text)
    {
        String[] photoArray = text.split(strSeparator);
        List<Photo> videos = new ArrayList<Photo>();
        Gson gson = new Gson();
        for (int i=0;i<photoArray.length-1;i++){
            videos.add(gson.fromJson(photoArray[i] , Photo.class));
        }
        return videos;
    }
    @TypeConverter
    public static String photoToString(List<Photo> photos)
    {
        Photo[] photoArray = new Photo[photos.size()];
        for (int i = 0; i <= photos.size()-1; i++) {
            photoArray[i] = photos.get(i);
        }
        String str = "";
        Gson gson = new Gson();
        for (int i = 0; i < photoArray.length; i++) {
            String jsonString = gson.toJson(photoArray[i]);
            str = str + jsonString;
            if (i < photoArray.length - 1) {
                str = str + strSeparator;
            }
        }
        return str;
    }
}
