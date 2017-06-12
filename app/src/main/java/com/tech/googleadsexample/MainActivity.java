package com.tech.googleadsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AdView adView;
    Button btnAds, btnVideoAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adView = (AdView) findViewById(R.id.adView);
        btnAds = (Button) findViewById(R.id.btnAds);
        btnVideoAds = (Button) findViewById(R.id.btnVideoAds);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);

        btnAds.setOnClickListener(this);
        btnVideoAds.setOnClickListener(this);

    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAds:
                startActivity(new Intent(MainActivity.this, FullScreenAds.class));
                break;
            case R.id.btnVideoAds:
                startActivity(new Intent(MainActivity.this, RewardingAds.class));
                break;
            default:
                break;
        }
    }
}
