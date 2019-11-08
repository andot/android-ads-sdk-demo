package com.adtalos.ads.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.adtalos.ads.sdk.AdActivity;
import com.adtalos.ads.sdk.BannerAdView;
import com.adtalos.ads.sdk.NativeAdView;
import com.adtalos.ads.sdk.SDK;
import com.adtalos.ads.sdk.SplashAd;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    private BannerAdView bannerAd;
    private NativeAdView nativeAd;
    private SplashAd spalshAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDK.requestPermissions(this);
        AdActivity.setDisplayActionBarEnabled(true);
        setContentView(R.layout.activity_main);
        spalshAd = new SplashAd("5C3DD65A809B08A2D6CF3DEFBC7E09C7");
        bannerAd = findViewById(R.id.banner_ad_view);
        nativeAd = new NativeAdView(getApplicationContext());
        ((ViewGroup) bannerAd.getRootView()).addView(nativeAd, MATCH_PARENT, WRAP_CONTENT);
        nativeAd.loadAd("98738D91D3BB241458D3FAE5A5BF7234");
        spalshAd.show();
    }

    @Override
    protected void onDestroy() {
        bannerAd.destroy();
        nativeAd.destroy();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        bannerAd.pause();
        nativeAd.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        bannerAd.resume();
        nativeAd.resume();
        super.onResume();
    }
}
