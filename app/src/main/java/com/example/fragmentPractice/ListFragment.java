package com.example.fragmentPractice;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends androidx.fragment.app.ListFragment {

    public interface ItemSelected {

        void onItemSelected(int index);

    }

    ItemSelected activity;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> medicineList = new ArrayList<String>();

        medicineList = updateMedicineList(medicineList);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, medicineList));

        activity.onItemSelected(0);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);

        activity.onItemSelected(position);
    }

    ArrayList updateMedicineList (ArrayList medicineList){
        medicineList.add("Xeldrin");
        medicineList.add("SodiCarb");
        medicineList.add("Hemofiz FZ");
        medicineList.add("Hypophos");
        medicineList.add("Neugalin");

        return medicineList;
    }
}
