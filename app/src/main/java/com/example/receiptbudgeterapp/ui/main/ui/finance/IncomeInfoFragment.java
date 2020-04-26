package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return root;
    }

}