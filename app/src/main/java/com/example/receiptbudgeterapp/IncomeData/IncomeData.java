package com.example.receiptbudgeterapp.IncomeData;

public class IncomeData implements IIncomeData
{
    private float mTotalExpenses;
    private float mUserIncome;
    private float mBudgetTotal;
    
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

        if(income > expenses)
        {
            mBudgetTotal = income - expenses;
        }
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

    public void setIncome(float income)
    {
        mUserIncome = income;
    }

    public float getBudgetTotal()
    {
        return mBudgetTotal;
    }

    public void setBudgetTotal(float total)
    {
        mBudgetTotal = total;
    }
}
