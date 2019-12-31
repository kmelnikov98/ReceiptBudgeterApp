package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.receiptbudgeterapp.IncomeData.IncomeData;
import com.example.receiptbudgeterapp.R;
import com.example.receiptbudgeterapp.Receipt.IReceipt;
import com.example.receiptbudgeterapp.Receipt.IReceiptFactory;
import com.example.receiptbudgeterapp.Receipt.ReceiptFactory;
import com.example.receiptbudgeterapp.ui.main.Misc.ReceiptListAdapter;

import java.util.ArrayList;

public class FinanceFragment extends Fragment
{
    private FinanceViewModel financeViewModel;
    private ListView listView;
    ReceiptListAdapter listAdapter;
    private IReceiptFactory mReceiptFactory;
    private int mReceiptCount = 0;

/*OnCreateView, essentially creates the items, like the textViews, and so on.
* References the correct item by its Id.*/

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState)
    {
        mReceiptFactory = new ReceiptFactory();
        Activity context = getActivity();

        financeViewModel =
                ViewModelProviders.of(getActivity()).get(FinanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_finance, container, false);

        listAdapter = new ReceiptListAdapter(context, financeViewModel.GetReceipts());
        listView = (ListView) root.findViewById(R.id.receipt_list_view_ID);
        listView.setAdapter(listAdapter);
        return root;
    }

    public void Add(String totalCost)
    {
        mReceiptCount++;
        financeViewModel.GetReceipts().add(mReceiptFactory.Create(totalCost, Integer.toString(mReceiptCount)));
        financeViewModel.CalculateTotalCost();
        listAdapter.notifyDataSetChanged();
    }

    public static FinanceFragment newInstance() {
        FinanceFragment f = new FinanceFragment();
        return f;
    }
}