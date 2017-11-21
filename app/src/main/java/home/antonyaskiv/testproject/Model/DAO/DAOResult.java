package home.antonyaskiv.testproject.Model.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import home.antonyaskiv.testproject.Model.Result;
import io.reactivex.Flowable;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */
@Dao
public interface DAOResult {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertResults(Result... results);

    @Insert
    public void insertBothResult(Result result1, Result result2);

    @Update
    public void updateResults(Result... users);
    @Delete
    public void deleteResults(Result... users);
    @Query("SELECT * FROM result")
    public Flowable<List<Result>> loadAllResults();
}
