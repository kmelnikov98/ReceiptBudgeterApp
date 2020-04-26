package com.example.receiptbudgeterapp.ui.main.ui.finance;

import android.app.Activity;
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
    private FinanceViewModel mFinanceViewModel;

    public static IncomeInfoFragment newInstance() {
        IncomeInfoFragment f = new IncomeInfoFragment();
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {

        mFinanceViewModel =
                ViewModelProviders.of(getActivity()).get(FinanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_income_info, container, false);

        return root;
    }

}