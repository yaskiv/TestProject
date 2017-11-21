package home.antonyaskiv.testproject.App;

import android.app.Application;
import android.arch.persistence.room.Room;

import home.antonyaskiv.testproject.Model.DAO.ResultsDatabase;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */

public class App extends Application {
    public static App INSTANCE;
    private static final String DATABASE_NAME = "ResultsDB";

    private ResultsDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(), ResultsDatabase.class, DATABASE_NAME)
                .build();

        INSTANCE = this;
    }

    public ResultsDatabase getDB() {
        return database;
    }




}
