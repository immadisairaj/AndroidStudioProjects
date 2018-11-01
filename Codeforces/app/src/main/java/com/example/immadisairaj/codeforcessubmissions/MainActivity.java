package com.example.immadisairaj.codeforcessubmissions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        EditText handleText = findViewById(R.id.et_handle);
        String handle = handleText.getText().toString();

        if (handle.isEmpty()) {
            TextView reEnter = findViewById(R.id.tv_re_enter);
            reEnter.setVisibility(View.VISIBLE);
        } else {
            TextView reEnter = findViewById(R.id.tv_re_enter);
            reEnter.setVisibility(View.GONE);
            Intent intent = new Intent(this, InfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("handle", handle);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
