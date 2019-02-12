package com.example.fresco01;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView draweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("https://p0.ssl.qhimgs1.com/bdr/200_200_/t014b3fc0eef5e6940c.jpg");
        draweeView = findViewById(R.id.my_image);
        draweeView.setImageURI(uri);

    }
}
