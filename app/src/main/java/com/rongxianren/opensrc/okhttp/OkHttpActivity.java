package com.rongxianren.opensrc.okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rongxianren.opensrc.R;

import okhttp3.OkHttpClient;

public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        OkHttpClient okHttpClient = new OkHttpClient();

    }
}
