package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
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
    TextView textView;
    TextView textView2;
    TextView textView3;


    public static FinanceDisplayFragment newInstance() {
        FinanceDisplayFragment f = new FinanceDisplayFragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBudgeterViewModel =
                ViewModelProviders.of(getActivity()).get(BudgeterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_finance_display, container, false);
        View root_income_info = inflater.inflate(R.layout.fragment_income_info, container, false);

        textView = root.findViewById(R.id.expensesID);
        mBudgeterViewModel.getExpenseText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                String expensesText = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.budget_expenses) +  "</b>" +  "   " +  "$" + s;
                textView.setText(Html.fromHtml(expensesText));

            }
        });


        textView3 = root.findViewById(R.id.incomeID);
        EditText text = (EditText) root_income_info.findViewById(R.id.income);
        TextWatcher textWatcher = new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String incomeText = textView2.getText().toString();
                textView3.setText(incomeText);
            }
        };
        text.addTextChangedListener(textWatcher);





        return root;
    }
}