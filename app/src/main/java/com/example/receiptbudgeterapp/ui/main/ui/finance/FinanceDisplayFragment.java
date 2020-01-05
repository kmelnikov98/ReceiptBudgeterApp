package com.example.receiptbudgeterapp.ui.main.ui.finance;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.receiptbudgeterapp.R;
import com.example.receiptbudgeterapp.ui.main.Misc.IncomeListAdapter;

public class FinanceDisplayFragment extends Fragment
{
    private FinanceViewModel mFinanceViewModel;
    ListView listView;

    public static FinanceDisplayFragment newInstance() {
        FinanceDisplayFragment f = new FinanceDisplayFragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        mFinanceViewModel =
                ViewModelProviders.of(getActivity()).get(FinanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_finance_display, container, false);


        String[] nameArray = {"Octopus", "Pig", "Sheep", "Rabbit", "Snake", "Spider"};
        String[] infoArray = {
                "8 tentacled monster",
                "Delicious in rolls",
                "Great for jumpers",
                "Nice in a stew",
                "Great for shoes",
                "Scary."
        };
        //use this below method for writing the total amount of the receipts


//        TextView textView = root.findViewById(R.id.text_share);
//        mFinanceViewModel.GetExpenseText().observe(this, new Observer<Float>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        IncomeListAdapter listAdapter = new IncomeListAdapter(getActivity(), nameArray, infoArray);
//        listView = (ListView) root.findViewById(R.id.listviewID);
//        listView.setAdapter(listAdapter);

        return root;
    }
}