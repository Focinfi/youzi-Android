package com.focinfi.youzi.views;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.focinfi.youzi.App;
import com.focinfi.youzi.R;
import com.focinfi.youzi.beans.TouristRegionBean;
import com.focinfi.youzi.models.TouristRegionModel;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.IOException;

public class TouristRegionActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    TouristRegionModel touristRegionModel = new TouristRegionModel();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView textView;
        textView = (TextView) findViewById(R.id.test_view);
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String responseStr = touristRegionModel.find("1", getApplicationContext()).toString();
                    subscriber.onNext(responseStr);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onNext(String str) {
                        textView.setText(str);
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("[Tourist Region View]", e.toString());
                    }
                });

    }
}
