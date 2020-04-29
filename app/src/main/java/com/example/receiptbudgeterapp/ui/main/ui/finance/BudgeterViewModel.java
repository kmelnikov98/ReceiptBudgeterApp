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
    private IIncomeData mIncomeData;

    private MutableLiveData<Float> mExpenseText;
    private MutableLiveData<Float> mIncomeText;
    private MutableLiveData<Float> mBudgetText;
    private MutableLiveData<Float> mWantsText;
    private MutableLiveData<Float> mNeedsText;
    private MutableLiveData<Float> mDebtText;

    public BudgeterViewModel() {
        mReceiptList = new ArrayList<>();
        mIncomeData = new IncomeData();
        mIncomeText = new MutableLiveData<>(mIncomeData.getIncomeData());
        mExpenseText = new MutableLiveData<>(mIncomeData.getExpenses());
        mBudgetText = new MutableLiveData<>(mIncomeData.getBudgetTotal());
        mWantsText = new MutableLiveData<>((float)(mIncomeData.getBudgetTotal()*0.5));
        mNeedsText = new MutableLiveData<>((float)(mIncomeData.getBudgetTotal()*0.3));
        mDebtText = new MutableLiveData<>((float)(mIncomeData.getBudgetTotal()*0.2));
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


    public LiveData<Float> getBudgetText()
    {
        return mBudgetText;
    }

    public void CalculateTotal()
    {
        float total = mIncomeData.getIncomeData() - mIncomeData.getExpenses();

        if(total < 0f) //do not want to create a budget of negative values.
        {
            total = (float)(0.0);
        }

        mIncomeData.setBudgetTotal(total);
        mBudgetText.setValue(total);
    }

    public void setIncomeText(float income)
    {
        mIncomeText.setValue(income);
    }

    public void setUserData(float income)
    {
        mIncomeData.setIncome(income);
    }

    public void setWantsText(float value)
    {
        mWantsText.setValue(value);
    }

    public void setNeedsText(float value)
    {
        mNeedsText.setValue(value);
    }

    public void setDebtsText(float value)
    {
        mDebtText.setValue(value);
    }
}