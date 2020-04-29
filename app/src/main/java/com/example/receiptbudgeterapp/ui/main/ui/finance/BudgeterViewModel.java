package com.example.receiptbudgeterapp.ui.main.ui.finance;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.receiptbudgeterapp.IncomeData.IIncomeData;
import com.example.receiptbudgeterapp.IncomeData.IncomeData;
import com.example.receiptbudgeterapp.Receipt.IReceipt;

import java.util.ArrayList;

public class BudgeterViewModel extends ViewModel
{
    private ArrayList<IReceipt> mReceiptList;
    private MutableLiveData<Float> mExpenseText;
    private MutableLiveData<Float> mIncomeText;
    private IIncomeData mIncomeData;

    public BudgeterViewModel() {
        mReceiptList = new ArrayList<>();
        mIncomeData = new IncomeData();
        mIncomeText = new MutableLiveData<>(mIncomeData.getIncomeData());
        mExpenseText = new MutableLiveData<>(mIncomeData.getExpenses());
    }

    public ArrayList<IReceipt> GetReceipts(){
        return mReceiptList;
    }

    public void CalculateTotalCost() {

        float totalExpenses = 0;

        for(int i = 0; i < mReceiptList.size(); i++)
        {
            if (mReceiptList.get(i).getReceiptCost() == null
                    || mReceiptList.get(i).getReceiptCost().equals("")) {
                totalExpenses = totalExpenses + 0f;
            }
            else
            {
                totalExpenses = totalExpenses + Float.parseFloat(mReceiptList.get(i).getReceiptCost());
            }
        }

        mIncomeData.setExpenses(totalExpenses); //set value of total expenses (need to save it somewhere)
        mExpenseText.setValue(totalExpenses); //set value of text

    }

    public LiveData<Float> getExpenseText()
    {
        return mExpenseText;
    }

    public LiveData<Float> getIncomeText()
    {
        return mIncomeText;
    }

    public void setIncomeText(float income)
    {
        mIncomeText.setValue(income);
    }

    public void setUserData(float income)
    {
        mIncomeData.setIncome(income);
    }
}