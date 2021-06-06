package com.example.fragmentPractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    TextView tvMedName;
    TextView tvPrice;
    ArrayList<String> medNames;
    ArrayList<Integer> priceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMedName = findViewById(R.id.tvMedName);
        tvPrice = findViewById(R.id.tvPrice);

        medNames = new ArrayList<String>();
        medNames = updateMedDetails(medNames);

        priceList = new ArrayList<Integer>();
        priceList = getPriceList(priceList);

        //the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();
        }

        //the phone is in landscape mode
        if(findViewById(R.id.layout_land) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .commit();
        }
    }

    ArrayList updateMedDetails (ArrayList medNames){
        medNames.add("Xeldrin");
        medNames.add("SodiCarb");
        medNames.add("Hemofiz FZ");
        medNames.add("Hypophos");
        medNames.add("Neugalin");

        return medNames;
    }

    ArrayList getPriceList(ArrayList priceList){
        priceList.add(450);
        priceList.add(320);
        priceList.add(270);
        priceList.add(300);
        priceList.add(300);

        return priceList;
    }

    @Override
    public void onItemSelected(int index) {
        tvMedName.setText(medNames.get(index));
        tvPrice.setText("Price: " + priceList.get(index));

        //the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .hide(manager.findFragmentById(R.id.listFragment))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
