package home.antonyaskiv.testproject.Model.DAO;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import home.antonyaskiv.testproject.Model.Result;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */
@Database(entities = Result.class, version = 1,exportSchema = false)
public abstract  class ResultsDatabase extends RoomDatabase {
    public abstract DAOResult resultDAO();
}
