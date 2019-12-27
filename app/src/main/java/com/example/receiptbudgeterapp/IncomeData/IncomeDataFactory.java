package com.example.receiptbudgeterapp.IncomeData;

public class IncomeDataFactory implements IIncomeDataFactory
{
    public IIncomeData Create()
    {
        return new IncomeData();
    }
}
