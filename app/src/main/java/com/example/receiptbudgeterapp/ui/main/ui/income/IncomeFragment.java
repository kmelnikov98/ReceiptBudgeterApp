package com.example.receiptbudgeterapp.ui.main.ui.income;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.receiptbudgeterapp.R;
import com.example.receiptbudgeterapp.ui.main.Misc.IncomeListAdapter;

public class IncomeFragment extends Fragment
{
    private IncomeViewModel incomeViewModel;
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        Activity context = getActivity();

        String[] nameArray = {"Octopus", "Pig", "Sheep", "Rabbit", "Snake", "Spider"};
        String[] infoArray = {
                "8 tentacled monster",
                "Delicious in rolls",
                "Great for jumpers",
                "Nice in a stew",
                "Great for shoes",
                "Scary."
        };

        incomeViewModel =
                ViewModelProviders.of(this).get(IncomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_income, container, false); //fragment home is the UI of home page.

        IncomeListAdapter listAdapter = new IncomeListAdapter(context, nameArray, infoArray);
        listView = (ListView) root.findViewById(R.id.listviewID);
        listView.setAdapter(listAdapter);

        return root;
    }

    public void UpdateView()
    {

    }
}