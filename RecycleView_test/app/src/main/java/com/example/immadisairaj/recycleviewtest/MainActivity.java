package com.example.immadisairaj.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> fruitNameList;
    private ArrayList<Integer> fruitImageList;
    private RecyclerView.Adapter fruitAdapter;

    @BindView(R.id.rv_fruits_list_view)
    RecyclerView fruitRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fruitAdapter = new FruitAdapter(setFruitImageList(), setFruitNameList());
        fruitRecyclerView.setAdapter(fruitAdapter);
    }

    public ArrayList<String> setFruitNameList() {
        fruitNameList = new ArrayList<>();
        fruitNameList.add("Apple");
        fruitNameList.add("Banana");
        fruitNameList.add("Blue Berries");
        fruitNameList.add("Broccoli");
        fruitNameList.add("Cabbage");
        fruitNameList.add("Carrot");
        fruitNameList.add("Cherries");
        fruitNameList.add("Grapes");
        fruitNameList.add("Lemon");
        fruitNameList.add("Orange");
        fruitNameList.add("Pear");
        fruitNameList.add("Pomegranate");
        fruitNameList.add("Raspberry");
        fruitNameList.add("Strawberry");
        fruitNameList.add("Tomato");
        fruitNameList.add("Watermelon");

        Log.v("Fruit List", fruitNameList.toString());

        return fruitNameList;
    }

    public ArrayList<Integer> setFruitImageList() {
        fruitImageList = new ArrayList<>();
        fruitImageList.add(R.drawable.apple);
        fruitImageList.add(R.drawable.banana);
        fruitImageList.add(R.drawable.blueberries);
        fruitImageList.add(R.drawable.broccoli);
        fruitImageList.add(R.drawable.cabbage);
        fruitImageList.add(R.drawable.carrot);
        fruitImageList.add(R.drawable.cherries);
        fruitImageList.add(R.drawable.grapes);
        fruitImageList.add(R.drawable.lemon);
        fruitImageList.add(R.drawable.orange);
        fruitImageList.add(R.drawable.pear);
        fruitImageList.add(R.drawable.pomegranate);
        fruitImageList.add(R.drawable.raspberry);
        fruitImageList.add(R.drawable.strawberry);
        fruitImageList.add(R.drawable.tomato);
        fruitImageList.add(R.drawable.watermelon);

        Log.v("Fruit Image Id", fruitImageList.toString());

        return fruitImageList;
    }
}
