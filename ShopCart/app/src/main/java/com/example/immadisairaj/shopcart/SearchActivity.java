package com.example.immadisairaj.shopcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    EditText manufacturer, model, min_price, max_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        manufacturer = findViewById(R.id.et_manufacturer);
        model = findViewById(R.id.et_model);
        min_price = findViewById(R.id.et_min_price);
        max_price = findViewById(R.id.et_max_price);
    }

    public void search(View view) {

        Bundle bundle = new Bundle();

        String string = manufacturer.getText().toString();
        if(string.equals("")) {
            string = null;
        }
        bundle.putString("manufacturer", string);

        string = model.getText().toString();
        if(string.equals("")) {
            string = null;
        }
        bundle.putString("model", string);

        string = min_price.getText().toString();
        if(string.equals("")) {
            string = null;
        }
        bundle.putString("min_price", string);

        string = max_price.getText().toString();
        if(string.equals("")) {
            string = null;
        }
        bundle.putString("max_price", string);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
