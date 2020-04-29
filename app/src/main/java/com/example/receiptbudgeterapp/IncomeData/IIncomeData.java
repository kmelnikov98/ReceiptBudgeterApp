package com.example.receiptbudgeterapp.IncomeData;

public interface IIncomeData
{
    float getExpenses();
    float getIncomeData();
    float getBudgetTotal();
    void setExpenses(float expenses);
    void setBudgetTotal(float total);
    void setIncome(float income);
}
