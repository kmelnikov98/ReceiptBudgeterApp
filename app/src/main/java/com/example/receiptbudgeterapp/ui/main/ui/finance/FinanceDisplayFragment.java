package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.receiptbudgeterapp.R;

public class FinanceDisplayFragment extends Fragment
{
    private FinanceViewModel mFinanceViewModel;
    TextView textView;

    public static FinanceDisplayFragment newInstance() {
        FinanceDisplayFragment f = new FinanceDisplayFragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mFinanceViewModel =
                ViewModelProviders.of(getActivity()).get(FinanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_finance_display, container, false);

        textView = root.findViewById(R.id.expensesID);
        mFinanceViewModel.getExpenseText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                String expensesText = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.budget_expenses) +  "</b>" +  "   " +  "$" + s;
                textView.setText(Html.fromHtml(expensesText));
            }
        });

        return root;
    }
}