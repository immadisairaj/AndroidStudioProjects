package com.example.immad.lovehate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnLove, btnHate;
    ImageView imgLove, imgHate;

    int lov = 0, hat = 0;

    int[] ldrawables= {
            R.drawable.love_1,
            R.drawable.love_2,
            R.drawable.love_3,
            R.drawable.love_4
    };

    int[] hdrawables= {
            R.drawable.hate_1,
            R.drawable.hate_2,
            R.drawable.hate_3,
            R.drawable.hate_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLove = findViewById(R.id.btn_love);
        btnHate = findViewById(R.id.btn_hate);
        imgLove = findViewById(R.id.img_love);
        imgHate = findViewById(R.id.img_hate);
    }

    public void onClickLove(View v) {
        lov++;
        imgLove.setImageResource(ldrawables[lov%4]);
    }

    public void onClickHate(View v) {
        hat++;
        imgHate.setImageResource(hdrawables[hat%4]);
    }
}
