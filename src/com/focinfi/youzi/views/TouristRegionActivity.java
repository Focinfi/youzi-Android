package com.focinfi.youzi.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.focinfi.youzi.R;
import com.focinfi.youzi.beans.TouristRegionBean;
import com.focinfi.youzi.models.TouristRegionModel;
import com.focinfi.youzi.presenters.TouristRegionPresenter;
import com.focinfi.youzi.services.TouristRegionVoiceService;
import com.squareup.picasso.Picasso;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.IOException;

public class TouristRegionActivity extends Activity implements ITouristRegionView, View.OnClickListener {
    TouristRegionPresenter touristRegionPresenter = new TouristRegionPresenter(this);

    ImageView mainPicImgV;
    TextView levelTV, priceTV, locationTV, openTimeTV, descTV;
    Button musicBtn;

    String musicUrl;

    Boolean isPlaying = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_region);
        mainPicImgV = (ImageView) findViewById(R.id.main_pic_imgv);
        levelTV = (TextView) findViewById(R.id.level_textv);
        priceTV = (TextView) findViewById(R.id.price_textv);
        locationTV = (TextView) findViewById(R.id.location_textv);
        openTimeTV = (TextView) findViewById(R.id.open_time_textv);
        descTV = (TextView) findViewById(R.id.desc_textv);
        musicBtn = (Button) findViewById(R.id.tourist_region_music_btn);
        musicBtn.setOnClickListener(this);

        // get TouristRegionBean and set text to views when fetching is done
        Observable.create(new Observable.OnSubscribe<TouristRegionBean>() {
            @Override
            public void call(Subscriber<? super TouristRegionBean> subscriber) {
                try {
                    TouristRegionBean touristRegionBean = touristRegionPresenter.findTouristRegion("1", getApplicationContext());
                    subscriber.onNext(touristRegionBean);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TouristRegionBean>() {
                    @Override
                    public void onNext(TouristRegionBean touristRegionBean) {
                        levelTV.setText(touristRegionBean.getLevel() + "景区");
                        priceTV.setText("门票:" + touristRegionBean.getPrice() + "元");
                        locationTV.setText(touristRegionBean.getLocation());
                        openTimeTV.setText(touristRegionBean.getOpenTime());
                        descTV.setText(touristRegionBean.getDesc());

                        musicBtn.setClickable(true);
                        musicUrl = touristRegionBean.getVoiceUrl();

                        Picasso.with(getApplicationContext()).load(touristRegionBean.getPictureUrls().get(0)).resize(1000, 320).centerCrop().into(mainPicImgV);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tourist_region_music_btn:
                Intent intent = new Intent(TouristRegionActivity.this, TouristRegionVoiceService.class);
                Bundle bundle = new Bundle();
                if (isPlaying) {
                    bundle.putInt("command", TouristRegionVoiceService.PAUSE);
                    isPlaying = false;
                } else {
                    bundle.putInt("command", TouristRegionVoiceService.PLAY);
                    isPlaying = true;
                }
                bundle.putString("voice_url", musicUrl);
                intent.putExtras(bundle);
                startService(intent);
        }
    }
}
