package home.antonyaskiv.testproject.App;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import home.antonyaskiv.testproject.Model.DAO.ResultsDatabase;
import home.antonyaskiv.testproject.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */

public class App extends Application {
    public static App INSTANCE;
    private static final String DATABASE_NAME = "_ResultsDB";

    private ResultsDatabase database;
    private OkHttpClient client;
    private Retrofit api;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(), ResultsDatabase.class, DATABASE_NAME)
                .build();
        Fresco.initialize(this);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        api=new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_adrees))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        INSTANCE = this;
    }
    public Retrofit getAPI()
    {
        return  api;
    }

    public ResultsDatabase getDB() {
        return database;
    }




}
