package com.example.receiptbudgeterapp.IncomeData;

public class IncomeData implements IIncomeData
{
    private float mTotalExpenses;
    private float mUserIncome;

    public IncomeData()
    {

    }

    public float GetIncomeData()
    {
        return mUserIncome;
    }

    public float GetExpenses()
    {
        return mTotalExpenses;
    }

    public void SetExpenses(float expense)
    {
        mTotalExpenses = expense;
    }
}
