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
    TextView budgetText;
    TextView needsText;
    TextView wantsText;
    TextView debtText;

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
                mBudgeterViewModel.CalculateTotal();

            }
        });

        incomeText = root.findViewById(R.id.incomeID);
        mBudgeterViewModel.getIncomeText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                String incomesText = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.income_user) +  "</b>" +  "   " +  "$" + s;
                incomeText.setText(Html.fromHtml(incomesText));
                mBudgeterViewModel.CalculateTotal();
            }
        });

        budgetText = root.findViewById(R.id.budgetID);
        mBudgeterViewModel.getBudgetText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                String budgetsText = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.total_budget) +  "</b>" +  "   " +  "$" + s;
                budgetText.setText(Html.fromHtml(budgetsText));
            }
        });

        needsText = root.findViewById(R.id.needsID);
        mBudgeterViewModel.getBudgetText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                float needsBudget = (float)(s*0.5);
                mBudgeterViewModel.setNeedsText(needsBudget);
                String textVal = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.budget_necessities) +  "</b>" +  "   " +  "$" + needsBudget;
                needsText.setText(Html.fromHtml(textVal));
            }
        });

        wantsText = root.findViewById(R.id.wantsID);
        mBudgeterViewModel.getBudgetText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                float wantsBudget = (float)(s*0.3);
                mBudgeterViewModel.setWantsText(wantsBudget);
                String textVal = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.budget_wants) +  "</b>" +  "   " +  "$" + wantsBudget;
                wantsText.setText(Html.fromHtml(textVal));
            }
        });

        debtText = root.findViewById(R.id.debtID);
        mBudgeterViewModel.getBudgetText().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float s) {
                float debtBudget = (float)(s*0.2);
                mBudgeterViewModel.setDebtsText(debtBudget);
                String textVal = "<b>" +  " " +
                        getActivity().getResources().getString(R.string.budget_debt_repayment) +  "</b>" +  "   " +  "$" + debtBudget;
                debtText.setText(Html.fromHtml(textVal));
            }
        });

        return root;
    }
}