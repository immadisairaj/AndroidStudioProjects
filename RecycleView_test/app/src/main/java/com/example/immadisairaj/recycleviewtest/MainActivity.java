package com.example.immadisairaj.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fruit> fruitsList;
    private RecyclerView.Adapter fruitAdapter;

    @BindView(R.id.rv_fruits_list_view)
    RecyclerView fruitRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fruitAdapter = new FruitAdapter(setFruitsList());
        fruitRecyclerView.setAdapter(fruitAdapter);
    }



    public ArrayList<Fruit> setFruitsList() {
        fruitsList = new ArrayList<>();

        fruitsList.add(new Fruit("Apple", R.drawable.apple));
        fruitsList.add(new Fruit("Banana", R.drawable.banana));
        fruitsList.add(new Fruit("Blue Berries", R.drawable.blueberries));
        fruitsList.add(new Fruit("Broccoli", R.drawable.broccoli));
        fruitsList.add(new Fruit("Cabbage", R.drawable.cabbage));
        fruitsList.add(new Fruit("Carrot", R.drawable.carrot));
        fruitsList.add(new Fruit("Cherry", R.drawable.cherries));
        fruitsList.add(new Fruit("Grapes", R.drawable.grapes));
        fruitsList.add(new Fruit("Lemon", R.drawable.lemon));
        fruitsList.add(new Fruit("Orange", R.drawable.orange));
        fruitsList.add(new Fruit("Pear", R.drawable.pear));
        fruitsList.add(new Fruit("Pomegranate", R.drawable.pomegranate));
        fruitsList.add(new Fruit("Raspberry", R.drawable.raspberry));
        fruitsList.add(new Fruit("Strawberry", R.drawable.strawberry));
        fruitsList.add(new Fruit("Tomato", R.drawable.tomato));
        fruitsList.add(new Fruit("Watermelon", R.drawable.watermelon));

        return fruitsList;
    }
}
