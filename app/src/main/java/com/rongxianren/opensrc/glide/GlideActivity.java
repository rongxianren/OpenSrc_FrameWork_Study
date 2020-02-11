package com.rongxianren.opensrc.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.rongxianren.opensrc.R;

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ImageView imageView = new ImageView(this);
        GlideUrl muGlideUrl = new GlideUrl("asfd");
        Glide.with(this).load(muGlideUrl).into(imageView);
    }
}
