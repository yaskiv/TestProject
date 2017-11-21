package home.antonyaskiv.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import home.antonyaskiv.testproject.API.MapsGoogleAPI;
import home.antonyaskiv.testproject.App.App;
import home.antonyaskiv.testproject.Model.API;
import home.antonyaskiv.testproject.Model.Result;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapsGoogleAPI api=App.get().getAPI().create(MapsGoogleAPI.class);
        Observable<API> res= api.get(getString(R.string.location),getString(R.string.radius),getString(R.string.key));
        res .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response->log(response));

    }
    void log(API api)
    {
        Log.d("API!!",api.getStatus());
        new Thread(() -> {
            for (Result result :api.getResults()){
                App.get().getDB().resultDAO().insertResults(result);
            }
        }).start();

        try {
            rec();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void rec() throws InterruptedException {
        Thread.sleep(4000);
        new Thread(() -> App.get().getDB().resultDAO().loadAllResults().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> Log.d("DB_OK", list.get(0).getName()))
        ).start();
    }
}
