package com.example.receiptbudgeterapp.IncomeData;

public class IncomeData implements IIncomeData
{
    private float mTotalExpenses;
    private float mUserIncome;
    
    public IncomeData()
    {

    }

    public IncomeData(float expenses)
    {
        mTotalExpenses = expenses;
    }

    public IncomeData(float income, float expenses)
    {
        mUserIncome = income;
        mTotalExpenses = expenses;
    }

    public float getIncomeData()
    {
        return mUserIncome;
    }

    public float getExpenses()
    {
        return mTotalExpenses;
    }

    public void setExpenses(float expense)
    {
        mTotalExpenses = expense;
    }
}
