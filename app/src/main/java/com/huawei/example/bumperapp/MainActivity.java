package com.huawei.example.bumperapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // if you want to redirect user to appgallery, without showing him landing page
        // with explanation, uncomment following 2 lines
        // and comment setContentView(R.layout.activity_main); line

        // goToAppGallery();
        // finish();

        setContentView(R.layout.activity_main);
    }

    public void UpdateClick(View view) {
        goToAppGallery();
    }

    public void goToAppGallery() {
        try {
            // Please replace this constant with your main app package name
            // also change it in build.gradle and AndroidManifest.xml
            // versionCode in build.gradle should be less than your main app versionCode

            String appId = "your.app.package.name";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("appmarket://details?id=" + appId));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.huawei.appmarket.tv");
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "DEBUG: AppGallery not found", Toast.LENGTH_SHORT).show();
        }
    }
}