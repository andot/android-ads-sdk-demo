package com.adtalos.ads.demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.adtalos.ads.sdk.AdSize;
import com.adtalos.ads.sdk.BannerAdView;
import com.adtalos.ads.sdk.NativeAdView;
import com.adtalos.ads.sdk.SplashAd;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String[] requestPermissions = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.REQUEST_INSTALL_PACKAGES
    };

    private static final SplashAd spalshAd = new SplashAd("5C3DD65A809B08A2D6CF3DEFBC7E09C7");

    private BannerAdView bannerAd;
    private NativeAdView nativeAd;

    private void requestPermissions() {
        ArrayList<String> permissionList = new ArrayList<>();
        for (int i = 0; i < requestPermissions.length; i++) {
            if (ActivityCompat.checkSelfPermission(this, requestPermissions[i])
                    != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(requestPermissions[i]);
            }
        }
        if (permissionList.size() > 0) {
            String[] permissions = new String[permissionList.size()];
            permissionList.toArray(permissions);
            ActivityCompat.requestPermissions(this, permissions, 1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();
        bannerAd = findViewById(R.id.banner_ad_view);
        nativeAd = new NativeAdView(getApplicationContext());
        ((ViewGroup)bannerAd.getRootView()).addView(nativeAd, MATCH_PARENT, WRAP_CONTENT);
        nativeAd.loadAd("98738D91D3BB241458D3FAE5A5BF7D34");
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
