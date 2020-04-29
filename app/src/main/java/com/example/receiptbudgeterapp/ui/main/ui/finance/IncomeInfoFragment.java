package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.receiptbudgeterapp.R;

public class IncomeInfoFragment extends Fragment
{
    private BudgeterViewModel mBudgeterViewModel;

    public static IncomeInfoFragment newInstance() {
        IncomeInfoFragment f = new IncomeInfoFragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        mBudgeterViewModel =
                ViewModelProviders.of(getActivity()).get(BudgeterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_income_info, container, false);

        final EditText editTextIncome = root.findViewById(R.id.user_income_inputID);
        editTextIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String incomeText = s.toString();
                if (incomeText == null || incomeText.equals("")) {
                    incomeText = "0.00";
                }

                mBudgeterViewModel.setUserData(Float.parseFloat(incomeText));
                mBudgeterViewModel.setIncomeText(Float.parseFloat(incomeText));
            }
        });

        return root;

    }

}