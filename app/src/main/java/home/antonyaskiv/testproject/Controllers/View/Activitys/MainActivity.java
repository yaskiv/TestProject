package home.antonyaskiv.testproject.Controllers.View.Activitys;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import home.antonyaskiv.testproject.API.MapsGoogleAPI;
import home.antonyaskiv.testproject.App.App;
import home.antonyaskiv.testproject.Controllers.Adapters.RecyclerAdapter;
import home.antonyaskiv.testproject.Model.API;
import home.antonyaskiv.testproject.Model.Result;
import home.antonyaskiv.testproject.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Observable<API> res;
    MapsGoogleAPI api;
    Disposable d;
    RecyclerView recyclerView_of_results;
    SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager layoutManager_of_results;
    private List<Result> list_of_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = App.get().getAPI().create(MapsGoogleAPI.class);
        Request();


        recyclerView_of_results = findViewById(R.id.recycler_for_results);
        layoutManager_of_results = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView_of_results.setItemAnimator(itemAnimator);
        recyclerView_of_results.setLayoutManager(layoutManager_of_results);
        // list_of_result=new ArrayList<>();
        res.subscribe(response -> recyclerView_of_results.setAdapter(new RecyclerAdapter(response.getResults(),this)));
        swipeRefreshLayout = findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setOnRefreshListener(() ->
        {
            Request();
            res.subscribe(response -> recyclerView_of_results.setAdapter(new RecyclerAdapter(response.getResults(),this))
                    ,e->Log.d("eror",e.getMessage())
            ,       ()->swipeRefreshLayout.setRefreshing(false)  );
        });

    }

    private void Request() {
        res = api.get(getString(R.string.location), getString(R.string.radius), getString(R.string.key))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        res.subscribe(response -> log(response));
    }

    void log(API api) {
        Observable<Result> db = Observable.fromIterable(api.getResults())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        new Thread(() -> db.subscribe(result -> App.get().getDB().resultDAO().insertResults(result)));


        try {
            rec();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void rec() throws InterruptedException {
        Thread.sleep(4000);
        App.get().getDB().resultDAO().loadAllResults()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> Log.d("DB_OK", list.get(0).getName()));

    }
}
