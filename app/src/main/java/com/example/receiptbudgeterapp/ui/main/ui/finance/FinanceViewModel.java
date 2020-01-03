package com.example.receiptbudgeterapp.ui.main.ui.finance;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.receiptbudgeterapp.IncomeData.IIncomeData;
import com.example.receiptbudgeterapp.IncomeData.IncomeData;
import com.example.receiptbudgeterapp.Receipt.IReceipt;

import java.util.ArrayList;

public class FinanceViewModel extends ViewModel
{
    private ArrayList<IReceipt> mReceiptList;
    private MutableLiveData<Float> mExpenseText;
    private IIncomeData mIncomeData;

    public FinanceViewModel() {
        mReceiptList = new ArrayList<>();
        mIncomeData = new IncomeData();
        mExpenseText = new MutableLiveData<>(mIncomeData.getExpenses());
    }

    public ArrayList<IReceipt> GetReceipts(){
        return mReceiptList;
    }

    public void CalculateTotalCost() {

        float totalExpenses = 0;

        for(int i = 0; i < mReceiptList.size(); i++)
        {
            totalExpenses = totalExpenses + Float.parseFloat(mReceiptList.get(i).getReceiptCost());
        }

        mIncomeData.setExpenses(totalExpenses);
    }

    public LiveData<Float> getExpenseText()
    {
        return mExpenseText;
    }
}