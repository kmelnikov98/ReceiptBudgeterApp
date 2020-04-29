package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.receiptbudgeterapp.R;

public class FinanceDisplayFragment extends Fragment
{
    private BudgeterViewModel mBudgeterViewModel;
    TextView expenseText;
    TextView incomeText;

    public static FinanceDisplayFragment newInstance() {
        FinanceDisplayFragment f = new FinanceDisplayFragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBudgeterViewModel =
                ViewModelProviders.of(getActivity()).get(BudgeterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_finance_display, container, false);

        expenseText = root.findViewById(R.id.expensesID);
        mBudgeterViewModel.getExpenseText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                String expensesText = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.budget_expenses) +  "</b>" +  "   " +  "$" + s;
                expenseText.setText(Html.fromHtml(expensesText));

            }
        });

        incomeText = root.findViewById(R.id.incomeID);
        mBudgeterViewModel.getIncomeText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                incomeText.setText(String.valueOf(s));
            }
        });

        return root;
    }
}